/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.iforms.user;

import com.newgen.iforms.common.LogMessages;
import com.newgen.iforms.custom.IFormListenerFactory;
import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.custom.IFormServerEventHandler;

import com.newgen.iforms.custom.IFormListenerFactory;

/**
 *
 * @author User
 */
public class MSME implements IFormListenerFactory {

    @Override
    public IFormServerEventHandler getClassInstance(IFormReference ifr) {
        LogMessages.statusLog.info("MSME Project begins::: ");
        return new MSME_Custom();
    }
    
}
