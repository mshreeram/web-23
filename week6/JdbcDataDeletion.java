import java.sql.*;
import java.util.*;

class JdbcDataDeletion {
  public static void main(String[] args) throws Exception {
    DBConnection.loadDriver();
    System.out.println("Driver Loaded...");
    Connection con = DBConnection.getConnection();
    System.out.println("Connection Established...");
    
    Scanner sc = new Scanner(System.in);
    System.out.print("Number of records to be deleted: ");
    int noOfRecords = sc.nextInt();

    Statement st = con.createStatement();

    for (int i = 0; i < noOfRecords; i++) {
      System.out.print("Roll Number " + (i + 1) + ": ");
      int rno = sc.nextInt();

      String query = "DELETE FROM students_23 WHERE rollno=" + rno;
      st.executeUpdate(query);

      System.out.println("Successfully deleted the record of: " + rno);
      System.out.println("");
    }

    sc.close();
    st.close();
    con.close();
  }  
}
