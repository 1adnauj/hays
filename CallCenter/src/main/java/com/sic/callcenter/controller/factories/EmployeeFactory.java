/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sic.callcenter.controller.factories;

import com.sic.callcenter.model.Director;
import com.sic.callcenter.model.Employee;
import com.sic.callcenter.model.Operator;
import com.sic.callcenter.model.Supervisor;
import com.sic.callcenter.controller.utils.EmployeeType;

/**
 *
 * @author Juan-pc
 */
public class EmployeeFactory extends AbstractFactory
{

    @Override
    public Employee build(EmployeeType type) {
          Employee emp = null;

        switch (type.ordinal()) {
            case 0:
                emp = new Operator();
                break;
            case 1:
                emp = new Supervisor();
                break;

            default:
                emp = new Director();
                break;
        }

        emp.setAvaliable(true);
        return emp;
    
    }
    
}
