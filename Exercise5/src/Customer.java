
public class Customer {

	 private String name;
	 private long accountNum;
	 private double savingAcc;
	 
	 Customer(String name, long accountNum, double savingAcc){
	     this.name = name;
	     this.accountNum = accountNum;
	     this.savingAcc = savingAcc;
	 
		}
	 
	public void setName(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public long getAccountNum() {
		return accountNum;
	}
	public double getSavingAcc() {
		return savingAcc;
	}
}
