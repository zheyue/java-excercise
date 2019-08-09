
public class Commission extends Employee {

	private double rate;
	public Commission ( String name, String ssn, double r){
	     super(name, ssn);
	     rate = r;
	}
	public double getRate () {
		return rate;
	}
	public void setRate(double r) {
		rate = r;
	}
	public String toString() {
		return ("Commission " + super.toString() + ", Commission=" + rate);
	}
}
