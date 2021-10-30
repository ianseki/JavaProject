<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><c:out value="${langID.name}"/></title>
	</head>
	<body>
		<div>
			<a href="/">Dashboard</a>
			<p><c:out value="${langID.name}"/></p>
			<p><c:out value="${langID.creator}"/></p>
			<p><c:out value="${langID.current_version}"/></p>
			<p><a href="/edit/${langID.id}">Edit</a></p>
			<form action="/delete/${langID.id}" method="POST">
				<input type="hidden" name="_method" value="delete" />
				<input type="submit" value="Delete" />
			</form>
		</div>
	</body>
</html>