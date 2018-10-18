package us.tomwielenbeck.model;

import java.sql.*;

public class DBStructure {
    public DBStructure()
    {

        try
        {
// Create a named constant for the URL.
// NOTE: This value is specific
// for Java DB.
            final String DB_URL = "jdbc:derby:SchmitzDB";

            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);

            // If the DB already exists, drop the tables.
            dropTables(conn);

            // Build the Events table.
            buildEventsTable(conn);

            // Build the Customer table.
            buildCartTable(conn);

            // Close the connection.
            conn.close();
        } catch (Exception e)
        {
            System.out.println("Error " + e.getMessage());
        }

    }

    /**
     * The dropTables method drops any existing
     * in case the database already exists.
     */
    public static void dropTables(Connection conn)
    {
        System.out.println("Checking for existing tables...");

        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            try
            {
                // Drop the Customer table.
                stmt.execute("DROP TABLE CART");
                System.out.println("CART table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }

            try
            {
                // Drop the Events table.
                stmt.execute("DROP TABLE EVENTS");
                System.out.println("EVENTS table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * The buildEventsTable method creates the
     * Events table and adds some rows to it.
     */
    public void buildEventsTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
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
            System.out.println("EVENTS table created.");
        } catch (SQLException ex)
        {
            System.out.println("Events Table Creation ERROR: " + ex.getMessage());
        }
        try {
            Statement stmt = conn.createStatement();
            // Insert row #1.
            stmt.executeUpdate("INSERT INTO EVENTS VALUES" +
                    "(1, " +
                    "'Sketch 22', " +
                    "'The night before the show, 10 groups of writers get randomly assigned topics for 10 comedy sketches. The next morning, the writers present the scripts and ten directors randomly select which sketch and which actors they’ll direct. Just 22 hours after the writers get their topics, the sketches are performed live in a one-time show!', " +
                    "10.00, " +
                    "'Comedy', " +
                    "'Comedy Sportz', " +
                    "'01/19/2019 07:30 PM', " +
                    "'sketch22')");

            // Insert row #2.
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
            System.out.println("Events Table rows inserted.");
        }  catch (SQLException ex)
        {
            System.out.println("Events Table INSERT ERROR: " + ex.getMessage());
        }
    }

    /**
     * The buildCartTable method creates the
     * CART table and adds some rows to it.
     */
    public static void buildCartTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE CART" +
                    "( CustomerNumber INT NOT NULL PRIMARY KEY, " +
                    "  ProductNumber INT NOT NULL, " +
                    "  Name VARCHAR(50)," +
                    "  Date DATE," +
                    "  Price double ," +
                    "  Image VARCHAR(25) )");



            System.out.println("CART table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
        /*try {
            Statement stmt = conn.createStatement();
            // Add some rows to the new table.
            stmt.executeUpdate("INSERT INTO CART VALUES" +
                    "(101, 1, 'Sketch 22', '01/19/2019'," +
                    " 10.00, 'sketch22')");

            System.out.println("CART Table rows inserted.");
        } catch (SQLException ex)
        {
            System.out.println("CART INSERT ERROR: " + ex.getMessage());
        }*/
    }

}
