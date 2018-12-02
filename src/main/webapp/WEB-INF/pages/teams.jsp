<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25.11.2018
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Velodrome Teams</title>
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

<table class="table" align="center">
    <thead>
    <th>Team name</th>
    <th>Team country</th>
    <th></th>
    <th></th>
    </thead>
    <tbody>
    <c:forEach items="${teams}" var="team">
    <tr>
        <td>${team.teamName}
        </td>
        <td>${team.teamCountry}
        </td>
        <td><a href="/editTeam?teamId=${team.teamId}">Edit</a></td>
        <td><a href="/deleteTeam?teamId=${team.teamId}">Delete</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<div class="description">
    <a href="/addTeam" class="add_button">Add team</a>
</div>
</form>
</body>
</html>
