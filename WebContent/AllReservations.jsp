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
<title>All reservations</title>
</head>
<body>

	<font color="red" size="5">All reservations: </font>
	
 	<font color="red" size="5">${bookingResultMessage}</font>
	<br>
	<br>
	
	<c:set var="val" value="${bookingResultMessage}"/>
	<br>
	<c:if test="${val == null}">
		<%= "no booking result" %>
	</c:if> 
	
	<br>
	
	<c:if test="${val != null}">
		<% List<BookingBean> bookingBeanList = (List<BookingBean>)request.getSession().getAttribute("viewBookingresult"); %>
		
		<% for(int i = 0; i < bookingBeanList.size(); i+=1) { %>
        <tr>
        	<td><%="Booking Id: "%></td>
            <td><%=bookingBeanList.get(i).getBookId()%></td>
            <br>
            
            <td><%="Passenger Id: "%></td>
            <td><%=bookingBeanList.get(i).getFlightNumber()%></td>
            <br>
        	
        	<td><%="Flight Number: "%></td>
            <td><%=bookingBeanList.get(i).getPassengerId()%></td>
            <br>
            
            <td><%="Seat Number: "%></td>
            <td><%=bookingBeanList.get(i).getSeatNumber()%></td>
            <br>
        	
        	<td><%="Baggage: "%></td>
            <td><%=bookingBeanList.get(i).getBaggage()%></td>
            <br>
            
            <td><%="Class Type: "%></td>
            <td><%=bookingBeanList.get(i).getClassType()%></td>
            <br>
            
            <td><%="Reservation Status: "%></td>
            <td><%=bookingBeanList.get(i).getReservStatus()%></td>
            <br>
            
           <%--  <form action='CancelServlet'>
        		<input type='hidden' name='bookingId'  value="<%=bookingBeanList.get(i).getBookId()%>"><br>
        		<input type='hidden' name='flightNumber'  value="<%=bookingBeanList.get(i).getPassengerId()%>"><br>
        		<input type='hidden' name='classType'  value="<%=bookingBeanList.get(i).getClassType()%>"><br>
				<input type='submit' value='Cancel Flight'>
				
			</form> --%>
            
        </tr>
        <br>
        <br>
    <% } %>
		
	</c:if> 
	 
	<br>
	<form action='AdminHome.jsp'>
		<input type='submit' value='Go Back to Home'>		
	</form>
	
</body>
</html>