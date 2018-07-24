package com.sic.callcenter.model;

import com.sic.callcenter.controller.utils.CallStatus;
import com.sic.callcenter.controller.utils.Utils;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sic.callcenter.interfaces.ICallResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * base representation of employee
 *
 * @author Juan-pc
 */
public class Employee implements ICallResponse {

    private boolean _avaliable;
    private CallInformation answercall;

    /**
     * @return the _avaliable
     */
    public boolean isAvaliable() {
        return _avaliable;
    }

    /**
     * @param _avaliable the _avaliable to set
     */
    public void setAvaliable(boolean _avaliable) {
        this._avaliable = _avaliable;
    }

    @Override
    public void AnswerCall(CallInformation call) {

        _avaliable = false;
        answercall = call;
        call.setStatus(CallStatus.PROGRESS);
        // the call time is between 5 to 10 sec
        call.setDuration(Utils.instance().randInt(5000, 10000));

        try {
            Thread.sleep(call.getDuration());
        } catch (InterruptedException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            _avaliable = true;
            answercall = null;
              call.setStatus(CallStatus.ENDED);
        }

    }

    /**
     * @return the answercall
     */
    public CallInformation getAnswercall() {
        return answercall;
    }

}
