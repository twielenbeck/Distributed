<%--
  Created by IntelliJ IDEA.
  User: censu
  Date: 10/26/2018
  Time: 1:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="tw.GatheringsManager" %>
<%@ page import="java.util.List" %>
<%@ page import="tw.ListIterator" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
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
    <title>Gatherings</title>
    <h1 id="toptitle" class="confirm_selection" align="center">GATES OF HEAVEN</h1>
</head>
<header>
    </div>
    <nav>
        <div id="navdiv">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="editgatherings.jsp">Login</a></li>
            </ul>
        </div>
    </nav>
    </div>
</header>
<body>
<div class="gatheringcontentdiv">
        <% List list = new GatheringsManager().getGatheringsList(); %>
    <c:set var="listIterator" value="<%= new ListIterator(list) %>"/>
    <h1>Current Events</h1>
    <div class="table-responsive">
        <table>
            <tr>
                <th>Gathering Name</th>
                <th>Date</th>
            </tr>
            <c:forEach var='item' items='${listIterator.list}'>
                <c:if test="${!item.completed}">
                    <tr>
                        <td><c:out value='${item.name}'/></td>
                        <td>
                            <fmt:parseDate pattern="MM/dd/yyyy" value="${item.date}" var="date"/>
                            <c:out value='${date}'/>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </div>
</body>
</html>
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
