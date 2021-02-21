import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main{

    public static String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
    public static Connection connection = null;
    public static PreparedStatement stmt1 = null;
    public static PreparedStatement stmt2 = null;
    public static ResultSet rs = null;
    public static ResultSet rs2 = null;

    public static int id;
    public static String name;
    public static int salary;
    public static int number;

    public static int total;
    public static int cost;

    public static Scanner sc = new Scanner(System.in); //Scanner to read the user input

    public static void main(String[] args) {

        /**There you can choose the action:
         * show employees - outputs all employee types with their salaries, to output enter "emp"
         * choose employee - choose employee and their number to your project from the list above, to choose enter "che"
         * show chosen - output chosen employees to your project and the total cost of project, to output enter "sch"
         * update chosen - update the number of chosen employees, to update enter "upd"
         * delete chosen - delete chosen employee from project, to delete enter "del"
         * finish - stop the code and finish the project, to finish enter "stop"
         */

        System.out.println("------------------------------------------------\n" +
                "   Choose the action (action name = code):\n" +
                "     show employees = emp\n" +
                "     choose employee = che\n" +
                "     show chosen = sch\n" +
                "     update chosen = upd\n" +
                "     delete chosen = del\n" +
                "     finish = stop\n" +
                "------------------------------------------------");
        String a = "";
        while(!(a.equals("stop"))) {

            a = sc.nextLine();

            switch (a) {

                case "emp" -> Employees.emp();

                case "che" -> {

                    System.out.println("Enter id of chosen employee");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter number of employees");
                    number = sc.nextInt();
                    sc.nextLine();

                    Choose_employee.choose(id, number);

                }

                case "sch" -> {

                    Chosen.sch();

                }

                case "upd" -> {

                    System.out.println("Enter id to change");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter changed number");
                    number = sc.nextInt();
                    sc.nextLine();

                    Update.update(id, number);

                }

                case "del" -> {

                    System.out.println("Enter id to delete:");
                    id = sc.nextInt();
                    sc.nextLine();

                    Delete.delete(id);
                }
            }
        }
    }
}
