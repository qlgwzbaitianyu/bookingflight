<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.beans.PassengerBean" %>
<%@ page import="com.beans.FlightBean" %>
<%@ page import="com.beans.BookingBean" %>
<%@ page import="java.util.*" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reserve_Result</title>
</head>
<body>

	<font color="red" size="5">Reserve Result: </font>
	
 	<font color="red" size="5">${reserveMessage}</font>
	<br>
	<br>
	
	<c:set var="val" value="${reserveMessage}"/>
	<br>
	<c:if test="${val == null}">
		<%= "serservation failed, seat is full for that class,  please try other flight" %>
	</c:if> 
	
	<br>
	
	<c:if test="${val != null}">
		<% BookingBean researveBean = (BookingBean)request.getSession().getAttribute("reserveResult"); %>
		
        <tr>
        	<td><%="Booking Id: "%></td>
            <td><%=researveBean.getBookId()%></td>
            <br>
            
            <td><%="Passenger Id: "%></td>
            <td><%=researveBean.getPassengerId()%></td>
            <br>
        	
        	<td><%="Flight Number: "%></td>
            <td><%=researveBean.getFlightNumber()%></td>
            <br>
            
            <td><%="Seat Number: "%></td>
            <td><%=researveBean.getSeatNumber()%></td>
            <br>
        	
        	<td><%="Baggage: "%></td>
            <td><%=researveBean.getBaggage()%></td>
            <br>
            
            <td><%="Class Type: "%></td>
            <td><%=researveBean.getClassType()%></td>
            <br>
            
            <td><%="Reservation Status: "%></td>
            <td><%=researveBean.getReservStatus()%></td>
            <br>
            
        </tr>
        <br>
        <br>
		
	</c:if> 
	 
	<br>
	<form action='UserHome.jsp'>
		<input type='submit' value='Go Back to Home'>		
	</form>
	
</body>
</html>