import java.sql.DriverManager;

public class Choose_employee extends Main{
    public static void choose(int id, int number){

        /**
         * This method is responsible for inserting the given row (employee) by id to the project table and giving their number
         * Id and number will be passed as a parameter
         * PreparedStatement with result set was used
         */

        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionUrl, "postgres", "admin");

            String sql = "insert into project " + " (id, name, number, salary, total)" + " values (?, ?, ?, ?, ?)";
            stmt1 = connection.prepareStatement(sql);

            stmt2 = connection.prepareStatement("SELECT name, salary FROM employees WHERE id = ?");
            stmt2.setInt(1, id);
            rs = stmt2.executeQuery();

            while (rs.next()){
                name = rs.getString("name");
                salary = rs.getInt("salary");
            }

            total = number * salary;

            stmt1.setInt(1, id);
            stmt1.setString(2, name);
            stmt1.setInt(3, number);
            stmt1.setInt(4, salary);
            stmt1.setInt(5, total);

            stmt1.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Successfully inserted");
        }
    }
}
