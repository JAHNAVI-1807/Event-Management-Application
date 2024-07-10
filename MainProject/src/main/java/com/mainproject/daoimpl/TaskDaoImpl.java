package com.mainproject.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mainproject.dao.TaskDao;
import com.mainproject.model.Task;
import com.mainproject.utility.JDBCUtils;



public class TaskDaoImpl implements TaskDao {
	Connection connection = null;
	PreparedStatement prepareStatement = null;
	ResultSet resultset = null;
	
	@Override
	public void save(Task task) {
		try {
			connection = JDBCUtils.getConnection();
			String saveSql = "INSERT INTO tasks(userid,task,startTime,endTime,date) VALUES (?,?,?,?,?)";
			PreparedStatement pStatement = JDBCUtils.createPreparedStatement(connection, saveSql);
			pStatement.setString(1,task.getUserid());
			pStatement.setString(2,task.getTask());
			pStatement.setString(3,task.getStartTime());
			pStatement.setString(4,task.getEndTime());
			pStatement.setString(5,task.getDate());
			pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closeConnection(connection);
			JDBCUtils.closePreparedStatement(prepareStatement);
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			connection = JDBCUtils.getConnection();
			String deleteSql = "DELETE FROM  tasks WHERE id = ? ";
			PreparedStatement pStatement = JDBCUtils.createPreparedStatement(connection, deleteSql);
			pStatement.setInt(1,id);
			pStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closePreparedStatement(prepareStatement);
			JDBCUtils.closeConnection(connection);
		}
		
	}

	@Override
	public void updateUserid(int id, String newUserid) {
		// TODO Auto-generated method stub
		try {
			connection = JDBCUtils.getConnection();
			String updateSql="UPDATE tasks SET userid=? WHERE (id = ?) ";
			prepareStatement = JDBCUtils.createPreparedStatement(connection, updateSql);
			prepareStatement.setString(1,newUserid);
			prepareStatement.setInt(2, id);
			prepareStatement.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closePreparedStatement(prepareStatement);
			JDBCUtils.closeConnection(connection);
		}
		
		
	}

	@Override
	public void updateTask(int id, String newTask) {
		// TODO Auto-generated method stub
		
		try {
			connection = JDBCUtils.getConnection();
			String updateSql1="UPDATE tasks SET task=? WHERE (id = ?) ";
			prepareStatement = JDBCUtils.createPreparedStatement(connection, updateSql1);
			prepareStatement.setString(1,newTask);
			prepareStatement.setInt(2, id);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closePreparedStatement(prepareStatement);
			JDBCUtils.closeConnection(connection);
		}
		
		
		
	}

	@Override
	public void updateDate(int id, String newDate) {
		// TODO Auto-generated method stub
		try {
			connection = JDBCUtils.getConnection();
			String updateSql1="UPDATE tasks SET date=? WHERE (id = ?) ";
			prepareStatement = JDBCUtils.createPreparedStatement(connection, updateSql1);
			prepareStatement.setString(1,newDate);
			prepareStatement.setInt(2, id);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closePreparedStatement(prepareStatement);
			JDBCUtils.closeConnection(connection);
		}
		
		
	}

	@Override
	public void updateStartTime(int id, String newStartTime) {
		// TODO Auto-generated method stub
		
		try {
			connection = JDBCUtils.getConnection();
			String updateSql1="UPDATE tasks SET startTime = ? WHERE (id = ?) ";
			prepareStatement = JDBCUtils.createPreparedStatement(connection, updateSql1);
			prepareStatement.setString(1,newStartTime);
			prepareStatement.setInt(2, id);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closePreparedStatement(prepareStatement);
			JDBCUtils.closeConnection(connection);
		}
		
	}

	@Override
	public void updateEndTime(int id, String newEndTime) {
		// TODO Auto-generated method stub
		try {
			connection = JDBCUtils.getConnection();
			String updateSql1="UPDATE tasks SET endTime = ? WHERE (id = ?) ";
			prepareStatement = JDBCUtils.createPreparedStatement(connection, updateSql1);
			prepareStatement.setString(1,newEndTime);
			prepareStatement.setInt(2, id);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.closePreparedStatement(prepareStatement);
			JDBCUtils.closeConnection(connection);
		}
		
	}

