/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.iforms.user.CollateralCover;

import com.newgen.iforms.common.LogMessages;
import com.newgen.iforms.user.CollateralCover.Request.CHANNELSAADETAILSCOLLATERALType;
import com.newgen.iforms.user.CollateralCover.Request.CHANNELSAADETAILSCOLLATERALType;
import com.newgen.iforms.user.CollateralCover.Request.WebRequestCommon;
import com.newgen.iforms.user.CollateralCover.Request.enquiryInputCollection;
import com.newgen.iforms.user.CollateralCover.Request.collateralCover;
import com.newgen.iforms.user.CollateralCover.Request.collateralCover;
import com.newgen.iforms.user.CollateralCover.Response.CollateralCoverDetailsResponses;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.JAXB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.simple.JSONObject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author User
 */
public class CollateralCoverDetails {
    public  String getCollateralCoverDetailsRequest(String stringData){
        System.out.println("Entered getLoanProductCodeRequest");
    
		StringBuilder toReturn=new StringBuilder();
        try {
             LogMessages.xmlLog.info("Inside getLoanProductCodeRequest");
//        	Date n = new Date();
//            DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.mmm");
//            String b = stringData.split("#",-1)[1].substring(0,3);
            
            String rawXML=createXML();
            toReturn.append(createXMLwithSOAP(rawXML));   
            
                    
            
            
            

        }catch(Exception e) {
        	LogMessages.errorLog.info("Exception inside getLoanProductCodeRequest::",e);
        }
        LogMessages.xmlLog.info(String.valueOf(toReturn));
        return String.valueOf(toReturn);
}
	
	public String getCollateralCoverDetailsResponse(String processName,String response) {   
            
             System.out.println("Entered getLoanProductCodeResponse");   
            
            String status = "";//, CustomerId = "", Loanid = "", LoanCategory = "", LoanType = "", TotalCommittment = "", Loanbalance = "", RepaymentAmount = "", DueDate = "", Term = "", InterestRate = "", OverdueAmount = "", OverdueStatus = "", OverdueDays = "", PostingRestrict = "", Writeoff = "";
    JSONArray jsonArray=new JSONArray();
        JSONObject obj=new JSONObject();
    try {
        // Initialize document builder to parse XML
        LogMessages.statusLog.info("Inside getLoanProductCodeResponse");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(response));
        Document doc = dBuilder.parse(is);

        // Normalize the document
        doc.getDocumentElement().normalize();

        // Extract successIndicator
         status = doc.getElementsByTagName("successIndicator").item(0).getTextContent();;
        
        if(status.equalsIgnoreCase("Success")){

//        String hdr,currency;
//            
//            String executionValue = null;
//            String thirdParty = null;
//            String netValue = null;
//            String nominalValue = null;
//            String expiryDate = null;
//            String benName = null;
//            String typeDescription = null;
CollateralCoverDetailsResponses ccr=new CollateralCoverDetailsResponses();

            // Extract each value and assign to respective strings using separate NodeList variables
            NodeList hdrNodeList = doc.getElementsByTagName("ns80:HDR");
            if (hdrNodeList.getLength() > 0) {
                ccr.hdr = hdrNodeList.item(0).getTextContent();
            }

            NodeList typeDescriptionNodeList = doc.getElementsByTagName("ns80:TYPEDESCRIPTION");
            if (typeDescriptionNodeList.getLength() > 0) {
                ccr.typeDescription = typeDescriptionNodeList.item(0).getTextContent();
            }

            NodeList currencyNodeList = doc.getElementsByTagName("ns80:CURRENCY");
            if (currencyNodeList.getLength() > 0) {
                ccr.currency = currencyNodeList.item(0).getTextContent();
            }

            NodeList executionValueNodeList = doc.getElementsByTagName("ns80:EXECUTIONVALUE");
            if (executionValueNodeList.getLength() > 0) {
                ccr.executionValue = executionValueNodeList.item(0).getTextContent();
            }

            NodeList thirdPartyNodeList = doc.getElementsByTagName("ns80:THIRDPARTY");
            if (thirdPartyNodeList.getLength() > 0) {
                ccr.thirdParty = thirdPartyNodeList.item(0).getTextContent();
            }

            NodeList netValueNodeList = doc.getElementsByTagName("ns80:NETVALUE");
            if (netValueNodeList.getLength() > 0) {
                ccr.netValue = netValueNodeList.item(0).getTextContent();
            }

            NodeList nominalValueNodeList = doc.getElementsByTagName("ns80:NOMINALVALUE");
            if (nominalValueNodeList.getLength() > 0) {
                ccr.nominalValue = nominalValueNodeList.item(0).getTextContent();
            }

            NodeList expiryDateNodeList = doc.getElementsByTagName("ns80:EXPIRYDATE");
            if (expiryDateNodeList.getLength() > 0) {
                ccr.expiryDate = expiryDateNodeList.item(0).getTextContent();
            }

            NodeList benNameNodeList = doc.getElementsByTagName("ns80:BENNAME");
            if (benNameNodeList.getLength() > 0) {
                ccr.benName = benNameNodeList.item(0).getTextContent();
            }
            
            LogMessages.xmlLog.info(ccr.benName+" "+ccr.expiryDate+" "+ccr.typeDescription+" "+ccr.nominalValue+" "+ccr.netValue+" "+ccr.thirdParty+" "+ccr.executionValue+" "+ccr.currency);
            
            
        }
        else{
            LogMessages.xmlLog.info("There is some error in fetching collateralCover SuccesIndicator set to Failure");
        }
            
        
        
    }
    catch(Exception e){
        LogMessages.errorLog.info("Exception inside getCollateralCoverDetailsResponse");
    }
    
