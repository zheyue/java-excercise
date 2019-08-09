import java.util.Scanner;
public class practice4 {
	static Scanner scanner = new Scanner(System.in); 
	public static void main(String[] args) {	
	int [][] mainArray1;

	
	}
	
	static int [][] readSize() {
		int size = scanner.nextInt();
		 if (size < 1)
			 size = 1;
		 
		 int localAry[][] = new int[size][size];
		 return localAry;
    	
    }
    static void initializeAry(int array[][]) {
    	for (int i = 0; i<array.length; i++){
    	    for (int j = 0; j<array[i].length; j++){
    	    		array[i][j]= i * 10 + j;

    	    } 
    	}
	
}
}
