package one.javacode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaOracleTest {

	public static void main(String[] args) {
		
	    
	    try {
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	    	
	    	String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
		    String username = "scott";
		    String password = "tiger";
		    
			Connection connection = DriverManager.getConnection(URL, username, password);
			System.out.println("Connected successfully");
			
			
		} catch (ClassNotFoundException e) {
			  e.printStackTrace();
		}
	    catch (SQLException e) {
			System.out.println("opps...error");
			
			e.printStackTrace();
		}
	

	}

}
