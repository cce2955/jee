<%@page import="org.apache.catalina.mbeans.UserMBean"%>
<%@page import="com.JSPExample.userRegistrationbean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!--  This page is the original introduction to beans, it has a very rough feel to it, mostly ignore it outside of just seeing where I started -->
<%
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	
	userRegistrationbean user = new userRegistrationbean();
	//Set up an object from our bean
	
	boolean bfailure = true;
	
	
	
	
	if(username.equals("validuser") && password.equals("password")){
		//if the user is valid, store, the username in a session called "valid user" (Can't change it, too late now) and redirect to loggedin.jsp
		user.setUserName(username);
		user.setPassWord(password);
		//Store the session so another page can access this 
		request.getSession().setAttribute("user", user);	
		response.sendRedirect("loggedin.jsp"); //Send them to loggedin.jsp
		
		
}else{
	String failure ="Try again";
	bfailure = false;
	//If it doesn't work, send them back to the login page asking them to try again 
	response.sendRedirect("index.jsp");
	session.setAttribute("failure", failure);
	session.setAttribute("returned", bfailure);
		
	
}
%>
</body>
</html>