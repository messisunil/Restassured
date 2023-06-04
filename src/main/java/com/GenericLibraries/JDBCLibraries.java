package com.GenericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * this class consists of methods related to datbase operations.
 * @author sunil
 *
 */
public class JDBCLibraries {
	protected Connection connect;
	protected Statement statement;
	/**
	 * this method is used to initialize database
	 */
	public void initializeDatabase() {
		Driver dbDriver = null;
		try {
			dbDriver = new Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			DriverManager.registerDriver(dbDriver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connect = DriverManager.getConnection(IDatabaseConstants.dbURL,IDatabaseConstants.dbUsername,IDatabaseConstants.dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement = connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * this method is used to validate the project is present in the database or not.
	 * @param sqlQuery
	 * @param expectedData
	 * @return
	 */
	public String validateProject(String sqlQuery, String expectedData) {
		ResultSet result = null;
		try {
			result = statement.executeQuery(sqlQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean flag = false;
		try {
			while(result.next())
			{
				String actualData = result.getString(1);
				if(actualData.equalsIgnoreCase(expectedData))
				{
					flag = true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(flag)
			return "verified";
		else
			return "project is not present";
	}
	
	/**
	 * this method is used to close database.
	 */
	public void closeDatabase() {
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
