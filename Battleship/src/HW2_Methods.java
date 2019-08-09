

	
 import java.util.*;

	public class HW2_Methods {

		public static Scanner userScanner = new Scanner(System.in);
		
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
		} // placedShip
		
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
	}




