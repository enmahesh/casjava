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

public class OfsFunction {
    private String messageId;

    @XmlElement(name = "messageId")
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
