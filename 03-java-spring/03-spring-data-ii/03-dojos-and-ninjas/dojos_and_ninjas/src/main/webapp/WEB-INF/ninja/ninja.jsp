<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create Ninja</title>
	</head>
	<body>
		<h1>Create New Ninja</h1>
		<form:form action="/ninja/create" modelAttribute="newNinja" method="POST">
			<p>
				<form:label path="dojo">Dojo</form:label>
				<form:select path="dojo">
					<c:forEach var="dojo" items="${allDojos}">
						<option value="${dojo.id}">${dojo.name}</option>
					</c:forEach>
				</form:select>
			</p>
			<form:errors path="first_name" />
			<p>
				<form:label path="first_name">First Name:</form:label>
				<form:input path="first_name" />
			</p>
			<form:errors path="last_name" />
			<p>
				<form:label path="last_name">Last Name:</form:label>
				<form:input path="last_name" />
			</p>
			<form:errors path="age" />
			<p>
				<form:label path="age">Age:</form:label>
				<form:input path="age" />
			</p>
			<form:button>Create Ninja</form:button>
		</form:form>
		<a href="/">Dashboard</a>
	</body>
</html>