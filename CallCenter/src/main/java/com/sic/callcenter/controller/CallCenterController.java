package com.sic.callcenter.controller;

import com.sic.callcenter.controller.factories.AbstractFactory;
import com.sic.callcenter.controller.factories.EmployeeFactory;
import com.sic.callcenter.controller.utils.CallStatus;
import com.sic.callcenter.model.CallInformation;
import com.sic.callcenter.model.Director;
import com.sic.callcenter.model.Employee;
import com.sic.callcenter.model.Operator;
import com.sic.callcenter.model.Supervisor;
import com.sic.callcenter.controller.utils.EmployeeType;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

/**
 * Control the actions over the call center
 *
 * @author Juan-pc
 */
public class CallCenterController {

    private ArrayList<Employee> employees;
    private Dispatcher dispatcher;
    private int countCalls = 0;
    
    private AbstractFactory factory;

    public CallCenterController( ) {
     
        factory = new EmployeeFactory();
        employees = new ArrayList<>();
        dispatcher = new Dispatcher(employees);
    }

    /**
     * @return the employees
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Create a new employee with the required type
     *
     * @param type
     */
    public void addEmployee(EmployeeType type) {

       Employee emp = factory.build(type);

        employees.add(emp);

    }

    /**
     * Remove the last free Employee
     */
    public void removeEmployee() {
        for (int i = employees.size()-1; i > -1; i--) {

            Employee emp = employees.get(i);
            if (emp.isAvaliable()) {

                synchronized (employees) {
                    employees.remove(emp);
                }
                return;
            }

        }

    }

    /**
     * report that a new call is arrive
     */
    public void arriveCall() {

        CallInformation call = new CallInformation(countCalls);
        call.setStatus(CallStatus.PENDING);
        countCalls++;
        dispatcher.attendCall(call);
    }

}
