<%@page import="java.util.List"%>
<%@page import="com.vinu.phonebook_mvc.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="v" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get All User</title>
</head>
<body>
	<h1>Employee Table!</h1>
	<%List<User> users = (List<User>)request.getAttribute("list"); %>
	<table>
		<tr>
			<th>User Id</th>
			<th>User Name</th>
			<th>Email</th>
			<th>Salary</th>
		</tr>
		<tr>
			<td><%= %></td>
		</tr>
	</table>

</body>
</html>