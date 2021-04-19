package week1;

/** 
 * In Karel’s world, a ballot consists of an arbitrary number of columns
 * that a voter can punch out. Every ballot column is exactly one space 
 * wide and three spaces high. The ballot card begins one square to the left
 * of the first column and ends one square to the right of the last column.
 * Karel always starts immediately to the left of the first ballot in the 
 * middle row of the ballot, facing East and the hole that gives Karel access 
 * to the voting area along the middle row of the ballot. Karel progresses 
 * through each column. Karel can travel along the middle row between 
 * the columns without hitting a wall. If a column contains a beeper in 
 * the middle, the voter did not intend to vote on that column, and Karel moves
 * to the next column. If a column contains no beeper in the middle, Karel 
 * makes sure that there is no hanging chad: Karel checks the column above and
 * below the middle row and removes any beepers. A column may contain any 
 * number of beepers. Karel ends execution facing East at the rightmost edge of 
 * the ballot in the middle row. 
 * 
 *  @author Irina Babkina
 *  
 */

import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {
	/* To clean up the voting ballot 
	 * If the ballot's column contains a beeper in the middle, the voter did not
	 * intend to vote on that column, and Karel moves to the next column. If 
	 * a column contains no beeper in the middle, Karel makes sure that there is
	 * no hanging chad: Karel checks the column above and below the middle row and
	 * removes any beepers.  
	 * 
	 * Pre-condition:  	A ballot consists of a single row of ballot columns that 
	 * 					appear on every even intersection. 
	 * 					Ballot may contain any number of ballot columns.			  
	 * 				  	Every ballot column is exactly one space wide and three
	 * 				  	spaces high.	
	 * 				  	The ballot card begins one square to the left of the first
	 *                 	column and ends one square to the right of the last 
	 *                 	column.
	 * 				  	Karel always starts immediately to the left of the first 
	 * 				  	ballot in the middle row of the ballot, facing East and 
	 * 				  	the hole that gives Karel access to the voting area along
	 * 				  	the middle row of the ballot.
	 * 				  	Karel can travel along the middle row between the columns 
	 * 				  	without hitting a wall. 
	 * 				  	A column may contain any number of beepers. 
	 * 
	 * Post-condition: 	Facing East at the rightmost edge of the ballot in 
	 * 				  	the middle row.  
	 */
	
	public void run() {
		while (frontIsClear()) {
			enterColumn();         // face East
			if(noBeepersPresent()) {
				turnLeft();        // face North
				cleanHalfColumn(); // move North then back to the middle 
				cleanHalfColumn(); // move South then back to the middle 
				turnRight();       // face East
			}
			exitColumn();	       // face East
		}
	}
	
	/* 
	 * Pre-condition:	In the middle row of the ballot facing East and 
	 *                 	the column
	 * Post-condition: 	In the middle of the column facing East
	 */
	
	private void enterColumn() {
		move();	
	}
	
	/* 
	 * To move forward in the direction set outside of this method then 
	 * clean up a half of the column and move back where it started facing 
	 * the opposite direction  
	 * 
	 * Pre-condition:	In the middle of the column
	 * Post-condition:	In the middle of the column
	 */
	
	private void cleanHalfColumn() {
		move();
		while (beepersPresent()) {
			pickBeeper();	
		}
		turnAround();
		move();
	}
	
	/* 
	 * Pre-condition:	In the middle of the column facing East 
	 * Post-condition:	Out of the column facing East 
	 */
	
	private void exitColumn() {
		move();
		
	}
}
