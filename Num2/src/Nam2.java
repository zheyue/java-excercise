
public class Nam2 {
   public static void main(String[] args) {
	   int num1 = 0x5ACD;
	   int num2 = (short)(num1 & 0x00F0) << 4;
	   System.out.println(Integer.toHexString(num2));	 
   }
}
