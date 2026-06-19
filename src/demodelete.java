import java.sql.*;
import java.util.Scanner;


public class demodelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Scanner sc = new Scanner(System.in);
         
         try {
        	 //Database Connection Details
        	 String url = "jdbc:mysql://localhost:3306/sitdemo";
        	 String username = "root";
        	 String password = "System";
        	 
        	 //Establish Connection
        	 Connection con = DriverManager.getConnection(url,username,password);
        	 
        	 //Take input from user
        	 System.out.println("Enter employee id to delete");
        	 int id = sc.nextInt();
        	 sc.nextLine();
        	 
        	 String query = "DELETE FROM emp WHERE id=?";
        	 
        	 PreparedStatement ps = con.prepareStatement(query);
        	 
        	 ps.setInt(1, id);
        	 
        	 int rows = ps.executeUpdate();
        	 
        	 if(rows>0) {
        		 System.out.println("Employee Deleted Successfully.");
        	 }else {
        		 System.out.println("Employee ID Not Found");
        	 }
        	 
        	 ps.close();
        	 con.close();
        	 sc.close();
        	 
        	 } catch(Exception e){
        		 System.out.println("Error:" +e.getMessage());
        		 

        	 }
        	 
        	 
         }
	}