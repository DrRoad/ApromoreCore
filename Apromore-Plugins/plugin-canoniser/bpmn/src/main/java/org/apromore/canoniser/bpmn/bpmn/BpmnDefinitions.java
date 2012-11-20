package org.apromore.canoniser.bpmn.bpmn;

// Java 2 Standard packges
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

// Local packages
import org.apromore.anf.AnnotationsType;
import org.apromore.cpf.BaseVisitor;
import org.apromore.cpf.DepthFirstTraverserImpl;
import org.apromore.cpf.CPFSchema;
import org.apromore.cpf.NetType;
import org.apromore.cpf.TaskType;
import org.apromore.cpf.TraversingVisitor;
import org.apromore.canoniser.bpmn.Constants;
import org.apromore.canoniser.bpmn.JAXBConstants;
import org.apromore.canoniser.bpmn.cpf.CpfCanonicalProcessType;
import org.apromore.canoniser.bpmn.cpf.CpfNetType;
import org.apromore.canoniser.exception.CanoniserException;
import org.omg.spec.bpmn._20100524.model.TBaseElement;
import org.omg.spec.bpmn._20100524.model.TCollaboration;
import org.omg.spec.bpmn._20100524.model.TDefinitions;

/**
 * BPMN 2.0 object model with canonisation methods.
 * <p>
 * To canonise a BPMN document, unmarshal the XML into an object of this class, and pass it to the constructor of
 * {@link CpfCanonicalProcessType}.
 * <p>
 * To decanonise a canonical model into BPMN, invoke the constructor {@link #BpmnDefinitions(CanonicalProcessType, AnnotationsType)}.
 * Only individual canonical models may be decanonised; there is no facility for generating a BPMN document containing
 * multiple top-level processes.
 *
 * @author <a href="mailto:simon.raboczi@uqconnect.edu.au">Simon Raboczi</a>
 */
