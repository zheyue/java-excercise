public class Salaried extends Employee {

	private double salary;
	
	public Salaried( String name, String ssn, double s){
	     super(name, ssn);
	     salary = s;
	}
	public void setSalary( double sal ){
	
		salary = sal;
	
	}
	
	public double getSalary(){ return salary; }
	
	public String toString(){
	     return "Salaried " + super.toString() + ", Salary=" + salary;
	}

}