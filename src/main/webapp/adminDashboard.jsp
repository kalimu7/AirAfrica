<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 10/18/2023
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="seesionadmin" value="${sessionScope.adminSession}"></c:set>
<c:set var="baseUrl" value="${requestScope.baseUrl}" scope="request" ></c:set>
<c:set var="flights" value="${requestScope.data}" scope="request"></c:set>

<c:if test="${sessionScope.adminSession == false}">
    <c:redirect url="http://localhost:8080/AirAfrica_war_exploded/SAdmin?action=login" />
</c:if>

<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <title>CRUD FROM API</title>

    <link href="index.css" rel="stylesheet">
</head>
<body>


<c:out value="${seesionadmin}" />
<title>Title</title>
<h5>hello this is dashboard page</h5> <br>
<a href="<c:out value="${baseUrl}" />SAdmin?action=showCreate">create</a> <br>
<a href="<c:out value="${baseUrl}" />SAdmin?action=selectAll">selectAll</a>

<nav class="navbar navbar-dark bg-mynav">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">My App</a>
    </div>
</nav>

<div class="container">
    <div class="d-flex bd-highlight mb-3">
        <div class="me-auto p-2 bd-highlight"><h2>Users </h2> </div>
        <div class="p-2 bd-highlight">
            <a href="<c:out value="${baseUrl}" />SAdmin?action=showCreate" class="btn btn-secondary" >Create</a>
        </div>
    </div>

    <div class="table-responsive">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">departure City</th>
                <th scope="col">departure Date</th>
                <th scope="col">arrival City</th>
                <th scope="col">arrival Date</th>
                <th scope="col">Flight Price</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody id="mytable">
            <c:forEach var="fls" items="${flights}" >
                <tr>
                    <td scope="col"> # </td>
                    <td scope="col"> <c:out value="${fls.departurecity}" /> </td>
                    <td scope="col"> <c:out value="${fls.departuredate}" /> </td>
                    <td scope="col">  <c:out value="${fls.arrivalcity}" /> </td>
                    <td scope="col">  <c:out value="${fls.arrivaldate}" /> </td>
                    <td scope="col"> <c:out value="${fls.price}" /> </td>
                    <td scope="col" style="display: flex;"> <div> <a href="<c:out value="${baseUrl}" />SAdmin?action=Showupdate&id=<c:out value="${fls.flightid}" /> " class="btn btn-primary" > Update </a></div>  <form action="<c:out value="${baseUrl}" />SAdmin?action=delete&id=<c:out value="${fls.flightid}" /> " method="post"> <button  type="submit" class="btn btn-danger" > Delete </button> </form>  </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>

<script src="index.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.16/dist/sweetalert2.all.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>
