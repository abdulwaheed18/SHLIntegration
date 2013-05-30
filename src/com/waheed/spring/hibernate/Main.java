package com.waheed.spring.hibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * A small tutorial on spring-hibernate-Liquibase integration and uses CURD operation.
 * 
 * @author abdul
 */
public class Main {

    private static final String APP_FILE = "beans.xml";

    public static void main(String[] args) {
        
        //loads context information from an XML file which is present in classpath.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(APP_FILE);
        
        //used to retrieve the "operation" bean from the Spring framework
        Operation operation = (Operation)context.getBean("operation");
        
        // Add employee object to the database
        Employee employee = new Employee();
        employee.setCountry("INDIA");
        employee.setGender("M");
        employee.setName("SACHIN");
        employee.setAboutYou("CRICKETER");
        operation.addEmployee(employee);
        
        //Get employee details
        operation.getEmployee((long)1);
        
        //Update the employee details
        Employee employee1 = operation.getEmployee((long)1);
        employee1.setName("Tendulkar");
        operation.updateEmployee(employee1);
        
        //Delete employee having id
        Employee employee2 = operation.getEmployee((long)1);
        operation.deleteEmployee(employee2);
    }
}
