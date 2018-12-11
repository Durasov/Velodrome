<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Velodrome</title>
    <link rel="shortcut icon" href="resources/img/chain.png" type="image/png">
    <link rel="stylesheet" type="text/css" href="resources/css/style.css"/>
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
    <form:form action="updateBicycle?bicycleId=${bicycleToEdit.bicycleId}" method="post" class="form">
        <h2>${bicycleToEdit.bicycleName}</h2>
        <p class="add_description">Cyclist</p>
        <select name="cyclistSelector" class="add_select">
            <option>${bicycleCyclist.cyclistName}</option>
            <c:forEach items="${cyclists}" var="cyclist">
                <option>${cyclist.cyclistName}</option>
            </c:forEach>
        </select>
        <p class="add_description">Model</p>
        <input id="changeModel" name="bicycle_name" required type="text" value="${bicycleToEdit.bicycleName}" class="textbox"> </br>
        <p class="add_description">Material</p>
        <input id="changeMaterial" name="bicycle_material" required type="text" value="${bicycleToEdit.bicycleMaterial}" class="textbox"> </br>
        <p class="add_description">Weight</p>
        <input id="changeWeight" name="bicycle_weight" required type="number" value="${bicycleToEdit.bicycleWeight}" class="textbox"> </br>
        <input id="submitButton" type="submit" value="Accept" class="button"/>
        <a href="/bicycles" class="cancel">Cancel</a>
    </form:form>
</div>
</body>
</html>