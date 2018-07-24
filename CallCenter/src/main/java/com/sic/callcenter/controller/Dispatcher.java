package com.sic.callcenter.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan-pc
 */
import com.sic.callcenter.controller.utils.CallStatus;
import com.sic.callcenter.interfaces.IDispatcher;
import com.sic.callcenter.model.CallInformation;
import com.sic.callcenter.model.Employee;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Dispatch the incoming calls
 * 
 * @author Juan-pc
 */
public class Dispatcher implements IDispatcher {

    private ArrayList<Employee> obj;
    private PersonAvailability pAvalia;

    public Dispatcher(ArrayList<Employee> obj) {

        this.obj = obj;
        pAvalia = new PersonAvailability(obj);

    }

    /**
     * Defined a thread pool with size 10
     */
    ExecutorService executor = Executors.newFixedThreadPool(10);

    /**
     * Attend a incoming call assign a thread
     * 
     * @param call 
     */
    public void attendCall(CallInformation call) {

        Runnable worker = new WorkerThread(call, this);
        executor.execute(worker);
       

    }

    @Override
    public void dispatchCall(CallInformation call) {

    TryAttend(call, 0);

    }

    /**
     * try to assign a employee to answer the call, try 100 times if there not a free employee discard the call 
     * @param call
     * @param number tried 
     * @return 
     */
    private boolean TryAttend(CallInformation call, int number) {
        Employee avali;
        synchronized (pAvalia) {
            avali = pAvalia.GetAvaliablePerson();
        }

        if (avali != null) {
            avali.AnswerCall(call);
            return true;
        }
        call.setStatus(CallStatus.WAITING);
        if (number < 100) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

                return TryAttend(call, number + 1);
            }
        }
        call.setStatus(CallStatus.DISCARDED);
        return false;

    }

}
