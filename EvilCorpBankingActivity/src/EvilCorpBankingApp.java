import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;
//
public class EvilCorpBankingApp {

	public static void main(String[] args) {	
		
		HashMap<Integer,Customer>myMap=new HashMap<Integer,Customer>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Evil Corp Savings and Loan\nPlease create the user account(s)");	
		System.out.println("Enter the account num:");
		try{
			int acct_num=Integer.parseInt(sc.nextLine());
			while (acct_num!=-1){
				
				System.out.println("Enter customer name:");
				String cust_name=sc.nextLine();
				System.out.println("Enter account balance:");
				int balance=Integer.parseInt(sc.nextLine());	
				Customer Cust_new=new Customer(acct_num,cust_name,balance);			
				if(!(myMap.containsKey(acct_num)))
					myMap.put(acct_num, Cust_new);
				System.out.println("Enter an account # or -1 to stop entering accounts :");
				System.out.println("Enter the account num:");
				acct_num=Integer.parseInt(sc.nextLine());
			}
			System.out.println("Enter a transaction type (Check-C, Debit card-D, Deposit-DP or Withdrawal-W) or -1 to finish :");
			String type=sc.nextLine();
			while(!(type.equals("-1"))){
				System.out.println("Enter account num:");
				int act_num=Integer.parseInt(sc.nextLine());
				System.out.println("Enter the amount:");
				int amount=Integer.parseInt(sc.nextLine());
				System.out.println("Enter the date of transaction");
				String userInput="";			
				userInput=sc.nextLine();
				Date dt=ChangeToDate(userInput);			
				Transaction t=new Transaction(type,dt,amount);
				if(myMap.containsKey(act_num))
					myMap.get(act_num).addToTransactions(t);
				System.out.println("Enter a transaction type (Check-C, Debit card-D, Deposit-DP or Withdrawal-W) or -1 to finish :");
				type=sc.nextLine();
				}
			for(int currentKey:myMap.keySet())
			   myMap.get(currentKey).updateBalance();
			for(int currentKey:myMap.keySet())
			   System.out.println(myMap.get(currentKey));	
		}catch(Exception e){
			System.out.println(e+"Please use valid inputs");
		}finally{
		sc.close();
		}
	}
	public static Date ChangeToDate(String userInput){
		int month,day,year;					
		String []Input=userInput.split("/");
		month=Integer.parseInt(Input[0]);
		day=Integer.parseInt(Input[1]);
		year=Integer.parseInt(Input[2]);
		GregorianCalendar n=new GregorianCalendar( year,month-1,day);
		Date date=new Date();
	    date=n.getTime();
	    return date;
	}

}