@XmlRootElement(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL", name = "definitions")
public class BpmnDefinitions extends TDefinitions implements Constants, JAXBConstants {

    /** Mapping from IDs to {@link TBaseElement}s within this document. */
    @XmlTransient
    private final Map<String, TBaseElement> idMap = new HashMap<String, TBaseElement>();  // TODO - use diamond operator

    /** JAXB context for BPMN. */
    //public static final JAXBContext BPMN_CONTEXT = newContext();

    /** XML schema for BPMN 2.0. */
    //private static final Schema BPMN_SCHEMA = getBpmnSchema();

    /**
     * The two halves of the XSLT transformation, occuring before and after the magic token "genid:TARGET".
     *
     * This is an ugly and desperate approach to the nigh-impossibility to modifying xmlns declarations via JAXP or XSLT.
     */
    private static String[] fixNamespacesXslt;

    /** Initialize {@link #fixNamespacesXslt}. */
    static {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            TransformerFactory.newInstance().newTransformer().transform(
                new StreamSource(ClassLoader.getSystemResourceAsStream("xsd/fix-namespaces.xsl")),
                new StreamResult(baos)
            );
            fixNamespacesXslt = baos.toString().split("genid:TARGET");
            assert fixNamespacesXslt.length == 2 : "genid:TARGET does not occur exactly once within fix-namespaces.xsl";
        } catch (TransformerException e) {
            throw new RuntimeException("Couldn't parse fix-namespaces.xslt", e);
        }
    }

    /** @return BPMN 2.0 XML schema */
    private static Schema getBpmnSchema() {
        try {
            final ClassLoader loader = BpmnDefinitions.class.getClassLoader();
            SchemaFactory schemaFactory = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
            schemaFactory.setResourceResolver(new JarLSResourceResolver());
            return schemaFactory.newSchema(new StreamSource(loader.getResourceAsStream(BPMN_XSD)));
        } catch (SAXException e) {
            throw new RuntimeException("Couldn't parse BPMN XML schema", e);
        }
    }

    /**
     * No-arg constructor.
     *
     * Required for JUnit to work.
     */
    public BpmnDefinitions() { }

    /**
     * Construct a BPMN model from a canonical model.
     * In other words, de-canonise a CPF/ANF model into a BPMN one.
     *
     * @param cpf  a canonical process model
     * @param anf  annotations for the canonical process model
     * @throws CanoniserException if unable to generate BPMN from the given CPF and ANF arguments
     */
    public BpmnDefinitions(final CpfCanonicalProcessType cpf, final AnnotationsType anf) throws CanoniserException {

        // We can get by without an ANF parameter, but we definitely need a CPF
        if (cpf == null) {
            throw new CanoniserException("Cannot create BPMN from null CPF");
        }

        Initializer initializer = new Initializer(cpf, "http://www.apromore.org/bpmn/" + UUID.randomUUID() + "#");

        // Set attributes of the document root
        setExporter(APROMORE_URI);
        setExporterVersion(APROMORE_VERSION);
        setExpressionLanguage(CPFSchema.EXPRESSION_LANGUAGE_XPATH);  // This is the default, so specifying it is redundant
        setId(null);
        setName(cpf.getName());
        setTargetNamespace(initializer.getTargetNamespace());
        setTypeLanguage(CPFSchema.TYPE_LANGUAGE_XSD);  // This is the default, so specifying it is redundant

        /* TODO - add as extension attributes
        String author = cpf.getAuthor();
        String creationDate = cpf.getCreationDate();
        String modificationDate = cpf.getModificationDate();
        */

        // Assume there will be pools, all of which belong to a single collaboration
        TCollaboration collaboration = initializer.getFactory().createTCollaboration();
        JAXBElement<TCollaboration> wrapperCollaboration = initializer.getFactory().createCollaboration(collaboration);

        // Workaround for the Apromore-core's failure to generate the CPF rootIds attribute
        final List<String> rootIds = cpf.getRootIds();
        final List<String> subnetIds = new ArrayList<String>();
        if (rootIds.size() == 0) {
            cpf.accept(new TraversingVisitor(new DepthFirstTraverserImpl(), new BaseVisitor() {
                @Override public void visit(final NetType net) { rootIds.add(net.getId()); }
                @Override public void visit(final TaskType task) { subnetIds.add(task.getSubnetId()); }  // null check not required
            }));
            rootIds.removeAll(subnetIds);
            initializer.warn("Using reconstructed root net list: " + rootIds);
        }

        // Translate CPF Nets as BPMN Processes
        for (final NetType net : cpf.getNet()) {

            // Only root elements are decanonised here; subnets are dealt with by recursion
            if (!rootIds.contains(net.getId())) {
                continue;
            }

            getRootElement().add(initializer.getFactory().createProcess(new BpmnProcess((CpfNetType) net, initializer, collaboration)));

            /*
            // If we haven't added the collaboration yet and this process is a pool, add the collaboration
            if (!getRootElement().contains(wrapperCollaboration)) {
                getRootElement().add(wrapperCollaboration);
            }
            */
        }

        // Make sure all the deferred fields did eventually get filled in
        initializer.close();

        // Translate any ANF annotations into a BPMNDI diagram element
        if (anf != null) {
            getBPMNDiagram().add(new BpmndiDiagram(anf, initializer));
        }
    }

    /**
     * Construct an instance from a stream.
     *
     * @param in  a BPMN-formatted stream
     * @param validate  whether to perform schema validation
     * @throws JAXBException if the stream can't be parsed as BPMN
     * @return the parsed instance
     */
    public static BpmnDefinitions newInstance(final InputStream in, final Boolean validate) throws JAXBException {
        Unmarshaller unmarshaller = /*BPMN_CONTEXT*/ newContext().createUnmarshaller();
        BpmnIDResolver resolver = new BpmnIDResolver();
        BpmnUnmarshallerListener listener = new BpmnUnmarshallerListener(resolver);
        unmarshaller.setListener(listener);
        unmarshaller.setProperty(ID_RESOLVER, resolver);
        unmarshaller.setProperty(OBJECT_FACTORY, new Object[]{new BpmnObjectFactory(), new BpmndiObjectFactory()});
        if (validate) {
            unmarshaller.setSchema(getBpmnSchema() /*BPMN_SCHEMA*/);
        }
        BpmnDefinitions result = ((JAXBElement<BpmnDefinitions>) unmarshaller.unmarshal(new StreamSource(in))).getValue();
        result.idMap.putAll(listener.getIdMap());
        return result;
    }

    /**
     * @return a context containing the various XML namespaces comprising BPMN 2.0.
     */
    public static JAXBContext newContext() {
        try {
            return JAXBContext.newInstance(org.omg.spec.bpmn._20100524.model.ObjectFactory.class,
                                           org.omg.spec.bpmn._20100524.di.ObjectFactory.class,
                                           org.omg.spec.dd._20100524.dc.ObjectFactory.class,
                                           org.omg.spec.dd._20100524.di.ObjectFactory.class);
        } catch (JAXBException e) {
            throw new RuntimeException("Unable to create JAXB context for BPMN", e);
        }
    }

    /**
     * Look up a {@link TBaseElement} by ID.
     *
     * @param id  the ID of the element
     * @return the unique element identified by <code>id</code>, or <code>null</code> if the document contains no such element
     */
    public TBaseElement findElementById(final String id) {
        return idMap.get(id);
    }

    /**
     * Serialize this instance to a steam.
     *
     * Default deserialization is pretty-printed but not schema-validated.
     *
     * @param out  the stream for writing
     * @param validate  whether to perform schema validation
     * @throws JAXBException if the steam can't be written to
     */
    public void marshal(final OutputStream out, final Boolean validate) throws JAXBException {
      try {
        // Create an empty DOM
        DOMResult intermediateResult = new DOMResult();

        // Marshal from JAXB to DOM
        Marshaller marshaller = /*BPMN_CONTEXT*/ newContext().createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        if (validate) {
            marshaller.setSchema(getBpmnSchema() /*BPMN_SCHEMA*/);
        }
        marshaller.marshal(new BpmnObjectFactory().createDefinitions(this), intermediateResult);

        // Apply the XSLT transformation, from DOM to the output stream
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(
            new StreamSource(new java.io.StringBufferInputStream(fixNamespacesXslt[0] + getTargetNamespace() + fixNamespacesXslt[1]))
        );
        DOMSource finalSource = new DOMSource(intermediateResult.getNode());
        StreamResult finalResult = new StreamResult(out);
        transformer.transform(finalSource, finalResult);
      } catch (TransformerException e) { throw new JAXBException("Dodgy wrapped exception", e); }
    }

    /**
     * Workaround for incorrect marshalling of {@link TLane#getFlowNodeRef} by JAXB.
     *
     * A flow node reference on a lane ought to be serialized as
     * <pre>
     * &lt;lane&gt;
     *   &lt;flowNodeRef&gt;id-123&lt;/flowNodeRef&gt;
     * &lt;/lane&gt;
     * </pre>
     * but instead they end up serialized as
     * <pre>
     * &lt;lane&gt;
     *   &lt;task id="id-123"/&gt;
     * &lt;/lane&gt;
     * </pre>
     * This method applies an XSLT transform to correct things.
     *
     * @param definitions  the buggy JAXB document
     * @param factory  source of elements for the result document
     * @throws JAXBException if <code>definitions</code> can't be marshalled to XML or unmarshalled back
     * @throws TransformerException  if the XSLT transformation fails
     * @return corrected JAXB document
     */
    // TODO - change the return type and the factory parameter to be Definitions and ObjectFactory, and move to bpmn-schema
    public static BpmnDefinitions correctFlowNodeRefs(final BpmnDefinitions definitions,
                                                      final BpmnObjectFactory factory) throws JAXBException, TransformerException {

        JAXBContext context = JAXBContext.newInstance(factory.getClass(),
                                                      org.omg.spec.bpmn._20100524.di.ObjectFactory.class,
                                                      org.omg.spec.bpmn._20100524.model.ObjectFactory.class,
                                                      org.omg.spec.dd._20100524.dc.ObjectFactory.class,
                                                      org.omg.spec.dd._20100524.di.ObjectFactory.class);

        // Marshal the BPMN into a DOM tree
        DOMResult intermediateResult = new DOMResult();
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(factory.createDefinitions(definitions), intermediateResult);

        // Apply the XSLT transformation, generating a new DOM tree
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(
            new StreamSource(ClassLoader.getSystemResourceAsStream("xsd/fix-flowNodeRef.xsl"))
        );
        DOMSource finalSource = new DOMSource(intermediateResult.getNode());
        DOMResult finalResult = new DOMResult();
        transformer.transform(finalSource, finalResult);

        // Unmarshal back to JAXB
        Object def2 = context.createUnmarshaller().unmarshal(finalResult.getNode());
        return ((JAXBElement<BpmnDefinitions>) def2).getValue();
    }
}