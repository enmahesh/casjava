/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.iforms.user.custLoanDet;

import com.newgen.iforms.common.LogMessages;
import com.newgen.iforms.user.custLoanDet.Request.CreditWorkflowAPI;
import com.newgen.iforms.user.custLoanDet.Request.FKLCREDITWORKFLOWAPIType;
import com.newgen.iforms.user.custLoanDet.Request.WebRequestCommon;
import com.newgen.iforms.user.custLoanDet.Request.enquiryInputCollection;
import com.newgen.iforms.user.custLoanDet.Response.CustLoanDetResponses;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXB;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author User
 */
public class CustLoanDet {
    public  String getCustLoanDetRequest(String stringData){
        StringBuilder Return=new StringBuilder();
        
        try {
             LogMessages.statusLog.info("Inside getCustLoanDetRequest");
//        	Date n = new Date();
//            DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.mmm");
//            String b = stringData.split("#",-1)[1].substring(0,3);
            
            
            String rawXML=createXML();
            Return.append(createXMLwithSOAP(rawXML)); 
            
                    
            
            
            

        }catch(Exception e) {
        	LogMessages.errorLog.info("Exception inside getLoanProductCodeRequest::",e);
        }
        LogMessages.xmlLog.info(String.valueOf(Return));
        return String.valueOf(Return);
}
    
    public String getLoanProductCodeResponse(String processName,String response) {  
      LogMessages.statusLog.info(response);                 
     //, CustomerId = "", Loanid = "", LoanCategory = "", LoanType = "", TotalCommittment = "", Loanbalance = "", RepaymentAmount = "", DueDate = "", Term = "", InterestRate = "", OverdueAmount = "", OverdueStatus = "", OverdueDays = "", PostingRestrict = "", Writeoff = "";
    LogMessages.statusLog.info("Inside getLoanProductCodeResponse");  
    List<String> ll=new ArrayList<String>();
    
            
            String status = "";//, CustomerId = "", Loanid = "", LoanCategory = "", LoanType = "", TotalCommittment = "", Loanbalance = "", RepaymentAmount = "", DueDate = "", Term = "", InterestRate = "", OverdueAmount = "", OverdueStatus = "", OverdueDays = "", PostingRestrict = "", Writeoff = "";
 
    try {
        // Initialize document builder to parse XML
        //LogMessages.statusLog.info("Inside getLoanProductCodeResponse");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(response));
        Document doc = dBuilder.parse(is);

        // Normalize the document
        doc.getDocumentElement().normalize();

        // Extract successIndicator
        NodeList statusList = doc.getElementsByTagName("successIndicator");
        if (statusList.getLength() > 0) {
            status = statusList.item(0).getTextContent();
            
        }
        if(status.equalsIgnoreCase("Success")){

        // Extract the ns45:CUSTID element
        NodeList custIdList = doc.getElementsByTagName("ns45:CUSTID");
        if (custIdList.getLength() > 0) {
            String custIdContent = custIdList.item(0).getTextContent();
            // Split the custIdContent by '*'
            String[] pairs = custIdContent.split("\\*");
            

            // Iterate over the pairs and split by ':'
            for (String pair : pairs) {
                String[] keyValue = pair.split(":", 2); // Split by the first ':' only
                //if (keyValue.length == 2) {
                    
                    String value = keyValue[1].trim();
                    // Assign each value to its respective variable
                    
                    //obj.put("" + key + "", "" + value + "");
                    ll.add(value);
                    

                //}
            }
            
            
            CustLoanDetResponses cldr=new CustLoanDetResponses();
            cldr.CustomerId=ll.get(0);
            cldr.CustomerName=ll.get(1);
            cldr.DueDate=ll.get(2);
            cldr.InterestRate=ll.get(3);
            cldr.LoanCategory=ll.get(4);
            cldr.LoanType=ll.get(5);
            cldr.Loanbalance=ll.get(6);
            cldr.Loanid=ll.get(7);
            cldr.OverdueAmount=ll.get(8);
            cldr.OverdueDays=ll.get(9);
            cldr.OverdueStatus=ll.get(10);
            cldr.PostingRestrict=ll.get(11);
            cldr.RepaymentAmount=ll.get(12);
            cldr.Term=ll.get(13);
            cldr.TotalCommittment=ll.get(14);
            cldr.Writeoff=ll.get(15);
          
            
        LogMessages.statusLog.info(ll);  
         
        }
        }else{
            LogMessages.statusLog.info("Error in successIndicator of getLoanProductCodeResponse");
        }



        

        }
        
    
         catch (Exception e) {
        //LogMessages.errorLog.error("Exception inside getLoanProductCodeResponse::",e);
        System.out.println("exception inside getLoanProductCodeResponse");
        }
    
    return null;
 }
        
        
        
        
        
       
    
    public String createXML(){
        
        enquiryInputCollection enquiry=new enquiryInputCollection();
        enquiry.columnName="";
        enquiry.criteriaValue="";
        enquiry.operand="";
        
        
        WebRequestCommon webreq=new WebRequestCommon();
        webreq.company="";
        webreq.password="";
        webreq.userName="";
        
        FKLCREDITWORKFLOWAPIType fkl=new FKLCREDITWORKFLOWAPIType();
        fkl.enquiryInputCollection=enquiry;
        
        CreditWorkflowAPI credit=new CreditWorkflowAPI();
        credit.WebRequestCommon=webreq;
        credit.FKLCREDITWORKFLOWAPIType=fkl;
        
        StringWriter stringwriter = new StringWriter();
        
       
    
        
        JAXB.marshal(credit, stringwriter);
        
        
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
        String raw = data.replaceAll("CreditWorkflowAPI", "faul:CreditWorkflowAPI");

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
    

