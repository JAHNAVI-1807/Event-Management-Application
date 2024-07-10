package com.mainproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mainproject.dao.UserDao;
import com.mainproject.daoimpl.UserDaoImpl;
import com.mainproject.model.Users;
import com.mainproject.service.UserService;
import com.mainproject.serviceimpl.UserServiceImpl;



/**
 * Servlet implementation class UserRegistrationServlet
 */
@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	UserDao userDao = new UserDaoImpl();
	public void init() throws ServletException 
	{
		this.userService= new UserServiceImpl(userDao);
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		 String fname=request.getParameter("fname");
		 String lname=request.getParameter("lname");
		 String email=request.getParameter("email");
		 String password=request.getParameter("password");
		 String confirmPassword=request.getParameter("password2");
		 Users user = new Users();
		 
		 user.setFname(fname);
		 user.setLname(lname);
		 user.setUserid(userid);
		 user.setEmail(email);
		 user.setPassword(password);
		
		 String Status= userService.registerUser(user);
			/* request.setAttribute("Valid",Status); */
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
		
		if (password.equals(confirmPassword)) {
			
			try {
				UserDao.insertUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			request.getRequestDispatcher("/Login.jsp").forward(request, response); 
		} else {
			
			request.getRequestDispatcher("/Register.jsp").forward(request, response); 
		}


	}

}
