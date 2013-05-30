/**
 * 
 */
package com.waheed.spring.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

/**
 * @author abdul
 *
 */
@Component
public class Operation {
    
    private EmployeeService employeeService;
    
    @Autowired
    @Required
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    protected void addEmployee(Employee employee) {
        long id = employeeService.addEmployee(employee);
        System.out.println("Employee with Id{"+ id + "} was inserted");
        display();
    }
    
    protected Employee getEmployee(long employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        return employee;
    }
    
    
    protected void updateEmployee(Employee employee) {
        employeeService.updateEmployee(employee);
        System.out.println("Updated employee having employeeId: " + employee.getId());
        display(employee.getId());

    }
    
    protected void deleteEmployee(Employee employee) {
        employeeService.deleteEmployee(employee);
        System.out.println("Deleted employee having employeeId: " + employee.getId());
    }
    
    private void display() {
       employeeService.display();
    }
    
    private void display(long employeeId) {
        employeeService.display(employeeId);
    }
}
