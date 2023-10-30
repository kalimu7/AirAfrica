<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 10/27/2023
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/home.css" />
</head>
<body>
<jsp:include page="./Components/header.jsp" />

    <h3>Your booking is almost Ready</h3>
    <div class="continFlightDetails" >


    <div class="flight-details">
        <div class="flight-body" >
            <div>
                <p>  <i class="fa-solid fa-plane-departure" style="margin-right: 20px"></i>  Departure City : Fes  </p>
                <p>  <i class="fa-solid fa-clock" style="margin-right: 20px" ></i>   Flight Time : 12:00</p>

            </div>
            <div>
                <p> <i class="fa-solid fa-plane-arrival" style="margin-right: 20px"></i> Arrival City : Paris  </p>
                <p>  <i class="fa-solid fa-clock" style="margin-right: 20px" ></i>   Flight Time : 12:00</p>
            </div>
        </div>
        <div>
            <p> <i class="fa-solid fa-calendar-days"></i> 2023/10/12 </p>
            Flight Price  <i class="fa-solid fa-money-bill"></i> : 100 DH

        </div>

        </div>
    </div>






<jsp:include page="./Components/footer.jsp" />
</body>
</html>
