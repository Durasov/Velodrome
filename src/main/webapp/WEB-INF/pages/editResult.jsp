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
    <form action="updateResult?resultId=${resultToEdit.resultId}" method="post" class="form">
        <h2>Edit Result</h2>
        <p class="add_description">Result id</p>
        <input name="result_id" type="number" required placeholder="0" class="textbox"> </br>
        <p class="add_description">Team</p>
        <select name="teamSelector" class="add_select">
            <option>${resultTeam.teamName}</option>
            <c:forEach items="${teams}" var="team">
                <option>${team.teamName}</option>
            </c:forEach>
        </select>
        <p class="add_description">Cyclist</p>
        <select name="cyclistSelector">
            <option>${resultCyclist.cyclistName}</option>
            <c:forEach items="${cyclists}" var="cyclist">
                <option>${cyclist.cyclistName}</option>
            </c:forEach>
        </select>
        <p class="add_description">Race type</p>
        <input id="changeType" name="race_type" required type="text" value="${resultToEdit.raceType}" class="textbox"> </br>
        <p class="add_description">Place</p>
        <input id="changePlace" name="result_place" required type="number" value="${resultToEdit.resultPlace}" class="textbox"> </br>
        <input id="submitButton" type="submit" value="Accept" class="button"/>
        <a href="/results" class="cancel">Cancel</a>
    </form>
</div>
</body>
</html>