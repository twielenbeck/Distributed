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
// prompts index.jsp to print the message in that file: out.println(request.getParameter("message"));

        Students theStudents = new Students();

        ArrayList<Individual> result;
        String selection = request.getParameter("search_selection");
        String accountNum = request.getParameter("account_number");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email_address");
        String ipAddress = request.getParameter("ip_address");

        //result = theStudents.findStudents(FindColumns.ACCTNUM, accountNum, FindColumns.FNAME, firstName, FindColumns.LNAME, lastName, FindColumns.EMAIL, email, FindColumns.IPADDR, ipAddress);
        result = theStudents.findStudents(FindColumns.ACCTNUM, accountNum);
        for (Individual i : result) {
            out.println("<tr><td>" + i.getAccountNumber() + "</td><td>" + i.getFname() + "</td><td>" + i.getLname() + "</td><td>" + i.getEmail() + "</td><td>" + i.getIpAddress() + "</td></tr>");
        }
/*
        result = theStudents.findStudents(FindColumns.FNAME, firstName);
        for (Individual i: result) {
            out.println("<tr><td>" + i.getAccountNumber() + "</td><td>" + i.getFname() + "</td><td>" + i.getLname() + "</td><td>" + i.getEmail() + "</td><td>" + i.getIpAddress() + "</td></tr>");
        }

        result = theStudents.findStudents(FindColumns.LNAME, lastName);
        for (Individual i: result) {
            out.println("<tr><td>" + i.getAccountNumber() + "</td><td>" + i.getFname() + "</td><td>" + i.getLname() + "</td><td>" + i.getEmail() + "</td><td>" + i.getIpAddress() + "</td></tr>");
        }

        result = theStudents.findStudents(FindColumns.EMAIL, email);
        for (Individual i: result) {
            out.println("<tr><td>" + i.getAccountNumber() + "</td><td>" + i.getFname() + "</td><td>" + i.getLname() + "</td><td>" + i.getEmail() + "</td><td>" + i.getIpAddress() + "</td></tr>");
        }

        result = theStudents.findStudents(FindColumns.IPADDR, ipAddress);
        for (Individual i: result) {
            out.println("<tr><td>" + i.getAccountNumber() + "</td><td>" + i.getFname() + "</td><td>" + i.getLname() + "</td><td>" + i.getEmail() + "</td><td>" + i.getIpAddress() + "</td></tr>");
        }
*/
    }
}