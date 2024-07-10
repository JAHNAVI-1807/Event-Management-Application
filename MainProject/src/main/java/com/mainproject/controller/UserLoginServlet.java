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
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
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
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("userid");
		String password = request.getParameter("password");
		String Validation;
		Users user = null;
		try {
			user = userService.getUser(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Validation = userService.loginValidation(username, password);
		if(Validation.equals("User"))
		{

			String RedirectVal = "Success";
			request.setAttribute("userid",user.getUserid());
		 request.setAttribute("Valid",RedirectVal); 
			request.getRequestDispatcher("/functions/Validations.jsp").forward(request, response);

		}
		else if(Validation.equals("Error"))
		{

//			String RedirectVal = "Error";
			/* request.setAttribute("Valid",RedirectVal); */
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		else if(Validation.equals("NotAUser"))
		{
//			String RedirectVal = "NotAUser";
			/* request.setAttribute("Valid",RedirectVal); */
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}
}


