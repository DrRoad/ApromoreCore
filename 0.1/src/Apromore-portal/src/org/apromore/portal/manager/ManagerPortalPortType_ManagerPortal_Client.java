
package org.apromore.portal.manager;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
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

public final class ManagerPortalPortType_ManagerPortal_Client {

    private static final QName SERVICE_NAME = new QName("http://www.apromore.org/manager/service_portal", "ManagerPortalService");

    private ManagerPortalPortType_ManagerPortal_Client() {
    }

    public static void main(String args[]) throws Exception {
        URL wsdlURL = ManagerPortalService.WSDL_LOCATION;
        if (args.length > 0) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        ManagerPortalService ss = new ManagerPortalService(wsdlURL, SERVICE_NAME);
        ManagerPortalPortType port = ss.getManagerPortal();  
        
        {
        System.out.println("Invoking exportNative...");
        org.apromore.portal.model_manager.ExportNativeInputMsgType _exportNative_payload = new org.apromore.portal.model_manager.ExportNativeInputMsgType();
        _exportNative_payload.setNativeType("NativeType-171554002");
        _exportNative_payload.setProcessId(Integer.valueOf(-2012307882));
        _exportNative_payload.setVersionName("VersionName158898608");
        org.apromore.portal.model_manager.ExportNativeOutputMsgType _exportNative__return = port.exportNative(_exportNative_payload);
        System.out.println("exportNative.result=" + _exportNative__return);


        }
        {
        System.out.println("Invoking writeUser...");
        org.apromore.portal.model_manager.WriteUserInputMsgType _writeUser_payload = new org.apromore.portal.model_manager.WriteUserInputMsgType();
        org.apromore.portal.model_manager.UserType _writeUser_payloadUser = new org.apromore.portal.model_manager.UserType();
        java.util.List<org.apromore.portal.model_manager.SearchHistoriesType> _writeUser_payloadUserSearchHistories = new java.util.ArrayList<org.apromore.portal.model_manager.SearchHistoriesType>();
        org.apromore.portal.model_manager.SearchHistoriesType _writeUser_payloadUserSearchHistoriesVal1 = new org.apromore.portal.model_manager.SearchHistoriesType();
        _writeUser_payloadUserSearchHistoriesVal1.setSearch("Search735683638");
        _writeUser_payloadUserSearchHistoriesVal1.setNum(Integer.valueOf(31512664));
        _writeUser_payloadUserSearchHistories.add(_writeUser_payloadUserSearchHistoriesVal1);
        _writeUser_payloadUser.getSearchHistories().addAll(_writeUser_payloadUserSearchHistories);
        _writeUser_payloadUser.setFirstname("Firstname1677586091");
        _writeUser_payloadUser.setLastname("Lastname464537699");
        _writeUser_payloadUser.setEmail("Email-1119699583");
        _writeUser_payloadUser.setUsername("Username-411716625");
        _writeUser_payloadUser.setPasswd("Passwd612378302");
        _writeUser_payload.setUser(_writeUser_payloadUser);
        org.apromore.portal.model_manager.WriteUserOutputMsgType _writeUser__return = port.writeUser(_writeUser_payload);
        System.out.println("writeUser.result=" + _writeUser__return);


        }
        {
        System.out.println("Invoking writeEditSession...");
        org.apromore.portal.model_manager.WriteEditSessionInputMsgType _writeEditSession_payload = new org.apromore.portal.model_manager.WriteEditSessionInputMsgType();
        org.apromore.portal.model_manager.EditSessionType _writeEditSession_payloadEditSession = new org.apromore.portal.model_manager.EditSessionType();
        _writeEditSession_payloadEditSession.setUsername("Username-842178916");
        _writeEditSession_payloadEditSession.setNativeType("NativeType-1869224046");
        _writeEditSession_payloadEditSession.setProcessId(Integer.valueOf(-117639046));
        _writeEditSession_payloadEditSession.setProcessName("ProcessName-898867701");
        _writeEditSession_payloadEditSession.setVersionName("VersionName282297482");
        _writeEditSession_payloadEditSession.setDomain("Domain-1944578244");
        _writeEditSession_payload.setEditSession(_writeEditSession_payloadEditSession);
        org.apromore.portal.model_manager.WriteEditSessionOutputMsgType _writeEditSession__return = port.writeEditSession(_writeEditSession_payload);
        System.out.println("writeEditSession.result=" + _writeEditSession__return);


        }
        {
        System.out.println("Invoking readFormats...");
        org.apromore.portal.model_manager.ReadFormatsInputMsgType _readFormats_payload = new org.apromore.portal.model_manager.ReadFormatsInputMsgType();
        _readFormats_payload.setEmpty("Empty-137627298");
        org.apromore.portal.model_manager.ReadFormatsOutputMsgType _readFormats__return = port.readFormats(_readFormats_payload);
        System.out.println("readFormats.result=" + _readFormats__return);


        }
        {
        System.out.println("Invoking readDomains...");
        org.apromore.portal.model_manager.ReadDomainsInputMsgType _readDomains_payload = new org.apromore.portal.model_manager.ReadDomainsInputMsgType();
        _readDomains_payload.setEmpty("Empty-715609663");
        org.apromore.portal.model_manager.ReadDomainsOutputMsgType _readDomains__return = port.readDomains(_readDomains_payload);
        System.out.println("readDomains.result=" + _readDomains__return);


        }
        {
        System.out.println("Invoking readUser...");
        org.apromore.portal.model_manager.ReadUserInputMsgType _readUser_payload = new org.apromore.portal.model_manager.ReadUserInputMsgType();
        _readUser_payload.setUsername("Username-692889188");
        org.apromore.portal.model_manager.ReadUserOutputMsgType _readUser__return = port.readUser(_readUser_payload);
        System.out.println("readUser.result=" + _readUser__return);


        }
        {
        System.out.println("Invoking deleteEditSession...");
        org.apromore.portal.model_manager.DeleteEditSessionInputMsgType _deleteEditSession_payload = new org.apromore.portal.model_manager.DeleteEditSessionInputMsgType();
        _deleteEditSession_payload.setEditSessionCode(Integer.valueOf(-387622211));
        org.apromore.portal.model_manager.DeleteEditSessionOutputMsgType _deleteEditSession__return = port.deleteEditSession(_deleteEditSession_payload);
        System.out.println("deleteEditSession.result=" + _deleteEditSession__return);


        }
        {
        System.out.println("Invoking deleteProcessVersions...");
        org.apromore.portal.model_manager.DeleteProcessVersionsInputMsgType _deleteProcessVersions_payload = new org.apromore.portal.model_manager.DeleteProcessVersionsInputMsgType();
        java.util.List<org.apromore.portal.model_manager.ProcessVersionIdentifierType> _deleteProcessVersions_payloadProcessVersionIdentifier = new java.util.ArrayList<org.apromore.portal.model_manager.ProcessVersionIdentifierType>();
        org.apromore.portal.model_manager.ProcessVersionIdentifierType _deleteProcessVersions_payloadProcessVersionIdentifierVal1 = new org.apromore.portal.model_manager.ProcessVersionIdentifierType();
        java.util.List<java.lang.String> _deleteProcessVersions_payloadProcessVersionIdentifierVal1VersionName = new java.util.ArrayList<java.lang.String>();
        _deleteProcessVersions_payloadProcessVersionIdentifierVal1.getVersionName().addAll(_deleteProcessVersions_payloadProcessVersionIdentifierVal1VersionName);
        _deleteProcessVersions_payloadProcessVersionIdentifierVal1.setProcessid(Integer.valueOf(2026498928));
        _deleteProcessVersions_payloadProcessVersionIdentifier.add(_deleteProcessVersions_payloadProcessVersionIdentifierVal1);
        _deleteProcessVersions_payload.getProcessVersionIdentifier().addAll(_deleteProcessVersions_payloadProcessVersionIdentifier);
        org.apromore.portal.model_manager.DeleteProcessVersionsOutputMsgType _deleteProcessVersions__return = port.deleteProcessVersions(_deleteProcessVersions_payload);
        System.out.println("deleteProcessVersions.result=" + _deleteProcessVersions__return);


        }
        {
        System.out.println("Invoking importProcess...");
        org.apromore.portal.model_manager.ImportProcessInputMsgType _importProcess_payload = new org.apromore.portal.model_manager.ImportProcessInputMsgType();
        _importProcess_payload.setProcessName("ProcessName879418312");
        _importProcess_payload.setVersionName("VersionName-1233559245");
        _importProcess_payload.setNativeType("NativeType-1853531544");
        _importProcess_payload.setDomain("Domain1684931276");
        javax.activation.DataHandler _importProcess_payloadProcessDescription = null;
        _importProcess_payload.setProcessDescription(_importProcess_payloadProcessDescription);
        _importProcess_payload.setUsername("Username1808248325");
        org.apromore.portal.model_manager.ImportProcessOutputMsgType _importProcess__return = port.importProcess(_importProcess_payload);
        System.out.println("importProcess.result=" + _importProcess__return);


        }
        {
        System.out.println("Invoking readProcessSummaries...");
        org.apromore.portal.model_manager.ReadProcessSummariesInputMsgType _readProcessSummaries_payload = new org.apromore.portal.model_manager.ReadProcessSummariesInputMsgType();
        _readProcessSummaries_payload.setSearchExpression("SearchExpression-1741519208");
        org.apromore.portal.model_manager.ReadProcessSummariesOutputMsgType _readProcessSummaries__return = port.readProcessSummaries(_readProcessSummaries_payload);
        System.out.println("readProcessSummaries.result=" + _readProcessSummaries__return);


        }
        {
        System.out.println("Invoking readEditSession...");
        org.apromore.portal.model_manager.ReadEditSessionInputMsgType _readEditSession_payload = new org.apromore.portal.model_manager.ReadEditSessionInputMsgType();
        _readEditSession_payload.setEditSessionCode(Integer.valueOf(-575357053));
        org.apromore.portal.model_manager.ReadEditSessionOutputMsgType _readEditSession__return = port.readEditSession(_readEditSession_payload);
        System.out.println("readEditSession.result=" + _readEditSession__return);


        }
        {
        System.out.println("Invoking updateProcess...");
        org.apromore.portal.model_manager.UpdateProcessInputMsgType _updateProcess_payload = new org.apromore.portal.model_manager.UpdateProcessInputMsgType();
        javax.activation.DataHandler _updateProcess_payloadNative = null;
        _updateProcess_payload.setNative(_updateProcess_payloadNative);
        _updateProcess_payload.setUsername("Username1881217508");
        _updateProcess_payload.setNativeType("NativeType1572003292");
        _updateProcess_payload.setProcessId(Integer.valueOf(100690992));
        _updateProcess_payload.setNewVersion("NewVersion1931715954");
        _updateProcess_payload.setPreVersion("PreVersion1848260059");
        _updateProcess_payload.setDomain("Domain-1500054538");
        org.apromore.portal.model_manager.UpdateProcessOutputMsgType _updateProcess__return = port.updateProcess(_updateProcess_payload);
        System.out.println("updateProcess.result=" + _updateProcess__return);


        }

        System.exit(0);
    }

}
