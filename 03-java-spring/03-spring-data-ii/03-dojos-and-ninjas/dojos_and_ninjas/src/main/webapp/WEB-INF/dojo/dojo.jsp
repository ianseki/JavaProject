<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${dojoId.name}</title>
	</head>
	<body>
		<h1>${dojoId.name} Dojo</h1>
		<h3>Ninjas Attending:</h3>
		<table>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ninjas" items="${dojoId.ninjas}">
					<tr>
						<td>${ninjas.first_name}</td>
						<td>${ninjas.last_name}</td>
						<td>${ninjas.age}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/">Dashboard</a>
		<a href="/ninja/new">Create New Ninja</a>
	</body>
</html>