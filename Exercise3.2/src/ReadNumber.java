import java.util.Scanner;
public class ReadNumber {
	 static Scanner scanner = new Scanner(System.in); 
	 public static void main (String[] args) {
		 int num1;
		 int num2;
         int num3;
         
         System.out.println("Enter a int: ");
         num1 = scanner.nextInt();
         System.out.println("Enter a int: ");
         num2 = scanner.nextInt(); 
         System.out.println("Enter a int: ");
         num3 = scanner.nextInt();
         int x = average(num1, num2,num3);
         int m = middle(num1,num2,num3);
         
         System.out.println(x);
         System.out.println(m);
         
         
         
	 }
	 
	  static int average (int a, int b, int c) {
		  
		  int ave = ((a + b + c) / 3 );
		return Math.round(ave);
		  
	  }
	  static int middle(int a, int b, int c) {
		  int max =  Math.max(a,Math.max(b, c));
		  int min =  Math.min(a, Math.min(b, c));
		  int mid = (a + b + c) - max- min;
		return mid;
		 
		  
	  }
	  
	  
}
