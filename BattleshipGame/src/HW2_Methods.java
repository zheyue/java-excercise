

	/**
	 * Zheyue Wang
	 * CIS 35 JAVA
	 * 10/24/2017
	*/


	import java.util.*;

	public class HW2_Methods {

		public static Scanner userScanner = new Scanner(System.in);
		public static final int dimSize = 10;
		public static void main(String[] args) {
			// allocate array
			int[][] shipGrid = new int[dimSize][dimSize];
			int[][] hitGrid = new int [dimSize][dimSize];
			int rowLetter;
			int colNum;
			
			
			for( int i=0; i<hitGrid.length; i++)
			{
				
				for(int j=0; j< hitGrid.length; j++ )
				{
					shipGrid[i][j] = 0;
					hitGrid[i][j] = 0;
				}
			}
			
			
			displayInfo();
			
			boolean choice = false;
			
			// use do while to keep repeat
			do{
			
				// call fillShipGrid
			    fillShipGrid(shipGrid,5);
			    for (int i = 0; i < dimSize; i++) {
			    	    for(int j = 0; j < dimSize; j++) {
			    	    	System.out.print(shipGrid[i][j]);
			    	    }
			    	    System.out.println(" ");
			    }
			    
				// call playBattleship
			    choice = playBattleship(shipGrid,hitGrid); 
				// call wantsToContinue() 
			}while(choice == true);
			
		}
		
		public static void displayGrid( int [][]hitGrid) {
			
			
			//System.out.println("Enter row letter and column number (sep. by a space):");
			
		
			for( int i=0; i<hitGrid.length; i++)
			{

				for(int j=0; j< hitGrid.length; j++ )
				{
					if(hitGrid[i][j]==0) {
					System.out.print("- ");
					
					
					}
					else if(hitGrid[i][j] == -1)
					{
						System.out.print("M ");
					}
					else if(hitGrid[i][j] >0 && hitGrid[j][i]<10)
					{
						System.out.print("H ");
					}
				}
				System.out.print("\n");

			}
		}
		
		
		public static void displayInfo() {
			System.out.println("Welcome to CIS 35A's One-person Battleship game!\n "
					+ "There will be 5 ships placed on a 10 x 10 grid,\n "
					+ "one of each of size 1, size 2 , size 3, etc.\n  "
					+ "The game ends when you sink them all,\n "
					+ "make 25 guesses, or decide to quit at the end of a turn.\n\n" );
		}
		
		
		
		/*-----------------------------------------------------
		 * wantsToContinue method
		 * 
		 * This method displays the String parameter (prompt)
		 * and reads a one-word String from the user (System.in).
		 * If the input String begins with 'n' or 'N', the method 
		 * returns false, otherwise, the method returns true.
		  -----------------------------------------------------*/
		public static boolean wantsToContinue(String prompt){
			String answer;

			System.out.print(prompt + " (N for no): ");
			answer = userScanner.next();
			return answer.charAt(0)!= 'n' && answer.charAt(0) != 'N';
		} // end wantsToContinue




		public static boolean playBattleship(int [][]shipGrid, int [][]hitGrid) {
			
			
			int rowNum = 0,colNum = 0;
			int sunkNum = 0;
			char rowLeter;
			boolean condition = false;
			do {
				
				for(int i = 0; i < 25; i++) {
					displayGrid(hitGrid);

					System.out.print("Enter row letter and column number (sep. by a space):"
							+ "");
					rowLeter = userScanner.next().charAt(0);
					rowNum = rowLeter;
					rowNum -= 65;
					
					colNum = userScanner.nextInt();
					colNum --;
			        int gridStatus = checkGrid(shipGrid,hitGrid, rowNum, colNum);	
		        		if(gridStatus == -1) {
		        			System.out.print("Invalid row or column");
		        		}else if(gridStatus == -2) {
		        			System.out.print("Spot already guessed");
		        		}else if(gridStatus == 0) {
		                 System.out.print("Not a hit\n");             
		        		}else if(gridStatus > 0) {
		        			 System.out.print("Made a hit \n");      			 
		        		}else if (gridStatus >= 0) {
		        			int retVal = setHitGrid(shipGrid, hitGrid, rowNum, colNum);
		        			if(retVal > 0 && retVal < 10) {
		        				System.out.println("Sunk a ship: ");
		        				sunkNum++;
		        				System.out.print("Want to continue?(Y/N)");
		        				condition = wantsToContinue("Keep Playing? (N for no)");
		        				}
		        		  }
		        		hitGrid[rowNum][colNum] = setHitGrid(shipGrid,hitGrid,rowNum,colNum);
		        		
				}
		        	}while(condition == true);
			return condition;
			}

	        		
		

	   /*------------------------------------------------------------
	    * checkGrid
	    *    passing shipGrid, hitGrid, rowNum and colNum and assign the return value to gridStatus (int local variable)
	    *    in the checkGrid method, checks if valid rowNum (0 - 9) and colNum (0 – 9).  If not valid, return –1.  Otherwise:
	 	*	 If the element in hitGrid at the rowNum & colNum isn't 0, return -2 (already chosen)
	    *	 Return the element in shipGrid at the rowNum & colNum
	    ---------------------------------------------------------------*/
		public static int checkGrid(int [][]shipGrid, int [][]hitGrid, int rowNum, int colNum) {
		    
		    
			if((rowNum < dimSize && rowNum > -1) && (colNum < dimSize && colNum > -1)) {
				if(hitGrid[rowNum][colNum] != 0) {
					return -2;
				}
			}else {
				return -1;
			}
		
			return shipGrid[rowNum][colNum];
		}
		
		
	     public static int setHitGrid(int [][]shipGrid, int [][]hitGrid, int rowNum, int colNum) {
	 		if((rowNum < dimSize && rowNum > -1) && (colNum < dimSize && colNum > -1)) {
				if (shipGrid[rowNum][colNum] == 0) {
					hitGrid[rowNum][colNum] = -1;
					return -1;
				}
				else
				{
					hitGrid[rowNum][colNum] = shipGrid[rowNum][colNum] + 10;
					//check
					int sameNum  = 0;
					int shipNum = shipGrid[rowNum][colNum];
					//check row
					for(int row = 0; row < dimSize; row++) {
						if(shipGrid[row][colNum] == shipNum) 
							sameNum++;
					}
					if(sameNum == shipNum) {
						for(int row = 0; row < dimSize; row++) {
							if(hitGrid[row][colNum] % 10 == shipNum) {
								hitGrid[row][colNum] = hitGrid[row][colNum] % 10;
								shipGrid[row][colNum] = 0;
							}
						}
						return shipNum;
					}
					//check column
					for(int col = 0; col < dimSize; col++) {
						if(shipGrid[rowNum][col] == shipNum) 
							sameNum++;
					}if(sameNum == shipNum) {
						for(int col = 0; col < dimSize; col++) {
							if(hitGrid[rowNum][col] % 10 == shipNum) {
								hitGrid[rowNum][col] = hitGrid[rowNum][col] % 10;
								shipGrid[rowNum][col] = 0;
							}
						}
						return shipNum;
					}
				}
				
				return hitGrid[rowNum][colNum];
	 		}
	 		return -1;
		}
		/*-----------------------------------------------------
		 * fillShipGrid
		 *     This method fills the 2-dim. array of ints
		 *     with all 0s first, then for each ship from
		 *     1 to numShips, places randomly in consecutive
		 *     spots the ship number (1 for ship 1, 2 for ship 2,
		 *     3 for ship 3, etc.) either in a row or column
		 *  Parameters: shipGrid (int [][])
		 *  			numShips (int), forced to be 4 to 9
		 *  			(default 4)
		 ------------------------------------------------------*/
		public static void fillShipGrid(int [][] shipGrid,
									int numShips)
		{
			if( shipGrid == null )
				return;
			if( numShips < 4 || numShips > 9 )// must be 4 to 9 ships
				numShips = 4;
			
			// initialize grid to all 0's (in case set before)
			for( int row = 0; row < shipGrid.length; ++row )
				for( int col = 0; col < shipGrid[row].length; ++col )
					shipGrid[row][col] = 0;
			
			// fill in ships randomly
			int randRow, randCol;
			for( int shipNum = 1; shipNum <= numShips; ++shipNum )
			{
				do
				{
					randRow = (int)(Math.random() * shipGrid.length);
					randCol = (int)(Math.random() * shipGrid[0].length);
				}while( !placedShip(shipNum, randRow, randCol, shipGrid));
			} // end for
		} // end fillShipGrid
		
		/*-----------------------------------------------------
	     * placedShip method
	     *      This method tries to assign a ship in the shipGrid
	     *  if it fits in randRow row (if a randomly chosen direction
	     *  is 0) or the randCol column.  It will assign the same number
	     *  of spots as the shipNum and return true if successful
	     *  or false if the spot is already assigned, or no room
	     *  to assign at the randRow, randCol coordinates.
		 ------------------------------------------------------*/
		public static boolean placedShip(int shipNum,
									int randRow,
									int randCol,
									int [][] shipGrid)
		{
			if( shipGrid[randRow][randCol] != 0 ) // already used spot
				return false;
			// pick right (0) or down (1)
			int direction = (int)(Math.random()*2);
			boolean blocked;
			// try to rill right if direction is 0 and there's room
			if( direction==0 && (randCol + shipNum) <= shipGrid[0].length )
			{
				blocked = false;
				// check if row is blocked
				for( int count = 1; count < shipNum ; ++count )
					if( shipGrid[randRow][randCol+count] != 0 )
					{
						blocked = true;
						break;
					}
				if( !blocked ) // not blocked, so place ship
				{
					for(int col = 0; col < shipNum; ++col )
						shipGrid[randRow][randCol+col] = shipNum;
					return true;
				}
			} // end if try to fill right
			// try to fill down if above fails and there's room
			if( (randRow + shipNum) <= shipGrid.length )
			{
				blocked = false;
				// check if column is blocked
				for( int count = 1; count < shipNum ; ++count )
					if( shipGrid[randRow+count][randCol] != 0 )
					{
						blocked = true;
						break;
					}
				if( !blocked ) // not blocked so place ship
				{
					for(int row = 0; row < shipNum; ++row )
						shipGrid[randRow+row][randCol] = shipNum;
					return true;
				}
			} // end if try to fill down
			return false; // coordinates didn't work
		
	}// placedShip

	     /*-------------------------------------------------
	      * displayResults
	      *     In the displayResults method, display "Ships not sunk" 
	      *     and call displayGrid passing the shipGrid . 
	      *     Then display "Your results" and call displayGrid (for the hitGrid).
	      ---------------------------------------------------*/
	    public void displayResults(int[][] shipGrid, int[][] hitGrid) {
	  
	    	System.out.print("Ships not sunk");
	    	displayGrid(shipGrid);
	    	System.out.print("Your results");
	    	displayGrid(hitGrid);
	    }
	}
		
		/**
		 * Welcome to CIS 35A's One-person Battleship game!
	 There will be 5 ships placed on a 10 x 10 grid,
	 one of each of size 1, size 2 , size 3, etc.
	  The game ends when you sink them all,
	 make 25 guesses, or decide to quit at the end of a turn.


	3000000000 
	3000000000 
	3500000000 
	0500040000 
	0500042200 
	0500040000 
	0500040000 
	0000010000 
	0000000000 
	0000000000 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	Enter row letter and column number (sep. by a space):A 4
	Not a hit
	- - - M - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	Enter row letter and column number (sep. by a space):G 6
	Made a hit 
	- - - M - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - H - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	Enter row letter and column number (sep. by a space):G 4
	Not a hit
	- - - M - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - M - H - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	Enter row letter and column number (sep. by a space):J 8
	Not a hit
	- - - M - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - M - H - - - - 
	- - - - - - - - - - 
	- - - - - - - - - - 
	- - - - - - - M - - 
	Enter row letter and column number (sep. by a space):
		 */

}
