package midterm;

import acm.program.ConsoleProgram;

public class SecondLargest extends ConsoleProgram {
	
	private static final int SENTINEL = 0;
	
	public void run() {
		println("This program finds the two largest integers in a list. "
				+ "Enter values, one per line, using a 0 to signal the end"
				+ " of the list.");
		int largest = -1;
		int secondLargest = -1;
		while (true) {
			int userNumber = readInt(" ? ");
			if(userNumber == SENTINEL)
				break;
			if(userNumber > largest) {
				secondLargest = largest;
				largest = userNumber;
				}
			else if (userNumber > secondLargest) {
				secondLargest = userNumber;
			}
		}
		println("The largest value is " + largest);
	    println("The second largest is " + secondLargest);
	}
}	

