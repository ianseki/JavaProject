<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Counter</title>
</head>
<body>
<h1>You have visited http://your_server: <c:out value="${showCurrentCount}"/> times</h1>
<a href="/">Take another visit</a>
<a href="/reset">Reset Count</a>
</body>
</html>