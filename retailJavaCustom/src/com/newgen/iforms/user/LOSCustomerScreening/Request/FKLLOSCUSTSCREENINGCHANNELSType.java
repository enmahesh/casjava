/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.iforms.user.LOSCustomerScreening.Request;

/**
 *
 * @author User
 */
import javax.xml.bind.annotation.XmlElement;

public class FKLLOSCUSTSCREENINGCHANNELSType {
    private String CUSTOMER;
    private String IPRSCHECK;
    private String ACCOUNT;
    private String CUSTOMERRATING;
    private String CRBSTATUS;
    private String id;
    private String text;
   

    @XmlElement(name = "fkl:CUSTOMER")
    public String getCUSTOMER() {
        return CUSTOMER;
    }

    public void setCUSTOMER(String CUSTOMER) {
        this.CUSTOMER = CUSTOMER;
    }

    @XmlElement(name = "fkl:IPRSCHECK")
    public String getIPRSCHECK() {
        return IPRSCHECK;
    }

    public void setIPRSCHECK(String IPRSCHECK) {
        this.IPRSCHECK = IPRSCHECK;
    }

    @XmlElement(name = "fkl:ACCOUNT")
    public String getACCOUNT() {
        return ACCOUNT;
    }

    public void setACCOUNT(String ACCOUNT) {
        this.ACCOUNT = ACCOUNT;
    }

    @XmlElement(name = "fkl:CUSTOMERRATING")
    public String getCUSTOMERRATING() {
        return CUSTOMERRATING;
    }

    public void setCUSTOMERRATING(String CUSTOMERRATING) {
        this.CUSTOMERRATING = CUSTOMERRATING;
    }

    @XmlElement(name = "fkl:CRBSTATUS")
    public String getCRBSTATUS() {
        return CRBSTATUS;
    }

    public void setCRBSTATUS(String CRBSTATUS) {
        this.CRBSTATUS = CRBSTATUS;
    }

    @XmlElement(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
