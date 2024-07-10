package com.mainproject.service;

import java.util.ArrayList;

import com.mainproject.model.Task;


public interface TaskService {
	void addTask(Task task);
	void updateTask(int id,String newTask,String newDate,String newStartTime,String newEndTime);
	void updateUserName(int id,String newUserid);
	void removeTask(int id);
	ArrayList<Task> getSearchTask(String Input,String userid);
	
	
	
	ArrayList<Task> displayTaskForUser(String newUserid);
	
	ArrayList<Task> displayCurrentTaskUser(String userid);

}
