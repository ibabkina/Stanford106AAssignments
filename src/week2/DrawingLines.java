package week2;

/**
 * This program allows users to draw lines on the canvas. Pressing the mouse button
 * sets the starting point for the line. Dragging the mouse moves the other
 * endpoint around as the drag proceeds. Releasing the mouse fixes the line
 * in its current position and gets ready to start a new line. If users then move 
 * the mouse downward without releasing the button, the displayed line will track
 * the mouse.
 * 
 *  @author Irina Babkina
 * 
 */

import acm.graphics.GLine;
import acm.program.GraphicsProgram;
import java.awt.event.*;

public class DrawingLines extends GraphicsProgram {
	
	/* Instance variables */
	GLine line;
	
	/* Note: no run() method in this program */
	
	/* Called when the program starts */
	public void init() {
		addMouseListeners();
		//addMouseMotionListener(this);
	}
	
	/* Called every time user presses mouse, and sets starting point of line */
	public void mousePressed(MouseEvent e) {
		line =  new GLine(e.getX(), e.getY(), e.getX(), e.getY());
		add(line); 
		}
	
	/* Called on mouse drag to reposition the end point of line */
	public void mouseDragged(MouseEvent e) {
		   line.setEndPoint(e.getX(),e.getY());
	}
}
