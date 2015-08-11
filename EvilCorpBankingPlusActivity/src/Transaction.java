import java.io.Serializable;
import java.util.Date;
//
@SuppressWarnings("serial")
public class Transaction implements Comparable<Transaction>,Serializable{
	private String transaction_type;
	private Date date;
	private int amount;
	boolean flag;
	public Transaction(String type,Date d,int amount){
		transaction_type=type;
		date=d;
		this.amount=amount;
		flag=false;
	}
	public Transaction(){
		transaction_type="";
		date=new Date();
		amount=0;
		flag=false;
	}
	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public int compareTo(Transaction o) {
	    if (getDate() == null || o.getDate() == null)
	      return 0;
	    return getDate().compareTo(o.getDate());
	  }
	public String toString(){
		return "Transaction: "+transaction_type+"\nDate: "+date+"\nAmount:"+amount+"\n\n";
	}
}
