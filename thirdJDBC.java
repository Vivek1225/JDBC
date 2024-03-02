import java.sql.*;
public class thirdJDBC {
    public static void main(String[] args)throws Exception {
        //Step-1 Loading driver
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //Step-2 Establishing Connection
        Connection c1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "System");
        //Step-3 Creating Statement
        Statement s1 = c1.createStatement();
        System.out.println("Connection Successful");
        String a = "select * from std_detail";
        ResultSet s = s1.executeQuery(a);//Result set cannot be printed driectly with println we have to iterate through itS
        while (s.next()) {
            System.out.println(s.getInt(1)+"\t"+s.getString(2)+"\t"+s.getInt(3));
        }
        s.close();
    }
}
