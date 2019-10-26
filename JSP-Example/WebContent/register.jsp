<%@page import="org.apache.catalina.UserDatabase"%>
<%@page import="java.util.Map"%>
<%@page import="com.JSPExample.multiuserregistration"%>
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
	

	String username = (String)request.getParameter("regusername");
	String password = (String)request.getParameter("regpassword");
	
	//Creating an object of our hashmap class
	multiuserregistration usermap = new multiuserregistration();
	
	if(!username.isEmpty() && !password.isEmpty())
	{
		//If there are parameters in the registration form and none in the login form, register the user
		//and send them back home
		//---------------------------
		//Register
		usermap.setPassword(password); //Sets the user and password for the current session
		usermap.setUsers(username);
		usermap.userdatabase.put(usermap.userdatabase.size(), username);//Place user and pass in the hashmap at the last spot
		usermap.passdatabase.put(usermap.userdatabase.size(), password);
		response.sendRedirect("index.jsp");
	}		
	
	
	
	//-----------------------------------
	//Login
	//---------------------------------
	
	else if (usermap.userdatabase.containsValue(username) && usermap.passdatabase.containsValue(password))
	{
		usermap.setCurrentUser(username);
		String reminder = "You already registered!!";
		request.getSession().setAttribute("reminder", reminder);
		
		response.sendRedirect("loggedin.jsp");
	}
	else
	{
		response.sendRedirect("index.jsp");
	}
	
	
	
	
	
%>
</body>
</html>