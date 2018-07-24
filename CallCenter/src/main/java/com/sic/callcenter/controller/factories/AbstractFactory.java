/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sic.callcenter.controller.factories;

import com.sic.callcenter.model.Employee;
import com.sic.callcenter.controller.utils.EmployeeType;

/**
 *
 * @author Juan-pc
 */
public abstract class AbstractFactory {
    
    
    public abstract Employee build( EmployeeType type);
}
