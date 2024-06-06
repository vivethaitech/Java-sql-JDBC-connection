import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQLJDBC {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:postgresql://localhost:5432/theatre";
        String user = "postgres"; // Replace with your PostgreSQL username
        String password = "Rjvv@1997"; // Replace with your PostgreSQL password

        // SQL query to retrieve data
        String query = "SELECT * FROM Movies";

        try {
            // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Print the table header

            System.out.printf("%-20s %-15s %-20s%n", "Name", "Released Date", "Actor");
            System.out.println("--------------------------------------------------------------");
            

            // Process the result set
            while (rs.next()) {
                String name = rs.getString("name");
                String released_date = rs.getString("released_date");
                String actor = rs.getString("actor");
                System.out.printf("%-20s %-15s %-20s%n", name, released_date, actor);
            }

            // Close the resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

