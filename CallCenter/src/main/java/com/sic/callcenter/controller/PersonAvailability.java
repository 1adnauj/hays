package com.sic.callcenter.controller;


import com.sic.callcenter.model.Supervisor;
import com.sic.callcenter.model.Employee;
import com.sic.callcenter.model.Operator;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan-pc
 */
public class PersonAvailability {
    
    
    private ArrayList<Employee> obj;

    public PersonAvailability(  ArrayList<Employee> obj ) {
        
        this.obj = obj;
    }
        
        
    /**
     * Try to find a avaliable Employee if not return null
     * Looks first the operators then the supervisor and last directors
     * 
     * @return a employee
     */
    public Employee GetAvaliablePerson()
    {
    
        Employee avaliable= null;
        
         ArrayList<Employee> supp = new ArrayList<>();
         ArrayList<Employee> direc = new ArrayList<>();
         
        
        for (Employee person : obj) {
            
            if (person instanceof Operator) {
                
            
                if (person.isAvaliable()) {
                    avaliable = person;
                    avaliable.setAvaliable(false);
                    return avaliable;
                }
            }else
            {
            
                if (person instanceof Supervisor) {
                    supp.add(person);
                    
                }else{
                
                    
                    direc.add(person);
                }
                
            
            }
            
        }
        
        
        for (Employee employee : supp) {

             if (employee.isAvaliable()) {
                    avaliable = employee;
                    avaliable.setAvaliable(false);
                    return avaliable;
                }
        }
        
        for (Employee employeedic : direc) {
            
             if (employeedic.isAvaliable()) {
                    avaliable = employeedic;
                    avaliable.setAvaliable(false);
                    return avaliable;
                }
            
        }
        
        
        return  avaliable;
    }
    
    
    
    
}
