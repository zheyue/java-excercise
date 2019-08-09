import java.util.Scanner;

/**
* name of project: Battleship
* name: Zheyue Wang
* date is 11/10 
* computer system: Mac os, compiler: eclipse
* play the battleship game
* 
*/
public class Battleship {
    public static final int DIMENSIONSIZE = 10; 
    public static final int NUMEROFSIP = 5;
    public static final int NUMBEROFGUESS = 25;
    public static Scanner userScanner = new Scanner(System.in);
    	
	public static void main (String[] args) {
    		int[][] shipGrid = new int[DIMENSIONSIZE][DIMENSIONSIZE];
    		int[][] hitGrid = new int[DIMENSIONSIZE][DIMENSIONSIZE];
    		message();
    		
    		do {
    			HW2_Methods.fillShipGrid(shipGrid,NUMEROFSIP);
    			setHitGridToZero(hitGrid);
    			playBattleShip(shipGrid,hitGrid);
    			
    		}while( HW2_Methods.wantsToContinue("Want to play another game?") );
    }
	public static void displayGrid(int[][] grid) {
		
		System.out.format("%4c", '|');
		for(int i = 1;i < grid.length +1;i++) {
			System.out.printf("%4d",i);
		}
		
		System.out.println();
		System.out.print("---+");
		for(int i = 0;i < 40;i++) {
			System.out.print("-");
		}
		System.out.println();
		for(int i = 0;i < grid.length;i++) {
			System.out.print(" "+(char)(i+65) + " |");
			for(int j = 0; j < grid[i].length;j++) {
				if(grid[i][j]==0 ) {
					System.out.printf("%4c",'-');
			    }else if(grid[i][j] == -1) {
			    		System.out.printf("%4c",'m');
			    }else if(grid[i][j] > 10){
			    		System.out.printf("%4c",'H');
			    }else{
			    		System.out.printf("%4d" ,grid[i][j]);
			    }
			}
			System.out.println();
		}
			
		
		System.out.println();
	}
	
	public static void playBattleShip(int[][] shipGrid,int[][] hitGrid) {
		int guessCount = 0;
		int hitCount = 0;
		do {
			displayGrid(hitGrid);
			System.out.println("Enter row letter and column number (sep. by a space): ");
			
			
			char rowLetter = userScanner.next().toUpperCase().charAt(0);
			int rownumber =((int) rowLetter) - 65;
			
			boolean number = false;
			String c = userScanner.next();
			for(int i = 0; i < c.length(); i++) {
				if(!Character.isDigit(c.charAt(i))) {
					number = true;
				}
			}
			
			int columnnumber;
			if(number) {
				columnnumber = -1;
			} else {
				columnnumber = Integer.parseInt(c)-1;
			}
			
			
			int gridStatus = checkGrid(shipGrid,hitGrid,rownumber,columnnumber);
			if(gridStatus == -1){ 
				System.out.println("Invalid row or column");
			}else if(gridStatus == -2){
				System.out.println("Spot already guessed");
			}else if(gridStatus == 0) {
				System.out.println("Not a hit");
			}else {
				System.out.println("Made a hit");
			}
			if(gridStatus >= 0) {
	            guessCount++;
	            int hitNumber = setHitGrid(shipGrid,hitGrid,rownumber,columnnumber);
	            if(hitNumber <= 10 && hitNumber >= 0) {
	            	 	hitCount++;
	            	 	System.out.println("you already sank: " + hitCount + " ships" );
	            }
	           
			}
		} while(guessCount < NUMBEROFGUESS && hitCount < NUMEROFSIP && HW2_Methods.wantsToContinue("Keep playing?"));
		
		System.out.println(" game over!");
		if (hitCount == NUMEROFSIP) {
			System.out.println(" you sank all the ships");
		}
		if (guessCount == NUMBEROFGUESS) {
			System.out.println(" you used up all your allowed guesses");
		}
		     
		
	}
	
	public static void displayResult(int[][] shipGrid, int[][] hitGrid) {
		
		System.out.println(" ships not sunk: ");
		displayGrid(shipGrid);
		System.out.println(" your result is: ");
		displayGrid(hitGrid);
	}
	
	public static int setHitGrid(int[][] shipGrid, int[][] hitGrid,int rowNum,int colNum) {
		
		if(shipGrid[rowNum][colNum] == 0) {
			hitGrid[rowNum][colNum] = -1;
			return -1;
		} else {
			hitGrid[rowNum][colNum] = shipGrid[rowNum][colNum] + 10;
			int count = 0;
			int count2 = 0;
			for(int i = 0; i < shipGrid.length;i++) {
				if( hitGrid[rowNum][i] == shipGrid[rowNum][colNum] + 10) {
					count++;
				}
				if( hitGrid[i][colNum] == shipGrid[rowNum][colNum] + 10) {
					count2++;
				}
			}
			
			// if a ship is sunk
			if (count == shipGrid[rowNum][colNum] ||count2 == shipGrid[rowNum][colNum]) {
				
				int ship = shipGrid[rowNum][colNum];
				
				for(int i = 0; i < shipGrid.length;i++) {
					if( hitGrid[rowNum][i] == ship + 10) {
						hitGrid[rowNum][i] %= 10;
						shipGrid[rowNum][i] = 0;
					}
					if( hitGrid[i][colNum] == ship + 10) {
						hitGrid[i][colNum] %= 10;
						shipGrid[i][colNum] = 0;
					}
				}
				return ship;
			}
			return shipGrid[rowNum][colNum] + 10;
			
		}
	}
		
		
		
	public static void setHitGridToZero(int[][] hitGrid) {
		for(int i = 0;i < hitGrid.length; i++) {
			for(int j = 0; j< hitGrid[i].length;j++) {
				hitGrid[i][j] = 0;
			}
		}
		
	}
		
	public static void message () {
		System.out.println("Welcome to CIS 35A's One-person Battleship game!\n "
				+ "There will be 5 ships placed on a 10 x 10 grid,"
				+ " one of each of size 1, size 2 , size 3, etc.\n "
				+ "The game ends when you sink them all,"
				+ " make 25 guesses, or decide to quit at the end of a turn." );
	}
	
	public static int checkGrid(int[][] shipGrid, int[][] hitGrid,int rowNum,int colNum) {
		if(rowNum < 0 || rowNum > 9 || colNum < 0 || colNum > 9) {
			return -1;
		}
		if(hitGrid[rowNum][colNum] != 0 ) {
			return -2;
		}
	    return shipGrid[rowNum][colNum];
	}
}

