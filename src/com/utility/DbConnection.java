package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection
{
	private Connection connection;
	private String url = "jdbc:oracle:thin:@inchnilpdb03.India.TCS.com:1521:JAVADB03";
	private String user = "E972942";
	private String password = "E972942";
	
	public DbConnection() {
	}

	public Connection getConnection()
	{
		try {
			closeConnection();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void closeConnection()
	{
		try
		{
			if(connection != null && connection.isClosed() == false)
				connection.close();
			connection = null;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}