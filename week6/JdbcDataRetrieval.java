import java.sql.*;
import java.util.*;

class JdbcDataRetrieval {
  public static void main(String[] args) throws Exception {
    DBConnection.loadDriver();
    System.out.println("Driver Loaded...");
    Connection con = DBConnection.getConnection();
    System.out.println("Connection Established...");
    Statement st = con.createStatement();

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the Table Name: ");
    String tname = sc.nextLine();
    
    String query = "SELECT * FROM " + tname;
    ResultSet rs = st.executeQuery(query);
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnCount = rsmd.getColumnCount();

    System.out.println("");
    System.out.println("Table Data: ");

    for (int i = 1; i <= columnCount; i++) 
      System.out.print(rsmd.getColumnName(i) + "\t");
    System.out.println("");
    while(rs.next()) {
      for (int i = 1; i <= columnCount; i++) 
        System.out.print(rs.getString(i) + "\t");
      System.out.println("");
    }
    rs.close();
    st.close();
    con.close();
    sc.close();
  }
}
