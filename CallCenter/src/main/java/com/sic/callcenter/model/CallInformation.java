package com.sic.callcenter.model;

import com.sic.callcenter.controller.utils.CallStatus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Represent a call
 * @author Juan-pc
 */
public class CallInformation {
   
    private int id;
    
    private int duration;
    
    private CallStatus status;

    public CallInformation(int id ) {
        
        this.id = id;
        
    }

    /**
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the status
     */
    public CallStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(CallStatus status) {
        this.status = status;
    }
    
    
    
    
}
