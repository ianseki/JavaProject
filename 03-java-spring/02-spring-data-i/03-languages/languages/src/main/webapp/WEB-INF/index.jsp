<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Languages</title>
	</head>
	<body>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="language" items="${allLanguages}">
					<tr>
						<td><a href="/show/${language.id}"><c:out value="${language.name}" /></a></td>
						<td><c:out value="${language.creator}" /></td>
						<td><c:out value="${language.current_version}" /></td>
						<td>
							<a href="/edit/${language.id}">Edit</a>
							<form action="/delete/${language.id}" method="POST">
								<input type="hidden" name="_method" value="delete" />
								<input type="submit" value="Delete" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h2>Create New Language</h2>
		<form:form action="/" method="POST" modelAttribute="newLanguage">
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
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>