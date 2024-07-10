package com.mainproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mainproject.service.TaskService;
import com.mainproject.serviceimpl.TaskServiceImpl;
import com.mainproject.model.Task;
import com.mainproject.dao.*;
import com.mainproject.daoimpl.*;

/**
 * Servlet implementation class AddTaskUserServlet
 */
@WebServlet("/AddTaskUserServlet")
public class AddTaskUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskService taskService;
	TaskDao taskDao = new TaskDaoImpl();
	public void init() throws ServletException 
	{
		this.taskService= new TaskServiceImpl(taskDao);
	}   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaskUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Task task = new Task();
		task.setUserid(request.getParameter("userid"));
		task.setDate(request.getParameter("date"));
		task.setTask(request.getParameter("task"));
		task.setStartTime(request.getParameter("startTime"));
		task.setEndTime(request.getParameter("endTime"));
	    taskService.addTask(task);
	    String RedirectVal = "AddTaskUser";
		request.setAttribute("Valid",RedirectVal);
	    //request.setAttribute("User",request.getParameter("userid"));
		request.getRequestDispatcher("../functions/Validations.jsp").forward(request, response);
	}

}
