package us.tomwielenbeck.model;

import java.sql.*;

public class DBStructure
{
    public DBStructure()
    {
        try
        {
            final String DB_URL = "jdbc:derby:SchmitzDB";
            Connection conn = DriverManager.getConnection(DB_URL);
            
            // Build EVENTS Table if EVENTS does not already exist
            ResultSet eventRs = conn.getMetaData().getTables(null, "APP", "EVENTS", null);
            if (!eventRs.next())
            {
                buildEventsTable(conn);
            }
            
            // Build CART Table if CART does not already exist
            ResultSet cartRs = conn.getMetaData().getTables(null, "APP", "CART", null);
            if (!cartRs.next())
            {
                buildCartTable(conn);
            }
            
            // INSERT ROWS into the EVENTS table.
            insertEventsTable(conn);
            
            // Close the connections
            eventRs.close();
            cartRs.close();
            conn.close();
        } catch (Exception e)
        {
            e.getMessage();
        }
    }
    
    public static void buildEventsTable(Connection conn) throws SQLException
    {
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE EVENTS (" +
                "ProductNumber INT NOT NULL PRIMARY KEY, " +
                "Name VARCHAR(50), " +
                "Description VARCHAR (8000), " +
                "Price DOUBLE, " +
                "Genre VARCHAR(20), " +
                "Location VARCHAR(30), " +
                "Date VARCHAR(30), " +
                "Image VARCHAR (25) " +
                ")");
    }
    
    public static void buildCartTable(Connection conn) throws SQLException
    {
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE CART (" +
                "CustomerNumber INT NOT NULL PRIMARY KEY, " +
                "ProductNumber INT NOT NULL, " +
                "Name VARCHAR(50)," +
                "Date DATE," +
                "Price double ," +
                "Image VARCHAR(25) " +
                ")");
    }
    
    public static void insertEventsTable(Connection conn) throws SQLException
    {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO EVENTS VALUES" +
                "(1, " +
                "'Sketch 22', " +
                "'The night before the show, 10 groups of writers get randomly assigned topics for 10 comedy sketches. The next morning, the writers present the scripts and ten directors randomly select which sketch and which actors they’ll direct. Just 22 hours after the writers get their topics, the sketches are performed live in a one-time show!', " +
                "10.00, " +
                "'Comedy', " +
                "'Comedy Sportz', " +
                "'01/19/2019 07:30 PM', " +
                "'sketch22')");
        
        stmt.executeUpdate("INSERT INTO EVENTS VALUES" +
                "(2, " +
                "'Comedy of Othello', " +
                "'Written and directed by Patrick Schmitz starring the Shakesparody players the Comedy of Othello, Kinda sorta is bound to betray your sense of humor.', " +
                "12.00, " +
                "'Comedy', " +
                "'Next Act Theatre', " +
                "'08/11/2019 07:30 PM', " +
                "'othello')");
        
        stmt.executeUpdate("INSERT INTO EVENTS VALUES" +
                "(3, " +
                "'Katelyns Wasteland', " +
                "'A new drama by Patrick Schmitz: When Katelyns cancer goes into remission she must reconnect with the family she abandoned, or move on and accept that you can never go home. Based on true events and T.S. Eliots The Wasteland.', " +
                "11.00, " +
                "'Drama', " +
                "'The Alchemist', " +
                "'06/19/2019 07:30 PM', " +
                "'katewasteland')");
        
        stmt.executeUpdate("INSERT INTO EVENTS VALUES" +
                "(4, " +
                "'Comedy of Macbeth', " +
                "'Macbeth is a cool play.', " +
                "15.00, " +
                "'Comedy', " +
                "'Next Act Theatre', " +
                "'08/09/19 07:30 PM', " +
                "'macbeth')");
        
        stmt.executeUpdate("INSERT INTO EVENTS VALUES" +
                "(5, " +
                "'Merlin', " +
                "'A sketch parody based on the Merlin folklore.', " +
                "8.00, " +
                "'Comedy', " +
                "'Underground Collaborative', " +
                "'04/19/19 07:30 PM', " +
                "'merlin')");
        
        stmt.executeUpdate("INSERT INTO EVENTS VALUES" +
                "(6, " +
                "'Who Dunnit Halloween Show', " +
                "'Join Patrick Schmitz and some of Milwaukees best improvisers (Robby McGhee, Tim Higgins, Laura Holterman, Max Bord, Liv Shircel, Josh Decker, and more) Each improviser secretly picks a number card which will determine the order the characters will die and one will have also selected a killer card so not even the performers will know who the killer is until the end.', " +
                "10.00, " +
                "'Improv', " +
                "'Comedy Sportz', " +
                "'10/26/18 07:00 PM', " +
                "'whodunnit')");
    }
}
