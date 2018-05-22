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
<title>Insert title here</title>
</head>
<body>

	<font color="red" size="5">Search Result: </font>
	
	<font color="red" size="5">${msg}</font>
	<br>
	<br>
	
	<c:set var="val" value="${resultmsg}"/>
	<%-- <c:out value="${resultmsg}"></c:out> --%>
	<br>
	<br>
	<c:if test="${val != null}">
		<% List<FlightBean> fb = (List<FlightBean>)request.getSession().getAttribute("searchresult"); %>
		<%
			System.out.print(fb.get(0).getAirport());
		%>
		
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
        	<form action='BookFlightServlet'>
				<input type='submit' value='Book Flight'>
			</form>
        	
        </tr>
        <br>
        <br>
    <% } %>
		<%-- <c:forEach items="${flightlist}" var="flightbean">
    	<tr>      
        	<td>${flightbean.getDestination()}</td>
    	</tr>
		</c:forEach> --%>
	</c:if>
	
	<br>
	
	
</body>
</html>