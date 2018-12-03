<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.10.2018
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Velodrome</title>
    <link rel="shortcut icon" href="resources/img/chain.png" type="image/png">
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>

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
<main class="main">
    <ul class="news_ul">
        <li class="news1_li">
            <div class="news1">
                <img src="resources/img/night_race.jpg" alt="" class="news1_img">
                <div class="news_description">
                    <p class="news_text">What will happen in April of 2018? This month in Russia will be rich in only one race under the auspices of the FVSR, this is the championship of Russia and All-Russian competitions that will be held on 24-27 in Moscow.</p>
                </div>
            </div>
        </li>
        <li class="news2_li">
            <div class="news2">
                <img src="resources/img/skvoz_minsk.jpg" alt="" class="news1_img">
                <div class="news_description">
                    <p class="news_text">What will happen in April of 2018? This month in Russia will be rich in only one race under the auspices of the FVSR, this is the championship of Russia and All-Russian competitions that will be held on 24-27 in Moscow.</p>
                </div>
            </div>
        </li>
        <li class="news3_li">
            <div class="news3">
                <img src="resources/img/luzhniki.jpg" alt="" class="news1_img">
                <div class="news_description">
                    <p class="news_text">What will happen in April of 2018? This month in Russia will be rich in only one race under the auspices of the FVSR, this is the championship of Russia and All-Russian competitions that will be held on 24-27 in Moscow.</p>
                </div>
            </div>
        </li>
        <li class="news4_li">
            <div class="news4">
                <img src="resources/img/open_season.jpg" alt="" class="news1_img">
                <div class="news_decription">
                    <p class="news_text">What will happen in April of 2018? This month in Russia will be rich in only one race under the auspices of the FVSR, this is the championship of Russia and All-Russian competitions that will be held on 24-27 in Moscow.</p>
                </div>
            </div>
        </li>
    </ul>
</main>
</body>
</html>
