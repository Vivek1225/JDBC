import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
public class FirstJDBC{
    public static void main(String[] args) {
        //Step-1 loading driver class
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Registering Driver is completed");
            //Step-2 establishing the connection with database;
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "System");
            if (conn!=null){
                System.out.println("Connection established....");
            }
            //Step-3 creating statement object
            Statement s = conn.createStatement();
            //Step-4 Query processing
            String q = "create table std_detail(std_id number(5), std_name char(10), std_age number(2))";
            s.executeUpdate(q);
            System.out.println("Table Created ........");
            //Closing connection
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
   }
}

