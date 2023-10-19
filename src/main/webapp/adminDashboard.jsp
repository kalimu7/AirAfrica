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
<c:if test="${sessionScope.adminSession == false}">
    <c:redirect url="http://localhost:8080/AirAfrica_war_exploded/SAdmin?action=login" />
</c:if>

<html>
<head>
    <c:out value="${seesionadmin}" />
    <title>Title</title>
    <h1>hello this is dashboard page</h1> <br>
    <a href="<c:out value="${baseUrl}" />SAdmin?action=create">create</a> <br>
    <a href="<c:out value="${baseUrl}" />SAdmin?action=selectAll">selectAll</a>

</head>
<body>

</body>
</html>
