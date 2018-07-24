/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sic.callcenter.controller;

import com.sic.callcenter.controller.utils.EmployeeType;
import com.sic.callcenter.model.Director;
import com.sic.callcenter.model.Employee;
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
public class CallCenterControllerTest {
    
    public CallCenterControllerTest() {
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
     * Test of getEmployees method, of class CallCenterController.
     */
    @Test
    public void testGetEmployees() {
        System.out.println("getEmployees");
        CallCenterController instance = new CallCenterController();
        ArrayList<Employee> expResult = null;
        ArrayList<Employee> result = instance.getEmployees();
        assertNotNull(result);
        
    }

    /**
     * Test of addEmployee method, of class CallCenterController.
     */
    @Test
    public void testAddEmployee() {
        System.out.println("addEmployee");
        EmployeeType type = EmployeeType.DIRECTOR;
        CallCenterController instance = new CallCenterController();
        instance.addEmployee(type);
        assertTrue( instance.getEmployees().get(0) instanceof Director);
    }

    /**
     * Test of removeEmployee method, of class CallCenterController.
     */
    @Test
    public void testRemoveEmployee() {
        System.out.println("removeEmployee");
        CallCenterController instance = new CallCenterController();
        EmployeeType type = EmployeeType.DIRECTOR;
        instance.addEmployee(type);
        
        instance.removeEmployee();
        assertFalse(instance.getEmployees().size()>0);
       
    }

    
    
}
