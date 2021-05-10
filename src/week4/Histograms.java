package week4;

/** 
 * This program reads a list of exam scores, with one score per line.
 * Then it displays a histogram of those scores, divided into the
 * ranges 0–9, 10–19, 20–29, and so on, up to the range containing
 * only the value 100. 
 *  
 * @author Irina Babkina
 * 
 */


//import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.*;
import acm.util.*;


import acm.program.ConsoleProgram;

public class Histograms extends ConsoleProgram {
	
	String fileName = "MidtermScores.txt";
	int[] scores = new int[0];
	int[] histogramArr;
	
	public void run() {
		
		initializeHistogram(); 
		readScoresIntoHistogram(); 
		displayHistogram();
	}	
		
	/* Initializes the histogram array */ 
	private void initializeHistogram() {
		histogramArr = new int[11]; 
		for (int i = 0; i <= 10; i++) {
			histogramArr[i] = 0; 
		}
	}	
		
	/* Reads the exam scores, updating the histogram */ 
	private void readScoresIntoHistogram() {	
		try {
			BufferedReader rd = new BufferedReader(new FileReader(fileName));
			while(true) {
				String line = rd.readLine();
				if(line == null) break;
				
				int score = Integer.parseInt(line); 
				if (score < 0 || score > 100) {
					throw new ErrorException("This score is out of range!");
				}
				else {
					int range = score / 10;
					histogramArr[range]++;
				}
				//scores = addElementToArray(score, scores);				
			}	

			rd.close();
		}

		catch(IOException e) {
			println("IO Exception");
		}
	}
	
	/* Displays the histogram */ 
	private void displayHistogram() {
		for (int range = 0; range <= 10; range++) { 
			String label;
			switch (range) {
				case  0: 
					label = "00-09"; 
					break;
				case 10:
					label = "  100";
					break;
				default:
					label = (10 * range) + "-" + (10 * range + 9);
					break;
			}
		
			String stars = createStars(histogramArr[range]);
			println(label + ": " + stars); 
		}
	}
	
	/* Creates a string consisting of n stars */ 
	private String createStars(int n) {
		String stars = "";
		for (int i = 0; i < n; i++) {
		stars += "*"; 
		}
		return stars; 
	}
	
	
//	private int[] addElementToArray(int element, int[] scores) {
//		
//		int[] temp = new int[scores.length + 1];
//		for(int i = 0; i < scores.length; i++) {
//			temp[i] = scores[i];
//			//println(temp[i]);
//		}
//		temp[temp.length - 1] = element;
//		//println(temp[temp.length - 1]);
//		scores = temp;
//		return scores;
//	}
	
}
