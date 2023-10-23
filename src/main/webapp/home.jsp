<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 10/22/2023
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="data" value="${requestScope.data}" ></c:set>
<html>
<head>
    <title>Title</title>
    <link href="css/home.css" rel="stylesheet" />
    <link
            href="https://cdn.jsdelivr.net/npm/remixicon@3.4.0/fonts/remixicon.css"
            rel="stylesheet"
    />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<nav>
    <div class="nav__logo">Air Africa</div>
    <ul class="nav__links">
        <li class="link"><a href="#">Home</a></li>
        <li class="link"><a href="#">About</a></li>
        <li class="link"><a href="#">Offers</a></li>
        <li class="link"><a href="#">Seats</a></li>
        <li class="link"><a href="#">Destinations</a></li>
    </ul>
    <button class="btn">Sign up / Login</button>

</nav>

<header class="section__container header__container">
    <h1 class="section__header">Find And Book<br />A Great Experience</h1>
    <img src="assets/header.jpg" alt="header" />
</header>

<section class="section__container booking__container">

    <form method="post" action="http://localhost:8080/AirAfrica_war_exploded/Client?action=Search" >
        <div class="form__group">
            <span><i class="ri-map-pin-line"></i></span>
            <div class="input__content">
                <div class="input__group">
                    <input type="text" name="from" />

                </div>
                <p>From Location</p>
            </div>
        </div>

        <div class="form__group">
            <span><i class="ri-map-pin-line"></i></span>
            <div class="input__content">
                <div class="input__group">
                    <input type="text" name="to" />

                </div>
                <p>Your destination</p>
            </div>
        </div>

        <div class="form__group">
            <span><i class="ri-user-3-line"></i></span>
            <div class="input__content">
                <div class="input__group">
                    <input type="number" />

                </div>
                <p>Add guests</p>
            </div>
        </div>
        <div class="form__group">
            <span><i class="ri-calendar-line"></i></span>
            <div class="input__content">
                <div class="input__group">
                    <input type="date" name="when" />

                </div>
                <p>Add date</p>
            </div>
        </div>
        <div class="form__group">
            <span><i class="ri-calendar-line"></i></span>
            <div class="input__content">
                <div class="input__group">
                    <input type="date" name="back" />

                </div>
                <p>Add date</p>
            </div>
            <section style="display:flex;justify-content:center;width: 100%" >
                <button type="submit" class="btn" ><i class="ri-search-line"></i></button>
            </section>
        </div>


    </form>
</section>

<section class="results"  >
    <c:forEach var="fl" items="${data}">
    <div class="card-flight" >

        <div class="main-body" >
            <div class="">
                <label> <c:out value="${fl.departurecity}" /> </label>
                <p><c:out value="${fl.departuretime}" /> </p>
            </div>

            <i class="fa-solid fa-plane"></i>
            <div class="">
                <label> <c:out value="${fl.arrivalcity}" /> </label>
                <p><c:out value="${fl.arrivaltime}" /></p>
            </div>
        </div>
        <div class="genraleinfo">
            <p>  <span style="margin: 0 20px;"> Direct Flight </span>  <span> <c:out value="${fl.departuredate}" /> </span> </p> <br>
            <button class="price"><c:out value="${fl.price}" /> DH</button>
        </div>
    </div>
    </c:forEach>
    <div class="card-flight" >

        <div class="main-body" >
            <div class="">
                <label> Casablanca </label>
                <p>10:30</p>
            </div>

            <i class="fa-solid fa-plane"></i>
            <div class="">
                <label> Paris </label>
                <p>14:30</p>
            </div>
        </div>
        <div class="genraleinfo">
            <p>  <span style="margin: 0 20px;"> Direct Flight </span>  <span> 20/10/2023 </span> </p> <br>
            <button class="price">6500 DH</button>
        </div>
    </div>

</section>

<section class="memories">
    <div class="section__container memories__container">
        <div class="memories__header">
            <h2 class="section__header">
                Travel to make memories all around the world
            </h2>
            <button class="view__all">View All</button>
        </div>
        <div class="memories__grid">
            <div class="memories__card">
                <span><i class="ri-calendar-2-line"></i></span>
                <h4>Book & relax</h4>
                <p>
                    With "Book and Relax," you can sit back, unwind, and enjoy the
                    journey while we take care of everything else.
                </p>
            </div>
            <div class="memories__card">
                <span><i class="ri-shield-check-line"></i></span>
                <h4>Smart Checklist</h4>
                <p>
                    Introducing Smart Checklist with us, the innovative solution
                    revolutionizing the way you travel with our airline.
                </p>
            </div>
            <div class="memories__card">
                <span><i class="ri-bookmark-2-line"></i></span>
                <h4>Save More</h4>
                <p>
                    From discounted ticket prices to exclusive promotions and deals,
                    we prioritize affordability without compromising on quality.
                </p>
            </div>
        </div>
    </div>
</section>

<footer class="footer">
    <div class="section__container footer__container">
        <div class="footer__col">
            <h3>Air Africa</h3>
            <p>
                Where Excellence Takes Flight. With a strong commitment to customer
                satisfaction and a passion for air travel, Flivan Airlines offers
                exceptional service and seamless journeys.
            </p>
            <p>
                From friendly smiles to state-of-the-art aircraft, we connect the
                world, ensuring safe, comfortable, and unforgettable experiences.
            </p>
        </div>
        <div class="footer__col">
            <h4>INFORMATION</h4>
            <p>Home</p>
            <p>About</p>
            <p>Offers</p>
            <p>Seats</p>
            <p>Destinations</p>
        </div>
        <div class="footer__col">
            <h4>CONTACT</h4>
            <p>Support</p>
            <p>Media</p>
            <p>Socials</p>
        </div>
    </div>
    <div class="section__container footer__bar">
        <p>Copyright © 2023 Web Design Mastery. All rights reserved.</p>
        <div class="socials">
            <span><i class="ri-facebook-fill"></i></span>
            <span><i class="ri-twitter-fill"></i></span>
            <span><i class="ri-instagram-line"></i></span>
            <span><i class="ri-youtube-fill"></i></span>
        </div>
    </div>
</footer>


</body>
</html>
