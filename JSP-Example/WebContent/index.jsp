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
</form>

<br> Enter in information to register yourself
<form action="register.jsp" method = "post">
<br> Username: <input type="text" name="regusername"/>
<br>Password: <input type="password" name = "regpassword"/>
<br><button type="submit">register</button>
</form>
<br> Enter in information to login (Unrelated to the login form above)
<form action="login.jsp" method = "post">
<br> Username: <input type="text" name="loginuser"/>
<br>Password: <input type="password" name = "loginpassword"/>
<br><button type="submit">Log In</button>
</form>

</body>
<jsp:useBean id="usermap" class="com.JSPExample.multiuserregistration" scope="session"/>
<%

if (usermap.userdatabase.containsValue("loginuser") && usermap.passdatabase.containsValue("loginpassword"))
		{
			response.sendRedirect("loggedin.jsp");
		}
else
{
	out.print(session.getAttribute("failure")); //Get an attribute from logincheck.jsp that checks if the user has failed the login
	//Although technically this happens anytime the user refreshes the page
}
%>

</html>