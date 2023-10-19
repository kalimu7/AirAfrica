<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 10/19/2023
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <link href="./css/createFlight.css" rel="stylesheet">

</head>

  <form class="form-style-9">
    <ul>
      <li>
        <input type="text" name="departureCity" class="field-style field-split align-left" placeholder="Departure City" />
        <input type="text" name="arrivalCity" class="field-style field-split align-right" placeholder="Arrival City" />

      </li>
      <li>
        <input type="text" name="field3" class="field-style field-split align-left" placeholder="departure Date" />
        <input type="url" name="field4" class="field-style field-split align-right" placeholder="Departure Time" />
      </li>

      <li>
        <input type="text" name="field3" class="field-style field-split align-left" placeholder="Arrival Date" />
        <input type="url" name="field4" class="field-style field-split align-right" placeholder="Arrival Time" />
      </li>

      <li>
        <input type="text" name="field3" class="field-style field-full align-none" placeholder="Subject" />
      </li>
      <li>
        <textarea name="field5" class="field-style" placeholder="Message"></textarea>
      </li>
      <li>
        <input type="submit" value="Send Message" />
      </li>
    </ul>
  </form>

<body>

</body>
</html>
