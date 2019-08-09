/*
 * zheyue wang
 * 11/16/2017
 * Windows 10, eclipse
 * find the dog and cat 
 * Scannner scan is for reading the data from the user.
 */
import java.util.Scanner;
 
public class Homework5 {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Pet[] pets = method1();
		
		System.out.println();
		
		sort(pets);
		message(pets);
		int number = smallDog(pets);
		
		System.out.println();
		
		if(number == -1) {
			System.out.println("There are no dogs.");
		}else {
			System.out.println("There are " + number + " small dogs");
		}
		
	}
	
	public static void  message(Pet[] p) {
		for(Pet d : p) {
			System.out.println(d.toString());
			System.out.print("	Human years: " + d.convertYears());
			System.out.println(", Says: " + d.speak() );
		}
		
	}

	public static void sort(Pet[] p) {
		boolean b = true;
		while(b) {
			b = false;
			for (int i = 0;i <p.length-1;i++ ) {
				if(p[i].getName().compareToIgnoreCase(p[i+1].getName()) > 0) {
					Pet c = p[i];
					p[i] = p[i + 1];
					p[i + 1] = c;
					b = true;
				}
			}
		}
	}
	
	public static int smallDog(Pet[] p) {
		int sum = 0;
		for (int i = 0; i<p.length; i++ )
			if(p[i] instanceof Dog)
				if(((Dog)p[i]).getSize() == 'S')
	           		  sum++;
		return sum == 0 ? -1 : sum;
	}
	
	public static Pet[] method1() {
		int size = 0;
		while(size < 1 || size > 9) {
			System.out.print("how many pets do you have: ");
			size = scan.nextInt();
			scan.nextLine();
			if(size < 1 || size > 9 ) {
				System.out.println("size invalid");
			}
			
		}
		
		Pet[] pets = new Pet[size];
		for(int i = 0; i < size; i++) {
			Pet e = method2();
			if(e == null) {
				System.out.println("Invalid input!!!!! ");
				i--;
				continue;
			}
			pets[i] = e;
		}
		return pets;
	}
	
	public static Pet method2() {
		System.out.print("Enter pet info, separated by commas: ");
		String a = scan.nextLine();
		String[] b = a.split("[,]");
		
		
		
		try {
			if(b[0].compareToIgnoreCase("dog") == 0) {
				return new Dog(b[1],Integer.parseInt(b[2]),Integer.parseInt(b[3]),b[4].charAt(0));
			}else if (b[0].compareToIgnoreCase("cat") == 0) {
				return new Cat(b[1],Integer.parseInt(b[2]),Boolean.parseBoolean(b[3]));
			}else {
				return null;
			}
		}catch(Exception c ) {
			System.out.println(c.toString());
			return null;
		}
		
		
		
		
	}  

}

/**
how many pets do you have: 6
Enter pet info, separated by commas: Dog,Tuffy Terrier,2017,4,S
Enter pet info, separated by commas: Cat,PURR Kitten,2015,true
Enter pet info, separated by commas: Dog,Sparky Dalmatian,2016,6,M
Enter pet info, separated by commas: Cat,Zip Cat,2014,false
Enter pet info, separated by commas: Cat,amber tabby,2009,true
Enter pet info, separated by commas: Dog,tiny chihuahua,2015,8,s

Cat name: amber tabby, birthyear: 2009, Indoor
	Human years: 48, Says: meow-purr
Cat name: PURR Kitten, birthyear: 2015, Indoor
	Human years: 24, Says: meow-purr
Dog name: Sparky Dalmatian, birthyear: 2016, tricks : 6, size : M
	Human years: 12, Says: Woof Woof Woof Woof Woof Woof 
Dog name: tiny chihuahua, birthyear: 2015, tricks : 8, size : S
	Human years: 24, Says: Woof Woof Woof Woof Woof Woof Woof Woof 
Dog name: Tuffy Terrier, birthyear: 2017, tricks : 4, size : S
	Human years: 0, Says: Woof Woof Woof Woof 
Cat name: Zip Cat, birthyear: 2014, Not Indoor
	Human years: 28, Says: MEOW-hiss

There are 2 small dogs
*/
/**
how many pets do you have: 8
Enter pet info, separated by commas: dog,Titan Great Dane,2005,5,L
Enter pet info, separated by commas: Dog,Tuffy Terrier,2006,4,s
Enter pet info, separated by commas: Cat,PURR Kitten,2001,true
Enter pet info, separated by commas: DOG,Bernie St. Bernard,2006,5,L
Enter pet info, separated by commas: Cat,Zip Cat,2005,false
Enter pet info, separated by commas: Cat,Amber Tabby,2000,true
Enter pet info, separated by commas: dog,Fetch Retriever,2007,10,L
Enter pet info, separated by commas: Cat,Debo Cat,2004,false

Cat name: Amber Tabby, birthyear: 2000, Indoor
	Human years: 84, Says: meow-purr
Dog name: Bernie St. Bernard, birthyear: 2006, tricks : 5, size : L
	Human years: 69, Says: Woof Woof Woof Woof Woof 
Cat name: Debo Cat, birthyear: 2004, Not Indoor
	Human years: 68, Says: MEOW-hiss
Dog name: Fetch Retriever, birthyear: 2007, tricks : 10, size : L
	Human years: 64, Says: Woof Woof Woof Woof Woof Woof Woof Woof Woof Woof 
Cat name: PURR Kitten, birthyear: 2001, Indoor
	Human years: 80, Says: meow-purr
Dog name: Titan Great Dane, birthyear: 2005, tricks : 5, size : L
	Human years: 74, Says: Woof Woof Woof Woof Woof 
Dog name: Tuffy Terrier, birthyear: 2006, tricks : 4, size : S
	Human years: 69, Says: Woof Woof Woof Woof 
Cat name: Zip Cat, birthyear: 2005, Not Indoor
	Human years: 64, Says: MEOW-hiss

There are 1 small dogs

*/

/**
how many pets do you have: 2
Enter pet info, separated by commas: cat,Wild Cat,2016,false
Enter pet info, separated by commas: CAT,kissy kitten,2017,true

Cat name: kissy kitten, birthyear: 2017, Indoor
	Human years: 0, Says: meow-purr
Cat name: Wild Cat, birthyear: 2016, Not Indoor
	Human years: 15, Says: MEOW-hiss

There are no dogs.
*/
