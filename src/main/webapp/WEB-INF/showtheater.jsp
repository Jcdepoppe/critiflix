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

<title>Select Movies</title>
</head>
<body>
    <div class="container-fluid">
        <br><br>
        <div class="row">
            <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2"></div>
            <div class="col-xl-8 col-lg-8 col-md-8 col-sm-8">
                <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <th>Start Time</th>
                            <th>Movie Title</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${selectedMovieTimes}" var="movieTime">
                                <tr>
                                    <td>${movieTime.starttime}</td>
                                    <td>${movieTime.title}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
            </div>
            <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2"></div>
        </div>
        <br>
        <hr>
        <div class="row">
            <div class="col-xl-1 col-lg-1 col-md-1 col-sm-1"></div>
            <div class="col-xl-10 col-lg-10 col-md-10 col-sm-10">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                        <th>Start Time</th>
                        <th colspan="2">Movie Title</th>
                        <th>Description</th>
                        <th>Duration (HH:mm)</th>
                        <th>Action</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${movieTimes}" var="movieTime">
                            <tr>
                                <td>${movieTime.starttime}</td>
                                <td><img src='https://cuso.tmsimg.com/${movieTime.imageUrl}' alt='Movie Image' height='75' width='75'></td>
                                <td>${movieTime.title}</td>
                                <td>${movieTime.shortdescription}</td>
                                <td>${movieTime.strduration}</td>
                                <td>
                                    <form action="/theaters/selectshowing" method="POST">
                                        <input type="hidden" name="showid" value="${movieTime.id}">
                                        <input type="hidden" name="placeid" value="${placeid}">
                                        <input class="btn btn-primary" type="submit" value="Select">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-xl-1 col-lg-1 col-md-1 col-sm-1"></div>
        </div>
    </div>

</body>
</html>