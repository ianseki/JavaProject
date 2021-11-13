<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${product.name}</title>
	</head>
	<body>
		<h1><c:out value="${product.name}" /></h1>
		<c:out value="${product.description}" />
		<c:out value="${product.price}" />
		
		<h2>Categories</h2>
		<ul>
			<c:forEach items="${product.categories}" var="category">
				<li>${category.name}</li>
			</c:forEach>
		</ul>
		<form action="/product/addCategory/${product.id}" method="POST">
			<select name="categories">
				<c:forEach items="${notInProduct}" var="category">
					<option value="${category.id}">${category.name}</option>
				</c:forEach>
			</select>
			<button>Add Category</button>
		</form>
	</body>
</html>