<%--
  Created by IntelliJ IDEA.
  User: censu
  Date: 10/26/2018
  Time: 1:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="favicon.ico">
    <link href="fonts/diablo.ttf" rel="stylesheet">
    <link rel="stylesheet" href="site.css">
    <video autoplay muted loop id="gatheringbackdrop">
        <source src="images/gatheringbackdrop.mp4" type="video/mp4">
        Your browser does not support HTML5 video.
    </video>
    <audio preload="auto" id="menuhoversound">
        <source src="sounds/flames.wav" type="audio/wav">
        Your browser isn't invited for super fun audio time.
    </audio>
    <audio preload="auto" id="menuclicksound">
        <source src="sounds/acme-siren.wav" type="audio/wav">
        Your browser isn't invited for super fun audio time.
    </audio>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>tw.Gatherings</title>
    <h1 id="toptitle" class="confirm_selection" align="center">GATES OF HEAVEN</h1>
</head>
<header>
    </div>
    <nav>
        <div id="navdiv">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="gatherings.jsp">Gatherings</a></li>
            </ul>
        </div>
    </nav>
    </div>
</header>
<body>
<div class="gatheringcontentdiv">
    <table id="gathertable" border="1" cellpadding="5" align="center">
        <thead>
        <tr>
            <th width="200px">
                GATHERING
            </th>
            <th width="300px">
                DESCRIPTION
            </th>
            <th width="100px">
                DATE
            </th>
            <th width="40px">
                JOIN?
            </th>
        </tr>
        </thead>
        <tr>
            <td class="firetext">Welcome new pledges<img src="images/cthulu.png"></td>
            <td class="firetext">Come one come all to welcome our newcomers! Come early to get the seats with all the sacrificial splatters. Don't forget your umbrella!</td>
            <td class="firetext">10/29/18</td>
            <td>
                <ul class="tg-list">
                    <li class="tg-list-item">
                        <input class="tgl tgl-flip" id="cb5" value="remove" type="checkbox"/>
                        <label class="tgl-btn" data-tg-off="Nope" data-tg-on="Yeah!" for="cb5"></label>
                    </li>
                </ul>
            </td>
        </tr>
    </table>
</div>
<div class="base">
    <div class="bar">
        <div class="bar one">
            <div class="bar two">
                <div class="bar three">
                    <div clas="bar four">
                        <div class="bar five"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<input type="submit" class="actionbtn2 fire" value="Pledge Attendance">
</body>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    var audio1 = document.getElementById("menuhoversound");
    audio1.loop = true;
    audio1.volume = 0.8;
    var audio2 = document.getElementById("menuclicksound");
    $('li a').mouseenter(function () {
        audio1.pause();
        audio1.play();
    });
    $('li a').mouseleave(function () {
        audio1.pause();
    });
    $('li a').click(function () {
        audio2.play();
    });
</script>
</html>
