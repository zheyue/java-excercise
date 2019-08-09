/*
 * zheyue wang
 * 12/10/2017
 * Windows 10, eclipse
 * find the dog and cat 
 * Scannner scan is for reading the data from the user.
 */
import java.io.*;
import java.util.*;
 
public class Homework7 {
	public static void main(String[] args) {
//		Pet[] pets = method1();
		TreeMap<String, Pet> pets = method1();
		
		System.out.println();
		
		
		
		message(pets);
		int number = smallDog(pets);
		
		System.out.println();
		
		if(number == -1) {
			System.out.println("There are no dogs.");
		}else {
			System.out.println("There are " + number + " small dogs");
		}
		
	}
	
	public static void  message(TreeMap<String,Pet> p) {
		
		Set<Map.Entry<String,Pet>> set = p.entrySet();
		Iterator<Map.Entry<String, Pet>> it = set.iterator();
		
		
		while(it.hasNext()) {
			Map.Entry<String, Pet> entry = it.next();
			System.out.println(entry.getValue().toString());
			System.out.print("	Human years: " + entry.getValue().convertYears());
			System.out.println(", Says: " + entry.getValue().speak() );
		}
		
	}

//	public static void sort(Pet[] p) {
//		boolean b = true;
//		while(b) {
//			b = false;
//			for (int i = 0;i <p.length-1;i++ ) {
//				if(p[i].getName().compareToIgnoreCase(p[i+1].getName()) > 0) {
//					Pet c = p[i];
//					p[i] = p[i + 1];
//					p[i + 1] = c;
//					b = true;
//				}
//			}
//		}
//	}
	
	public static int smallDog(TreeMap<String ,Pet> p) {
		int sum = 0;
		int dogs = 0;
		Set<Map.Entry<String,Pet>> set = p.entrySet();
		Iterator<Map.Entry<String, Pet>> it = set.iterator();
		while(it.hasNext()) {
		Map.Entry<String, Pet> entry = it.next();
			if( entry.getValue() instanceof Dog)  {
				dogs++;
				if(((Dog)entry.getValue()).getSize() == 'S') {
	           		  sum++;
				}
			}
		}
		return dogs == 0 ? -1 : sum;
	}
	
	public static TreeMap<String, Pet> method1() {
//		int size = 0;
//		while(size < 1 || size > 10) {
//			System.out.print("how many pets do you have: ");
//			size = scan.nextInt();
//			scan.nextLine();
//			if(size < 1 || size > 10) {
//				System.out.println("size invalid");
//			}
//			
//		}
		
		TreeMap<String, Pet> pets = new TreeMap<String,Pet>(new TreeMapCompartor());
		File file = new File ("hi3.txt");
		try {
			Scanner san = new Scanner(file);
			while(san.hasNextLine()) {
				Pet e = method2(san.nextLine());
				if(e == null) {
					System.out.println("Invalid input!!!!! ");
					continue;
				}
				pets.put(e.getName() + e.getBirthyear(),e);
			}			
			
		}catch(FileNotFoundException a) {
			System.out.println("File not found");
			System.out.println(file.getAbsolutePath());
		}		
		return pets;
	}
	
	public static Pet method2(String a) {
		
		String[] b = a.split("[,]");
		
		
		
		try {
			if(b[0].compareToIgnoreCase("dog") == 0) {
				if(b.length == 3) {
					return new Dog(b[1], Integer.parseInt(b[2]));
				}
				if(b.length == 4) {
					return new Dog(b[1], Integer.parseInt(b[2],Integer.parseInt(b[3])));
				}
				
				
				return new Dog(b[1],Integer.parseInt(b[2]),Integer.parseInt(b[3]),b[4].charAt(0));
			}else if (b[0].compareToIgnoreCase("cat") == 0) {
				if(b.length == 3) {
					return new Cat(b[1], Integer.parseInt(b[2]));
				}
				return new Cat(b[1], Integer.parseInt(b[2]), Boolean.parseBoolean(b[3]));
			}else {
				System.out.println("Unrecognized pet type: " + b[0]);
				return null;
			}
		}
		catch(ArrayIndexOutOfBoundsException c) {
			System.out.println("incorrect amount of arguments");
			return null;
		}
		catch(NumberFormatException c) {
			System.out.println("unrecognized input");
			return null;
		}
		
		
	}  

}

/**
Cat name: Naughty Kitty, birthyear: 2016, Not Indoor
	Human years: 15, Says: MEOW-hiss
Cat name: Nice Kitty, birthyear: 2014, Not Indoor
	Human years: 28, Says: MEOW-hiss
Cat name: NICE KITTY, birthyear: 2017, Indoor
	Human years: 0, Says: meow-purr
Cat name: NIP CAT, birthyear: 2016, Indoor
	Human years: 15, Says: meow-purr
Cat name: Prance Tabby, birthyear: 2015, Not Indoor
	Human years: 24, Says: MEOW-hiss

There are no dogs.
**/

/*
Unrecognized pet type: Dag
Invalid input!!!!! 

Dog name: Another Dog, birthyear: 2009, tricks : 3, size : S
	Human years: 54, Says: Woof Woof Woof 
Dog name: second try, birthyear: 2010, tricks : 0, size : M
	Human years: 49, Says: 
Cat name: some cat, birthyear: 2012, Not Indoor
	Human years: 36, Says: MEOW-hiss
Dog name: Some Dog, birthyear: 2014, tricks : 5, size : M
	Human years: 29, Says: Woof Woof Woof Woof Woof 
Dog name: SOME DOG, birthyear: 2016, tricks : 2, size : S
	Human years: 12, Says: Woof Woof 
Dog name: Spunky Spaniel, birthyear: 2017, tricks : 3, size : M
	Human years: 0, Says: Woof Woof Woof 

There are 2 small dogs
*/

/**
Dog name: Bernie St. Bernard, birthyear: 2011, tricks : 4, size : L
	Human years: 44, Says: Woof Woof Woof Woof 
Dog name: Cute Corgi, birthyear: 2008, tricks : 4, size : M
	Human years: 59, Says: Woof Woof Woof Woof 
Dog name: Fetch Retriever, birthyear: 2016, tricks : 5, size : L
	Human years: 12, Says: Woof Woof Woof Woof Woof 
Cat name: Smokey Cat, birthyear: 2012, Not Indoor
	Human years: 36, Says: MEOW-hiss
Dog name: Whippie, birthyear: 2012, tricks : 7, size : M
	Human years: 39, Says: Woof Woof Woof Woof Woof Woof Woof 

There are 0 small dogs
**/