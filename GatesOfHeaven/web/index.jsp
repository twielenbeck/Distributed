<%--
  Created by IntelliJ IDEA.
  User: censure
  Date: 10/24/2018
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="favicon.ico">
    <video autoplay muted loop id="backdrop">
        <source src="images/logobackdrop.mp4" type="video/mp4">
        Your browser does not support HTML5 video.
    </video>
    <audio preload="auto" id="menuhoversound">
    <source src="sounds/flames.wav" type="audio/wav">
    Your browser isn't invited for super fun audio time.
</audio>
    <audio preload="auto" id="menuclicksound">
        <source src="sounds/manyscreams.wav" type="audio/wav">
        Your browser isn't invited for super fun audio time.
    </audio>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gates Of Heaven</title>
    <link href="fonts/diablo.ttf" rel="stylesheet">
    <link rel="stylesheet" href="site.css">

    <h1 id="toptitle" class="confirm_selection" align="center">GATES OF HEAVEN</h1>
</head>
<header>
    </div>
    <nav>
        <div id="navdiv">
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="gatherings.jsp">Gatherings</a></li>
                <li><a href="editgatherings.jsp">Login</a></li>
            </ul>
        </div>
    </nav>
    </div>
</header>
<body>
    <c:set var="string1" value="Founded by Jebediah Bodaious in 1337 A.D. during the great possession, The Gates Of Heaven have since been preparing mankind for the ultimate glory.
     The G.O.H. is a community organization built by generations of friendships that has spread the truth for centuries to open the eyes of the blind - All three of them."/>
    <c:set var="string2" value="${fn:split(string1, ' ')}"/>
    <c:set var="string3" value="${fn:join(string2, ' ')}"/>
    <c:set var="string4" value="Worry not for the time of revolution and reckoning is upon this world.
    Come with us to celebrate the dark Lord in all of his glory. Bring your kids!
    Prove your loyalty and you shall inherit the remnants of Earth. Free tacos every Tuesday!"/>
<div class="contentdiv firetext">
        <c:out value="${string3.toUpperCase()}"/>
    <br><br>
    <c:out value="${string4.toUpperCase()}"/>
</div>
</body>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    var audio1 = document.getElementById("menuhoversound");
    audio1.loop = true;
    audio1.volume = 0.8;
    var audio2 = document.getElementById("menuclicksound");
    $('li a').mouseenter(function() {
        audio1.pause();
        audio1.play();
    });
    $('li a').mouseleave(function() {
        audio1.pause();
    });
    $('li a').click(function() {
       audio2.play();
    });
</script>
</html>
