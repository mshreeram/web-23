import java.sql.*;

class JdbcTableCreation {
  public static void main(String[] args) throws Exception {
    DBConnection.loadDriver();
    System.out.println("Driver Loaded...");
    Connection con = DBConnection.getConnection();
    System.out.println("Connection Established...");

    Statement st = con.createStatement();
    String query = "CREATE TABLE students_23 (rollno number(10), name varchar2(20), email varchar2(100))";
    int n = st.executeUpdate(query);
    System.out.println("Value of n is: " + n);
    if (n >= 0)
      System.out.println("Students table created successfully!!");
    else
      System.out.println("Table Creation Unsuccessfull!!");
    st.close();
    con.close();
  }
} 