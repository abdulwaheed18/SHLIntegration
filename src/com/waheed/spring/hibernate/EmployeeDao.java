package com.waheed.spring.hibernate;

import java.util.Iterator;

/**
 * Data access object for {@link Employee}s.
 * 
 * @author abdul
 *
 */
public interface EmployeeDao {
    
    public long addEmployee(Employee employee);

    public void deleteEmployee(Employee employee);
    
    public Employee getEmployee(long id);
    
    public Iterator<Employee> getEmployees();
    
    public Employee updateEmployee(Employee employee);
}
