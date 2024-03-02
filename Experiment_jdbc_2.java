import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Experiment_jdbc_2 {
    public static void main(String[] args) throws  Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Scanner sc = new Scanner(System.in);
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "System");
        Statement s1 = c.createStatement();
        String s = "select * from std_detail";
        ResultSet r1 = s1.executeQuery(s);
        ResultSetMetaData rs1 = r1.getMetaData();
        System.out.println("\nName\t\tData Type\t Size\t");
        System.out.println("------------------------------------------");
        System.out.println(rs1.getColumnLabel(1)+"\t\t"+rs1.getColumnTypeName(1)+"\t\t"+rs1.getPrecision(1));
        System.out.println(rs1.getColumnLabel(2)+"\t"+rs1.getColumnTypeName(2)+"\t\t"+rs1.getPrecision(2));
        System.out.println(rs1.getColumnLabel(3)+"\t\t"+rs1.getColumnTypeName(3)+"\t\t"+rs1.getPrecision(3));
        System.out.println("\nTotal number of columns: "+rs1.getColumnCount());
        sc.close();
    }
}
