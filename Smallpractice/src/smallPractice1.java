import java.util.Scanner;
public class smallPractice1 {
 public static void main (String[] args) {
	 Scanner scanner = new Scanner(System.in); 
	 int number;
	 double sum = 0.0;
	 double factor = 1;
	 System.out.println("Enter a double: ");
	 number = scanner.nextInt();
	 
	 for(double i = 1.0; i <= number; i++) {
		factor = factor * i; 
		double term = 1 / factor;
 
	 }
	 System.out.println(term);
 }
}
