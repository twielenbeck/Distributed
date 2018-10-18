
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.*;

public class CreateProject5DB
{
    public CreateProject5DB() throws SQLException {

        try
        {
            // Create a named constant for the URL.
            // NOTE: This value is specific
            // for Java DB.
            final String DB_URL = "jdbc:derby:Project5DB";

            // Create a connection to the database.
            Connection conn = DriverManager.getConnection(DB_URL);

            // setup query string to get id's from events
            String sqlEvents = "SELECT PRODUCTNUMBER FROM EVENTS";
            // setup query string to get id's from cart
            String sqlCart = "SELECT CustomerNumber FROM CART";

            // query EVENTS with param from sqlEvents and print values of PRODUCTNUMBER
            PreparedStatement checkIdExists = conn.prepareStatement(sqlEvents);
            try (ResultSet rs = checkIdExists.executeQuery()) {
                while (rs.next()) {
                    System.out.println("ProductNumber ID: " + rs.getString(1));
                }
            }


            // print out table names in schema APP for fun
            ResultSet res = conn.getMetaData().getTables(null, "APP", "%", null);//Default schema name is "APP"
            while(res.next())
            {
                System.out.println(res.getString(3) + " exists");//Show table name
            }
            // If the DB already exists, drop the tables.
            //dropTables(conn);

            ResultSet eventRs = conn.getMetaData().getTables(null, "APP", "EVENTS", null);
            if(eventRs.next())
            {
                System.out.println("Event table exists. Skipping build.");
            } else
            {
                // Build the Events table.
                buildEventsTable(conn);
            }

            //insert data into the Events table.
            insertEventsTable(conn);
            ResultSet cartRs = conn.getMetaData().getTables(null, "APP", "CART", null);
            if(cartRs.next())
            {
                System.out.println("Cart table exists. Skipping build.");
            } else
            {
                // Build the Cart table.
                buildCartTable(conn);
            }


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
    public void buildEventsTable(Connection conn) throws SQLException {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE EVENTS (" +
                    "ProductNumber INT NOT NULL PRIMARY KEY, " +
                    "Name VARCHAR(50), " +
                    "Description VARCHAR (8000), " +
                    "Date DATE, " +
                    "Image VARCHAR (25), " +
                    "Price DOUBLE " +
                    ")");
            System.out.println("EVENTS table created.");
        } catch (SQLException ex)
        {
            System.out.println("Events Table Creation ERROR: " + ex.getMessage());
        }
    }
    private void insertEventsTable(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            // Insert row #1.
            stmt.executeUpdate("INSERT INTO EVENTS VALUES" +
                    "(1, " +
                    "'Sketch 22', " +
                    "'The night before the show, 10 groups of writers get randomly assigned topics for 10 comedy sketches. The next morning, the writers present the scripts and ten directors randomly select which sketch and which actors they’ll direct. Just 22 hours after the writers get their topics, the sketches are performed live in a one-time show!', " +
                    "'01/19/2019', " +
                    "'sketch22', " +
                    "10.00)");

            // Insert row #2.
            stmt.executeUpdate("INSERT INTO EVENTS VALUES" +
                    "(2, " +
                    "'Comedy of Othello', " +
                    "'Written and directed by Patrick Schmitz starring the Shakesparody players the Comedy of Othello, Kinda sorta is bound to betray your sense of humor.', " +
                    "'08/11/2019', " +
                    "'othello', " +
                    "12.00)");
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
        try {
            Statement stmt = conn.createStatement();
            // Add some rows to the new table.
            stmt.executeUpdate("INSERT INTO CART VALUES" +
                    "(101, 1, 'Sketch 22', '01/19/2019'," +
                    " 10.00, 'sketch22')");

            System.out.println("CART Table rows inserted.");
        } catch (SQLException ex)
        {
            System.out.println("CART INSERT ERROR: " + ex.getMessage());
        }
    }

}