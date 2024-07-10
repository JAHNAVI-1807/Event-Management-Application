package com.mainproject.serviceimpl;

import java.util.ArrayList;

import com.mainproject.dao.TaskDao;
import com.mainproject.model.Task;
import com.mainproject.service.TaskService;

public class TaskServiceImpl implements TaskService {

	private TaskDao taskDao;
	public TaskServiceImpl(TaskDao taskDao) {
		// TODO Auto-generated constructor stub
		this.taskDao = taskDao;
	}

	@Override
	public void addTask(Task task) {
		// TODO Auto-generated method stub
		taskDao.save(task);

	}

	@Override
	public void updateTask(int id, String newTask, String newDate, String newStartTime, String newEndTime) {
		// TODO Auto-generated method stub
		taskDao.updateTask(id, newTask);
		taskDao.updateDate(id, newDate);
		taskDao.updateStartTime(id, newStartTime);
		taskDao.updateEndTime(id, newEndTime);
		

	}

	@Override
	public void updateUserName(int id, String newUserid) {
		// TODO Auto-generated method stub
		taskDao.updateUserid(id, newUserid);
	

	}

	@Override
	public void removeTask(int id) {
		// TODO Auto-generated method stub
		taskDao.delete(id);
		

	}

	@Override
	public ArrayList<Task> getSearchTask(String Input,String userid) {
		// TODO Auto-generated method stub
		
		return taskDao.filter(Input,userid);
	}





	@Override
	public ArrayList<Task> displayTaskForUser(String newUserid) {
		// TODO Auto-generated method stub
		return taskDao.getTaskByUserName(newUserid);
	}
	
	public ArrayList<Task> displayCurrentTaskUser(String userid){
		return taskDao.getTaskByDateUser(userid);
	}

}
