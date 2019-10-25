<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	//Store password and username as strings
	if(username.equals("validuser") && password.equals("password")){
		//if the user is valid, store, the username in a session called "valid user" (Can't change it, too late now) and redirect to loggedin.jsp
		session.setAttribute("valid user", username);//Set a session to welcome them with the login name on the landing page
		response.sendRedirect("loggedin.jsp"); //Send them to loggedin.jsp
		
}else{
	String failure ="Try again";
	
	//If it doesn't work, send them back to the login page asking them to try again 
	response.sendRedirect("index.jsp");
	session.setAttribute("failure", failure);
	
}
		        %>

</body>
</html>