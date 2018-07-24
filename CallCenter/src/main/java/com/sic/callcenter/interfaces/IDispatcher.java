package com.sic.callcenter.interfaces;

import com.sic.callcenter.model.CallInformation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Give the ability to Dispatch a call
 * @author Juan-pc
 */
public interface IDispatcher {

    void dispatchCall(CallInformation call);
    
}
