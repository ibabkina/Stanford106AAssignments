package week1;
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

	public void run() {
		
		while(frontIsClear()) {
			
			moveToNextBallot();
			
			if(noBeepersPresent()) {
				runBallot();
			}
		
			exitBallot();	
		}
	}
	
	/* Pre-condition: Karel is facing the ballot and facing East
	 * Post-condition: Karel is inside the ballot and facing East)
	 * 
	 */
	private void moveToNextBallot() {
		move();
		
	}
	
	/* Pre-condition: Karel is facing the ballot and facing East
	 * Post-condition: Karel is inside the ballot and facing East)
	 * 
	 */
	private void exitBallot() {
		move();
		
	}
	
	
	private void runBallot() {
		removeBeepersDownTheBallot();
		removeBeepersUpTheBallot();	
	}
	
	/* Karel moves down the ballot, checks for beepers, pick 
	 * them all up if beepers are present, moves back to the center 
	 * of the ballot. 
	 * Pre-condition: Karel is facing the ballot and facing East
	 * Post-condition: Karel is inside the ballot, in the center of
	 * the ballot and facing East)
	 */
	
	private void removeBeepersDownTheBallot() {
		turnRight();
		move();
		while(beepersPresent()) {
			pickBeeper();	
		}
		turnAround();
		move();
		turnRight();	
	}
	
	
	private void removeBeepersUpTheBallot() {
		turnLeft();
		move();
		while(beepersPresent()) {
			pickBeeper();	
		}
		turnAround();
		move();
		turnLeft();	
	}
	
		
}
