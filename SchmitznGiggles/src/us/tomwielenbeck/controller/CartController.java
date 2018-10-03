package us.tomwielenbeck.controller;

import us.tomwielenbeck.model.Event;
import us.tomwielenbeck.model.EventGenre;
import us.tomwielenbeck.model.EventLibrary;
import us.tomwielenbeck.model.EventLocation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet")
public class CartController extends HttpServlet {
    private String RESULT_PAGE = "Cart.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        // Get an array of Cookies associated with the this domain
        cookies = request.getCookies();
        PrintWriter out = response.getWriter();
        List<Event> items = new ArrayList();
        items.add(new Event(0," "," ",0.0," ", EventGenre.COMEDY, EventLocation.COMEDYSPORTZ, " "));
        if( cookies != null ) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                out.print(cookie.getValue());
                if (cookie.getName().equals("cartItem")) {
                    items = orderedItems( cookie.getValue( ));
                }
            }
        }
        request.setAttribute("catalog", items);

        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }

    protected List<Event> orderedItems(String itemsNumbers) {
        List<Event> items = new ArrayList<>();
        EventLibrary cat = new EventLibrary();
        String[] nums = itemsNumbers.split(",");
        for (int i=0;i<nums.length;i++) {
            items.add(cat.getSingleEvent(Integer.parseInt(nums[i])));
        }
        return items;
    }
}