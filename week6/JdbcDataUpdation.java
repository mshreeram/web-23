import java.sql.*;
import java.util.*;

class JdbcDataUpdation {
  public static void main(String[] args) throws Exception {
    DBConnection.loadDriver();
    System.out.println("Driver Loaded...");
    Connection con = DBConnection.getConnection();
    System.out.println("Connection Established...");
    
    Scanner sc = new Scanner(System.in);
    System.out.print("Number of records to be updated: ");
    int noOfRecords = sc.nextInt();

    Statement st = con.createStatement();

    for (int i = 0; i < noOfRecords; i++) {
      System.out.print("Roll Number " + (i + 1) + ": ");
      int rno = sc.nextInt();
      System.out.print("Name " + (i + 1) + ": ");
      String name = sc.next();
      System.out.print("Email " + (i + 1) + ": ");
      String email = sc.next();

      String query = "UPDATE students_23 SET name='" + name + "',email='" + email + "' WHERE rollno=" + rno;
      st.executeUpdate(query);

      System.out.println("Successfully updated the record of: " + rno);
      System.out.println("");
    }

    sc.close();
    st.close();
    con.close();
  }  
}
