import java.sql.DriverManager;

public class Employees extends Main{

    public static void emp(){

        /**
         * This method is responsible to output the table of all existing employees with their salaries
         * PreparedStatement with result set was used
         */

        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionUrl, "postgres", "admin");

            stmt1 = connection.prepareStatement("SELECT * FROM employees ORDER BY id");   //SQL Statement for output
            rs = stmt1.executeQuery();

            System.out.println("------------------------------------------------");  //Line for design of the output
            while (rs.next())
                System.out.println(rs.getInt("id") + " " + rs.getString("name") +
                        " " + rs.getInt("salary") + "\n------------------------------------------------");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Successfully read");
        }
    }
}
