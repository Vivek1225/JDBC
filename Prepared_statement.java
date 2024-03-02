import java.sql.*;
public class Prepared_statement {
    public static void main(String[] args) throws Exception {
        //Step-1 Loading drivers
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //Step-2 Establishing connection
        Connection c2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "System");
        //Step-3 Creating prepared statement object available in sql package
        PreparedStatement p1 = c2.prepareStatement("insert into std_detail values(?,?,?)");
        p1.setInt(1, 1229);
        p1.setString(2, "Vivek");
        p1.setInt(3, 19);
        int c = p1.executeUpdate();
        if (c>=0)
            System.out.println("Values is inserted into the table.");
        Statement s = c2.createStatement();
        String a = "select * from std_detail";
        ResultSet s1 = s.executeQuery(a);//Result set cannot be printed driectly with println we have to iterate through itS
        while (s1.next()) {
            System.out.println(s1.getInt(1)+"\t"+s1.getString(2)+"\t"+s1.getInt(3));
        }
        s.close();
        p1.close();
    }
}
