import java.sql.*;
import java.util.Scanner;



public class demoretrive {

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
       	 
       	 //Sql Query
       	  
       	  String query = "SELECT * FROM emp";
       	  
       	  //create statment
       	   Statement stmt = con.createStatement();
       	   
       	   //Excute Query
       	   
       	   ResultSet rs = stmt.executeQuery(query);
       	   
       	   
       	   System.out.println("--------------------------");
       	  System.out.println("ID\tNAME\tSALARY");
       	  System.out.println("--------------------------");
       	  
       	  
       	  while(rs.next()) {
       		  
       		  int id = rs.getInt("id");
       		  String name = rs.getString("Name");
       		  double salary = rs.getDouble("salary");
       		  
       		  System.out.println(id + "\t" +name + "\t" + salary);
       	  }
       	  
       	  //close resources
       	  rs.close();
       	  stmt.close();
       	  con.close();
       	   
       			   
       			   
	}catch(Exception e) {
		System.out.println(e);
	}
	}
}
