
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% String baseUrl = (String) request.getAttribute("baseUrl"); %>


<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="container">
    <div class="wrapper">

        <div class="title"><span>Login Form</span></div>
        <form action="<%= baseUrl %>SAdmin?action=authAdmin" method="post" >

            <div class="row">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Enter your email" name="email" required>
            </div>
            <div class="row">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Password" required name="password">
            </div>
            <div class="row button">
                <input type="submit" value="Login">
            </div>

        </form>
    </div>
</div>
</body>
</html>
