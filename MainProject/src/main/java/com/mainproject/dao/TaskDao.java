package com.mainproject.dao;

import java.util.ArrayList;

import com.mainproject.model.Task;


public interface TaskDao {
	
	void save(Task task);
	void delete(int id);
	void updateUserid(int id,String newUserid);
	void updateTask(int id,String newTask);
	void updateDate(int id,String newDate);
	void updateStartTime(int id,String newStartTime);
	void updateEndTime(int id,String newEndTime);
	Task getTaskById(int id);
	
	

	ArrayList<Task> getTaskByUserName(String userid);
	
	ArrayList<Task> getTaskByTask(String Tasks);
	ArrayList<Task> getTaskByDate(String Date);

	
	ArrayList<Task> getTaskByStartTime(String StartTime);
	ArrayList<Task> getTaskByEndTime(String EndTime);
	ArrayList<Task> filter(String Input,String userid);
	ArrayList<Task> getTaskByDateUser(String userid);
	

}
