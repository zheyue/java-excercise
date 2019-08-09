/*
 * zheyue wang
 * 12/10/2017
 * Windows 10, eclipse
 * find the dog and cat 
 * trick is the number of trick. size is the size of the dog.
 */
public class Dog extends Pet {
	private int tricks = 0;
	private char size = 'M';
	
	public Dog(String name, int birthyear,int trick, char size) {
		super(name, birthyear);
		setSize(size);
		setTricks(trick);
	}
	public Dog() {
		
	}
	public Dog(String name, int birthyear) {
		super(name, birthyear);
	}
	public Dog(String name, int birthyear,int trick) {
		super(name, birthyear);
		setTricks(trick);
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
		} else {
			size = 'M';
		}
	}
	public void setTricks(int t) {
	      tricks = t;	
	}
	public String toString() {
		StringBuilder a = new StringBuilder();
		a.append("Dog ");
		a.append(super.toString());
		a.append(", tricks : ");
		a.append(tricks);
		a.append(", size : ");
		a.append(size);
		
		return a.toString();
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