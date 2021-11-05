<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dojos and Ninjas</title>
	</head>
	<body>
		<h1>Create Dojo: </h1>
		<form:form action="/" method="POST" modelAttribute="newDojo">
				<form:errors path="name" />
			<p>
				<form:label path="name">Name:</form:label>
				<form:input path="name" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
		<table>
			<thead>
				<tr>
					<th>Dojo Name</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dojo" items="${allDojos}">
					<tr>
						<td><a href="/dojo/show/${dojo.id}"><c:out value="${dojo.name}" /></a></td>
						<td>
							<form action="/delete/${dojo.id}" method="POST">
								<input type="hidden" name="_method" value="delete" />
								<input type="submit" value="Delete" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>
			<a href="/ninja/new">Add Ninja</a>
		</h3>
	</body>
</html>