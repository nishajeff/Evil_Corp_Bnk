

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;
//
public class EvilCorpBankingPlusApp {
public static HashMap<Integer,Customer>myMap = null;	
	public static void main(String[] args) throws IOException {	
		myMap = new HashMap<Integer,Customer>();
		FileOutputStream fos = null;
		ObjectOutputStream oos=null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;		 
		try {			
			fis = new FileInputStream("CustInfo.ser");
			ois = new ObjectInputStream(fis);
			ReadFromFile(ois);
		} catch (Exception e1) {			
			//do nothing
		}
		try {
			fos = new FileOutputStream("CustInfo.ser");
			oos = new ObjectOutputStream(fos);			 
		} catch (IOException e1) {			
			//do nothing
		}
		System.out.println("Existing Accounts are:");
		for(int Key:myMap.keySet()){			
			   System.out.println(myMap.get(Key));			   		   
			}
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Evil Corp Savings and Loan\nPlease create the user account(s)");	
		System.out.println("Enter the account num:");
		try{
			String actNum=sc.nextLine();
			while(!(Validator.ValidateAccountNumber(actNum))){				
				System.out.println("Invalid Entry.Enter an acct-Num");				
				actNum=sc.nextLine();						 
			}
			int acct_num=Integer.parseInt(actNum);
			while (acct_num!=-1){						
				if(!(myMap.containsKey(acct_num))){
					System.out.println("Enter customer name:");
					String cust_name=sc.nextLine();
					while(!(Validator.ValidateName(cust_name))){				
						System.out.println("Invalid Entry.Enter a Name");				
						 cust_name=sc.nextLine();				 
					}
					System.out.println("Enter account balance:");					
					int balance=Integer.parseInt(sc.nextLine());
					while(!(Validator.ValidateBalance(balance))){				
						System.out.println("Invalid Entry.Enter a Balance");				
						balance=Integer.parseInt(sc.nextLine());				 
					}
					Customer Cust_new=new Customer(acct_num,cust_name,balance);						
					myMap.put(acct_num, Cust_new);
				}
				System.out.println("Enter an account # or -1 to stop entering accounts :");
				System.out.println("Enter the account num:");
				actNum=sc.nextLine();
				while(!(Validator.ValidateAccountNumber(actNum))){				
					System.out.println("Invalid Entry.Enter an acct-Num");				
					actNum=sc.nextLine();				 
				}
				acct_num=Integer.parseInt(actNum);				
			}
			System.out.println("Enter a transaction type (Check-C, Debit card-D, Deposit-DP or Withdrawal-W) or -1 to finish :");
			String type=sc.nextLine();
			while(!(Validator.ValidateType(type))){				
				System.out.println("Invalid Entry.Enter a Type");				
				type=sc.nextLine();				 
			}
			while(!(type.equals("-1"))){
				System.out.println("Enter account num:");
				actNum=sc.nextLine();
				while(!(Validator.ValidateAccountNumber(actNum))){				
					System.out.println("Invalid Entry.Enter an acct-Num");				
					actNum=sc.nextLine();				 
				}
				int act_num=Integer.parseInt(actNum);
				
				System.out.println("Enter the amount:");				
				int amount=Integer.parseInt(sc.nextLine());
				while(!(Validator.ValidateAmount(amount))){				
					System.out.println("Invalid Entry.Enter an Amount");				
					amount=Integer.parseInt(sc.nextLine());				 
				}
				System.out.println("Enter the date of transaction");
				String userInput="";			
				userInput=sc.nextLine();
				while(!(Validator.ValidateDate(userInput))){				
					System.out.println("Invalid Entry.Enter an Amount");				
					userInput=sc.nextLine();				 
				}
				Date dt=ChangeToDate(userInput);			
				Transaction t=new Transaction(type,dt,amount);
				if(myMap.containsKey(act_num))
					myMap.get(act_num).addToTransactions(t);
				System.out.println("Enter a transaction type (Check-C, Debit card-D, Deposit-DP or Withdrawal-W) or -1 to finish :");
				type=sc.nextLine();
				while(!(Validator.ValidateType(type))){				
					System.out.println("Invalid Entry.Enter a Type");				
					type=sc.nextLine();				 
				}
				}
			for(int currentKey:myMap.keySet())
			   myMap.get(currentKey).updateBalance();
			for(int currentKey:myMap.keySet()){
			   System.out.println(myMap.get(currentKey));			   		   
			}
			oos.writeObject(myMap);					  
			}catch(Exception e){
				e.printStackTrace();
			}finally{
			sc.close();			
			fos.close();
			//fis.close();
			//ois.close();
			oos.close();
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
	
	@SuppressWarnings("unchecked")
	public static void  ReadFromFile( ObjectInputStream ois) throws IOException,ClassNotFoundException {		
			try{
			myMap = (HashMap<Integer, Customer>) ois.readObject();
			}catch(Exception e){
				//do nothing
			}	 
		
	 }

}
