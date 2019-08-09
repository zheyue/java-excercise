/*
 * zheyue wang
 * 12/10/2017
 * Windows 10, eclipse
 * find the dog and cat 
 * indoor is to see if the cat is indoor or outdoor.
 */
public class Cat extends Pet {
	private boolean indoor = false;
	
	public Cat(String name, int birthyear,  boolean indoor) {
		super(name,birthyear);
		setIndoor(indoor);
	}
	public Cat(String name, int birthyear){
		super(name,birthyear);
	}
	public Cat() {
		
	}
	public boolean getIndoor() {
		return indoor;
	}
	public void setIndoor(boolean indo) {
		indoor = indo;
	}
	public String toString() {
		StringBuilder c = new StringBuilder();
		c.append("Cat ");
		c.append(super.toString());
		c.append(", ");
		c.append(indoor ? "Indoor" : "Not Indoor");
		return c.toString();
	}
	public int convertYears() {
		
		int age = calcAge();
		 switch(age) {
		 case 0: return 0;
		 case 1: return 15;
		 case 2: return 24;
		 default: return  24 + 4 * (age-2);
		 }
	}
	public String speak() {
		return indoor ?  "meow-purr" : "MEOW-hiss";
			
		
	}
}

/*
-indoor : boolean


+Cat( (name : String, birthyear : int, nothing : double, indoor : boolean)
+Cat()
+getIndoor() : boolean
+setIndoor()
+toString() : String
+convertYear() : int
+speak() : String
*/