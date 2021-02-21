import java.sql.DriverManager;

public class Chosen extends Main{

    public static void sch(){

        /**
         * This method is responsible to output the table of chosen employees with their number and salary
         * PreparedStatement with result set was used
         */

            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(connectionUrl, "postgres", "admin");

                stmt1 = connection.prepareStatement("SELECT * FROM project ORDER BY id");   //SQL Statement for output
                rs = stmt1.executeQuery();
                stmt2 = connection.prepareStatement("SELECT SUM(total) as total_sum FROM project");
                rs2 = stmt2.executeQuery();

                System.out.println("------------------------------------------------");  //Line for design of the output

                while (rs.next())
                    System.out.println(rs.getInt("id") + " " + rs.getString("name") +
                            " " + rs.getInt("number") + " " + rs.getInt("salary") + " " + rs.getInt("total") +
                            "\n------------------------------------------------");

                while (rs2.next())
                    cost = rs2.getInt("total_sum");

                System.out.println("Total cost of the project: " + cost + "\n----------------------------------");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Successfully read");
            }
        }
}
