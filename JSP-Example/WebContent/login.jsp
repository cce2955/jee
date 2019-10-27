<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!--  This is an advanced version of the beans I was using to work on login and registration -->
<jsp:useBean id="usermap" class="com.JSPExample.multiuserregistration" scope="session"/>
<% 
	String loginuser = (String) request.getParameter("loginuser");
	String loginpassword = (String)request.getParameter("loginpassword");
	request.getAttribute("usernamedatabase"); //Grab databases from register.jsp
	request.getAttribute("passdatabase");
	
	
	if (usermap.userdatabase.containsValue(loginuser) && usermap.passdatabase.containsValue(loginpassword))
	{
		//If anyvalue in the database matches the string of login user, then get in this loop, set the current user to display on loggedin.jsp
		usermap.setCurrentUser(loginuser);
		request.getSession().setAttribute("currentUser", usermap.getCurrentUser());
		response.sendRedirect("loggedin.jsp");
		
	}
	else
	{
		response.sendRedirect("loggedin.jsp");
	}
	%>
</body>
</html>