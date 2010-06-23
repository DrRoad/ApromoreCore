
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org.apromore.portal.manager;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.2.7
 * Wed Jun 23 09:54:07 EST 2010
 * Generated source version: 2.2.7
 * 
 */

@javax.jws.WebService(
                      serviceName = "ManagerPortalService",
                      portName = "ManagerPortal",
                      targetNamespace = "http://www.apromore.org/manager/service_portal",
                      wsdlLocation = "http://localhost:8080/Apromore-manager/services/ManagerPortal?wsdl",
                      endpointInterface = "org.apromore.portal.manager.ManagerPortalPortType")
                      
public class ManagerPortalPortTypeImpl implements ManagerPortalPortType {

    private static final Logger LOG = Logger.getLogger(ManagerPortalPortTypeImpl.class.getName());

    /* (non-Javadoc)
     * @see org.apromore.portal.manager.ManagerPortalPortType#exportNative(org.apromore.portal.model_manager.ExportNativeInputMsgType  payload )*
     */
    public org.apromore.portal.model_manager.ExportNativeOutputMsgType exportNative(org.apromore.portal.model_manager.ExportNativeInputMsgType payload) { 
        LOG.info("Executing operation exportNative");
        System.out.println(payload);
        try {
            org.apromore.portal.model_manager.ExportNativeOutputMsgType _return = new org.apromore.portal.model_manager.ExportNativeOutputMsgType();
            org.apromore.portal.model_manager.ResultType _returnResult = new org.apromore.portal.model_manager.ResultType();
            _returnResult.setMessage("Message-523830802");
            _returnResult.setCode(Integer.valueOf(206010644));
            _return.setResult(_returnResult);
            javax.activation.DataHandler _returnNative = null;
            _return.setNative(_returnNative);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.portal.manager.ManagerPortalPortType#writeUser(org.apromore.portal.model_manager.WriteUserInputMsgType  payload )*
     */
    public org.apromore.portal.model_manager.WriteUserOutputMsgType writeUser(org.apromore.portal.model_manager.WriteUserInputMsgType payload) { 
        LOG.info("Executing operation writeUser");
        System.out.println(payload);
        try {
            org.apromore.portal.model_manager.WriteUserOutputMsgType _return = new org.apromore.portal.model_manager.WriteUserOutputMsgType();
            org.apromore.portal.model_manager.ResultType _returnResult = new org.apromore.portal.model_manager.ResultType();
            _returnResult.setMessage("Message737049619");
            _returnResult.setCode(Integer.valueOf(1901327427));
            _return.setResult(_returnResult);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.portal.manager.ManagerPortalPortType#writeEditSession(org.apromore.portal.model_manager.WriteEditSessionInputMsgType  payload )*
     */
    public org.apromore.portal.model_manager.WriteEditSessionOutputMsgType writeEditSession(org.apromore.portal.model_manager.WriteEditSessionInputMsgType payload) { 
        LOG.info("Executing operation writeEditSession");
        System.out.println(payload);
        try {
            org.apromore.portal.model_manager.WriteEditSessionOutputMsgType _return = new org.apromore.portal.model_manager.WriteEditSessionOutputMsgType();
            org.apromore.portal.model_manager.ResultType _returnResult = new org.apromore.portal.model_manager.ResultType();
            _returnResult.setMessage("Message796909320");
            _returnResult.setCode(Integer.valueOf(1868622444));
            _return.setResult(_returnResult);
            _return.setEditSessionCode(Integer.valueOf(-238916348));
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.portal.manager.ManagerPortalPortType#readFormats(org.apromore.portal.model_manager.ReadFormatsInputMsgType  payload )*
     */
    public org.apromore.portal.model_manager.ReadFormatsOutputMsgType readFormats(org.apromore.portal.model_manager.ReadFormatsInputMsgType payload) { 
        LOG.info("Executing operation readFormats");
        System.out.println(payload);
        try {
            org.apromore.portal.model_manager.ReadFormatsOutputMsgType _return = new org.apromore.portal.model_manager.ReadFormatsOutputMsgType();
            org.apromore.portal.model_manager.ResultType _returnResult = new org.apromore.portal.model_manager.ResultType();
            _returnResult.setMessage("Message-241200574");
            _returnResult.setCode(Integer.valueOf(-673711379));
            _return.setResult(_returnResult);
            org.apromore.portal.model_manager.FormatsType _returnFormats = new org.apromore.portal.model_manager.FormatsType();
            java.util.List<org.apromore.portal.model_manager.FormatType> _returnFormatsFormat = new java.util.ArrayList<org.apromore.portal.model_manager.FormatType>();
            org.apromore.portal.model_manager.FormatType _returnFormatsFormatVal1 = new org.apromore.portal.model_manager.FormatType();
            _returnFormatsFormatVal1.setFormat("Format-826485628");
            _returnFormatsFormatVal1.setExtension("Extension1293121615");
            _returnFormatsFormat.add(_returnFormatsFormatVal1);
            _returnFormats.getFormat().addAll(_returnFormatsFormat);
            _return.setFormats(_returnFormats);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.portal.manager.ManagerPortalPortType#readDomains(org.apromore.portal.model_manager.ReadDomainsInputMsgType  payload )*
     */
    public org.apromore.portal.model_manager.ReadDomainsOutputMsgType readDomains(org.apromore.portal.model_manager.ReadDomainsInputMsgType payload) { 
        LOG.info("Executing operation readDomains");
        System.out.println(payload);
        try {
            org.apromore.portal.model_manager.ReadDomainsOutputMsgType _return = new org.apromore.portal.model_manager.ReadDomainsOutputMsgType();
            org.apromore.portal.model_manager.ResultType _returnResult = new org.apromore.portal.model_manager.ResultType();
            _returnResult.setMessage("Message-1389132417");
            _returnResult.setCode(Integer.valueOf(-1064967819));
            _return.setResult(_returnResult);
            org.apromore.portal.model_manager.DomainsType _returnDomains = new org.apromore.portal.model_manager.DomainsType();
            java.util.List<java.lang.String> _returnDomainsDomain = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnDomainsDomainVal1 = "_returnDomainsDomainVal440483725";
            _returnDomainsDomain.add(_returnDomainsDomainVal1);
            _returnDomains.getDomain().addAll(_returnDomainsDomain);
            _return.setDomains(_returnDomains);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.portal.manager.ManagerPortalPortType#readUser(org.apromore.portal.model_manager.ReadUserInputMsgType  payload )*
     */
    public org.apromore.portal.model_manager.ReadUserOutputMsgType readUser(org.apromore.portal.model_manager.ReadUserInputMsgType payload) { 
        LOG.info("Executing operation readUser");
        System.out.println(payload);
        try {
            org.apromore.portal.model_manager.ReadUserOutputMsgType _return = new org.apromore.portal.model_manager.ReadUserOutputMsgType();
            org.apromore.portal.model_manager.ResultType _returnResult = new org.apromore.portal.model_manager.ResultType();
            _returnResult.setMessage("Message-1433518574");
            _returnResult.setCode(Integer.valueOf(-1908888995));
            _return.setResult(_returnResult);
            org.apromore.portal.model_manager.UserType _returnUser = new org.apromore.portal.model_manager.UserType();
            java.util.List<org.apromore.portal.model_manager.SearchHistoriesType> _returnUserSearchHistories = new java.util.ArrayList<org.apromore.portal.model_manager.SearchHistoriesType>();
            org.apromore.portal.model_manager.SearchHistoriesType _returnUserSearchHistoriesVal1 = new org.apromore.portal.model_manager.SearchHistoriesType();
            _returnUserSearchHistoriesVal1.setSearch("Search419950170");
            _returnUserSearchHistoriesVal1.setNum(Integer.valueOf(-674897590));
            _returnUserSearchHistories.add(_returnUserSearchHistoriesVal1);
            _returnUser.getSearchHistories().addAll(_returnUserSearchHistories);
            _returnUser.setFirstname("Firstname190255486");
            _returnUser.setLastname("Lastname-1978164459");
            _returnUser.setEmail("Email-362046490");
            _returnUser.setUsername("Username-439763025");
            _returnUser.setPasswd("Passwd1135579301");
            _return.setUser(_returnUser);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.portal.manager.ManagerPortalPortType#deleteEditSession(org.apromore.portal.model_manager.DeleteEditSessionInputMsgType  payload )*
     */
    public org.apromore.portal.model_manager.DeleteEditSessionOutputMsgType deleteEditSession(org.apromore.portal.model_manager.DeleteEditSessionInputMsgType payload) { 
        LOG.info("Executing operation deleteEditSession");
        System.out.println(payload);
        try {
            org.apromore.portal.model_manager.DeleteEditSessionOutputMsgType _return = new org.apromore.portal.model_manager.DeleteEditSessionOutputMsgType();
            org.apromore.portal.model_manager.ResultType _returnResult = new org.apromore.portal.model_manager.ResultType();
            _returnResult.setMessage("Message-472724226");
            _returnResult.setCode(Integer.valueOf(1084690670));
            _return.setResult(_returnResult);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.portal.manager.ManagerPortalPortType#deleteProcessVersions(org.apromore.portal.model_manager.DeleteProcessVersionsInputMsgType  payload )*
     */
    public org.apromore.portal.model_manager.DeleteProcessVersionsOutputMsgType deleteProcessVersions(org.apromore.portal.model_manager.DeleteProcessVersionsInputMsgType payload) { 
        LOG.info("Executing operation deleteProcessVersions");
        System.out.println(payload);
        try {
            org.apromore.portal.model_manager.DeleteProcessVersionsOutputMsgType _return = new org.apromore.portal.model_manager.DeleteProcessVersionsOutputMsgType();
            org.apromore.portal.model_manager.ResultType _returnResult = new org.apromore.portal.model_manager.ResultType();
            _returnResult.setMessage("Message17684933");
            _returnResult.setCode(Integer.valueOf(1002268056));
            _return.setResult(_returnResult);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.portal.manager.ManagerPortalPortType#importProcess(org.apromore.portal.model_manager.ImportProcessInputMsgType  payload )*
     */
    public org.apromore.portal.model_manager.ImportProcessOutputMsgType importProcess(org.apromore.portal.model_manager.ImportProcessInputMsgType payload) { 
        LOG.info("Executing operation importProcess");
        System.out.println(payload);
        try {
            org.apromore.portal.model_manager.ImportProcessOutputMsgType _return = new org.apromore.portal.model_manager.ImportProcessOutputMsgType();
            org.apromore.portal.model_manager.ResultType _returnResult = new org.apromore.portal.model_manager.ResultType();
            _returnResult.setMessage("Message-1467040242");
            _returnResult.setCode(Integer.valueOf(-148301314));
            _return.setResult(_returnResult);
            org.apromore.portal.model_manager.ProcessSummaryType _returnProcessSummary = new org.apromore.portal.model_manager.ProcessSummaryType();
            java.util.List<org.apromore.portal.model_manager.VersionSummaryType> _returnProcessSummaryVersionSummaries = new java.util.ArrayList<org.apromore.portal.model_manager.VersionSummaryType>();
            org.apromore.portal.model_manager.VersionSummaryType _returnProcessSummaryVersionSummariesVal1 = new org.apromore.portal.model_manager.VersionSummaryType();
            _returnProcessSummaryVersionSummariesVal1.setRanking(Integer.valueOf(196541136));
            _returnProcessSummaryVersionSummariesVal1.setName("Name2043905201");
          //  _returnProcessSummaryVersionSummariesVal1.setLastUpdate(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2010-06-01T10:37:32.253+10:00"));
          //  _returnProcessSummaryVersionSummariesVal1.setCreationDate(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2010-06-01T10:37:32.255+10:00"));
          //  _returnProcessSummaryVersionSummaries.add(_returnProcessSummaryVersionSummariesVal1);
            _returnProcessSummary.getVersionSummaries().addAll(_returnProcessSummaryVersionSummaries);
            _returnProcessSummary.setOriginalNativeType("OriginalNativeType-1406077280");
            _returnProcessSummary.setName("Name-1127022123");
            _returnProcessSummary.setId(Integer.valueOf(1511463858));
            _returnProcessSummary.setDomain("Domain1105230892");
            _returnProcessSummary.setRanking(Integer.valueOf(-1152982153));
            _returnProcessSummary.setLastVersion("LastVersion785579283");
            _return.setProcessSummary(_returnProcessSummary);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.portal.manager.ManagerPortalPortType#readProcessSummaries(org.apromore.portal.model_manager.ReadProcessSummariesInputMsgType  payload )*
     */
    public org.apromore.portal.model_manager.ReadProcessSummariesOutputMsgType readProcessSummaries(org.apromore.portal.model_manager.ReadProcessSummariesInputMsgType payload) { 
        LOG.info("Executing operation readProcessSummaries");
        System.out.println(payload);
        try {
            org.apromore.portal.model_manager.ReadProcessSummariesOutputMsgType _return = new org.apromore.portal.model_manager.ReadProcessSummariesOutputMsgType();
            org.apromore.portal.model_manager.ResultType _returnResult = new org.apromore.portal.model_manager.ResultType();
            _returnResult.setMessage("Message-1067387247");
            _returnResult.setCode(Integer.valueOf(347711740));
            _return.setResult(_returnResult);
            org.apromore.portal.model_manager.ProcessSummariesType _returnProcessSummaries = new org.apromore.portal.model_manager.ProcessSummariesType();
            java.util.List<org.apromore.portal.model_manager.ProcessSummaryType> _returnProcessSummariesProcessSummary = new java.util.ArrayList<org.apromore.portal.model_manager.ProcessSummaryType>();
            org.apromore.portal.model_manager.ProcessSummaryType _returnProcessSummariesProcessSummaryVal1 = new org.apromore.portal.model_manager.ProcessSummaryType();
            java.util.List<org.apromore.portal.model_manager.VersionSummaryType> _returnProcessSummariesProcessSummaryVal1VersionSummaries = new java.util.ArrayList<org.apromore.portal.model_manager.VersionSummaryType>();
            _returnProcessSummariesProcessSummaryVal1.getVersionSummaries().addAll(_returnProcessSummariesProcessSummaryVal1VersionSummaries);
            _returnProcessSummariesProcessSummaryVal1.setOriginalNativeType("OriginalNativeType-353252350");
            _returnProcessSummariesProcessSummaryVal1.setName("Name-569565904");
            _returnProcessSummariesProcessSummaryVal1.setId(Integer.valueOf(-1148276553));
            _returnProcessSummariesProcessSummaryVal1.setDomain("Domain-1390123812");
            _returnProcessSummariesProcessSummaryVal1.setRanking(Integer.valueOf(1738893537));
            _returnProcessSummariesProcessSummaryVal1.setLastVersion("LastVersion-886309200");
            _returnProcessSummariesProcessSummary.add(_returnProcessSummariesProcessSummaryVal1);
            _returnProcessSummaries.getProcessSummary().addAll(_returnProcessSummariesProcessSummary);
            _return.setProcessSummaries(_returnProcessSummaries);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.portal.manager.ManagerPortalPortType#readEditSession(org.apromore.portal.model_manager.ReadEditSessionInputMsgType  payload )*
     */
    public org.apromore.portal.model_manager.ReadEditSessionOutputMsgType readEditSession(org.apromore.portal.model_manager.ReadEditSessionInputMsgType payload) { 
        LOG.info("Executing operation readEditSession");
        System.out.println(payload);
        try {
            org.apromore.portal.model_manager.ReadEditSessionOutputMsgType _return = new org.apromore.portal.model_manager.ReadEditSessionOutputMsgType();
            org.apromore.portal.model_manager.ResultType _returnResult = new org.apromore.portal.model_manager.ResultType();
            _returnResult.setMessage("Message-252789062");
            _returnResult.setCode(Integer.valueOf(1828422051));
            _return.setResult(_returnResult);
            javax.activation.DataHandler _returnNative = null;
            _return.setNative(_returnNative);
            org.apromore.portal.model_manager.EditSessionType _returnEditSession = new org.apromore.portal.model_manager.EditSessionType();
            _returnEditSession.setUsername("Username609935015");
            _returnEditSession.setNativeType("NativeType-246307180");
            _returnEditSession.setProcessId(Integer.valueOf(-514300196));
            _returnEditSession.setProcessName("ProcessName-1008687652");
            _returnEditSession.setVersionName("VersionName-1649270559");
            _returnEditSession.setDomain("Domain435438355");
            _return.setEditSession(_returnEditSession);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.portal.manager.ManagerPortalPortType#updateProcess(org.apromore.portal.model_manager.UpdateProcessInputMsgType  payload )*
     */
    public org.apromore.portal.model_manager.UpdateProcessOutputMsgType updateProcess(org.apromore.portal.model_manager.UpdateProcessInputMsgType payload) { 
        LOG.info("Executing operation updateProcess");
        System.out.println(payload);
        try {
            org.apromore.portal.model_manager.UpdateProcessOutputMsgType _return = new org.apromore.portal.model_manager.UpdateProcessOutputMsgType();
            org.apromore.portal.model_manager.ResultType _returnResult = new org.apromore.portal.model_manager.ResultType();
            _returnResult.setMessage("Message825984436");
            _returnResult.setCode(Integer.valueOf(-2016518507));
            _return.setResult(_returnResult);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
