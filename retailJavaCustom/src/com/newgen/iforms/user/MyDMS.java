/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newgen.iforms.user;

import com.newgen.iforms.custom.IFormListenerFactory;
import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.custom.IFormServerEventHandler;

/**
 *
 * @author Rabin
 */
public class MyDMS implements IFormListenerFactory {

    @Override
    public IFormServerEventHandler getClassInstance(IFormReference ifr) {
        System.out.println("Inside process MyDMS....");
        
        return new MyDMS_Custom();
        }
    
}
