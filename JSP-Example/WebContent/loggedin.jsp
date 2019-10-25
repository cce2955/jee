<%@page import="java.util.Date"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Congrats, <% 
out.print(session.getAttribute("valid user"));
//Congrat the user for loggin in
%>, you're logged in!
<br> @ 
<% Date current = new Date();
		out.print("year: " + current.getYear() + "month: "+ current.getMonth() + "day: " + current.getDate() + "hour: " + current.getHours() + "minutes: " + current.getMinutes() + "seconds: " + current.getSeconds());
		//I thought I did this correctly, but get year seems to be centuries off and month is 1 month off
		//Not too sure why.
		
%>

</h1> 
</body>
</html>