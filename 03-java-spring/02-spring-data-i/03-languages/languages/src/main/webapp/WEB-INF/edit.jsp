<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit ${langID.name}</title>
	</head>
	<body>
		<div>
			<h2>Edit ${langID.name}</h2>
			<form action="/delete/${langID.id}" method="POST">
				<input type="hidden" name="_method" value="delete" />
				<input type="submit" value="Delete" />
			</form>
			<a href="/">Dashboard</a>
		</div>
		<form:form action="/edit/${langID.id}" method="POST" modelAttribute="langID">
				<form:errors path="name" />
			<p>
				<form:label path="name">Name:</form:label>
				<form:input path="name" />
			</p>
				<form:errors path="creator" />
			<p>
				<form:label path="creator">Creator:</form:label>
				<form:input path="creator" />
			</p>
				<form:errors path="current_version" />
			<p>
				<form:label path="current_version">Version:</form:label>
				<form:input path="current_version" />
			</p>
			<input type="hidden" name="_method" value="put" />
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>