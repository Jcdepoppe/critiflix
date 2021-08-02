<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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

<title>Dashboard</title>
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

    <script>

        

        function initMap() {

        var tlLatLng = [
            <c:forEach items="${theaterlocations}" var="location" varStatus="counter">
                {lat: ${location.lat}, lng: ${location.lng} }, 
            </c:forEach>
            ];

        var map = new google.maps.Map(document.getElementById('map'), {
            center: tlLatLng[0],
            zoom: 11
        });

        var marker = [];
        var infowindow = [];
        var contentString = [];

        <c:forEach items="${theaterlocations}" var="location" varStatus="counter">
            contentString[${counter.count-1}] = "<div id='content'> <div id='siteNotice'></div> <h3 id='firstHeading' class='firstHeading'>${location.name}</h3> <div id='bodyContent'><p>${location.vicinity}</p><a href='/theaters/${location.place_id}'>Select Theater</a></div></div>";
            infowindow[${counter.count-1}] = new google.maps.InfoWindow({ content: contentString[${counter.count-1}]});
            marker[${counter.count-1}] = new google.maps.Marker({ map: map, position: tlLatLng[${counter.count-1}], title: "${location.name}"});
            marker[${counter.count-1}].addListener('click', function() { infowindow[${counter.count-1}].open(map, marker[${counter.count-1}]); });
        </c:forEach>

    }
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA_aOK49a2Rm00tCPaeNE6d23F0y2O7BL4&callback=initMap" async defer></script>

</body>
</html>