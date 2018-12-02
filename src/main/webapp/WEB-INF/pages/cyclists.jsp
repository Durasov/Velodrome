<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 30.11.2018
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Velodrome cyclists</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
    <link rel="stylesheet" type="text/css" href="resources/style2.css"/>
</head>
<body>
<header class="header">
    <h1 class="header_logo">
        <a href="#" class="header_logo_link">Velodrome</a></h1>
    <nav class="nav_item">
        <ul class="nav_ul">
            <li class="nav_li">
                <a href="/index.jsp" class="nav_link nav_link1"> News </a>
            </li>
            <li class="nav_li">
                <a href="/teams" class="nav_link nav_link2"> Teams </a>
            </li>
            <li class="nav_li">
                <a href="/cyclists" class="nav_link nav_link3"> Cyclists </a>
            </li>
            <li class="nav_li">
                <a href="/bicycles" class="nav_link nav_link4"> Bicycles </a>
            </li>
            <li class="nav_li">
                <a href="/results" class="nav_link nav_link5"> Results </a>
            </li>
        </ul>
    </nav>
</header>

<table class="table" align="center">
    <thead>
    <th>Cyclist name</th>
    <th>Cyclist team</th>
    <th>Cyclist age</th>
    <th></th>
    <th></th>
    </thead>
    <tbody>
    <c:forEach items="${cyclists}" var="cyclist">
    <tr>
        <td>${cyclist.cyclistName}
        </td>
        <td>${cyclist.getTeam().getTeamName()}
        </td>
        <td>${cyclist.cyclistAge}
        </td>
        <td><a href="/editCyclist?cyclistId=${cyclist.cyclistId}">Edit</a></td>
        <td><a href="/deleteCyclist?cyclistId=${cyclist.cyclistId}">Delete</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<div class="description">
    <c:forEach items="${cyclists}" var="cyclist" begin="0" end="0">
        <a href="/addCyclist?cyclistId=${cyclist.cyclistId}" class="add_button">Add cyclist</a>
    </c:forEach>
</div>
</body>
</html>
