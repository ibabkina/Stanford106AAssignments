package week2;

/** 
 * This program draws a set of ten circles with different sizes, positions, and colors. 
 * Each circle should have a randomly chosen color, a randomly chosen radius between
 * 5 and 50 pixels, and a randomly chosen position on the canvas, subject to the 
 * condition that the entire circle must fit inside the canvas without extending past
 * the edge. 
 *  
 * @author Irina Babkina
 *   
 */

import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class RandomCircles extends GraphicsProgram {
	
	private static final int NUM_CIRCLES = 10;
	private static final int MIN_RADIUS = 5;
	private static final int MAX_RADIUS = 50;
	
	public void run() {
		for (int i = 0; i < NUM_CIRCLES; i++) {
			int r = rgen.nextInt(MIN_RADIUS, MAX_RADIUS);
			GOval circle = createCircle(r, rgen.nextColor());
			add(circle, 
				rgen.nextInt(0, getWidth() - 2 * r), 
				rgen.nextInt(0, getHeight() - 2 * r)); 	
		}
	}
	
	private GOval createCircle(double r, Color color) {	
		GOval circle = new GOval(2 * r, 2 * r);
		circle.setFilled(true);
		circle.setColor(color);
		return circle;
	}
	
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
