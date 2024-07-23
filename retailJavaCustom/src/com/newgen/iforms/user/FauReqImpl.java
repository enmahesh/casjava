
package com.newgen.iforms.user;

import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.user.ProductCodes.EnquiryInputCollection;
import com.newgen.iforms.user.ProductCodes.FKLLOANPRODCODESType;
import com.newgen.iforms.user.ProductCodes.ProductCodes;
import com.newgen.iforms.user.ProductCodes.WebRequestCommon;
import java.io.StringWriter;
import javax.xml.bind.JAXB;

/**
 *
 * @author Rabin
 */
public class FauReqImpl {
    private IFormReference IFormObj;
    
    
    public FauReqImpl(IFormReference ifr)
    {
        IFormObj = ifr;
    }
    
    public String createXML()
    {
        EnquiryInputCollection enq = new EnquiryInputCollection();
        enq.columnName = "col";
        enq.criteriaValue = "cri";
        enq.operand = "ope";
        
        WebRequestCommon webrequestcommon = new WebRequestCommon();
        webrequestcommon.company = "com";        
        webrequestcommon.password = "pas";
        webrequestcommon.userName = "usr";
        
        FKLLOANPRODCODESType fkl = new FKLLOANPRODCODESType();
        fkl.enquiryInputCollection = enq;
        
        ProductCodes productcodes = new ProductCodes();
        productcodes.FKLLOANPRODCODESType = fkl;
        productcodes.WebRequestCommon = webrequestcommon;
        

        StringWriter sw = new StringWriter();
        JAXB.marshal(productcodes, sw);
        String xmlString = sw.toString();
        return xmlString;

    }
    
    public String createXMLwithSOAP(String rawXML)
    {
        String soapBodyXMLString = rawXML.replaceAll("productCodes", "faul:ProductCodes");
        String soapXMLString = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:faul=\"http://temenos.com/FauluCreditWorkflow\">\n" +
                               "<soapenv:Header/> \n" + 
                               "<soapenv:Body> \n" +
                                soapBodyXMLString + 
                               "\n </soapenv:Body>\n" +
                               "</soapenv:Envelope>";
        return soapXMLString;
    }
}
