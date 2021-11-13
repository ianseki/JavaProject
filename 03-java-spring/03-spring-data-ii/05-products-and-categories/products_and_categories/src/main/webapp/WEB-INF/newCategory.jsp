<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create New Category</title>
	</head>
	<body>
		<h1>New Category</h1>
		<form action="/category/create" method="POST">
			<label for="name">Name: </label>
			<input name="name" type="text" />
			<input type="submit" value="Submit"/>
		</form>
	</body>
</html>