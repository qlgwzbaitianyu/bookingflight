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
<title>UpdateFlight</title>
</head>
<body>	
<br>
	<%int flightNumber = Integer.parseInt(request.getParameter("flightNumber")); %>
		 <form action='UpdateFlightServlet'>
		<input type='hidden' name='flightNumber'  value="<%=flightNumber%>">
		<input type='text' name='seat' placeholder='seat'><br>
		<input type='test' name='arrtime' placeholder='arrtime'><br>
		<input type='text' name='arrdate' placeholder='arrdate'><br>
		<input type='text' name='deptime' placeholder='deptime'><br>
		<input type='text' name='depdate' placeholder='depdate'><br>
		<input type='text' name='airport' placeholder='airport'><br>
		<input type='text' name='depart' placeholder='depart'><br>
		<input type='text' name='destination' placeholder='destination'><br>
		<input type='text' name='airplane_producer' placeholder='airplane_producer'><br>
		
		<input type='submit' value='Update Flight'>
	</form>

	<form action='AdminHome.jsp'>
		<input type='submit' value='Go Back to Admin Home'>		
	</form>
	
</body>
</html>