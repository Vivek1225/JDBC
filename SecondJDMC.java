import java.sql.*;
import java.util.Scanner;
public class SecondJDMC {
    public static void main(String[] args) {
        try {
            //Step-1: Loading the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");//here the last oracledriver is the class name everything else is package and subpackages
            //This forName method is static method and is part of java.lang package which is the default package;
            //Here we are passing the class path so sometimes it might raise classnotfoundexception which is a checked exception;

            //Creating a connection object which is of connection interface type;
            System.out.println("Drivers are loaded.");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "System");
            //url format =  api:vendor:type of driver:host machine addressi.e machine in which database is installed name or ip address:
            //portnumber i.e applications unique id:service name i.e default database name
            //parameters are connection url , user name , password
            //If connection is not established c contains null value
            if(c!=null){
                System.out.println("Connection established");
            }
            c.createStatement();
            Statement s = c.createStatement();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the id: ");
            int a = sc.nextInt();
            System.out.print("Enter name: ");
            String n = sc.next();
            System.out.print("Enter age: ");
            int b = sc.nextInt();
            String q = "insert into std_detail values("+a+","+n+","+b+")";
            s.executeUpdate(q);
            System.out.println("Values inserted to a table...");
            //Closing connection
            c.close();
            sc.close();
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}