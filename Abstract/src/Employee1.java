public abstract class Employee1 implements Comparable{
    
	protected String name;

	protected String ssn;

	public Employee1( String n, String s ){
	     name = n; ssn = s;
	}

	public String getName(){ return name; }

	public String getSsn(){ return ssn; }
	  // could add mutators

	public abstract double computePay();
	
	public int compareTo(Object a) {
		int nc = getName().compareToIgnoreCase(((Employee1)a).getName());
		if( nc == 0) {
			return getSsn().compareTo(((Employee1)a).getSsn());	
		}else {
			return nc;
		}
		
	}

}
