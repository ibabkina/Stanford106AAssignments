package midterm;

import stanford.karel.SuperKarel;

public class KarelTheRobot extends SuperKarel {
	
	public void run() {
		move();
		turnLeft();
		for(int i = 0; i < 4; i++){
			followPath();
			comeBackToPath();	
		}	
	}		
		
	private void followPath() {	
		while (frontIsClear()) {
			if(noBeepersPresent()) 
				putBeeper();
			move();
		}
	}
	
	private void comeBackToPath() {
		turnRight();
		turnRight();
		move();
		turnLeft();
	}
}	





