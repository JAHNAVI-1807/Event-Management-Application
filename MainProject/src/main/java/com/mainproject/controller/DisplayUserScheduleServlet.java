package com.mainproject.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mainproject.dao.TaskDao;
import com.mainproject.dao.UserDao;
import com.mainproject.daoimpl.TaskDaoImpl;
import com.mainproject.daoimpl.UserDaoImpl;
import com.mainproject.service.TaskService;
import com.mainproject.serviceimpl.TaskServiceImpl;
import com.mainproject.serviceimpl.UserServiceImpl;
import com.mainproject.model.Task;

/**
 * Servlet implementation class DisplayUserScheduleServlet
 */
@WebServlet("/DisplayUserScheduleServlet")
public class DisplayUserScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDao userDao = new UserDaoImpl();
	private TaskService taskService;
	TaskDao taskDao = new TaskDaoImpl();

	public void init() throws ServletException 
	{
		new UserServiceImpl(userDao);
		this.taskService= new TaskServiceImpl(taskDao);
	}
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayUserScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<com.mainproject.model.Task> taskList = new ArrayList<Task>();
		taskList = taskService.displayTaskForUser(request.getParameter("userid"));
		String RedirectVal = "DisplayTaskUser";
		request.setAttribute("Valid", RedirectVal);
		request.setAttribute("taskList", taskList);
		//request.setAttribute("User", request.getParameter("User"));
		request.getRequestDispatcher("../functions/Validations.jsp").forward(request, response);
	}

}
