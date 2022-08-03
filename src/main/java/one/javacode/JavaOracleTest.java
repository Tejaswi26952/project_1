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
			String sql ="INSERT INTO bankaccounts(customername,city)" + "VALUES('Tejaswi','Guntur')";
			String sql1 ="INSERT INTO bankaccounts(customername,city)" + "VALUES('sreeya','vijayawada')";
			String sql2 ="INSERT INTO bankaccounts(customername,city)" + "VALUES('Divya','ongoole')";
			String sql3 ="INSERT INTO bankaccounts(customername,city)" + "VALUES('vindhya','nellore')";
			Statement statement =connection.createStatement();
			Statement statement1 =connection.createStatement();
			Statement statement2 =connection.createStatement();
			Statement statement3 =connection.createStatement();
			int rows =statement.executeUpdate(sql);
			int rows1 =statement.executeUpdate(sql1);
			int rows2 =statement.executeUpdate(sql2);
			int rows3 =statement.executeUpdate(sql3);

			int row = 0;
			if (row > 0) {
				System.out.println("A row has been inserted");
			}
			connection.close();
			
		} catch (ClassNotFoundException e) {
			  e.printStackTrace();
		}
	    catch (SQLException e) {
			System.out.println("opps...error");
			
			e.printStackTrace();
		}
	

	}

}
