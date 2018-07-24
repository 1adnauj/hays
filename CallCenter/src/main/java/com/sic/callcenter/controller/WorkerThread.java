package com.sic.callcenter.controller;


import com.sic.callcenter.interfaces.IDispatcher;
import com.sic.callcenter.model.CallInformation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Representation of a worked thread 
 * @author Juan-pc
 */
public class WorkerThread implements Runnable {
  
    private CallInformation call;
    private IDispatcher dispatch;
    
    /**
     * 
     * @param call 
     * @param dispatch 
     */
    public WorkerThread(CallInformation call, IDispatcher   dispatch  ){
     this.call = call;
     this.dispatch = dispatch;  
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Process  ");
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processCommand() {
        
        dispatch.dispatchCall(call);
        
        try {
            //give the priority of the current threads
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return "";
    }
}