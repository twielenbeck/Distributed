package tw;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GatheringsServlet extends HttpServlet
{
    private String RESULT_PAGE = "editgatherings.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    } // </editor-fold>

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //get params
        String gatheringsName = request.getParameter("gatheringsName");
        String gatheringsDate = request.getParameter("gatheringsDate");
        String remove = request.getParameter("remove");
        String newName = request.getParameter("newName");
        String newDate = request.getParameter("newDate");

        //Event Lists
        GatheringsManager gatherings = new GatheringsManager();
        List<Gatherings> result = gatherings.getGatheringsList();

        //remove event if remove was checked
        if(remove.equals("checked"))
        {
            result.remove(gatherings.getGatheringsByName(gatheringsName));
        }

        // Parameters are read only Request object properties, but attributes
        // are read/write. We can use attributes to store data for use on
        // another page.
        request.setAttribute("gatherings", result);

        // This object lets you forward both the request and response
        // objects to a destination page
        RequestDispatcher view = request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }
}