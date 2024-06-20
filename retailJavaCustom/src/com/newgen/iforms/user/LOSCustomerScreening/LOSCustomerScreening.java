/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.iforms.user.LOSCustomerScreening;

import com.newgen.iforms.common.LogMessages;
import com.newgen.iforms.user.LOSCustomerScreening.Request.FKLLOSCUSTSCREENINGCHANNELSType;
import com.newgen.iforms.user.LOSCustomerScreening.Request.OfsFunction;
import com.newgen.iforms.user.LOSCustomerScreening.Request.Root;
import com.newgen.iforms.user.LOSCustomerScreening.Request.WebRequestCommon;
import com.newgen.iforms.user.LOSCustomerScreening.Response.LOSCustomerScreeningResponses;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @authorunnnn            
 */
public class LOSCustomerScreening {
    public String getLOSCustomerScreeningRequest(String stringData){
        LogMessages.statusLog.info("Inside getLOSCustomerScreeningRequest");
            
    
		StringBuilder toReturn=new StringBuilder();
        try {
             LogMessages.xmlLog.info("Inside getLOSCustomerScreeningRequest in try block");
//        	Date n = new Date();
//            DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.mmm");
//            String b = stringData.split("#",-1)[1].substring(0,3);
            
            String rawXML=createXML();
            toReturn.append(createXMLwithSOAP(rawXML));   
           
                    
            
            
            

        }catch(Exception e) {
        	LogMessages.errorLog.info("Exception inside getLOSCustomerScreeningRequest::",e);
        }
        LogMessages.xmlLog.info(String.valueOf(toReturn));
        return String.valueOf(toReturn);
}
            
            
                
    
    
