


public class TryMyMath {
     public static double printNum(double num) {
    
    	 System.out.println(String.format("%.2f",num));	 
    	 	
    	   
    	   double sqrtroot = MyMath.round(Math.sqrt(num));
    	   
    	   double cuberoot = MyMath.round(Math.pow(num, (1./3.)));
    	   System.out.println( String.format("%.2f",sqrtroot) );
    	   System.out.println(String.format("%.2f",cuberoot) );
    	   
    	   
    	   return num;
     }
     public static void main (String[] args){
    	 double number = 1000.*Math.E;
    	 TryMyMath.printNum(number);
     
     }

}



/** 
 * 2718.28 is 1000.*Math.E with two decimal number.
 * 52.14 is  round number after quart root.
 * 13.96 is round number after cube root.
 */