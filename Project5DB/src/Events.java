import java.sql.*;
import java.util.List;

public class Events implements EventInterface {


    @Override
    public List<EventBean> getAllEvents() {
        return null;
    }

    public void addContent() {
        final String DB_URL = "jdbc:derby:Project5DB";
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO EVENTS " +
                    "VALUES (3, 'Katelyns Wasteland', 'A new drama by Patrick Schmitz: When Katelyns cancer goes into remission she must reconnect with the family she abandoned, or move on and accept that you can never go home. Based on true events and T.S. Eliots The Wasteland.', '06/19/2019', 'katewasteland', 11.00)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
            //Clean-up environment
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }


    public void outputDB() {
        final String DB_URL = "jdbc:derby:Project5DB";
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM EVENTS";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                String id  = rs.getString("ProductNumber");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                Date date = rs.getDate("Date");
                String image = rs.getString("Image");
                double price = rs.getDouble("Price");


                //Display values
                System.out.print("\nID: " + id.trim());
                System.out.print(", Name: " + name);
                System.out.print(", Description: " + description);
                System.out.print(", Date: " + date);
                System.out.print(", Image: " + image);
                System.out.print(", Price: " + price);

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }
}
