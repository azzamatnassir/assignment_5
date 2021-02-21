import java.sql.DriverManager;

public class Delete extends Main{

    public static void delete(int id){
        /**
         * This method is responsible for deleting the given row (employee) by id
         * Id will be passed as a parameter
         * PreparedStatement was used
         */

        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionUrl, "postgres", "admin");

            stmt1 = connection.prepareStatement("DELETE FROM project WHERE id = ?");
            stmt1.setInt(1, id);

            stmt1.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Successfully deleted");
        }
    }
}
