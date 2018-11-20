<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Write a review</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
    crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
    crossorigin="anonymous"></script>
<style>
	.card{
		display: block;
	}
</style>
</head>
<body>
	<div class="card">
		<div class="card-body">
			<h2>THEATER NAME</h2>
			<p>Location info</p>
			<p>Rate the movie theater on these three catagories:</p>
			<form:form method="POST" action="/ratings/create"
				modelAttribute="rating">
				<form:label path="cleanliness">Cleanliness:</form:label>
				<form:select path="cleanliness">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</form:select>
				<form:label path="foodQuality">Food Quality:</form:label>
				<form:select path="foodQuality">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</form:select>
				<form:label path="service">Service:</form:label>
				<form:select path="service">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</form:select>
				<p>
					<form:label path="description">Write a review:</form:label>
					<form:textarea path="description" />
					<input type="submit" value="Submit" />
				</p>
			</form:form>
		</div>
	</div>
</body>
</html>