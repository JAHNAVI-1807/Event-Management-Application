<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="com.mainproject.model.Task"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="taskList" value="${sessionScope.taskList}" />

	<table id="ProfileTaskdisplay">
		<thead>
			<tr>
				<th>Username</th>
				<th>Date</th>
				<th>Tasks</th>
				<th>StartTime</th>
				<th>EndTime</th>
				<th>Update</th>
				<th>Remove</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="obj" items="${taskList}">
				<tr>
					<td>${obj.userid}</td>
					<td>${obj.date}</td>
					<td>${obj.task}</td>
					<td>${obj.startTime}</td>
					<td>${obj.endTime}</td>
					<%-- <td>
						<form action="../functions/Dashboard.jsp" method="post">
							<input type="hidden" value="${obj.id}" name="id"> 
							<input type="hidden" value="${obj.date}" name="date"> 
							<input type="hidden" value="${obj.tasks}" name="task"> 
							<input type="hidden" value="${obj.startTime}" name="startTime"> 
							<input type="hidden" value="${obj.endTime}" name="endTime"> 
							<input type="hidden" value="UpdateUser" name="NavInput">  
							<input type="submit" value="Update">
						</form>
					</td>
					<td><form action="${pageContext.request.contextPath}/DeleteTaskServlet" method="post">
							<input type="hidden" value="${obj.id}" name="Id"> 
							 <input type="submit" value="Remove">
						</form></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>