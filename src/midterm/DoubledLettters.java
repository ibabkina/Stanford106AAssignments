package midterm;

import acm.program.ConsoleProgram;

public class DoubledLettters extends ConsoleProgram {
	
	public void run() {
		
		while (true) {
			String word = readLine("Enter a word: "); 
			if (word.equals("")) {
				break;
			}
			println("After doubled letters replaced by a single letter: ");
			println(removeDoubledLetters(word));		
		}
	}


	private String removeDoubledLetters(String oldWord) {
		String updatedWord = "";
		for(int i = 0; i < oldWord.length(); i++) {
			if(i == 0 || oldWord.charAt(i) != oldWord.charAt(i-1)) {
				updatedWord += oldWord.charAt(i); 
			}
		}
		return updatedWord;
	}
}
