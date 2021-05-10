package week5;

/** 
 * This program reads in a file containing flight destinations from various cities, 
 * and then allow the user to plan a round-trip flight route.
 * 
 * @author Irina Babkina
 * 
 */

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;

public class FlightPlanner extends ConsoleProgram {
	
	private HashMap<String, ArrayList<String>> flights; 
	
	public void run() {
		println("Welcome to Flight Planner!");
		readFile("flights.txt");
		println("\nHere is a list of all the cities in our database: ");
		displayDepartureCities();
		println("\nLet's plan a round-trip route!");
		String startCity = (readLine("\nEnter the starting city: ")).trim();
		startCity = handleStartCity(startCity);
		ArrayList<String> trip = new ArrayList<String>();
		trip.add(startCity);
		String currentCity = startCity;
		while(true) {
			String nextCity = getNextCity(currentCity);	
			trip.add(nextCity);
			if (nextCity.equals(startCity)) { break; }
			currentCity = nextCity;
		}
		displayTrip(trip);
	}	
	
	private String getNextCity(String city) {
		
		String nextCity = null;
		while(true) {
			displayFlights(city);
			nextCity = (readLine("\nWhere do you want to go from " + city + "? ")).trim();
			if(flights.containsKey(nextCity)) { break; }
			println("You can't get to that city by a direct flight.");
		}
		return nextCity;	
	}
		
	private String handleStartCity(String startCity) {
	
		while(startCity == "" || !flights.containsKey(startCity)) { 
			println("Incorrect Input.");
			displayDepartureCities();
			startCity = (readLine("\nEnter the starting city: ")).trim();
		}
		return startCity;
	}	
		
	private void displayFlights(String fromCity) {
		println("\nFrom: " + fromCity + " you can fly directly to: ");
		// Read values Using an iterator
		Iterator<String> itr2 = flights.get(fromCity).listIterator();
		while (itr2.hasNext()) { println(itr2.next()); }
	}
	
	private void displayDepartureCities() { //(ArrayList<String> list) {
		Iterator<String> itr1 = flights.keySet().iterator();
		while (itr1.hasNext()) { println(" " + itr1.next()); }
	}
	
	private void displayTrip(ArrayList<String> trip) { 
		println("The route you've chosen is: ");
		// Read keys Using an iterator
		Iterator<String> itr1 = trip.iterator();
		String route = "";
		while (itr1.hasNext()) { 
			route += (itr1.next() + " -> ");
        }
		route = route.substring(0,(route.length() - 3));	
		print(route); 
	}
	
	private void readFile(String filePath) {	
		flights = new HashMap<String,ArrayList<String>>(); 
		try {
			File file = new File(filePath);
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
//				if(line == null) break;
				if(line.length() > 0) {
					String[] segments = line.split(" -> ");
					String city = segments[0];
					String destination = segments[segments.length-1];
					addToFlights(city, destination); 
				}
			}	
			sc.close(); 
		}
		catch(IOException e) {
			println("IO Exception");
		}
		catch(ErrorException e) {
			println("ErrorException");
		}
	}

	private void addToFlights(String city, String destination) {
		ArrayList<String> destinations = flights.get(city);
		// if list does not exist create it
		if(destinations == null) { //key isn't in the map
			destinations = new ArrayList<String>();
			destinations.add(destination);
			flights.put(city, destinations);
		}
		// add if item is not already in list
		else {	
			if(!destinations.contains(destination)) { destinations.add(destination); }
		}	
	}	
}