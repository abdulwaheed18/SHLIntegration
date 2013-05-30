/**
 * 
 */
package com.waheed.spring.hibernate;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Provide methods to work with Employees.
 * 
 * @author abdul
 * 
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public long addEmployee(Employee employee) {
		long id = employeeDao.addEmployee(employee);
		return id;
	}

	@Override
	@Transactional
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);

	}

	@Override
	@Transactional
	public void display() {
		Iterator<Employee> employees = employeeDao.getEmployees();
		while (employees.hasNext()) {
			System.out.println(employees.next().toString());
		}
	}

	@Override
	@Transactional
	public void display(long employeeId) {
		Employee employee = employeeDao.getEmployee(employeeId);
		System.out.println(employee);
	}

	@Override
	@Transactional
	public Employee getEmployee(long employeeId) {
		Employee employee = employeeDao.getEmployee(employeeId);
		return employee;
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Autowired
	@Required
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
}
