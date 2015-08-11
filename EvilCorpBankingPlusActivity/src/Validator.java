
import java.util.regex.Pattern;
public class Validator {
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
	
	public static boolean ValidateName(String input){
		if(Pattern.matches("[a-zA-Z ]+", input)) 
			return true;
		 else 
			 return false;

	}
	
	public static boolean ValidateBalance(int input){
		try
			{								
						if( input>0 && input<=10000)
							return true;
						else
							return false;
				
			}
			catch(NumberFormatException ne){
				return false;
			}
		}
		
	public static boolean ValidateAccountNumber(String input){
		try
		{
			if(isNumeric(input)){	
				if(Integer.parseInt(input)>=-1)
					return true;
				else
					return false;
			}
			else
				return false;
			
		}catch(NumberFormatException ne){
			return false;
		}
	}
	public static boolean ValidateAmount(int input){
		try
		{
			
				if(input>0 && input<10000)
					return true;
				else
					return false;
			
		}catch(NumberFormatException ne){
			return false;
		}
	}
	public static boolean ValidateDate(String input){
		try{
			int month,day;	
			String year;
			String []Input=input.split("/");
			month=Integer.parseInt(Input[0]);
			day=Integer.parseInt(Input[1]);
			year=Input[2];
			boolean isFourDigits = year.length() == 4;
			if((month>0 && month<=12)&&(day>0 && day<=31) && isFourDigits)
					return true;
			else 
				return false;
				}catch(NumberFormatException ne){
			return false;
		}
	}
	public static boolean ValidateType(String input){
		if(input.equalsIgnoreCase("C")||input.equalsIgnoreCase("D")||input.equalsIgnoreCase("W")||input.equalsIgnoreCase("DP")||input.equalsIgnoreCase("-1"))
			return true;
		else
			return false;
	}
	
}

