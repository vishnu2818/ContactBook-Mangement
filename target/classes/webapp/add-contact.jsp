<%@page import="com.vinu.phonebook_mvc.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="v"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Contact</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 400px;
	margin: 50px auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

form {
	display: grid;
	gap: 15px;
}

label {
	font-weight: bold;
}

input {
	width: 100%;
	padding: 8px;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 4px;
}

button {
	background-color: #4caf50;
	color: #fff;
	padding: 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

button:hover {
	background-color: #45a049;
}
</style>
</head>
<body>

	<div class="container">
		<h2>Add Contact</h2>
		
		<v:form modelAttribute="contact" action="add-contact" method="post">
		
			<v:label path="contactFirstName">First Name:</v:label>
			<v:input path="contactFirstName"/>

			<v:label path="contactLastName">Last Name:</v:label>
			<v:input path="contactLastName"/>

			<v:label path="contactPhoneNo">Phone Number:</v:label>
			<v:input path="contactPhoneNo"/>

			<v:label path="contactEmail">Email:</v:label>
			<v:input path="contactEmail" readonly="readonly"/>

			<v:button>Save</v:button>
			
		</v:form>
	</div>
	
</body>
</html>
