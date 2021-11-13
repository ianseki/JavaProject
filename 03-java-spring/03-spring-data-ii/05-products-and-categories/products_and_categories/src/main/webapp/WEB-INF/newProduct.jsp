<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create New Product</title>
	</head>
	<body>
		<h1>New Product</h1>
		<form action="/product/create" method="POST">
			<p>
				<label for="name">Name: </label>
				<input name="name" type="text" />
			</p>
			<p>
				<label for="description">Description: </label>
				<textarea name="description" rows="5" cols="30"></textarea>
			<p>
				<label for="price">Price: </label>
				<input name="price" type="number" />
			</p>
				<input type="submit" value="Submit"/>
		</form>
	</body>
</html>