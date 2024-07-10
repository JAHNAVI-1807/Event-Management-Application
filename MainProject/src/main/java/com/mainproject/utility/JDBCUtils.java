package com.mainproject.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
	private static final String dburl = "jdbc:mysql://localhost:3306/sample";
	private static final String dbuser = "root";
	private static final String dbpass = "root";
	private static final String dbdriver ="com.mysql.cj.jdbc.Driver";

	static {
		try {
			Class.forName(dbdriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dburl, dbuser, dbpass);
	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public static PreparedStatement createPreparedStatement(Connection connection, String sql) throws SQLException {
		return connection.prepareStatement(sql);
	}
	
	public static void closePreparedStatement(PreparedStatement prepareStatement) {
		try {
			if (prepareStatement != null && !prepareStatement.isClosed()) {
				prepareStatement.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static ResultSet executeResultSet(PreparedStatement preparedStatement) throws SQLException {
		 
		 return preparedStatement.executeQuery();
		
	}
	public static void closeResultSet(ResultSet resultset) {
		try {
			if (resultset != null && ! resultset.isClosed()) {
				resultset.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	

}
