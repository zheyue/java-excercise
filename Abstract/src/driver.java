
public class driver {
   public static void main(String[] args) {
	   Employee1[] array1 = new Employee1[4];
	   array1[0] = new Salaried1("Mickey Mouse", "987-65-4321", 100000.);
	   array1[1] = new Salaried1("Bugs Bunny", "121-21-2121", 90000.);
	   array1[2] = new Commission1("Donald Duck", "123-45-6789", 5000.0, 0.22);
	   array1[3] = new Commission1("Elmer Fudd", "343-43-4343", 3000., 0.25) ;
	   
	   for (int i = 0; i < array1.length; i++) {
		   System.out.println(array1[i].toString());
		   System.out.println(array1[i].computePay());
	   }
	   System.out.println(array1[0].compareTo(array1[0]));
   }
}
