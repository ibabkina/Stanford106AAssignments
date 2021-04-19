package week2;

/** 
 * This program displays the terms in the Fibonacci sequence, starting with 0 and 1,
 * and continuing as long as the terms are less than 10,000.
 *  
 * @author Irina Babkina
 *   
 */

import java.awt.Color;

import acm.program.*;

public class Fibonacci extends ConsoleProgram {
	
	private static final int FIB_0 = 0;
	private static final int FIB_1 = 1;
	private static final int SENTINEL = 10000;
	
	public void run() {
		int term1 = FIB_0;
		int term2 = FIB_1;
		//int term;
		
		println("This program lists the Fibonacci sequence." 
			+ "\n" + FIB_0
			+ "\n" + FIB_1 );
		
/*		term = nextFibonacii(FIB_0, FIB_1);
		
		while (term < MAX_TERM_VALUE){
			System.out. println(term);
			term = nextFibonacii(term1, term2);
			term1 = term2;
			term2 = term;	
		}  	
		*/
		
		while (true){   // to try Loop-and-a-Half instead of while loop
			int term = nextFibonacii(term1, term2);
			if (term >= SENTINEL) break;
			println(term);
			//term = nextFibonacii(term1, term2);
			term1 = term2;
			term2 = term;	
		}  
	}
	private int nextFibonacii(int term1, int term2) {
		return term1+term2;
	}	
		
		


}
