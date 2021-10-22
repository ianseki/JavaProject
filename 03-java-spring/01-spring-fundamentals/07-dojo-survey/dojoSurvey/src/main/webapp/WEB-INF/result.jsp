<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Survey Results</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	</head>
	<body>
		<div class="card col-6 mx-auto my-5">
            <h1 class="card-title">
                Survey Results
            </h1>
            <p class="card-text">
                Name: <c:out value="${name}"/>
            </p>
            <p class="card-text">
                Dojo Location: <c:out value="${location}"/>
            </p>
            <p class="card-text">
                Favorite Language: <c:out value="${language}"/>
            </p>
            <p class="card-text">
                Comments: <c:out value="${comments}"/>
            </p>
            <form action="/">
                <input type="submit" value="Back" class="btn btn-primary">
            </form>
        </div>
	</body>
</html>