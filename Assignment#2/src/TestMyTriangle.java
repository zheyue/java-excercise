

public class TestMyTriangle {
   public static void main (String[] args) {
	   myTraingle tran1 = new myTraingle(2.1, 3.2, 4.3);
	   myTraingle tran2 = new myTraingle(3.2, 8.0,1.2);
	   
	   System.out.println(tran1.perimeter(2.1, 3.2, 4.3));
	   System.out.println(tran1.Area(2.1, 3.2, 4.3));
	   System.out.println(tran2.perimeter(3.2, 8.0,1.2));
	   System.out.println(tran2.Area(3.2, 8.0,1.2));
	   

   
   }
}
 

/**
* tran1 perimeter = 9.600000000000001
* tran1 Area = 3.219937887599701
* tran2 perimeter = 12.399999999999999
* tran3 Area = NaN
*/