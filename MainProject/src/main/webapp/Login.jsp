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
<jsp:include page="common/header.jsp"></jsp:include>
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>Login Form</h1>
		<form action="${pageContext.request.contextPath}/UserLoginServlet" method="post">
		  <div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">Username</label>
		    <input type="text" class="form-control" name = "userid" id="exampleInputEmail1" aria-describedby="emailHelp">
		    <!-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> -->
		  </div>
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Password</label>
		    <input type="password" name= "password" class="form-control" id="exampleInputPassword1">
		  </div>
		  <!-- <div class="mb-3 form-check">
		    <input type="checkbox" class="form-check-input" id="exampleCheck1">
		    <label class="form-check-label" for="exampleCheck1">Check me out</label>
		  </div> -->
		  <input type="submit" class="btn btn-primary" value="Submit">
		</form>
	</div>
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</html>