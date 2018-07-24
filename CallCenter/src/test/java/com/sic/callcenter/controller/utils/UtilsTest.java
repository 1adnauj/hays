/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sic.callcenter.controller.utils;

import com.sic.callcenter.controller.PersonAvailability;
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
public class UtilsTest {
    
    public UtilsTest() {
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
     * Test of randInt method, of class Utils.
     */
    @Test
    public void testRandInt() {
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

    /**
     * Test of instance method, of class Utils.
     */
    @Test
    public void testInstance() {
        System.out.println("instance");
        Utils expResult = Utils.instance();
        Utils result = Utils.instance();
        assertEquals(expResult, result);
      
    }
    
}
