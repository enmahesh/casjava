/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.iforms.user.ProductCodes;

import com.newgen.iforms.common.LogMessages;
import com.newgen.iforms.user.ProductCodes.Request.FKLLOANPRODCODESType;
import com.newgen.iforms.user.ProductCodes.Request.ProductCodes;
import com.newgen.iforms.user.ProductCodes.Request.WebRequestCommon;
import com.newgen.iforms.user.ProductCodes.Request.enquiryInputCollection;
import com.newgen.iforms.user.ProductCodes.Response.LoanProductCodeResponses;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXB;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author User
 */
public class LoanProductCode { 
    public  String getLoanProductCodeRequest(String stringData){
        StringBuilder Return=new StringBuilder();
        try {
             LogMessages.statusLog.info("Inside getLoanProductCodeRequest");
//        	Date n = new Date();
//            DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.mmm");
//            String b = stringData.split("#",-1)[1].substring(0,3);
            
            String rawXML=createXML(stringData);
            Return.append(createXMLwithSOAP(rawXML));   
            
                    
            
            
            

        }catch(Exception e) {
        	LogMessages.errorLog.info("Exception inside getLoanProductCodeRequest::",e);
        }
        LogMessages.xmlLog.info(String.valueOf(Return));
        return String.valueOf(Return);
}
    
    public String getLoanProductCodeResponse(String processName,String response) {  
       String successIndicator="";
       ArrayList<String> arr=new ArrayList<String>();
        try{
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(response)));

        // Normalize the document
        doc.getDocumentElement().normalize();

        // Extract successIndicator
        //NodeList statusList = doc.getElementsByTagName("successIndicator");
        
        successIndicator = doc.getElementsByTagName("successIndicator").item(0).getTextContent();;
        
        if(successIndicator.equalsIgnoreCase("Success")){
        
           
            

            // Get all ns46:ID elements
            NodeList idList = doc.getElementsByTagNameNS("namespace_uri", "ID");

            // Print the content of each ns46:ID element
            for (int i = 0; i < idList.getLength(); i++) {
                Element idElement = (Element) idList.item(i);
                arr.add(idElement.getTextContent());
                
                
            }
            
            
            LoanProductCodeResponses lpcr=new LoanProductCodeResponses();
            lpcr.loan=arr;
            
            
            System.out.println(arr);
        }
        else{
            System.out.println("failure in successIndicator");
        }
        }catch (Exception e) {
            e.printStackTrace();
        }  
        
        
        
        
       
        
        
   
    return arr.toString();
    
    } 
    
    
    public String createXML(String stringData){
         enquiryInputCollection enquiry=new enquiryInputCollection();
        enquiry.columnName="";
        enquiry.criteriaValue="";
        enquiry.operand="";
        
        
        WebRequestCommon webreq=new WebRequestCommon();
        webreq.company="";
        webreq.password="";
        webreq.userName="";
        
        FKLLOANPRODCODESType fklloan=new FKLLOANPRODCODESType();        
        fklloan.enquiryInputCollection=enquiry;
        
        ProductCodes pd=new ProductCodes();
        pd.WebRequestCommon=webreq;
        pd.FKLLOANPRODCODESType=fklloan;
        
        
        
        
        StringWriter stringwriter = new StringWriter();
        
       
    
        
        JAXB.marshal(pd, stringwriter);
        
        
        //marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        String xmlString = stringwriter.toString();
    int index = xmlString.indexOf("?>");
    if (index != -1) {
        xmlString = xmlString.substring(index + 2).trim();
    }

    return xmlString;       
        
    }
    
    public String createXMLwithSOAP(String data){
        StringBuilder sb = new StringBuilder();
        String raw = data.replaceAll("ProductCodes", "faul:ProductCodes");

        // Split the raw XML into lines
        String[] lines = raw.split("\n");
        StringBuilder indentedRaw = new StringBuilder();

        // Add a tab character to each line
        for (String line : lines) {
            indentedRaw.append("\t").append(line).append("\n");
        }

        String xmlString1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:faul=\"http://temenos.com/FauluProjectExodus\">\n" +
                            "   <soapenv:Header/>\n" +
                            "   <soapenv:Body>\n";
        String xmlString2 = "   </soapenv:Body>\n" +
                            "</soapenv:Envelope>";

        sb.append(xmlString1).append(indentedRaw).append(xmlString2);

        return sb.toString();
    
        
    }
    
    
}
