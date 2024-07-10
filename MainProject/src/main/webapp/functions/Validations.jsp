<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${Valid eq 'Success'}">
  <c:redirect url="./functions/Dashboard.jsp">
  <c:param name="userid" value="${userid}"/>
    </c:redirect>
</c:when>

<c:when test="${Valid eq 'NotAUser'}">
  <c:redirect url="./index.jsp">
  <c:param name="HeaderInput" value="Login"/>
   <c:param name="unmatch" value="Not A User"/>
  </c:redirect>
</c:when>

<c:when test="${Valid eq 'DisplaySearchTask'}">
<c:redirect url="./UserDashBoard.jsp">
<c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="NavInput" value="ScheduleAdmin"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>

 
<c:when test="${Valid eq 'AddTaskUser'}">
  <c:redirect url="./functions/Dashboard.jsp">
  <c:param name="NavInput" value="AddTaskUser"/>
  <c:param name="User" value="${userid}"/>
  </c:redirect>
  </c:when>

  

<c:when test="${Valid eq 'DisplayTaskUser'}">
<c:redirect url="./UserDashBoard.jsp">
  <c:param name="NavInput" value="ScheduleUser"/>
<c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>
  <c:when test="${Valid eq 'DeletedTask'}">
<c:redirect url="./UserDashBoard.jsp">
<c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="NavInput" value="ScheduleUser"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>


  <c:when test="${Valid eq 'UpdatedTask'}">
<c:redirect url="./UserDashBoard.jsp">
<c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="NavInput" value="ScheduleUser"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>


   <c:when test="${Valid eq 'ProfileDisplay'}">
<c:redirect url="./UserDashBoard.jsp">
  <c:param name="NavInput" value="Profile"/>
  <c:set var="UserProfile" value="${UserProfile}" scope="session"/>
  <c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>
 
<c:otherwise>
</c:otherwise>
</c:choose>
</body>
</html>