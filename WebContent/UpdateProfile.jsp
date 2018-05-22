<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.beans.PassengerBean" %>
<%@ page import="com.beans.FlightBean" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdateProfile</title>
</head>
<body>	
	<form action='UpdateServlet'>
		<input type='text' name='firstName' placeholder='First Name'><br>
		<input type='test' name='lastName' placeholder='Last Name'><br>
		<input type='text' name='street' placeholder='street'><br>
		<input type='text' name='city' placeholder='city'><br>
		<input type='text' name='state' placeholder='state'><br>
		<input type='text' name='zipCode' placeholder='zipcode'><br>
		<input type='text' name='email' placeholder='email'><br>
		
		<input type='submit' value='Update Profile'>
	</form>

	<form action='UserHome.jsp'>
		<input type='submit' value='Go Back to Home'>		
	</form>
</body>
</html>