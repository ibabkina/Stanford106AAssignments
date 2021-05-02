package week4;

/** 
 * This program reads a file and reports how many lines, words,
 * and characters appear in it. It does not not count the characters that mark 
 * the end of a line, which will have different values depending on the type of computer.
 *  
 * @author Irina Babkina
 * 
 */

import java.io.*;
import java.util.*;
import acm.program.ConsoleProgram;


public class WordCount extends ConsoleProgram {
	
	public void run() {
		String fileName = "lear.txt";
		int lineCount = 0;
		int numOfWords = 0;
		int numOfChars = 0;
		
		try {
			BufferedReader rd = new BufferedReader(new FileReader(fileName));
			while(true) {
				String line = rd.readLine();
				if(line == null) break;
				lineCount++;
				//println(line);
				numOfChars += charCount(line);
				numOfWords += wordCount(line);
			}	
			rd.close();
			println("File: " + fileName);
			println("Lines = " + lineCount);
			println("Words = " + numOfWords);
			println("Chars = " + numOfChars);
		}

		catch(IOException e) {
			println("IO Exception");
		}
	}
			
	int charCount(String line) {
		int num = 0;
			
		for(char ch: line.toCharArray()) {
			num++; 
		}

		return num;
	}
	
	int wordCount(String line) {
		int num = 0;
		StringTokenizer tokenizer = new StringTokenizer(line, ",.?!'\n\r ");
		//println("line in wordCount: " + line);
		while (tokenizer.hasMoreTokens()) {
			tokenizer.nextToken(); //println("nextToken is: " + tokenizer.nextToken());
			num++; 
		}
		return num;
	}
	
}

