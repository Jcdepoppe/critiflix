<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Critiflix - Register/Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
    crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
    crossorigin="anonymous"></script>
    
<style>
	.error{
		color: red;
	}
	.card{
		width: 45%;
		display: inline-block;
		vertical-align:top;
		margin: 10px;
	}
	.form{
		width: 45%;
		display: inline-block;
		vertical-align:top;
	}
</style>
</head>
<body>
	<div class="card">
		<div class="card-body">
			<h1>Register!</h1>
			<p class="error">
				<form:errors path="user.*" />
			</p>

			<form:form method="POST" action="/registration" modelAttribute="user">
				<div class="form">
					<p>
						<form:label path="alias">Username:</form:label>
					</p>
					<p>
						<form:label path="email">Email:</form:label>
					</p>
					<p>
						<form:label path="zipcode">Zip-code:</form:label>
					</p>
					<p>
						<form:label path="password">Password:</form:label>
					</p>
					<p>
						<form:label path="passwordConfirmation">Password Confirmation:</form:label>
					</p>

				</div>
				<div class="form">
					<p>
						<form:input path="alias" />
					</p>
					<p>
						<form:input type="email" path="email" />
					</p>
					<p>
						<form:input path="zipcode" />
					</p>
					<p>
						<form:password path="password" />
					</p>
					<p>
						<form:password path="passwordConfirmation" />
					</p>
					<input type="submit" value="Register!" />
				</div>
			</form:form>
		</div>
	</div>

	<div class="card">
	<div class="card-body">
	    <h1>Login</h1>
	    <p class="error"><c:out value="${error}" /></p>
			<form method="post" action="/login">
				<div class="form">
					<p>
						<label type="email" for="email">Email</label>
					</p>
					<p>
						<label for="password">Password</label>
					</p>

				</div>
				<div class="form">
					<p>
						<input type="text" id="email" name="email" />

					</p>
					<p>
						<input type="password" id="password" name="password" />
					</p>
					<input type="submit" value="Login!" />
				</div>
			</form>
		</div>
	 </div>
</body>
</html>