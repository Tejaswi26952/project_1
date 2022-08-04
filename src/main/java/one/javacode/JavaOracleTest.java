package one.javacode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaOracleTest {
	

	public static void main(String [] args)
	{
		int row; 
		int opt;
		
		try
		{
			String username="scott";
			String password="tiger";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			Connection  con=DriverManager.getConnection(url, username, password);
			Statement stmt=con.createStatement();
			System.out.println("Welcome");
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			do
			{
			System.out.println("1. OPEN AN ACCOUNT");
            System.out.println("2. ACCOUNT DETAILS");
            System.out.println("3. DEPOSIT");
			System.out.println("4. WITHDRAW");
			System.out.println("5. EXIT\n");
			System.out.println("choose from the options");
			opt=Integer.parseInt(br.readLine());
			switch(opt)
			{
		
			case 1:
				
				System.out.println("enter the name of the customer");
				String name=br.readLine();
				System.out.println("enter the phone no. of the customer");
				long phoneno=Long.parseLong(br.readLine());
				System.out.println("enter the city of the customer");
				String city=br.readLine();
				System.out.println("enter some money first");
				String bal=br.readLine();
				System.out.println("enter your aadhar number");
				String accno=br.readLine();
				
				
				
				

				
				
				try {
				String insstr="insert into CUSTOMER values('"+accno+"','"+name+"','"+city+"', '"+bal+"','"+phoneno+"')";
				
				
				
				row=stmt.executeUpdate(insstr);
				System.out.println("Thankyou for choosing our bank to open an account"+name+"\n"+"Your account has opened"+"\n");
				}catch(Exception e  ) {
					System.out.println("you have entered wrong details"+ e);
				}
				
				
				break;
		
			case 2: 
				System.out.println("enter the Account No of the customer");
				String acc=br.readLine(); 
				String sql1="select * from CUSTOMER   where accno='"+acc+"'";
				ResultSet rs1=stmt.executeQuery(sql1);			
				while(rs1.next())
				{	
					System.out.print(rs1.getString(1)+"\t");
					System.out.print(rs1.getString(2)+"\t");
					System.out.print(rs1.getString(3)+"\t");
					System.out.print(rs1.getString(4)+"\t");
					System.out.print(rs1.getString(5)+"\n");
					
				}
			break;
			case 3:
				System.out.println("enter the account number");
				  acc=br.readLine();
				System.out.println("enter the amount to be deposited");
				int amt=Integer.parseInt(br.readLine());
				String sql2="select TOTAL_BAL from CUSTOMER where accno='"+acc+"'";
				ResultSet rs2=stmt.executeQuery(sql2);
				
				
				
				
				String updstr="update CUSTOMER set TOTAL_BAL=TOTAL_BAL+"+amt+" where accno='"+acc+"'";
				row=stmt.executeUpdate(updstr);
				
				String sql3="select TOTAL_BAL from CUSTOMER where accno='"+acc+"'";
				ResultSet rs3=stmt.executeQuery(sql3);
				System.out.print("balance is: \t");
				while(rs3.next())
					System.out.println(rs3.getString("TOTAL_BAL")+"\n");
			break;
			case 4:
				int bal8=0;
				System.out.println("enter the account number");
				String acc1=br.readLine();
				System.out.println("enter the amount to be withdraw");
				int amt2=Integer.parseInt(br.readLine());
				String sql4="select TOTAL_BAL from CUSTOMER where accno='"+acc1+"'";
				ResultSet rs4=stmt.executeQuery(sql4);// ResultSet reference is a matrix
				System.out.print("Previous balance is: \t");
				while(rs4.next())
					
				{
					System.out.println(rs4.getString("TOTAL_BAL")+"\n");
					bal8=Integer.parseInt(rs4.getString("TOTAL_BAL"));
					
				}
				if(bal8>=amt2)
				{
					updstr="update CUSTOMER set TOTAL_BAL=TOTAL_BAL-"+amt2+" where accno='"+acc1+"'";
					row=stmt.executeUpdate(updstr);
					String sql5="select TOTAL_BAL from CUSTOMER where accno='"+acc1+"'";
					ResultSet rs5=stmt.executeQuery(sql5);// ResultSet reference is a matrix
					System.out.print("Updated balance is: \t");
					while(rs5.next())
					System.out.println(rs5.getString("TOTAL_BAL")+"\n");
				}
				else
					System.out.println("Insufficient Balance!\n");
				
			break;
			case 5: 
				stmt.close();
				con.close();
				System.out.println("\nThank you\n");
				System.exit(0);
				break;
			default:
				System.out.println("\nWrong choice\n");
				}
			}
			while(opt!=5);			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}// end of main method
}// end of public class
	


			