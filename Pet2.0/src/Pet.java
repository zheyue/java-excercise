/*
 * zheyue wang
 * 12/10/2017
 * Windows 10, eclipse
 * find the dog and cat 
 * name is for the name of the pet. birthyear is the year those pet birth. c is to find the current year. 
 */
import java.util.*;
public abstract class Pet {
	protected String name = " No name";
	protected int birthyear = 2010;
	
	public Pet (String n ,int birthyear) {
		setName(n);
		setBirthyear(birthyear);
	}
	public Pet() {
		
	}
	public String getName() {
		return name;
	}
	public int getBirthyear() {
		return birthyear;
	}
	public void setName(String n) {
		if(n != null && n.length() > 0) {
			name = n;
		}
		
	}
	public void setBirthyear(int y) {
		GregorianCalendar c = new GregorianCalendar();	
		if (y >= 1990 && y <= c.get(Calendar.YEAR)) {
			birthyear = y;
		}
	}
	public int calcAge() {
		GregorianCalendar d = new GregorianCalendar();
		return d.get(Calendar.YEAR) - birthyear;
	}
	public abstract int convertYears();
	public abstract String speak();
	
	public String toString() {
		
		StringBuilder a = new StringBuilder();
		a.append("name: ");
		a.append(name);
		a.append(", ");
		a.append("birthyear: ");
		a.append(birthyear);
		
		return a.toString();
		
		
		
		
		
	}
	
}
