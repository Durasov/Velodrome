<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 30.11.2018
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Add Team</title>
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
    <form:form action="saveTeam" method="post" class="form">
        <h2>Add Team</h2>
        <p class="add_description">Team name </p>
        <input name="team_name" type="text" required placeholder="Team Name" class="textbox"> </br>
        <%-- <form:input path="team_name" type="text" class="textbox"/> </br> --%>
         <p class="add_description">Team country</p>
         <input name="team_country" type="text" required placeholder="Team Country" class="textbox"> </br>
        <%--<form:input path="team_country" type="text" class="textbox"/> </br> --%>
         <input type="submit" value="Add team" class="button"/>
         <a href="/teams" class="cancel">Cancel</a>
     </form:form>
 </div>

 </body>
 </html>
