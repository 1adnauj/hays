/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sic.callcenter.controller;

import com.sic.callcenter.controller.utils.CallStatus;
import com.sic.callcenter.model.CallInformation;
import com.sic.callcenter.model.Director;
import com.sic.callcenter.model.Employee;
import com.sic.callcenter.model.Operator;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DispatcherTest {

    public DispatcherTest() {
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
     * Test of attendCall method, of class Dispatcher.
     */
    @Test
    public void testAttendCall() {
        System.out.println("attendCall");
        CallInformation call = new CallInformation(0);
        call.setStatus(CallStatus.PENDING);
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
        Dispatcher instance = new Dispatcher(obj);
        instance.attendCall(call);

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(DispatcherTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            assertTrue(call.getStatus() != CallStatus.PENDING);
        }

    }

    public void testAttendTenCalls() {
        System.out.println("attendCall");

        ArrayList<Employee> obj = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            Employee ope = new Operator();
            ope.setAvaliable(true);

            obj.add(ope);
        }

        Dispatcher instance = new Dispatcher(obj);
        ArrayList<CallInformation> calls = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            CallInformation call = new CallInformation(i);
            call.setStatus(CallStatus.PENDING);
            instance.attendCall(call);
            calls.add(call);
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(DispatcherTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            for (int i = 0; i < 10; i++) {
                assertTrue(calls.get(i).getStatus() != CallStatus.PENDING);
            }

        }

    }

}
