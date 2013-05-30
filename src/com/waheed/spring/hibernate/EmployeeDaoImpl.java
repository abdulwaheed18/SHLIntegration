/**
 * 
 */
package com.waheed.spring.hibernate;

import java.util.Iterator;

import org.springframework.stereotype.Repository;

/**
 * Data access object for {@link Employee}s.
 * 
 * @author abdul
 * 
 */
@Repository
public class EmployeeDaoImpl extends DaoImpl implements EmployeeDao {

	@Override
	public long addEmployee(Employee employee) {
		return createObject(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		deleteObject(employee);
	}

	@Override
	public Employee getEmployee(long id) {
		return getObject(Employee.class, id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return updateObject(employee);
	}

	@Override
	public Iterator<Employee> getEmployees() {
		return getObjects(Employee.class);
	}
}
