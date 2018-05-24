<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.beans.PassengerBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdminHome</title>
</head>
<body>

	<font color="red" size="5">Welcome to AdminHome !</font>
	<br>
	<font color = "red" size = "6">${cancelMessage}</font>
	<br>
	<font color = "red" size = "6">${resultmsg}</font>
	<br>
	<font color = "red" size = "6">${addReuslt}</font>
	<br>
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
  		<%= "Role: " + pb.getUsertype() %>
	
	<br>
 		
 	<br>
 	
	<form action='UpdateProfile.jsp'>
		<input type='submit' value='Edit Profile'>
	</form>
	
	<form action='ViewReservationServlet'>
		<input type='submit' value='View all Reservations'>
	</form>
	
	<form action='AddFlight.jsp'>
		<input type='submit' value='Add flight'>
	</form>
	
	<form action='ViewFlightServlet'>
		<input type='submit' value='View all Flights'>
	</form>
	
	<form action='index.jsp'>
		<input type='submit' value='Log out'>
	</form>

</body>
</html>