<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.beans.PassengerBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<font color="red" size="5">Welcome to UserHome !</font>
	
	
	<br>
	<br>
	<c:set var="val" value="${resultmsg}"/>
	<c:if test="${val == null}">
	<%= "No flight results mathes your input" %>
	<br>
	<br>
	</c:if>
	
	
	<c:set var="val" value="${loginmsg}"/>
	<c:if test="${val == null}">
		<% PassengerBean pb = (PassengerBean)request.getSession().getAttribute("profile"); %>
  		<%= "First name: " + pb.getFirstname() %>
  		<br>
  		<%= "Last name: " + pb.getLastname() %>
  		<br>
  		<%= "Email: " + pb.getEmail() %>
  		<br>
  		<%= "Street: " + pb.getStreet() %>
  		<br>
  		<%= "City: " + pb.getCity() %>
  		<br>
  		<%= "State: " + pb.getState() %>
  		<br>
  		<%= "Zip codeL: " + pb.getZipcode() %>
  		<br>
  		<%= "Role" + pb.getUsertype() %>
  	 
  		<br>
	
	
	</c:if>
	
	<form action='SearchFlightServlet'>
		<input type='text' name='depart' placeholder='Enter depart'><br>
		<input type='test' name='destination' placeholder='Enter destination'><br>
		<input type='text' name='depdate' placeholder='Enter depdate'><br>
		
		<input type='submit' value='Search'>
	</form>
 		
	

</body>
</html>