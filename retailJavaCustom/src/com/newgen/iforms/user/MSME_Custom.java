/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.iforms.user;

import com.newgen.iforms.FormDef;
import com.newgen.iforms.common.APIConsumption;
import com.newgen.iforms.common.LogMessages;
import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.custom.IFormServerEventHandler;
import com.newgen.iforms.user.custLoanDet.CustLoanDet;
import com.newgen.iforms.user.CollateralCover.CollateralCoverDetails;
import com.newgen.iforms.user.LOSCustomerScreening.LOSCustomerScreening;
import com.newgen.iforms.user.ProductCodes.LoanProductCode;
import java.io.IOException;
import org.json.simple.JSONArray;

/**
 *
 * @author User
 */
public class MSME_Custom implements IFormServerEventHandler {

    @Override
    public void beforeFormLoad(FormDef fd, IFormReference ifr) {
        System.out.println("MSME Entered beforeload");
        
         LogMessages.statusLog.info("Inside before formload");
       
         
         
        
        ifr.setValue("CustomerId","Shraddha"); //To change body of generated methods, choose Tools | Templates.
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String setMaskedValue(String string, String string1) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return string1;
    }

    @Override
    public JSONArray executeEvent(FormDef fd, IFormReference ifr, String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String executeServerEvent(IFormReference iFormObj, String eventType, String controlName, String stringData) {
        LogMessages.statusLog.info("Inside executeServerEvent");
        
        try {
            LogMessages.statusLog.info("controlName is: " + controlName + " eventType is: " + eventType + " IFormReference is: " + iFormObj);
            switch (controlName) {
                case "click":                    
                   LogMessages.statusLog.info("Entered click controlname");
                   return handleClickEvent(iFormObj, eventType, stringData);
                case "FormLoad":
                    break;
                case "MOUSE_CLICKED":
                    break;
                case "VALUE_CHANGED":
                    break;
                case "submit":
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            LogMessages.statusLog.info("Exception --" + e);
        }
        return "";
    }
    private String handleClickEvent(IFormReference iFormObj, String eventType, String stringData) throws IOException {
       LogMessages.statusLog.info("Entered handleClickEvent");
        switch (eventType) {
            case "apicollateralCover":
                return apicollateralCover(stringData);
            case "apiCustLoanDet":
                return apiCustLoanDet(stringData);
            case "apiLoanProductCode":
                return apiLoanProductCode(stringData);
                
            case "apiLOSCustomerScreening":
                return apiLOSCustomerScreening(stringData);
            default:
                return "";
        }
    }


    @Override
    public JSONArray validateSubmittedForm(FormDef fd, IFormReference ifr, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String executeCustomService(FormDef fd, IFormReference ifr, String string, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCustomFilterXML(FormDef fd, IFormReference ifr, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String apicollateralCover(String stringData) {
        LogMessages.statusLog.info("Entered apiCollateralCover");
        CollateralCoverDetails ccd = new CollateralCoverDetails();
        APIConsumption ap = new APIConsumption();
        String requestapicollateralCover = ccd.getCollateralCoverDetailsRequest(stringData);
        LogMessages.statusLog.info(requestapicollateralCover);
        //LogMessages.xmlLog.info(requestapicollateralCover);
        
        String res = ap.consumeAPI(requestapicollateralCover, "");
        
        LogMessages.xmlLog.info(res);
        
        
        String responseapicollateralCover = ccd.getCollateralCoverDetailsResponse("", res);
        
        
        
        
        
        return responseapicollateralCover;    
    }
    private String apiCustLoanDet(String stringData){
        CustLoanDet cld=new CustLoanDet();
        APIConsumption api=new APIConsumption();
        String requestsapiCustLoanDet=cld.getCustLoanDetRequest(stringData);
        LogMessages.statusLog.info(requestsapiCustLoanDet);
        //LogMessages.xmlLog.info(requestsapiCustLoanDet);
        String ress = api.consumeAPI(requestsapiCustLoanDet, "");
        String responseapiCustLoanDet = cld.getLoanProductCodeResponse("", ress);
        LogMessages.statusLog.info(responseapiCustLoanDet);
        
        
        return responseapiCustLoanDet;
    }
    private String apiLoanProductCode(String stringData){
        LoanProductCode lpc=new LoanProductCode();
        APIConsumption api=new APIConsumption();
        String requestapiLoanProductCode=lpc.getLoanProductCodeRequest(stringData);
        LogMessages.statusLog.info(requestapiLoanProductCode);
        //LogMessages.xmlLog.info(requestapiLoanProductCode);
        String ress = api.consumeAPI(requestapiLoanProductCode, "");
        String responseapiLoanProductCode = lpc.getLoanProductCodeResponse("", ress);
        LogMessages.statusLog.info(responseapiLoanProductCode);
        
        
        return responseapiLoanProductCode;
    }
    
    private String apiLOSCustomerScreening(String stringData){
        LOSCustomerScreening lpc=new LOSCustomerScreening();
        APIConsumption api=new APIConsumption();
        String requestapiLOSCustomerScreening=lpc.getLOSCustomerScreeningRequest(stringData);
        LogMessages.statusLog.info(requestapiLOSCustomerScreening);
        //LogMessages.xmlLog.info(requestapiLOSCustomerScreening);
        String ress = api.consumeAPI(requestapiLOSCustomerScreening, "");
        String responseapiLOSCustomerScreening = lpc.getLOSCustomerScreeningResponse("", ress);
        LogMessages.statusLog.info(responseapiLOSCustomerScreening);
        
        
        return responseapiLOSCustomerScreening;
    }


    
}
