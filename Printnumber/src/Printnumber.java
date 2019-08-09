
public class Printnumber {
   public static void main(String[] args) {
	   double a;
	   double b;
	   for( int i = 2; i < 20; i++) {
		   a = Math.pow(i,2);
		   b = Math.pow(i, 3);
		   System.out.printf(i + " " +  a + " " + b + " \n");
	   }
   }
}
