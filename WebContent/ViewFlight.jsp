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
<title>View Flight</title>
</head>
<body>
${viewFlightMsg}
<br>
<br>
<br>
<% List<FlightBean> fb = (List<FlightBean>)request.getAttribute("flightList"); %>
		
		<% for(int i = 0; i < fb.size(); i+=1) { %>
        <tr>
        	<td><%="Flight number: "%></td>
            <td><%=fb.get(i).getFlight_number()%></td>
            <br>
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
        	<form action='UpdateFlight.jsp'>
        		<input type='hidden' name='flightNumber'  value="<%=fb.get(i).getFlight_number()%>">  <br>
				<input type='submit' value='Edit Flight'>
			</form>
			<form action='CancelFlightServlet'>
        		<input type='hidden' name='flightNumber'  value="<%=fb.get(i).getFlight_number()%>">  <br>
				<input type='submit' value='Cancel Flight'>
			</form>
        </tr>
        <br>
        <br>
    <% } %>

	<form action='AdminHome.jsp'>
		<input type='submit' value='Go Back to Home'>		
	</form>

</body>
</html>