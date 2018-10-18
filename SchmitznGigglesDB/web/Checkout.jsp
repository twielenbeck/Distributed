<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.tomwielenbeck.model.Event" %><%--
  Created by IntelliJ IDEA.
  User: censu
  Date: 9/24/2018
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
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
<h2>Confirm Checkout</h2>
<form action="checkout.go">
    <table>
        <%
            List recs = (List) request.getAttribute("catalog");
            Iterator it = recs.iterator();
            double total = 0;
            while (it.hasNext()) {
                Event item = (Event) it.next();
                out.print("<tr class='purch'><td> " + item.getName() + " </td><td>" +
                        String.format("$%3.2f",item.getPrice()) + "</td></tr>");
                total+=item.getPrice();
            }
            out.print("<tr class='total' ><td>Total:</td><td>" +
                    String.format("$%3.2f",total) + "</td></tr>");
        %>
    </table>
    <input type="submit" value="Complete Order">
</form>

</body>
</html>
