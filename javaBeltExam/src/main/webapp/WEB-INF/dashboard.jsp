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
	<title>Ideas</title>
	</head>
	<body>
		<div class="d-flex justify-content-between align-items-center col-12">
			<h1>Welcome, ${user.name}</h1>
			<a href="/logout">Log Out</a>
		</div>
		<div>
			<h3 class="ml-3">Ideas</h3>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Idea </th>
						<th>Created By </th>
						<th>Likes </th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allIdeas}" var="idea">
						<tr>
							<td><a href="/ideas/${idea.id}"><c:out value="${idea.name}" /></a></td>
							<td>${idea.creator.name}</td>
							<td>${idea.peopleWhoLikedIdea.size()}</td>
							<td>
								<c:choose>
									<c:when test="${idea.peopleWhoLikedIdea.contains(user)}">
										<a href="/ideas/${idea.id}/dislike">Dislike</a>
									</c:when>
									<c:otherwise>
										<a href="/ideas/${idea.id}/like">Like</a>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="/ideas/new" class="btn btn-primary m-2">Create Idea</a>
		</div>
	</body>
</html>