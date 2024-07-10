package com.mainproject.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mainproject.service.*;
import com.mainproject.daoimpl.*;
import com.mainproject.model.Task;
import com.mainproject.model.Users;
import com.mainproject.dao.*;
import com.mainproject.serviceimpl.*;




/**
 * Servlet implementation class DisplayUserProfileServlet
 */
@WebServlet("/DisplayUserProfileServlet")
public class DisplayUserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserService userService;
	UserDao userDao = new UserDaoImpl();
	private TaskService taskService;
	TaskDao taskDao = new TaskDaoImpl();

	public void init() throws ServletException 
	{
		this.userService= new UserServiceImpl(userDao);
		this.taskService= new TaskServiceImpl(taskDao);
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayUserProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		Users user = userService.getUser(userid);
		String RedirectVal = "ProfileDisplay";
		ArrayList<Task> taskList = new ArrayList<Task>();
		taskList = taskService.displayCurrentTaskUser(userid);
		request.setAttribute("Valid",RedirectVal);
		request.setAttribute("taskList",taskList);
		request.setAttribute("UserProfile",user);
		request.getRequestDispatcher("../functions/Validations.jsp").forward(request, response);
	}

}
