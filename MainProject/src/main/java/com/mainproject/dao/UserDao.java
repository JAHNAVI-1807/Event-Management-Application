package com.mainproject.dao;

import com.mainproject.model.Users;

public interface UserDao {

	//void requestApproval(Users user);
	String saveUser(Users user);
	public default Users getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	String loginValidation(String userid, String password);
	static void insertUser(Users user) {
		// TODO Auto-generated method stub
		
	}
}
