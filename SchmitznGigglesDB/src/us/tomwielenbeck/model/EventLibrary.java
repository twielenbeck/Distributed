package us.tomwielenbeck.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EventLibrary implements EventInterface
{
    DBStructure db = new DBStructure();
    
    @Override
    public List<Event> getAllEvents()
    {
        List<Event> eventList = new ArrayList<>();
        final String DB_URL = "jdbc:derby:SchmitzDB";
        Statement stmt = null;
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM EVENTS";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                //Retrieve by column name
                int id = rs.getInt("ProductNumber");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");
                String date = rs.getString("Date");
                String genre = rs.getString("Genre");
                String location = rs.getString("Location");
                String image = rs.getString("Image");
                eventList.add(new Event(id, name, description, price, date, genre, location, image));
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2)
            {
            }// nothing we can do
            try
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }//end try
        return eventList;
    }
    
    @Override
    public Event getEventByName(String name)
    {
        Event theEvent = null;
        for (Event e : getAllEvents())
        {
            if (e.getName().equals(name))
            {
                theEvent = e;
            }
        }
        return theEvent;
    }
    
    @Override
    public List<Event> searchEvents(String search)
    {
        search = search.toLowerCase();
        List<Event> searchList = new ArrayList<>();
        for (Event name : getAllEvents())
        {
            if (name.getName().toLowerCase().contains(search))
            {
                searchList.add(name);
            }
        }
        return searchList;
    }
    
    @Override
    public Event getSingleEvent(int itemNum)
    {
        Event item = null;
        for (Event i : getAllEvents())
        {
            if (i.getProductNumber() == itemNum)
            {
                return i;
            }
        }
        return item;
    }
    
    @Override
    public void addContent()
    {
        final String DB_URL = "jdbc:derby:SchmitzDB";
        Statement stmt = null;
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            //String sql = "INSERT INTO EVENTS " +
            //        "VALUES (3, 'Katelyns Wasteland', 'A new drama by Patrick Schmitz: When Katelyns cancer goes into remission she must reconnect with the family she abandoned, or move on and accept that you can never go home. Based on true events and T.S. Eliots The Wasteland.', '06/19/2019', 'katewasteland', 11.00)";
            //stmt.executeUpdate(sql);
            //Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2)
            {
            }// nothing we can do
            try
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }//end try
    }
    
    @Override
    public void deleteContent()
    {
    }
    
    @Override
    public void updateContent()
    {
    }
}
