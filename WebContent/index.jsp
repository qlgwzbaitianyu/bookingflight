<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<font color="red" size="5">Welcome to book fight tickets !</font>
	<br>
	<font color="red" size="5">${msg}</font>
	
	<form action='LoginServlet'>
		<input type='text' name='username' placeholder='Enter Username'><br>
		<input type='password' name='password' placeholder='Enter Password'><br>
		<input type='submit' value='Login'>
	</form>
	
	
	
</body>
</html>