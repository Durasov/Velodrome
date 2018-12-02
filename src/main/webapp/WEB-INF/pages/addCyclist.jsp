<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.12.2018
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Add Cyclist</title>
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

<div class="description">
    <form:form action="saveCyclist" method="post" class="form">
        <h2>Add Cyclist</h2>
        <p class="add_description">Cyclist id</p>
        <input name="cyclist_id" type="number" required placeholder="0" class="textbox"> </br>
        <p class="add_description">Team</p>
        <select name="teamSelector" class="add_select">
            <option>${playersTeam.teamName}</option>
            <c:forEach items="${teams}" var="team">
                <option>${team.teamName}</option>
            </c:forEach>
        </select>
        <p class="add_description">Cyclist name</p>
        <input name="cyclist_name" type="text" required placeholder="Cyclist Name" class="textbox"> </br>
        <p class="add_description">Cyclist age</p>
        <input name="cyclist_age" type="number" required placeholder="0" class="textbox"> </br>
        <input type="submit" value="Add cyclist" class="button"/>
        <a href="/cyclists" class="cancel">Cancel</a>
    </form:form>
</div>
</body>
</html>
