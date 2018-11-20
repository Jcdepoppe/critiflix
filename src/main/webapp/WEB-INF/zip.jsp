<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script type="text/javascript" src="/js/helpers.js"></script>

<title>Start with a Zip Code</title>
</head>
<body>
    <div class="container">
        <br><br>
        <div class="row">
            <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2"></div>
            <div class="col-xl-8 col-lg-8 col-md-8 col-sm-8">
                <form method="POST" action="/theaters/getzipcode">
                    <input type="text" name="zipcode" placeholder="Enter Zip Code">
                    <input type="submit" value="Search">
                </form>
            </div>
            <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2"></div>
        </div>
        <br>
        <div class="row">
            <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2"></div>
            <div class="col-xl-8 col-lg-8 col-md-8 col-sm-8" id="map"></div>
            <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2"></div>
        </div>
    </div>

</body>
</html>