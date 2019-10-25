<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%!
//Creating some methods in JSP
	int test()
	{
		return 1;
	}
	
	 int someClass(int x, int y)
	{
		int z = x + y;
		return z;
	}
	
 %>
<h1>test</h1>

<%
//Calling them here
out.println(test() + "" + someClass(2, 3)); %>

<!--  Creating a login form for our .jsp files -->
<form action= "logincheck.jsp" method = "post"><!--  flows into logincheck.jsp -->
<br>Username: <input type="text" name="username"/>
<br>Password: <input type="password" name="password"/> 
<br><button type="submit">Log-in!</button>
<%
if (session.isNew())
		{
			out.print("");
		}
else if(!session.isNew())
{
	out.print(session.getAttribute("failure")); //Get an attribute from logincheck.jsp that checks if the user has failed the login
	//Although technically this happens anytime the user refreshes the page
}
%>
</form>
</body>
</html>