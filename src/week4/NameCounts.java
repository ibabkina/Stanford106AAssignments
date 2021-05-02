package week4;

/** 
 * This program reads a list of names from the user and displays 
 * how many times each name appeared in the list.
 *  
 * @author Irina Babkina
 * 
 */

import acm.program.ConsoleProgram;
import java.util.*;

public class NameCounts extends ConsoleProgram {
	
	public void run() {
		HashMap<String,Integer> nameMap = new HashMap<String,Integer>();
		      readNames(nameMap);
		      printMap(nameMap);
	}
	
	/*
	* Reads a list of names from the user, storing names in the map that is 
	* passed in as a parameter. Also counts how many times each name appeared. 
	*/
	private void readNames(Map<String,Integer> map) { 
		while (true) {
			String name = readLine("Enter name: ");
			if (name.equals("")) 
				break;
	
	// Check if that name previously appeared in the map. Update 
	// count if it did, or create a new count if it didn't.
			Integer count = map.get(name);
			if (count == null) {
				count = 1;
			} 
			else {
				count++;
			}
			map.put(name, count);
		}
	}
	
	/*
	* Prints out a list of entries (and associated counts) from the map 
	* that is passed in as a parameter.
	*/
	private void printMap(Map<String,Integer> map) { 
		Iterator<String> it = map.keySet().iterator(); 
		while (it.hasNext()) {
			String key = it.next();
			int count = map.get(key);  
			println("Entry [" + key + "] has count " + count);
		}
	}
}