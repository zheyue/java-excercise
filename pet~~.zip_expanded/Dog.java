/*
 * zheyue wang
 * 11/16/2017
 * Windows 10, eclipse
 * find the dog and cat 
 * trick is the number of trick. size is the size of the dog.
 */
public class Dog extends Pet {
	private int tricks;
	private char size;
	
	public Dog(String name, int birthyear,int trick, char size) {
		super(name, birthyear);
		setSize(size);
		setTricks(trick);
	}
	public Dog() {
		
	}
	public char getSize() {
		return size;
	}
	public int getTricks() {
		return tricks;
	}
	public void setSize(char s) {
		char a = Character.toUpperCase(s);
		if (a == 'S' || a == 'M' || a == 'L') {
			size = a;
		}
	}
	public void setTricks(int t) {
	      tricks = t;	
	}
	public String toString() {
		return "Dog " + super.toString() + ", tricks : " + tricks + ", size : " + size;
	}
	public int convertYears() {
		
		 int age = super.calcAge();
		 if(age < 0) {
			 return 0;
		 }
		 switch(age) {
		 case 0: return 0;
		 case 1: return 12;
		 case 2: return 24;
		 default: return  24 + 5 * (age-2);
		 }
	}
	public String speak() {
		StringBuilder woof = new StringBuilder();
		for (int i = 0; i < tricks; i++) {
			woof.append("Woof ");
		}
		return woof.toString();
	}
}

/*
-tricks : int 
-size : char



+Dog (name : String, birthyear : int, nothing : double, trick : int, size : char)
+Dog()
+getTricks() : int
+getSize() : char
+setSize(s  : char)
+setTricks ( t : int)
+toString() : String
+convertYear() : int
+speak() : String
*/