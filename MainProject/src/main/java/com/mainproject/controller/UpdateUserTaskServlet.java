package com.mainproject.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mainproject.dao.TaskDao;
import com.mainproject.daoimpl.TaskDaoImpl;
import com.mainproject.model.Task;
import com.mainproject.service.TaskService;
import com.mainproject.serviceimpl.TaskServiceImpl;


/**
 * Servlet implementation class UpdateUserTaskServlet
 */
@WebServlet("/UpdateUserTaskServlet")
public class UpdateUserTaskServlet extends HttpServlet {
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
    public UpdateUserTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		taskService.updateTask(Integer.parseInt(request.getParameter("id")), request.getParameter("task"), request.getParameter("date"), request.getParameter("startTime"), request.getParameter("endTime"));
		ArrayList<Task> taskList = new ArrayList<Task>();
		taskList = taskService.displayTaskForUser(request.getParameter("userid"));
	    String RedirectVal = "UpdatedTask";
		request.setAttribute("Valid",RedirectVal);
		request.setAttribute("taskList",taskList);
		request.getRequestDispatcher("../functions/Validations.jsp").forward(request, response);
		
	}

}
