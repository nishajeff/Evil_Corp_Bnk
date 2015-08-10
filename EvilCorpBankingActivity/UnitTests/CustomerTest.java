import java.util.Date;

import org.junit.* ;

import static org.junit.Assert.* ;
public class CustomerTest {
	
	 @Test
	   public void test_updatecorrectBalance() {
	      System.out.println("Test if correct balance is Updated....") ;
	      Customer C = new Customer(1122,"XYZ",250) ;
	      Transaction T=new Transaction("C",new Date(),100);
	      C.addToTransactions(T);
	      C.updateBalance();
	      assertTrue(C.getBalance() ==150);
	   }

	 @Test
	   public void test_getcorrectBalance() {
	      System.out.println("Test if correct balance is returned....") ;
	      Customer C = new Customer(1122,"XYZ",250) ;	      
	      assertTrue(C.getBalance() ==250);
	   }
	 @Test
	   public void test_getcorrectName() {
	      System.out.println("Test if correct name is returned....") ;
	      Customer C = new Customer(1122,"XYZ",250) ;	      
	      assertTrue(C.getCust_name()=="XYZ");
	   }


	 @Test
	   public void test_formattedBalance() {
	      System.out.println("Test if correct formatted balance is returned....") ;
	      Customer C = new Customer(1122,"XYZ",250) ;		   
	      assertTrue(C.getFormattedBalance().equals("$250.00"));
	   }
}
