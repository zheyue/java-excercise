
public class Salaried1 extends Employee1 {

	private double salary;
	private static int payPeriods = 12;

	public Salaried1( String name, String ssn, double s){
	     super(name, ssn);
	     salary = s;
	}
	public void setSalary( double sal ){ salary = sal; }

	public double getSalary(){ return salary; }

	public double computePay(){
	     return Math.round(salary/payPeriods*100.)/100.;
	}

	public String toString(){
	     return "Salaried: name=" + name +
	          ", SSN=" + ssn + ", Salary=" + salary;
	}

}

