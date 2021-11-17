<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
		<title>Ideas</title>
	</head>
	<body>
		<div class="d-flex justify-content-around">
			<form:form action="/" method="post" modelAttribute="newUser">
				<h2>Register</h2>
			 	<div class="form-group">
			 		<p><form:errors path="name"/></p>
			        <form:label path="name">Name</form:label>
			        <form:input path="name" class="form-control" />
			    </div>
			    <div class="form-group">
			    	<p><form:errors path="email"/></p>
			        <form:label path="email">Email</form:label>
			        <form:input path="email" type="email" class="form-control" />
			    </div>
			     <div class="form-group">
			     	<p><form:errors path="password"/></p>
			        <form:label path="password">Password</form:label>
			        <form:password path="password" class="form-control" />
			    </div>
			    <div class="form-group">
			    	<p><form:errors path="passwordConfirmation"/></p>
			        <form:label path="passwordConfirmation">Confirm Password</form:label>
			        <form:password path="passwordConfirmation" class="form-control" />
			    </div>
			    <button>Register</button>
			</form:form>
			
			<form action="/login" method="POST">
				<h2>Login</h2>
				<span>${ error }</span>
				<div class="form-group">
					<label for="email">Email</label>
					<input type="email" name="email" id="email" class="form-control" />
				</div>
				<div class="form-group">
			        <label for="password">Password</label>
			        <input type="password" name="password" id="password" class="form-control" />		        
			    </div>
			    <button>Login</button>
			</form>
		</div>
	</body>
</html>