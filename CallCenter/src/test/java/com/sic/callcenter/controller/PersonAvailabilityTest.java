/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sic.callcenter.controller;

import com.sic.callcenter.model.Director;
import com.sic.callcenter.model.Employee;
import com.sic.callcenter.model.Operator;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan-pc
 */
public class PersonAvailabilityTest {
    
    public PersonAvailabilityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GetAvaliablePerson method, of class PersonAvailability.
     */
    @Test
    public void testGetAvaliablePerson() {
        System.out.println("GetAvaliablePerson");
          ArrayList<Employee> obj = new ArrayList<>();
         
         Employee bussy = new Operator();
         bussy.setAvaliable(false);
         
         obj.add(bussy);
         
         Employee director = new Director();
         director.setAvaliable(true);
         
         obj.add(director);
         
         Employee free = new Operator();
         free.setAvaliable(true);
         
         obj.add(free);
        
        PersonAvailability instance = new PersonAvailability(obj);
        Employee expResult = free;
        Employee result = instance.GetAvaliablePerson();
        assertEquals(expResult, result);
       
    }
    
      @Test
    public void testGetNotAvaliablePerson() {
        System.out.println("GetAvaliablePerson");
          ArrayList<Employee> obj = new ArrayList<>();
         
         Employee bussy = new Operator();
         bussy.setAvaliable(false);
         
         obj.add(bussy);
         
         Employee director = new Director();
         director.setAvaliable(false);
         
         obj.add(director);
         
         Employee free = new Operator();
         free.setAvaliable(false);
         
         obj.add(free);
        
        PersonAvailability instance = new PersonAvailability(obj);
        Employee expResult = null;
        Employee result = instance.GetAvaliablePerson();
        assertEquals(expResult, result);
       
    }
    
}
