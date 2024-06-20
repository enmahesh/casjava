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
import com.newgen.iforms.user.LOSCustomerScreening.Request.WebRequestCommon;
import com.newgen.iforms.user.LOSCustomerScreening.Request.OfsFunction;
import com.newgen.iforms.user.LOSCustomerScreening.Request.FKLLOSCUSTSCREENINGCHANNELSType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name = "LOSCustomerScreening", namespace = "http://temenos.com/FauluProjectExodus")

@XmlRootElement(name = "faul:LOSCustomerScreening")
@XmlType(propOrder = { "webRequestCommon", "ofsFunction", "fklloscustscreeningchannelstype" })
public class Root {
    private WebRequestCommon webRequestCommon;
    private OfsFunction ofsFunction;
    private FKLLOSCUSTSCREENINGCHANNELSType fklloscustscreeningchannelstype;

    
    @XmlElement(name = "OfsFunction")
    public OfsFunction getOfsFunction() {
        return ofsFunction;
    }

    public void setOfsFunction(OfsFunction ofsFunction) {
        this.ofsFunction = ofsFunction;
    }

    @XmlElement(name = "FKLLOSCUSTSCREENINGCHANNELSType")
    public FKLLOSCUSTSCREENINGCHANNELSType getFklloscustscreeningchannelstype() {
        return fklloscustscreeningchannelstype;
    }

    public void setFklloscustscreeningchannelstype(FKLLOSCUSTSCREENINGCHANNELSType fklloscustscreeningchannelstype) {
        this.fklloscustscreeningchannelstype = fklloscustscreeningchannelstype;
    }
    
    @XmlElement(name = "WebRequestCommon")
    public WebRequestCommon getWebRequestCommon() {
        return webRequestCommon;
    }

    public void setWebRequestCommon(WebRequestCommon webRequestCommon) {
        this.webRequestCommon = webRequestCommon;
    }

}
