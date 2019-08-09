
public class Commission1 extends Employee1{
   private double amount;
   private double rate;
   
   public Commission1(String n, String s, double a, double r){
	   super(n,s);
       amount = a;
	   rate = r;
   }
   public double computePay(){
	     return amount * rate;
	}
   public String toString() {
	   return "Commission: name=" + name +
		          ", SSN=" + ssn + ", amount=" + amount + " rate = " + rate;
   }
}
