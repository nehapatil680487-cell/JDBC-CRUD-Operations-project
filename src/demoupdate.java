import java.sql.*;
import java.util.Scanner;

public class demoupdate {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        try {
            // Database Connection Details
            String url = "jdbc:mysql://localhost:3306/sitdemo";
            String username = "root";
            String password = "System";

            // Establish Connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Take input from user
            System.out.println("Enter employee id");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Employee name");
            String name = sc.nextLine();

            System.out.println("Enter Employee salary");
            double salary = sc.nextDouble();

            // SQL Query
            String query = "UPDATE emp SET salary=?, name=? WHERE id=?";

            // Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, salary);
            ps.setString(2, name);
            ps.setInt(3, id);

            // Execute Update
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee details updated successfully");
            } else {
                System.out.println("Employee id not found");
            }

            // Close resources
            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}