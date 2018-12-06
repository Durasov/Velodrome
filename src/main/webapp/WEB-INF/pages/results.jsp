<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 30.11.2018
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<table class="table" align="center">
    <thead>
    <th>Cyclist name</th>
    <th>Cyclist team</th>
    <th>Race type</th>
    <th>Result place</th>
    <th></th>
    <th></th>
    </thead>
    <tbody>
    <c:forEach items="${results}" var="result">
    <tr>
        <td>${cyclistDao.getCyclist(result.getCyclistId()).getCyclistName()}
        </td>
        <td>${teamDao.getTeam(result.getTeamId()).getTeamName()}
        </td>
        <td>${result.raceType}
        </td>
        <td>${result.resultPlace}
        </td>
        <td><a href="/editResult?resultId=${result.resultId}">Edit</a></td>
        <td><a href="/deleteResult?resultId=${result.resultId}">Delete</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<div class="description">
    <c:forEach items="${results}" var="result" begin="0" end="0">
        <a href="/addResult?resultId=${result.resultId}" class="add_button">Add result</a>
    </c:forEach>
</div>
</form>
</body>
</html>