    return "";
        }

        
        
        
        
        
        
        
        
        
        
        
        
        
       
		 
            
            
            /*String Status="";
			try {
				LogMessages.statusLog.info("Inside getAccResponse");
			
		         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		         InputSource is = new InputSource(new StringReader(response));
		         Document doc = dBuilder.parse(is);

		         doc.getDocumentElement().normalize();
		         
		         NodeList sList = doc.getElementsByTagName("HostTransaction");
			     
		        	 Node snNode=sList.item(0);
		        	 
		             if (snNode.getNodeType() == Node.ELEMENT_NODE) {
		        		    Element sElement = (Element) snNode;
		        		
		                    Status=sElement.getElementsByTagName("Status").item(0).getTextContent();
		                    
		                    if(Status.equals("SUCCESS")) {
		           	         NodeList nList = doc.getElementsByTagName("GeneralAcctInquiryOutputVO");
		           	     
		           	         for (int temp = 0; temp < nList.getLength(); temp++) {
		           	        	 Node nNode=nList.item(temp);
		           	        	 
		           	             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		           	        		    Element eElement = (Element) nNode;
		           	        		
		           	                    AccountName=eElement.getElementsByTagName("acctName").item(0).getTextContent();
		           	                }
		           	   
		           	      
                                            }
			      			
		                    }else if(Status.equals("FAILURE")) {
		  		            	  NodeList sList1 = doc.getElementsByTagName("ErrorDetail");
		 		 			      Node snNode1=sList1.item(0);
		 		 		          if (snNode1.getNodeType() == Node.ELEMENT_NODE) {
			 		        		    Element sElement1 = (Element) snNode1;
			 		        		   String errSource="";
			 		                    String errCode=sElement1.getElementsByTagName("ErrorCode").item(0).getTextContent();
			 		                    String errDesc=sElement1.getElementsByTagName("ErrorDesc").item(0).getTextContent();
			 		                 
			 		                    String errType=sElement1.getElementsByTagName("ErrorType").item(0).getTextContent();
			 		                   LogMessages.statusLog.error("****Inside Account Inquiry Failure****");
			 		                   LogMessages.statusLog.error("errCode:"+errCode+" errDesc:"+errDesc+" errType:"+errType);
			 		                  return  Status+"@"+errCode+"@"+errDesc+"@"+errType+"@";
			 		                  //return null;
		 		 		          }
		 		              }
		              }
		       
		      } catch (Exception e) {
                   LogMessages.errorLog.error("Exception inside getAccResponse::",e);
		      }
			return null;			
		}*/
        
        
         
    public String createXML()
    {
        enquiryInputCollection enq = new enquiryInputCollection();
        enq.columnName = "col";
        enq.criteriaValue = "cri";
        enq.operand = "ope";
        
        
        WebRequestCommon webrequest = new WebRequestCommon();
        webrequest.company = "comp";        
        webrequest.password = "pas";
        webrequest.userName = "usr";
        
        CHANNELSAADETAILSCOLLATERALType channel=new CHANNELSAADETAILSCOLLATERALType();
        channel.enquiryInputCollection=enq;
        
        
       
        
        collateralCover cover=new collateralCover();
        cover.WebRequestCommon=webrequest;
        cover.CHANNELSAADETAILSCOLLATERALType=channel;
        
       
        
        StringWriter sw = new StringWriter();
        
       
    
        
        JAXB.marshal(cover, sw);
        
        
        //marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        String xmlString = sw.toString();
    int index = xmlString.indexOf("?>");
    if (index != -1) {
        xmlString = xmlString.substring(index + 2).trim();
    }

    return xmlString;

    
}
    
     public String createXMLwithSOAP(String rawXML) {
        StringBuilder sb = new StringBuilder();
        String raw = rawXML.replaceAll("collateralCover", "faul-collateralCover");

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
