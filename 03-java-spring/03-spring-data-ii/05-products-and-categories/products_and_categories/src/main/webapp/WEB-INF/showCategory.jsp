<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${category.name}</title>
	</head>
	<body>
		<h1><c:out value="${category.name}" /></h1>
		<h3>Products</h3>
		<ul>
			<c:forEach items="${category.products}" var="product">
				<li>${product.name} | ${product.description} | ${product.price}</li>
			</c:forEach>
		</ul>
		
		<form action="/category/addProduct/${category.id}" method="POST">
			<select name="products">
				<c:forEach items="${notInCategory}" var="products">
					<option value="${products.id}">${products.name}</option>
				</c:forEach>
			</select>
			<button>Add Product</button>
		</form>
	</body>
</html>