<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
		<title>Edit ${editIdea.name}</title>
	</head>
	<body>
		<div class="d-flex justify-content-between align-items-center col-12">
			<h1>Edit ${editIdea.name}</h1>
			<a href="/ideas">Dashboard</a>
		</div>
		<form:form action="/ideas/${editIdea.id}/edit" method="POST" modelAttribute="editIdea">
			<input type="hidden" name="_method" value="put">
			<form:hidden path="creator" value="${userId}" />
			<div class="form-group col-5">
				<form:label path="name">Name</form:label>
				<form:errors path="name"></form:errors>
				<form:input path="name" class="form-control" />
			</div>
			<button>Submit</button>
		</form:form>
		<form action="/ideas/${editIdea.id}/delete" method="POST">
			<input type="hidden" name="_method" value="delete" />
			<button>Delete</button>
		</form>
	</body>
</html>