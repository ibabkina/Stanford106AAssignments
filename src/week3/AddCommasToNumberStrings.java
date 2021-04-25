package week3;

/** 
 * This program takes a string of decimal digits representing a number and returns the string
 * formed by inserting commas at every third position, starting on the right. 
 *  
 * @author Irina Babkina
 * 
 */

import acm.program.ConsoleProgram;

public class AddCommasToNumberStrings extends ConsoleProgram {
	
	public void run() {
        while (true) {
        	String digits = readLine("Enter a numeric string: "); 
        	if (digits.length() == 0) break; 
        	println(addCommasToNumericString(digits));
        }
	}
	
	private String addCommasToNumericString(String digits) {
		if(digits.charAt(0) == '0' && digits.length() > 1) {
			return "Please do not include 0's in front of your numeric string if your string is greater than one character!";
		}
		
		String newStr = " ";
		newStr += digits.charAt(0);
		for(int i = 1; i < digits.length(); i++) {
			if((digits.length() - i) % 3 == 00 && (digits.length() - i) > 0) {
				newStr += ","; 
			}
			newStr += digits.charAt(i);
		}	
		return newStr;
	}	
}
