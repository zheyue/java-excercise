
public class array1 {
   public static void main(String[] args) {
	   
	  float mainArray[] = method1(9,(float) 5.0);
	   method2(mainArray);
	   
   }
  
   static float[] method1 (int numElems, float value ) {
	   float locaArray[] =  new float [numElems];
	   
	   for (int i = 0; i < locaArray.length; i++) {
		   locaArray[i] = (float) Math.pow(value, i);
	   }
             return locaArray;
   }
   
   static void method2 (float array[]) {
   
   for(int i = array.length -1; i >= 0; i--) {
	 System.out.println(array[i]);  
   }
   
}
}

/**
* result 
* 390625.0
* 78125.0
* 15625.0
* 3125.0
* 625.0
* 125.0
* 25.0
* 5.0
* 1.0 
 */



