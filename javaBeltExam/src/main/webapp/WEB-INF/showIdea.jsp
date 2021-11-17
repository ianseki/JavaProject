<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
		<title>${idea.name}</title>
	</head>
	<body>
		<div class="d-flex justify-content-between align-items-center col-12">
			<h1>${idea.name}</h1>
			<a href="/ideas">Dashboard</a>
		</div>
		<p class="ml-3">Created By: ${idea.creator.name}</p>
		<h2>Users Who Liked Idea: </h2>
		<table class="table">
			<thead>
				<tr>
					<th>Name: </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${idea.peopleWhoLikedIdea}" var="likers">
					<tr>
						<td><c:out value="${likers.name}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${idea.creator.id == userId}">
			<a href="/ideas/${idea.id}/edit" class="ml-2">Edit Idea</a>
		</c:if>
	</body>
</html>