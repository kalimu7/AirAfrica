
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseUrl" value="http://localhost:8080/AirAfrica_war_exploded/SAdmin?action=" scope="request" ></c:set>
<c:set var="flight" value="${requestScope.data}" scope="request" ></c:set>
<html>
<head>
    <title>Title</title>
    <link href="./css/createFlight.css" rel="stylesheet">
</head>

<form class="form-style-9" method="post" action=" <c:out value="${baseUrl}" />update">
    <ul>
        <li>
            <div>
                <h5>departure city</h5>
                <input type="hidden" value="<c:out value="${flight.flightid}" />" name="flightid" >
                <input type="text" name="departureCity" class="field-style field-split " placeholder="Departure City" value="<c:out value="${flight.departurecity}" />" />
            </div>
            <div>
                <h5>arrival city</h5>
                <input type="text" name="arrivalCity" class="field-style field-split " placeholder="Arrival City" value="<c:out value="${flight.arrivalcity}" />" />
            </div>
        </li>
        <li>
            <div>
                <h5>departure Date</h5>
                <input type="date" name="departureDate" class="field-style field-split align-left" placeholder="departure Date" value="<c:out value="${flight.departuredate}" />" />
            </div>
            <div>
                <h5>Departure Time</h5>
                <input type="time" name="departureTime" class="field-style field-split " placeholder="Departure Time" value="<c:out value="${flight.departuretime}" />" />
            </div>
        </li>
        <li>
            <div>
                <h5>Arrival Date</h5>
                <input type="date" name="arrivalDate" class="field-style field-split align-left" placeholder="Arrival Date" value="<c:out value="${flight.arrivaldate}" />" />
            </div>
            <div>
                <h5>Arrival Time</h5>
                <input type="time" name="arrivalTime" class="field-style field-split " placeholder="Arrival Time" value="<c:out value="${flight.arrivaltime}" />" />
            </div>
        </li>

        <li>
            <div>
                <h5>price</h5>
                <input type="Number" style="width: 45%" name="price" class="field-style field-split w" placeholder="Price" value="<c:out value="${flight.price}" />" />
            </div>

        </li>
        <li>
            <input type="submit" value="Update Flight" />
        </li>
    </ul>
</form>

<body>

</body>
</html>
