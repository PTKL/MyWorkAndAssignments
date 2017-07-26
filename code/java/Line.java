


import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Line extends Applet implements MouseMotionListener {

	int x1 = 20;  //initial coordinates for the line
	int y1 = 20;
	int x2 = 200;
	int y2 = 150;
	
	public void init() {
		
		
		setBackground(new Color(1f,1f,5f));  pale yellow background
		addMouseMotionListener(this);  //we will listen for the mouse being dragged
		repaint();
	}
	
	public void paint( Graphics g ) {
		g.drawLine(x1,y1,x2,y2);   //draw the line from (x1,y1) to (x2,y2)
		//display the command used to draw the line
		g.drawString("g.drawLine("+x1+","+y1+","+x2+","+y2+");",5,getSize().height-5);
	}
	
	public double dist(int x1, int y1, int x2, int y2) {  
		//find the Euclidean distance between (x1,y1) and (x2,y2)
		return
		   Math.sqrt(Math.pow((double)x1 - (double)x2,2) + Math.pow((double)y1 - (double)y2,2));
	}
	
	public void mouseDragged(MouseEvent me) {
		//this method is called by the system whenever the mouse is dragged
		int currentX = me.getX();  //get current location of mouse as its being dragged
		int currentY = me.getY();
		//change the coordinates of whichever end of the line the mouse is closest to
		if(dist(currentX,currentY,x1,y1) < dist(currentX,currentY,x2,y2)) {
			x1 = currentX;
			y1 = currentY;
		}
		else {
			x2 = currentX;
			y2 = currentY;
		}
		repaint();
	}
	
	public void mouseMoved(MouseEvent me) {
		//system calls this method whenever mouse is moved without being dragged
		//we don't want to process such calls, so this is an empty placeholder method
		
	}

}
