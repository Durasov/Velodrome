<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 02.12.2018
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Add Bicycle</title>
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
                <a href="/index" class="nav_link nav_link1"> News </a>
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
    <form action="saveBicycle" method="post" class="form">
        <h2>Add Bicycle</h2>
        <p class="add_description">Cyclist</p>
        <select name="cyclistSelector" class="add_select">
            <option>${bicycleCyclist.cyclistName}</option>
            <c:forEach items="${cyclists}" var="cyclist">
                <option>${cyclist.cyclistName}</option>
            </c:forEach>
        </select>
        <p class="add_description">Model</p>
        <input name="bicycle_name" type="text" required placeholder="Model" class="textbox"> </br>
        <p class="add_description">Material</p>
        <input name="bicycle_material" type="text" required placeholder="Material" class="textbox"> </br>
        <p class="add_description">Weight </p>
        <input name="bicycle_weight" type="number" placeholder="0" class="textbox"> </br>
        <input type="submit" value="Add bicycle" class="button"/>
        <a href="/bicycles" class="cancel">Cancel</a>
    </form>
</div>
</body>
</html>
