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
		session.setAttribute("validuser", username);//Set a session to welcome them with the login name on the landing page
		session.setAttribute("passwordAttribute", password);
		
		
		response.sendRedirect("loggedin.jsp"); //Send them to loggedin.jsp
		
		
}else{
	String failure ="Try again";
	
	//If it doesn't work, send them back to the login page asking them to try again 
	response.sendRedirect("index.jsp");
	session.setAttribute("failure", failure);
	
}
%>

<jsp:useBean id="URBean" class="com.JSPExample.userRegistrationbean">
	<jsp:setProperty name="URBean" property="userName" value="<%= session.getAttribute(\"validuser\") %>" 	/>
	<!--  so it looks like the session serialization immediately goes away, I'll be doing looking into database integration  -->
	<jsp:setProperty name="URBean" property="passWord" value="<%= session.getAttribute(\"passwordAttribute\") %>"	/>
	</jsp:useBean>
	

</body>
</html>