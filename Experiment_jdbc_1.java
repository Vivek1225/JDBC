import java.sql.*;
import java.util.Scanner;
public class Experiment_jdbc_1 {
    public static void main(String[] args)throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Scanner sc = new Scanner(System.in);
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "System");
        Statement s1 = c.createStatement();
        while(true){
            System.out.print("Choose an option:\n1.Insert a row\n2.Delete a row\n3.Modify a row\n4.Retrieve rows\n5.Truncate\n6.Exit\n");
            System.out.println("Enter option: ");
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    PreparedStatement p = c.prepareStatement("insert into std_detail values(?,?,?)");
                    System.out.println("Enter number of records to insert: ");
                    int count = sc.nextInt();
                    int i=0;
                    while (i<count) {
                        System.out.print("Enter id of the student: ");
                        int a = sc.nextInt();
                        System.out.print("Enter the name of the student: ");
                        String b = sc.next();
                        System.out.print("Enter the age of the student: ");
                        int d = sc.nextInt();
                        p.setInt(1, a);
                        p.setString(2, b);
                        p.setInt(3, d);
                        int v = p.executeUpdate();
                        if (v>=0) {
                            System.out.println("\n1 row inserted\n");
                            i++;
                        } else {
                            System.out.println("error");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter id of the row that you want to delete: ");
                    int d1 = sc.nextInt();
                    String d = "select count(std_id) from std_detail";
                    ResultSet rs1 = s1.executeQuery(d);
                    rs1.next();
                    int count1 = rs1.getInt(1);
                    String s = "delete from std_detail where std_id="+d1;
                    s1.executeUpdate(s);
                    ResultSet rs2 = s1.executeQuery(d);
                    rs2.next();
                    int count2 = rs2.getInt(1);
                    if (count1-count2 > 0)
                        System.out.println("\n"+(count1-count2)+" Row deleted\n");
                    else
                        System.out.println("\nNo rows deleted\n");
                    break;
                case 3:
                    //Statement s2 = c.createStatement();
                    System.out.println("Enter the id of the row which you want to update: ");
                    int id = sc.nextInt();
                    System.out.println("Enter the column name which you want to update: ");
                    String a1 = sc.next();
                    System.out.println("Enter the new value: ");
                    String v1 = sc.next();
                    if (a1.equals("std_name")){
                        try{
                            String q2 = "update std_detail SET "+a1+" = "+"'"+v1+"'"+" where std_id="+id; 
                            System.out.println(q2);
                            s1.executeUpdate(q2);
                            break;
                        }catch(Exception  e){
                            System.err.println(e);
                        }
                    }else{
                        String q1 = "update std_detail SET "+a1+" = "+v1+" where std_id="+id; 
                        System.out.println(q1);
                        try {
                            s1.executeUpdate(q1);
                            System.out.println("\nUpdate successful\n");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                    break;
                case 4:
                    //Statement s3 = c.createStatement();
                    String s5 = "select * from std_detail";
                    ResultSet r1 = s1.executeQuery(s5);//Result set cannot be printed driectly with println we have to iterate through itS
                    if (r1.next()==false){
                        System.out.println("\nNo rows Selected\n");
                        break;
                    }
                    do{
                        System.out.println("Id: "+r1.getInt(1)+"\t"+"Name: "+r1.getString(2)+"\t"+"Age: "+r1.getInt(3));
                    }while (r1.next());
                    break;
                case 5:
                    //Statement s4 = c.createStatement();
                    String s6 = "truncate table std_detail";
                    s1.executeQuery(s6);
                    System.out.println("\nTable truncated.\n");
                    break;
                case 6:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Enter a valid option . . . .");
                    break;
            }
        }
    }
}
