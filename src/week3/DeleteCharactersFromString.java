package week3;

/** 
 * This program removes all occurrences of the specified character from the specified string.
 * 
 * @author Irina Babkina
 * 
 */

import acm.program.ConsoleProgram;

public class DeleteCharactersFromString extends ConsoleProgram {
	
	public void run() {
		
		println(removeAllOccurrences("This is a test", 't'));  	// returns "This is a es"
		println(removeAllOccurrences("Summer is here!", 'e')); 	// returns "Summr is hr"
		println(removeAllOccurrences("---0---", '-'));			// returns "0"

	}
	
	public String removeAllOccurrences(String str, char ch) {
		String newStr = " ";
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ch) {
				continue;
			}
			newStr += str.charAt(i);
		}
		return newStr;
	}	
}