    public String getLOSCustomerScreeningResponse(String processName,String response){
       // String transactionId, messageId, successIndicator, application;
        //String CUSTOMER, IPRSCHECK, CUSTSECTOR, CUSTDOB, FAULUSECTOR, CUSTTARGET, CUSTINDUSTRY, ACCOUNT, CUSTOMERRATING, CRBSTATUS, LOSSTATUS, RECORDSTATUS, CURRNO, INPUTTER, DATETIME, COCODE, DEPTCODE;
        String successIndicator="";
        LOSCustomerScreeningResponses lsr=new LOSCustomerScreeningResponses();
        try{
            LogMessages.statusLog.info("Inside getLoanProductCodeResponse");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(response));
        Document doc = dBuilder.parse(is);

        // Normalize the document
        doc.getDocumentElement().normalize();

        // Extract successIndicator
         successIndicator = doc.getElementsByTagName("successIndicator").item(0).getTextContent();;
        
        if(successIndicator.equalsIgnoreCase("Success")){
            
            
            
            
            NodeList transactionIdNodeList = doc.getElementsByTagName("transactionId");
            if (transactionIdNodeList.getLength() > 0) {
                lsr.transactionId = transactionIdNodeList.item(0).getTextContent();
            }
            NodeList messageIdNodeList = doc.getElementsByTagName("messageId");
            if (messageIdNodeList.getLength() > 0) {
                lsr.messageId = messageIdNodeList.item(0).getTextContent();
            }

            NodeList applicationNodeList = doc.getElementsByTagName("application");
            if (applicationNodeList.getLength() > 0) {
                lsr.application = applicationNodeList.item(0).getTextContent();
            }
            NodeList CUSTOMERNodeList = doc.getElementsByTagName("ns28:CUSTOMER");
            if (CUSTOMERNodeList.getLength() > 0) {
                lsr.CUSTOMER = CUSTOMERNodeList.item(0).getTextContent();
            }
            NodeList IPRSCHECKNodeList = doc.getElementsByTagName("ns28:IPRSCHECK");
            if (IPRSCHECKNodeList.getLength() > 0) {
                lsr.IPRSCHECK = IPRSCHECKNodeList.item(0).getTextContent();
            }
            NodeList CUSTSECTORNodeList = doc.getElementsByTagName("ns28:CUSTSECTOR");
            if (CUSTSECTORNodeList.getLength() > 0) {
                lsr.CUSTSECTOR = CUSTSECTORNodeList.item(0).getTextContent();
            }
            NodeList CUSTDOBNodeList = doc.getElementsByTagName("ns28:CUSTDOB");
            if (CUSTDOBNodeList.getLength() > 0) {
                lsr.CUSTDOB = CUSTDOBNodeList.item(0).getTextContent();
            }
            NodeList FAULUSECTORNodeList = doc.getElementsByTagName("ns28:FAULUSECTOR");
            if (FAULUSECTORNodeList.getLength() > 0) {
                lsr.FAULUSECTOR = FAULUSECTORNodeList.item(0).getTextContent();
            }
            NodeList CUSTTARGETNodeList = doc.getElementsByTagName("ns28:CUSTTARGET");
            if (CUSTTARGETNodeList.getLength() > 0) {
                lsr.CUSTTARGET = CUSTTARGETNodeList.item(0).getTextContent();
            }
            NodeList CUSTINDUSTRYNodeList = doc.getElementsByTagName("ns28:CUSTINDUSTRY");
            if (CUSTINDUSTRYNodeList.getLength() > 0) {
                lsr.CUSTINDUSTRY = CUSTINDUSTRYNodeList.item(0).getTextContent();
            }
            NodeList ACCOUNTNodeList = doc.getElementsByTagName("ns28:ACCOUNT");
            if (ACCOUNTNodeList.getLength() > 0) {
                lsr.ACCOUNT = ACCOUNTNodeList.item(0).getTextContent();
            }
            NodeList CUSTOMERRATINGNodeList = doc.getElementsByTagName("ns28:CUSTOMERRATING");
            if (CUSTOMERRATINGNodeList.getLength() > 0) {
                lsr.CUSTOMERRATING = CUSTOMERRATINGNodeList.item(0).getTextContent();
            }
            NodeList CRBSTATUSNodeList = doc.getElementsByTagName("ns28:CRBSTATUS");
            if (CRBSTATUSNodeList.getLength() > 0) {
                lsr.CRBSTATUS = CRBSTATUSNodeList.item(0).getTextContent();
            }
            NodeList LOSSTATUSNodeList = doc.getElementsByTagName("ns28:LOSSTATUS");
            if (LOSSTATUSNodeList.getLength() > 0) {
                lsr.LOSSTATUS = LOSSTATUSNodeList.item(0).getTextContent();
            }
            NodeList RECORDSTATUSNodeList = doc.getElementsByTagName("ns28:RECORDSTATUS");
            if (RECORDSTATUSNodeList.getLength() > 0) {
                lsr.RECORDSTATUS = RECORDSTATUSNodeList.item(0).getTextContent();
            }
            NodeList CURRNONodeList = doc.getElementsByTagName("ns28:CURRNO");
            if (CURRNONodeList.getLength() > 0) {
                lsr.CURRNO = CURRNONodeList.item(0).getTextContent();
            }
            NodeList INPUTTERNodeList = doc.getElementsByTagName("ns28:INPUTTER");
            if (INPUTTERNodeList.getLength() > 0) {
                lsr.INPUTTER = INPUTTERNodeList.item(0).getTextContent();
            }
            NodeList DATETIMENodeList = doc.getElementsByTagName("ns28:DATETIME");
            if (DATETIMENodeList.getLength() > 0) {
                lsr.DATETIME = DATETIMENodeList.item(0).getTextContent();
            }
            NodeList COCODENodeList = doc.getElementsByTagName("ns28:COCODE");
            if (COCODENodeList.getLength() > 0) {
                lsr.COCODE = COCODENodeList.item(0).getTextContent();
            }
            NodeList DEPTCODENodeList = doc.getElementsByTagName("ns28:DEPTCODE");
            if (DEPTCODENodeList.getLength() > 0) {
                lsr.DEPTCODE = DEPTCODENodeList.item(0).getTextContent();
            }

 


            
        }
        else{
            return "Failure in statusIndicator of getLOSCustomerScreeningResponse";
        }
        }
        catch(Exception e){
            
            
        }
        return null;
        
    }
    
    
    
    
    
    
    public String createXML(){
        try {
            LogMessages.statusLog.info("Entered inside getLOSCustomerScreeningRequest createXML");
            // Create instances of your classes and set values
                 FKLLOSCUSTSCREENINGCHANNELSType fklloscustscreeningchannelstype = new FKLLOSCUSTSCREENINGCHANNELSType();
            fklloscustscreeningchannelstype.setCUSTOMER("569414");
            fklloscustscreeningchannelstype.setIPRSCHECK("Y");
            fklloscustscreeningchannelstype.setACCOUNT("1011910827");
            fklloscustscreeningchannelstype.setCUSTOMERRATING("");
            fklloscustscreeningchannelstype.setCRBSTATUS("YES");
            
            WebRequestCommon webRequestCommon = new WebRequestCommon();
            webRequestCommon.setCompany("");
            webRequestCommon.setPassword("POLice123");
            webRequestCommon.setUserName("H2HUSER");

            OfsFunction ofsFunction = new OfsFunction();
            ofsFunction.setMessageId("878evibef83984JJ98hveidsfkuewy");

       

            // Create Root object and set its components
            Root root = new Root();
            root.setOfsFunction(ofsFunction);
            root.setFklloscustscreeningchannelstype(fklloscustscreeningchannelstype);
              
            root.setWebRequestCommon(webRequestCommon);
          

            // Create a StringWriter to capture the XML output
            StringWriter sw = new StringWriter();

            // Marshalling (converting Java objects to XML)
            JAXBContext context = JAXBContext.newInstance(Root.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Marshal to StringWriter
            marshaller.marshal(root, sw);

            // Get the XML string from StringWriter
            String xmlString = sw.toString();

            // Print or use the XML string as needed
            
            int index = xmlString.indexOf("?>");
    if (index != -1) {
        xmlString = xmlString.substring(index + 2).trim();
    }
    return xmlString;

            

        } catch (JAXBException e) {
            LogMessages.errorLog.info("Exception inside getLOSCustomerScreeningRequest createXML::",e);
        }
        
       return null;
    }
    
    public String createXMLwithSOAP(String data){
        try{
            LogMessages.statusLog.info("Exception inside getLOSCustomerScreeningRequest createXMLWithSoap::");
        StringBuilder sb = new StringBuilder();
        String raw = data;

        // Split the raw XML into lines
        String[] lines = raw.split("\n");
        StringBuilder indentedRaw = new StringBuilder();

        // Add a tab character to each line
        for (String line : lines) {
            indentedRaw.append("\t").append(line).append("\n");
        }

        String xmlString1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:faul=\"http://temenos.com/FauluProjectExodus\" xmlns:fkl=\"http://temenos.com/FKLLOSCUSTSCREENINGCHANNELS\">\n" +
                 "   <soapenv:Header/>\n" +
                 "   <soapenv:Body>\n";
        String xmlString2 = "   </soapenv:Body>\n" +
                            "</soapenv:Envelope>";

        sb.append(xmlString1).append(indentedRaw).append(xmlString2);

        return sb.toString();
        }
        catch(Exception e){
            LogMessages.errorLog.info("Exception inside getLOSCustomerScreeningRequest createXMLwithSoap::",e);
        }
    return null;
        
    }

        
    }
    

