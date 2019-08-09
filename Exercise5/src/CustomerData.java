import java.util.Scanner;
public class CustomerData {
	 public static void main(String[] args) {
		 
		 Custmos[] customers = numCustmos();
		 	 
		 
		 
	 }
		 
		static Custmos[] numCustmos() {
	    	    Scanner scan = new Scanner(System.in);   
	       
		  
	       int number;
		   String name;
		   int accountNum;
		   double savingBalance;
		   System.out.println(" How many customer do you have: ");
		   number = scan.nextInt();
		 	Custmos [] localCustmo = new Custmos[number];
	       
		 	
		   for(int i = 0; i < number; i++) {
			   name = scan.nextLine();
			  System.out.println(" please enter your name: ");
			  name = scan.nextLine();
			  System.out.print(name);
			  System.out.println(" please enter your account number: "); 
			  accountNum = scan.nextInt();
			  System.out.println(" please enter your saving balance: "); 
			  savingBalance = scan.nextDouble();
			  localCustmo[i] = new Custmos(name, accountNum, savingBalance);   
		   }
		scan.close();
		       return localCustmo;  
		   
		  }
	
	
}