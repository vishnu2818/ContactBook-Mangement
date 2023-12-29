<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.vinu.phonebook_mvc.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 50px;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	border: 2px solid;
}

h1 {
	color: #333;
}

h3 {
	color: graytext;
	text-decoration: underline;
}

a {
	display: block;
	margin-bottom: 10px;
	color: #0066cc;
	text-decoration: none;
}
</style>
<body>
	<% String msg = (String) request.getAttribute("msg");
	if(msg != null){
		
		try{%>
			<%=msg%>
		<%}catch(Exception e){
		      
		}
	
	}%>
	<%
	User user = (User) session.getAttribute("user");//getting user from session
	if (user != null) {//validating for existence
	%>
	
	<h1>Welcome <%=user.getUserName()%> !!</h1>
	<h3>User Dashboard</h3>
	<button><a href="home.jsp">Logout</a></button>
	<br>
	<button><a href="add-contact?userId=<%=user.getUserId()%>">Add Contact</a></button>
	<br>
	<button><a href="update-user?userId=<%=user.getUserId()%>">Edit Profile</a></button>
	<%
	
	} else {//if user not present/ found in session
	String error = (String) request.getAttribute("error");
	if (error == null) 
	{//if the error message is null
		error = "User is not authenticated please Login..!";//adding custom error message
	}
	
	%>
	<h3><%=error%></h3>
	<a href="add-user">Register</a>
	<a href="login">Login</a>
	<%
	}
	%>

</body> 
</html>







