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
<title>Search_Result</title>
</head>
<body>

	<font color="red" size="5">Search Result: </font>
	
	<font color="red" size="5">${msg}</font>
	<br>
	<br>
	
	
	<c:set var="val" value="${classTypeMessage}"/>
	<br>
	<br>
	<c:if test="${val != null}">
		<%= "entered wrong Class Type" %>
	</c:if>
	
	<c:set var="val" value="${resultmsg}"/>
	<br>
	<br>
	<c:if test="${val != null}">
		<% List<FlightBean> fb = (List<FlightBean>)request.getSession().getAttribute("searchresult"); %>
		
		<% for(int i = 0; i < fb.size(); i+=1) { %>
        <tr>
        	
        	<td><%="Depart time: "%></td>
            <td><%=fb.get(i).getDeptime()%></td>
            <br>
            <td><%="Depart date: "%></td> 
            <td><%=fb.get(i).getDepdate()%></td>
            <br>
            <td><%="Depart city: "%></td>
            <td><%=fb.get(i).getDepart()%></td>
            <br>
            <td><%="Destination city: "%></td>
            <td><%=fb.get(i).getDestination()%></td>
            <br>
            <td><%="Airport: "%></td>
            <td><%=fb.get(i).getAirport()%></td>
            <br>
            <td><%="Arrive time: "%></td>
            <td><%=fb.get(i).getArrtime()%></td>
            <br>
            <td><%="Arrive date: "%></td>
        	<td><%=fb.get(i).getArrdate()%></td>
        	<br>
        	<td><%="Available Seat Number: "%></td>
        	<td><%=fb.get(i).getSeat()%></td>
        	<br>
        	<form action='BookingServlet'>
        		<input type='hidden' name='flightNumber'  value="<%=fb.get(i).getFlight_number()%>">  <br>
        		<input type='text' name='baggage' value='Input your baggage info'> <br>
        		<input type='text' name='classType' value='Input the class type'> <br>
				<input type='submit' value='Book Flight'>
				
			</form>
        	
        </tr>
        <br>
        <br>
    <% } %>
		
	</c:if>
	
	<br>
	
	<form action='UserHome.jsp'>
		<input type='submit' value='Go Back to Home'>		
	</form>
</body>
</html>