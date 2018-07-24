package com.sic.callcenter.interfaces;

import com.sic.callcenter.model.CallInformation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan-pc
 * Give the ability to answer the call 
 */

public interface ICallResponse {
    /**
     * attend a call
     * @param call 
     */
    void AnswerCall(CallInformation call);
    
}
