<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Add flights:

<form action='AddFlightServlet'>
		<input type='text' name='arrTime' placeholder='Arrive Time'><br>
		<input type='test' name='arrDate' placeholder='Arrive Date'><br>
		<input type='text' name='depTime' placeholder='Depart Time'><br>
		<input type='text' name='depDate' placeholder='Depart Date'><br>
		<input type='text' name='depart' placeholder='depart'><br>
		<input type='text' name='destination' placeholder='destination'><br>
		<input type='text' name='seat' placeholder='total seat'><br>
		<input type='text' name='airport' placeholder='airport'><br>
		<input type='text' name='airplane_producer' placeholder='Airplane Producer'><br>
		<br>
		<input type='text' name='first_class' placeholder='Seat Number for FirstClass'><br>
		<input type='test' name='business_class' placeholder='Seat Number for BusinessClass'><br>
		<input type='text' name='economy_class' placeholder='Seat Number for EconomyClass'><br>
		
		<input type='submit' value='Add Flight'>
</form>
<br>
<form action='AdminHome.jsp'>
	<input type='submit' value='Go Back to Home'>		
</form>


</body>
</html>