	@Override
	public Task getTaskById(int id) {
		// TODO Auto-generated method stub
		try {
			connection = JDBCUtils.getConnection();
			
			String selectSql=" Select * From tasks where Id = ? ";
			prepareStatement = JDBCUtils.createPreparedStatement(connection, selectSql);
			prepareStatement.setInt(1,id);
			resultset=JDBCUtils.executeResultSet(prepareStatement);
			
			while (resultset.next()) 
			{
				Task task = new Task();
				task.setId(resultset.getInt("id"));
				task.setUserid(resultset.getString("userid"));
				task.setTask(resultset.getString("task"));
				task.setStartTime(resultset.getString("StartTime")); 
				task.setEndTime(resultset.getString("EndTime"));
				task.setDate(resultset.getString("Date"));
			return task;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally 
		{
		
         JDBCUtils.closePreparedStatement(prepareStatement);
         JDBCUtils.closeResultSet(resultset);
         JDBCUtils.closeConnection(connection);
		}
		return null;
	}

	/*
	 * @Override public ArrayList<String> getDesigUser() { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public ArrayList<Task> getTaskForAdmin() { // TODO Auto-generated
	 * method stub return null; }
	 */

	@Override
	public ArrayList<Task> getTaskByUserName(String userid) {
		try {
			connection = JDBCUtils.getConnection();
			String UseridSql = "SELECT * FROM tasks WHERE userid = ?";
			prepareStatement = JDBCUtils.createPreparedStatement(connection, UseridSql);
			prepareStatement.setString(1,userid);
			resultset=JDBCUtils.executeResultSet(prepareStatement);
			ArrayList<Task> Userlist = new ArrayList<>();
			while (resultset.next()) 
			{
				Task task = new Task();
				task.setId(resultset.getInt("id"));
				task.setUserid(resultset.getString("userid"));
				task.setTask(resultset.getString("task"));
				task.setStartTime(resultset.getString("StartTime")); 
				task.setEndTime(resultset.getString("EndTime"));
				task.setDate(resultset.getString("Date"));
				Userlist.add(task);
			
			}
			return Userlist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCUtils.closePreparedStatement(prepareStatement);
	         JDBCUtils.closeResultSet(resultset);
	         JDBCUtils.closeConnection(connection);
		}
		return null;
	}

	@Override
	public ArrayList<Task> getTaskByTask(String task) {
		try {
			connection = JDBCUtils.getConnection();
			String TaskSql = "SELECT * FROM tasks WHERE task = ?";
			prepareStatement = JDBCUtils.createPreparedStatement(connection, TaskSql);
			prepareStatement.setString(1,task);
			resultset=JDBCUtils.executeResultSet(prepareStatement);
			ArrayList<Task> Tasklist = new ArrayList<>();
			while (resultset.next()) 
			{
				Task tasks = new Task();
				tasks.setId(resultset.getInt("id"));
				tasks.setUserid(resultset.getString("userid"));
				tasks.setTask(resultset.getString("task"));
				tasks.setStartTime(resultset.getString("StartTime")); 
				tasks.setEndTime(resultset.getString("EndTime"));
				tasks.setDate(resultset.getString("Date"));
				Tasklist.add(tasks);
			
			}
			return Tasklist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCUtils.closePreparedStatement(prepareStatement);
	         JDBCUtils.closeResultSet(resultset);
	         JDBCUtils.closeConnection(connection);
		}
		return null;
		
	} 


	@Override
	public ArrayList<Task> getTaskByDate(String date) {
		try {
			connection = JDBCUtils.getConnection();
			String DateSql = "SELECT * FROM tasks WHERE date = ?";
			prepareStatement = JDBCUtils.createPreparedStatement(connection, DateSql);
			prepareStatement.setString(1,date);
			resultset=JDBCUtils.executeResultSet(prepareStatement);
			ArrayList<Task> Datelist = new ArrayList<>();
			while (resultset.next()) 
			{
				Task tasks = new Task();
				tasks.setId(resultset.getInt("id"));
				tasks.setUserid(resultset.getString("userid"));
				tasks.setTask(resultset.getString("task"));
				tasks.setStartTime(resultset.getString("StartTime")); 
				tasks.setEndTime(resultset.getString("EndTime"));
				tasks.setDate(resultset.getString("Date"));
				Datelist.add(tasks);
			
			}
			return Datelist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCUtils.closePreparedStatement(prepareStatement);
	         JDBCUtils.closeResultSet(resultset);
	         JDBCUtils.closeConnection(connection);
		}
		return null;
	}

	/*
	 * @Override public ArrayList<Task> getTaskByDateAdmin() { // TODO
	 * Auto-generated method stub return null; }
	 */
	

	@Override
	public ArrayList<Task> getTaskByStartTime(String startTime) {
		try {
			connection = JDBCUtils.getConnection();
			String startTimeSql = "SELECT * FROM tasks WHERE startTime = ?";
			prepareStatement = JDBCUtils.createPreparedStatement(connection, startTimeSql);
			prepareStatement.setString(1,startTime);
			resultset=JDBCUtils.executeResultSet(prepareStatement);
			ArrayList<Task> StartTlist = new ArrayList<>();
			while (resultset.next()) 
			{
				Task tasks = new Task();
				tasks.setId(resultset.getInt("id"));
				tasks.setUserid(resultset.getString("userid"));
				tasks.setTask(resultset.getString("task"));
				tasks.setStartTime(resultset.getString("StartTime")); 
				tasks.setEndTime(resultset.getString("EndTime"));
				tasks.setDate(resultset.getString("Date"));
				StartTlist.add(tasks);
			
			}
			return StartTlist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCUtils.closePreparedStatement(prepareStatement);
	         JDBCUtils.closeResultSet(resultset);
	         JDBCUtils.closeConnection(connection);
		}
		return null;
	}

	@Override
	public ArrayList<Task> getTaskByEndTime(String endTime) {
		try {
			connection = JDBCUtils.getConnection();
			String endTimeSql = "SELECT * FROM tasks WHERE endTime = ?";
			prepareStatement = JDBCUtils.createPreparedStatement(connection, endTimeSql);
			prepareStatement.setString(1,endTime);
			resultset=JDBCUtils.executeResultSet(prepareStatement);
			ArrayList<Task> EndTlist = new ArrayList<>();
			while (resultset.next()) 
			{
				Task tasks = new Task();
				tasks.setId(resultset.getInt("id"));
				tasks.setUserid(resultset.getString("userid"));
				tasks.setTask(resultset.getString("task"));
				tasks.setStartTime(resultset.getString("StartTime")); 
				tasks.setEndTime(resultset.getString("EndTime"));
				tasks.setDate(resultset.getString("Date"));
				EndTlist.add(tasks);
			
			}
			return EndTlist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCUtils.closePreparedStatement(prepareStatement);
	         JDBCUtils.closeResultSet(resultset);
	         JDBCUtils.closeConnection(connection);
		}
		return null;
	}

	@Override
	public ArrayList<Task> filter(String Input,String userid) {
		ArrayList<Task> taskList = new ArrayList<Task>();
		taskList=getTaskByUserName(Input);
		if(taskList.isEmpty())
		{
	    taskList=getTaskByDate(Input);
		if(taskList.isEmpty())
		{
		taskList=getTaskByStartTime(Input);
		if(taskList.isEmpty())
		{
		taskList=getTaskByEndTime(Input);	
		if(taskList.isEmpty())
		{
	    taskList=getTaskByTask(Input);
		}
		else
		{
			return taskList;
		}
		}
		else
		{
			return taskList;
		}
		}
		else
		{
			return taskList;
		}
		}
		else
		{
			return taskList;
		}
		
		return getTaskByUserName(userid);
	}
	
	@Override
	public ArrayList<Task> getTaskByDateUser(String userid) {
		try {
			connection = JDBCUtils.getConnection();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		    Date date = new Date(); 
			String sql5=" Select * From tasks where Date = ?  AND  UserName = ?";
			prepareStatement = JDBCUtils.createPreparedStatement(connection, sql5);
			prepareStatement.setString(1,(formatter.format(date).toString()));
			prepareStatement.setString(2, userid);
			resultset=JDBCUtils.executeResultSet(prepareStatement);
			ArrayList<Task> taskList = new ArrayList<Task>();
			while (resultset.next()) 
			{
				Task task = new Task();
				task.setId(resultset.getInt("id"));
				task.setUserid(resultset.getString("userid"));
				task.setTask(resultset.getString("task"));
				task.setDate(resultset.getString("date"));
				task.setStartTime(resultset.getString("startTime")); 
				task.setEndTime(resultset.getString("endTime"));
			    taskList.add(task);
			}
			return taskList;
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally 
		{
		
         JDBCUtils.closePreparedStatement(prepareStatement);
         JDBCUtils.closeResultSet(resultset);
         JDBCUtils.closeConnection(connection);
		}
		return null;
	}
}

	


