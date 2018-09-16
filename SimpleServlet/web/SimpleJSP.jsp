<%@ page import="edu.wctc.simple.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <h1>Here's your student data</h1>
</head>
    <br>
    <br>
<body>
    <table border="1">
        <th>Account #</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>IP Address</th>
        <%
            Students theStudents = new Students();
            ArrayList<Individual> result = new ArrayList<Individual>();
            String selection = request.getParameter("search_selection");
            String searchQuery = request.getParameter("search_query");
            if (selection.equals("account_number")) {result = theStudents.findStudents(FindColumns.ACCTNUM, searchQuery);}
            else if (selection.equals("first_name")) {result = theStudents.findStudents(FindColumns.FNAME, searchQuery);}
            else if (selection.equals("last_name")) {result = theStudents.findStudents(FindColumns.LNAME, searchQuery);}
            else if (selection.equals("email_address")) {result = theStudents.findStudents(FindColumns.EMAIL, searchQuery);}
            else if (selection.equals("ip_address")) {result = theStudents.findStudents(FindColumns.IPADDR, searchQuery);}
            for (Individual i : result) {
                out.println("<tr><td>" + i.getAccountNumber()
                        + "</td><td>" + i.getFname() + "</td><td>" + i.getLname() + "</td><td>" + i.getEmail() + "</td><td>" + i.getIpAddress() + "</td></tr>");
            }
        %>
    </table>
</body>
</html>
