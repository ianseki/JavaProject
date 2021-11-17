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
		<title>Create Idea</title>
	</head>
	<body>
		<div class="d-flex justify-content-between align-items-center col-12">
			<h1>Create Idea</h1>
			<a href="/ideas">Dashboard</a>
		</div>
		<form:form action="/ideas/create" method="POST" modelAttribute="newIdea">
				<form:hidden path="creator" value="${user.id}" />
				<div class="form-group col-5">
					<form:label path="name">Name</form:label>
					<form:errors path="name"></form:errors>
					<form:input path="name" class="form-control" />
				</div>
			    <button>Create Idea</button>
		</form:form>
	</body>
</html>