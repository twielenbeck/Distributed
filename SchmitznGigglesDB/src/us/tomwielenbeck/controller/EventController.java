package us.tomwielenbeck.controller;

import us.tomwielenbeck.model.Event;
import us.tomwielenbeck.model.EventLibrary;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class EventController extends HttpServlet {
    private String RESULT_PAGE = "EventList.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    } // </editor-fold>

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Create a new instance of a model object
        // For some applications, we would not want to create a new one each time.
        EventLibrary shop = new EventLibrary();

        // Always a good idea to trim and/or validate input data
        List<Event> result = shop.getAllEvents();

        // Parameters are read only Request object properties, but attributes
        // are read/write. We can use attributes to store data for use on
        // another page.
        request.setAttribute("catalog", result);

        // This object lets you forward both the request and response
        // objects to a destination page
        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Main Controller";
    }// </editor-fold>

}

