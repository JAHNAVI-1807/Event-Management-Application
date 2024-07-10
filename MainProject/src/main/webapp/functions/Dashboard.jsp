<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<jsp:include page="dashboardHeader.jsp"></jsp:include>

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</html>




<%-- <c:choose>

<c:when test="${param.NavInput eq 'Profile'}">
  <jsp:include page="./Profile.jsp"/>
  <c:redirect url="../UserDashboard.jsp">
  <c:param name="NavInput" value="${param.NavInput}"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
</c:when>  

<c:when test="${param.NavInput eq 'AddTaskUser'}">
  <jsp:include page="./AddTaskUser.jsp"/>
  <c:redirect url="../UserDashboard.jsp">
  <c:param name="NavInput" value="${param.NavInput}"/>
  </c:redirect>
</c:when>

<c:when test="${param.NavInput eq 'ScheduleUser'}">
  <jsp:include page="./ScheduleTaskUser.jsp"/>
  <c:redirect url="../UserDashBoard.jsp">
  <c:param name="NavInput" value="${param.NavInput}"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
</c:when>

</c:choose> --%>

