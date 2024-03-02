import java.sql.*;
import java.util.Scanner;
public class prepare_statement_ui {
    public static void main(String[] args)throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //Step-2 Establishing connection
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "System");
        PreparedStatement p = c.prepareStatement("insert into std_detail values(?,?,?)");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of records to insert: ");
        int count = sc.nextInt();
        int i=0;
        while (i<count) {
            System.out.print("Enter id of the student: ");
            int a = sc.nextInt();
            System.out.println("Enter the name of the student: ");
            String b = sc.next();
            System.out.println("Enter the age of the student: ");
            int d = sc.nextInt();
            p.setInt(1, a);
            p.setString(2, b);
            p.setInt(3, d);
            int v = p.executeUpdate();
            if (v>=0) {
                System.out.println("1 row inserted");
                i++;
            } else {
                System.out.println("error");
            }

        }
        sc.close();
    }
}
