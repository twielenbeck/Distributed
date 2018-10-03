<%--
  Created by IntelliJ IDEA.
  User: censu
  Date: 9/18/2018
  Time: 2:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List"%>
<%@page import="us.tomwielenbeck.model.*"%>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.text.ParseException" %>
<!DOCTYPE html>
<html>
<head>
    <title>Event Lineup</title>
    <link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet">
    <link rel="stylesheet" href="site.css">
</head>
<header>
    <div id="backdrop">
        <div id="toptitlediv">
            <h1 id="toptitle">Schmitz 'n Giggles</h1>
        </div>
        <nav>
            <div id="navdiv">
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="events.go">Event Lineup</a></li>
                    <li><a href="cart.go">Shopping Cart</a></li>
                </ul>
            </div>
        </nav>
    </div>
</header>
<body>

    <h2 align="center">Event Lineup</h2>
    <table class="eventlist" border="1" cellpadding="5" align="center">
        <thead align="center">
        <th width="200px">Event Name</th>
        <th>Event Details</th>
        <th width="100px">Date</th>
        <th width="100px">Price</th>
        <th width="150px">Cart</th>
        </thead>
        <form action="cartplace.go">
                <%
                    List recs = (List) request.getAttribute("catalog");
                    Iterator it = recs.iterator();
                    while (it.hasNext()) {
                        // Notice we're outputting some HTML. Is that a good idea?
                        // Also, notice we do not cast the object returned by the
                        // iterator to a String. Why?
                        Event item = (Event) it.next();
                        try {
                        out.print(
                                "<tr align='center'>" +
                                "<td align='center'>" + item.getName() + "</td>" +
                                "<td align='center'><img src='" + item.getImage() + "' ></td>" +
                                "<td align='center'>" + item.getDate() + "</td>" +
                                "<td align='center'>$" + item.getPrice() + "0</td>" +
                                "<td align='center'>Add to Cart<br><input type='checkbox' name='cartItem' value=" + item.getProductNumber() + "></td>" +
                                "</tr>"
                                );
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                %>
            </table>
            <input type="submit" value="Purchase" class="actionbtn2">
        </form>
</body>
</html>
