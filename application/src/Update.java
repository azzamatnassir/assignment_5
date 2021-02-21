import java.sql.DriverManager;

public class Update extends Main{

    public static void update(int id, int number){

        /**
         * This method is responsible for updating the given row (employee) by id, changing the number of employees
         * Id and changed number will be passed as a parameter, given to sql statement
         * PreparedStatement was used
         */

        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionUrl, "postgres", "admin");

            stmt2 = connection.prepareStatement("SELECT salary FROM employees WHERE id = ?");
            stmt2.setInt(1, id);
            rs = stmt2.executeQuery();

            while (rs.next())
                salary = rs.getInt("salary");

            stmt1 = connection.prepareStatement("UPDATE project SET number = ?, total = ? WHERE id = ?");  //SQL Statement where number and id will be taken from parameter
            stmt1.setInt(1, number);
            stmt1.setInt(2, number * salary);
            stmt1.setInt(3, id);

            stmt1.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Successfully updated");
        }
    }
}
