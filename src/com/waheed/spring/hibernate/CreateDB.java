package com.waheed.spring.hibernate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * This class will create the Employee database if not exist.
 * 
 * @author abdul
 *
 */
@Component
public class CreateDB {

	private JdbcTemplate jdbcTemplate;
	private String dbName;
	
	@PostConstruct
	public void init() throws Exception {
		  System.out.println("Creating database : " + dbName);
		  try {
		  jdbcTemplate.execute("CREATE DATABASE IF NOT EXISTS " + dbName);
		  } catch(Exception e) {
				throw new Exception("Can not create "+ dbName +" database. Please make sure your DB settings are right");  
		  }
	}

	/**
	 * @return the dbName
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @param dbName the dbName to set
	 */
	@Autowired
	@Required
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	@Autowired
	@Required
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
}
