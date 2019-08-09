import java.util.Scanner;
public class Exercies7 {
	public static void main(String[] args) {
		
		Node a = readMessage();
		Double b = (Double)a.getData();
		
		Node e = new Node(Math.pow(b,2),a);
		System.out.println("the new data is : " + e.getData());
		
		System.out.println("the original data is: " + e.getNext().getData());
	}
	public static Node readMessage() {
		Scanner scan = new Scanner(System.in);
		System.out.println("please enter the double");
		double message = scan.nextDouble();
		Node d = new Node(message,null);
		return d;
			
		
	}
}
/**
*please enter the double
*54.54
*the new data is : 2974.6115999999997
*the original data is: 54.54
*/