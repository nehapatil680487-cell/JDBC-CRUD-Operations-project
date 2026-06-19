
import java.sql.*;
import java.util.Scanner;


public class Demo {

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
        	 System.out.println("Enter employee id");
        	 int id = sc.nextInt();
        	 sc.nextLine();
        	 
        	 System.out.println("Enter Employee name");
        	 String name = sc.nextLine();
        	 
        	 System.out.println("Enter Employee salary");
        	 Double salary = sc.nextDouble();
        	 
        	 //Sql Query
        	 
        	 String query = "INSERT INTO emp(id,name,salary) VALUES(?,?,?)";
        	 
        	 //create Preapredstatement
        	 
        	 PreparedStatement ps = con.prepareStatement(query);
        	 
        	 //set values
        	 
        	 ps.setInt(1, id);
        	 ps.setString(2,name);
        	 ps.setDouble(3,salary);
        	 
        	 
        	 //execute query
        	 
        	 int rows = ps.executeUpdate();
        	 
        	 if(rows > 0) {
        		 System.out.println("Employee Inserted Succesfully");
        	 }else {
        		 System.out.println("Insertion failed");
        	 }
        	 
        	 //close
        	 
        	 sc.close();
        	 con.close();
        	 ps.close();
        	 
        	 
        	 
         }catch(Exception e) {
        	 System.out.println(e);
         }
	}

}
