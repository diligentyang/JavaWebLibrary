package shiyan;

import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Db {
	 public static void main(String[] args) {
	        java.sql.Connection con; 
	        java.sql.Statement stmt; 
	        ResultSet rs;
	    
	         
	        try {
	            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
	 
	            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql","root","123456");
	  
	            stmt = con.createStatement(); 
	  
	            rs = stmt.executeQuery("select * user"); 
	             
	            while(rs.next()){
	          String name = rs.getString("User");
	          String des = rs.getString("Password");
	         
	        }
	            stmt.close();
	        con.close();
	       } catch (Exception e) {
	           e.printStackTrace();
	           System.out.println("¡¨Ω” ß∞‹");
	       }
	    }
}

