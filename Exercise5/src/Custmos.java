
public class Custmos {
	private static String name;
	private static int accountNum;
	private static double savingBalance;
     
	 
	 Custmos(String name, int accountNum, double savingBalance){
	    	      setCustmers(name, accountNum,savingBalance);
	  }
   
     public static void setCustmers(String Name, int AccountNum,double SavingBalance) {
    	       name = Name;
    	       accountNum = AccountNum;
    	       savingBalance = SavingBalance;
    	    		  
      }
      
      public String getName() {
    	    return name;
      }
      public int getAccountNum() {
    	     return accountNum;
      }
      public double getSavingBalance() {
    	     return savingBalance;
      }
   }
