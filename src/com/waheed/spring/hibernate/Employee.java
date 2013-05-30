/**
 * 
 */
package com.waheed.spring.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents the Employee schema.
 * 
 * @author abdul
 */
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name="EMPLOYEE_ID")
    private long id;

    @Column(name="NAME")
    private String name;
    
    @Column(name="GENDER")
    private String gender;
    
    @Column(name="COUNTRY")
    private String country;
    
    @Column(name="ABOUT_YOU")
    private String aboutYou;

    /**
     * @return employee id
     */
    public long getId() {
        return id;
    }
    
    /**
     * The employeeId attribute is auto_incemement. The value get set automatically while creating 
     * new employee.
     * 
     * @param id
     *         the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * @return employee name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name
     *        the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return employee gender
     */
    public String getGender() {
        return gender;
    }
    
    /**
     * @param gender
     *         the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    /**
     * @return employee country
     */
    public String getCountry() {
        return country;
    }
    
    /**
     * @param country
     *          the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
    
    /**
     * @return employee profile
     */
    public String getAboutYou() {
        return aboutYou;
    }
    
    /**
     * @param aboutYou
     *            the aboutYou to set
     */
    public void setAboutYou(String aboutYou) {
        this.aboutYou = aboutYou;
    }
    
    public String toString() {
        return "Employee[Id="+getId()+", Name=" + getName() + 
        		"Gender=" + getGender() + ", Country=" + getCountry() + ", About You= " + getAboutYou()+ "]"; 
    }

}
