<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit your review</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
    crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
    crossorigin="anonymous"></script>
            <meta name="viewport" content="initial-scale=1,width=device-width">
        <link rel="stylesheet" type="text/css" href="/css/StarRating.css">
        <link rel="stylesheet" href="//code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
</head>
<body>
	<div class="card">
		<div class="card-body">
			<h2>THEATER NAME</h2>
			<p>Location info</p>
			<p>Rate the movie theater on these three catagories:</p>
			<form:form method="POST" action="/ratings/${rating.id}/edit"
				modelAttribute="rating">
				<input type="hidden" name="_method" value="put">
				<div style="display: block">
				<form:label path="cleanliness">Cleanliness:</form:label>
				<x-star-rating value="${rating.cleanliness}" number="5"
					id="cleanStar"> </x-star-rating>
				<form:input type="hidden" path="cleanliness" id="cleanControl" />
				</div>
				<div style="display: block">
				<form:label path="foodQuality">Food Quality:</form:label>
				<x-star-rating value="${rating.foodQuality}" number="5"
					id="qualityStar"> </x-star-rating>
				<form:input type="hidden" path="foodQuality" id="qualityControl" />
				</div>
				<div style="display: block">
				<form:label path="service">Service:</form:label>
				<x-star-rating value="${rating.service}" number="5" id="serviceStar">
				</x-star-rating>
				<form:input type="hidden" path="service" id="serviceControl" />
				</div>
				<p>
					<form:label path="description">Write a review:</form:label>
					<form:textarea path="description" />
					<input type="submit" value="Submit" />
				</p>
			</form:form>
			<form:form method="POST" action="/ratings/${rating.id}/edit">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete" />
			</form:form>
		</div>
	</div>
	<script type="text/javascript" src="/js/StarRating.js"></script>
	<script src= 'http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js'></script>
	<script type="text/javascript">
	cleanStar.addEventListener('rate', () => {
		console.log(cleanStar.value);
		document.getElementById('cleanControl').setAttribute("value", cleanStar.value);
	});
	qualityStar.addEventListener('rate', () => {
		console.log(qualityStar.value);
		document.getElementById('qualityControl').setAttribute("value", qualityStar.value);
	});
	serviceStar.addEventListener('rate', () => {
		console.log(serviceStar.value);
		document.getElementById('serviceControl').setAttribute("value", serviceStar.value);
	});
	</script>
</body>
</html>