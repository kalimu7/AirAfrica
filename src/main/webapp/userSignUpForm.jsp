<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String baseUrl = (String) request.getAttribute("baseUrl"); %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>

<div class="container">
    <div class="wrapper">
        <div class="title"><span>Signup Form</span></div>

        <form action="<%= baseUrl %>/Client?action=insert" method="Post">
            <div class="row">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="First Name" required name="firstName">
            </div>
            <div class="row">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Last Name" required name="lastName">
            </div>
            <div class="row">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Email" required name="email">
            </div>
            <div class="row">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Phone" required name="phone" >
            </div>
            <div class="row">
                <i class="fas fa-user"></i>
                <input type="password" placeholder="Password" required name="password">
            </div>

            <div class="row button">
                <input type="submit" value="Sign up">
            </div>
            <div class="signup-link">Already a member? <a href="#">Signin now</a></div>
        </form>
    </div>
</div>

</body>
</html>
