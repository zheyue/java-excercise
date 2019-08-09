
public class Corectcode {
	public static void main(String []args){
    int inum1 = 10, inum2;
    inum2 = inum1;
    for (int i = 0; i < inum2; ++i,--inum2) {
    	System.out.println("i = " + i + ", inum2 = " + inum2);
    }
    System.out.println("The ending value of inum2 = "+inum2);
 }
}