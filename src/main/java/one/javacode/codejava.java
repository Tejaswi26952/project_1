package one.javacode;

public class codejava {
	

		int accno=232425;
		int balance;
		String customername;
		
		
		
		public void bankaccount(int balance, String customername) {
			
			this.balance = balance;
			this.customername = customername;
			this.accno=accno++;
			
		}
		
		void deposit(int amount)
		{
			if(amount !=0)
				balance=balance+amount;
			 System.out.println("balance in your account is "+balance);    
			
		} 
		void withdraw(int amount)
		{
			if(amount !=0)
				balance=balance - amount;
			 System.out.println("balance in your account is "+balance);    
			
		}
		void Checkbalance()
		{
			System.out.println("balance in your account is "+balance);    
			
		}
		
		

	}



