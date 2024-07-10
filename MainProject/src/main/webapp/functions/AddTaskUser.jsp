<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<jsp:include page="dashboardHeader.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/AddTaskUserServlet" method = "post">
		<div class="mb-3">
		    <label for="exampleInputDate" class="form-label">Date</label>
		    <input type="date" class="form-control" name = "date" id="exampleInputDate" aria-describedby="Datehelp">
		    <!-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> -->
		</div>	
		<div class="mb-3">
		    <label for="exampleAddTask" class="form-label">Task</label>
		    <input type="text" class="form-control" name = "task" id="exampleAddTask" aria-describedby="AddTaskhelp">
		    <!-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> -->
		</div>
		<div class="mb-3">
		    <label for="exampleStartTime" class="form-label">Start Time</label>
		    <input type="time" class="form-control" name = "startTime" id="exampleStartTime" aria-describedby="StartTimehelp">
		    <!-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> -->
		</div>
		<div class="mb-3">
		    <label for="exampleEndTime" class="form-label">Start Time</label>
		    <input type="time" class="form-control" name = "endTime" id="exampleEndTime" aria-describedby="endTimehelp">
		    <!-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> -->
		</div>
		<input type ="hidden" value="${param.NavInput}" name="NavInput">
		<input type="submit" class="btn btn-primary" value="Submit">

	</form>

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</html>