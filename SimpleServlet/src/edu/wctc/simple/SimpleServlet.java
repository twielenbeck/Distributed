package edu.wctc.simple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "SimpleServlet")
public class SimpleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<html>" +
                "<head></head>" +
                "<body>" +
                "<h1>Query Results</h1>" +
                "<br>" +
                "<br>" +
                "<table border='1'>" +
                "<tr>" +
                "<th>Account #</th>" +
                "<th>First Name</th>" +
                "<th>Last Name</th>" +
                "<th>Email</th>" +
                "<th>IP Address</th>" +
                "</tr>");

        Students theStudents = new Students();
        ArrayList<Individual> result = new ArrayList<Individual>();
        String selection = request.getParameter("search_selection");
        String searchQuery = request.getParameter("search_query");
        switch(selection)
        {
            case "account_number": result = theStudents.findStudents(FindColumns.ACCTNUM, searchQuery);break;
            case "first_name": result = theStudents.findStudents(FindColumns.FNAME, searchQuery);break;
            case "last_name": result = theStudents.findStudents(FindColumns.LNAME, searchQuery);break;
            case "email_address": result = theStudents.findStudents(FindColumns.EMAIL, searchQuery);break;
            case "ip_address": result = theStudents.findStudents(FindColumns.IPADDR, searchQuery);break;
        }
        for (Individual i : result)
        {
            out.println("<tr><td>" + i.getAccountNumber() + "</td><td>" + i.getFname() + "</td><td>" + i.getLname() + "</td><td>" + i.getEmail() + "</td><td>" + i.getIpAddress() + "</td></tr>");
        }

    }
}