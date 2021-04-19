package week2;

/** 
 * This program draws a robot face using GRects and GOvals, with constant dimensions and
 * centered in the graphics window.
 *  
 * @author Irina Babkina
 * 
 */

import java.awt.Color;

import javax.swing.border.*;

import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class RobotFace extends GraphicsProgram {

/* Constants specifying sizes in pixels */	
	private static final double HEAD_WIDTH = 250;
	private static final double HEAD_HEIGHT = 400;
	private static final double EYE_RADIUS = 20.0;
	private static final double MOUTH_WIDTH = 150;
	private static final double MOUTH_HEIGHT = 40;
	private static final Color HEAD_COLOR = Color.GRAY;
	private static final Color EYE_COLOR = Color.YELLOW;
	private static final Color MOUTH_COLOR = Color.WHITE;

/* Instance variables */
	private GRect head;
	private GOval leftEye;
	private GOval rightEye;
	private GRect mouth;
	
	public void run() {
		double x = getWidth() / 2;	// center of x-axis
		double y = getHeight() / 2;	// center of y-axis
		head = createHead(HEAD_WIDTH, HEAD_HEIGHT, HEAD_COLOR);
		add(head, x - HEAD_WIDTH / 2, y - HEAD_HEIGHT / 2);
		leftEye = createEye(EYE_RADIUS * 2, EYE_RADIUS * 2, EYE_COLOR);
		add(leftEye, x - HEAD_WIDTH / 4 - EYE_RADIUS, y - HEAD_HEIGHT / 4 - EYE_RADIUS); 
		rightEye = createEye(EYE_RADIUS * 2, EYE_RADIUS * 2, EYE_COLOR);
		add(rightEye, x + HEAD_WIDTH / 4 - EYE_RADIUS, y - HEAD_HEIGHT / 4 - EYE_RADIUS);
		mouth = createMouth(MOUTH_WIDTH, MOUTH_HEIGHT, MOUTH_COLOR); 
		add(mouth, x - MOUTH_WIDTH / 2, y + HEAD_HEIGHT / 4 - MOUTH_HEIGHT /2);
	}
		
	private GRect createHead(double width, double height, Color color) {
		GRect head = new GRect(width, height); 		
		head.setFilled(true);
		//head.setColor(color);
		head.setFillColor(color); // will leave a border of any object as long as 'setFilled' is true
		return head;
	}
	
	private GOval createEye(double width, double height, Color color) {	
		GOval eye = new GOval(width, height);
		eye.setFilled(true);
		eye.setColor(color);
		return eye;
	}
	   
	private GRect createMouth(double width, double height, Color color) {
		GRect mouth = new GRect(width, height); 
		mouth.setFilled(true);
		mouth.setColor(color);
		return mouth;	
	}
}
