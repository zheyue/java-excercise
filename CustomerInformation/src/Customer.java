
public class Customer {
	private String name = "No Name";      
	private long acctNum;    
	private SavingsAccount savings;
	private String firstName = null;
	private String lastName = null;
	

	
	public Customer(String nm, long ac,  SavingsAccount sav){            
		setName(nm);          
		if( ac > 0 )                  
			acctNum = ac;           
		if( sav != null )                 
			savings = sav;           
		else                  
			savings = new SavingsAccount();       
	}
	 public Customer(String nm,long ac, double bal) {
		 this(nm, ac, new SavingsAccount(bal));
	 }
	 
	 public String getName(){ 
		 
		 return name;
		 } 
	 
	 public long getAcctNum(){ return acctNum; }
	 
	 public SavingsAccount getSavings(){        
		 return savings;     
		 }
	 
	 public boolean setName( String nm) {
		 if( nm != null && nm.length() > 0 ) {
			 name = nm;         
			 return true;
		 }
		 int start = nm.indexOf(" ");
		 int end = nm.lastIndexOf(" ");
		 	  if (start >= 0) {
	            firstName = nm.substring(0, start);
	            if (end > start)
	            	 lastName = nm.substring(end + 1, nm.length());
	            
	            name = firstName + ", " + lastName;
	        }    
		 
		
		 return false;
      }
	 public void display() {
		 System.out.println("Customer: name= "+ name + ", Acct#= " + acctNum + ", savings balance= " + savings.getBalance() );
	 }
	 
	
}
