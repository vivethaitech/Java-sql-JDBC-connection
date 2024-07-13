
import java.sql.*;


public class Student_details {
	public static void main(String[] args) throws Exception {
      readRecords();
      insertRecords();
      insertVar();
      insertUsingPst();
      delete();
      update();
     }
    public static void insertRecords() throws Exception{
        String url="jdbc:postgresql://localhost:5432/student";
		String username="postgres";
		String password="Rjvv@1997";
		String Query="insert into student_details values(5,'vivetha',6.7)";	
        Connection conn = DriverManager.getConnection(url,username,password);
        Statement stmt = conn.createStatement();
        int rows = stmt.executeUpdate(Query);
        System.out.println("Number of rows affected : "+rows);
        conn.close();
	}
   public static void delete() throws Exception{
        String url="jdbc:postgresql://localhost:5432/student";
		String username="postgres";
		String password="Rjvv@1997";
        int student_id=6;
		String Query="delete from student_details where student_id="+student_id;		
        Connection conn = DriverManager.getConnection(url,username,password);
        Statement stmt = conn.createStatement();
        int rows = stmt.executeUpdate(Query);        
        System.out.println("Number of rows affected : "+rows);
        conn.close();        
	}
   public static void update() throws Exception{
        String url="jdbc:postgresql://localhost:5432/student";
		String username="postgres";
		String password="Rjvv@1997";
       
		String Query="update student_details set student_gpa=9.80 where student_id=1"	;	
        Connection conn = DriverManager.getConnection(url,username,password);
        Statement stmt = conn.createStatement();
        int rows = stmt.executeUpdate(Query);        
        System.out.println("Number of rows affected : "+rows);
        conn.close();        
	}
    public static void insertVar() throws Exception{
        String url="jdbc:postgresql://localhost:5432/student";
		String username="postgres";
		String password="Rjvv@1997";

        int student_id=6;
        String student_name="Mani";
        double student_gpa=7.0;

		String Query="insert into student_details values("+student_id+",'"+student_name+"',"+student_gpa+");";
		
        Connection conn = DriverManager.getConnection(url,username,password);
        Statement stmt = conn.createStatement();
        int rows = stmt.executeUpdate(Query);
        
        System.out.println("Number of rows affected : "+rows);
        conn.close();
        
	}
    public static void insertUsingPst() throws Exception{
        String url="jdbc:postgresql://localhost:5432/student";
		String username="postgres";
		String password="Rjvv@1997";

        int student_id=6;
        String student_name="Mani";
        double student_gpa=7.0;

		String Query="insert into student_details values(?,?,?);";
		
        Connection conn = DriverManager.getConnection(url,username,password);
        PreparedStatement pst = conn.prepareStatement(Query);
        pst.setInt(1,student_id);
        pst.setString(2,student_name);
        pst.setDouble(3,student_gpa);
        //Statement stmt = conn.createStatement();
        int rows = pst.executeUpdate();
        //int rows = stmt.executeUpdate(Query);
        
        System.out.println("Number of rows affected : "+rows);
        conn.close();
        
	}
        public static void readRecords() throws Exception{
        String url="jdbc:postgresql://localhost:5432/student";
		String username="postgres";
		String password="Rjvv@1997";
		String Query="select * from student_details";
		
        Connection conn = DriverManager.getConnection(url,username,password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(Query);
        
        while(rs.next()) {
        
        System.out.println("Id is "+rs.getInt(1));
        System.out.println("name is "+rs.getString(2));
        System.out.println("pa is "+rs.getFloat(3));
        System.out.println("--------------------------");
        
        }
        conn.close();
        
	}


}
