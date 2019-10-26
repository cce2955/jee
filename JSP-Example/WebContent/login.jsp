<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="usermap" class="com.JSPExample.multiuserregistration" scope="session"/>
<% 
	String loginuser = (String) request.getParameter("loginuser");
	String loginpassword = (String)request.getParameter("loginpassword");
	request.getAttribute("usernamedatabase");
	request.getAttribute("passdatabase");
	
	
	if (usermap.userdatabase.containsValue(loginuser) && usermap.passdatabase.containsValue(loginpassword))
	{
		usermap.setCurrentUser(loginuser);
		request.getSession().setAttribute("currentUser", loginuser);
		response.sendRedirect("loggedin.jsp");
		
	}
	else
	{
		response.sendRedirect("loggedin.jsp");
	}
	%>
</body>
</html>