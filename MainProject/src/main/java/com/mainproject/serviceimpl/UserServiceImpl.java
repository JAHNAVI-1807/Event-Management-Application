package com.mainproject.serviceimpl;

import com.mainproject.dao.UserDao;
import com.mainproject.model.Users;
import com.mainproject.service.UserService;


public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	public UserServiceImpl(UserDao userDao)
	{
	this.userDao=userDao;
	}
	@Override
	public String registerUser(Users user)
	{
		 return userDao.saveUser(user);
	}

	
	public Users getUser(String username) {
		return userDao.getUser(username);
	}
	@Override
	public String loginValidation(String username,String password) {
		
		return userDao.loginValidation(username,password);
	}
	

}
