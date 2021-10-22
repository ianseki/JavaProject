<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dojo Survey</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	</head>
	<body>
		<form action="/submit" method="POST" class="p-3 col-6 mx-auto my-5 border border-solid">
			<div class="form-group m-2">
				<label for="name">Name: </label>
				<input type="text" name="name">
			</div>
			<div class="form-group m-2">
				<label for="location">Dojo Location:</label>
				<select name="location">
					<option value="San Jose">San Jose</option>
	                <option value="Chicago">Chicago</option>
	                <option value="Seattle">Seattle</option>
	                <option value="Burbank">Burbank</option>
	                <option value="Bellvue">Bellvue</option>
	                <option value="Online">Online</option>
				</select>
			</div>
			<div class="form-group m-2">
				<label for="language">Favorite Language:</label>
	            <select name="language">
	                <option value="HTML">HTML</option>
	                <option value="CSS">CSS</option>
	                <option value="JavaScript">JavaScript</option>
	                <Option value="Java">Java</Option>
	                <option value="Python">Python</option>
	                <option value="C#">C#</option>
	            </select>
           	</div>
           	<div class="form-group m-2">
	            <label for="comments">
	                Comments (optional):
	            </label>
	            <textarea name="comments" cols="30" rows="10" class="form-control"></textarea>
           	</div>
            <input type="submit" value="Submit" class="btn btn-primary m-2">
		</form>
	</body>
</html>