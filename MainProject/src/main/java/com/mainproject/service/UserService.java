package com.mainproject.service;

import com.mainproject.model.Users;

public interface UserService {
	public String registerUser(Users user);
	public Users getUser(String username);
	public String loginValidation(String username,String password);
}
