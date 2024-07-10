package com.mainproject.daoimpl;

import java.io.ObjectInputFilter.Status;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mainproject.dao.UserDao;
import com.mainproject.utility.JDBCUtils;
import com.mainproject.model.Users;
import com.mainproject.model.Users;


public class UserDaoImpl implements UserDao {

	/*
	 * public void requestApproval(Users user) {
	 * 
	 * }
	 */

	Connection connection = null;
	PreparedStatement prepareStatement=null;
	ResultSet resultset=null;

	@Override
	public String saveUser(Users user) {
		String status="all fields required";
		
		
		try {
			connection = JDBCUtils.getConnection();
			String sql = "INSERT INTO users(fname,lname,email,userid,password)VALUES(?,?,?,?,?); "; 
			prepareStatement = JDBCUtils.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,user.getFname());
			prepareStatement.setString(2,user.getLname());
			prepareStatement.setString(3,user.getEmail());
			prepareStatement.setString(4,user.getUserid());
			prepareStatement.setString(5,user.getPassword());
			prepareStatement.executeUpdate();	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(connection);
			JDBCUtils.closePreparedStatement(prepareStatement);
		}
		
		
		
		return status;
	}

	@Override
	public Users getUser(String username) {
		try {
			connection = JDBCUtils.getConnection();
			String sql=" select * From users where userid = ?";
			prepareStatement = JDBCUtils.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,username);
			resultset=JDBCUtils.executeResultSet(prepareStatement);
			while (resultset.next()) {
			    Users user = new Users();
			    user.setFname(resultset.getString("fname"));
			    user.setLname(resultset.getString("lname"));
			    user.setEmail(resultset.getString("email"));
			    user.setUserid(resultset.getString("userid"));
			    user.setPassword(resultset.getString("password")); 
			    return user;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally 
		{
         JDBCUtils.closePreparedStatement(prepareStatement);
         JDBCUtils.closeResultSet(resultset);
         JDBCUtils.closeConnection(connection);
		}
		return null;
	}

	@Override
	public String loginValidation(String userid, String password) {
		
		try {
			Users user = new Users();
			user=getUser(userid);
			if(user.getUserid().equals(userid)||user.getEmail().equals(userid))
			{
				if(user.getPassword().equals(password))
				{
					return "User";
				}
				else
				{
					return "Error";
				}
			/*
			 * else { return "WrongPassword"; }
			 */
			}
			else
			{
				return "NotAUser";
			}
		}
		
		catch (Exception e) {
			// TODO: handle exception
		} finally 
		{
         JDBCUtils.closePreparedStatement(prepareStatement);
         JDBCUtils.closeResultSet(resultset);
         JDBCUtils.closeConnection(connection);
		}
	
		return "NotAUser";
	
		
		
	}
	
	

}
