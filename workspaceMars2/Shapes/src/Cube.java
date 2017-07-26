// George Distler

// Draw a rotating cube

import java.awt.*;
import java.awt.event.*;

public class Cube extends BufferedApplet implements KeyListener
{
	// GEOMETRY - YOU'LL WANT TO REPLACE THIS WITH YOUR OWN SHAPES.

	private Matrix3D matrix;

	boolean rotate = false;
	boolean translate = false;

	int[] xpoints =  new int[4];
	int[] ypoints = new int[4];

	double cube[][][] = {
			// back
			{{0,0,0}, {1,0,0}, {1,1,0}, {0,1,0}, {0,0,0}},

			// front
			{{.5,-.5,0}, {.5,.5,0}, {1.5,.5,0}, {1.5,-.5,0}, {.5,-.5,0}},

			// left
			{{0,0,0}, {.5,-.5,0}, {.5,.5,0}, {0,1,0}, {0,0,0}},

			// bottom
			{{0,0,0}, {1,0,0}, {1.5,-.5,0}, {.5,-.5,0}, {0,0,0}},

			// top
			{{0,1,0}, {1,1,0}, {1.5,.5,0}, {.5,.5,0}, {0,1,0}},

			// right
			{{1,1,0}, {1.5,.5,0}, {1.5,-.5,0}, {1,0,0}, {1,1,0}},

	};

	double a[] = {0,0,0}, b[] = {0,0,0};
	int w, h, count = 0;
	double t = 0,u=0;

	public void init() 
	{
		super.init();
		matrix = new Matrix3D();
		addKeyListener(this);

		// YOU MIGHT WANT TO CREATE YOUR MATRIX OBJECTS HERE
	}

	public void render(Graphics g) 
	{

		w = bounds().width;                         // FIND OUT HOW BIG THE APPLET WINDOW IS
		h = bounds().height;

		g.setColor(Color.white);                    // MAKE A CLEAR WHITE BACKGROUND
		g.fillRect(0,0,w,h);

		g.setColor(Color.blue);                    // SET THE DRAWING COLOR TO BLACK

		animate();                                  // DO ANIMATION CALCULATIONS

		for (int i = 0 ; i < cube.length ; i++)   // LOOP THROUGH ALL THE SHAPES
			for (int j = 1 ; j < cube[i].length ; j++) 
			{ 											// LOOP THROUGH ALL THE LINES IN THE SHAPE
				transform(cube[i][j-1], a);                      // TRANSFORM BOTH ENDPOINTS OF LINE
				transform(cube[i][j  ], b);
				g.drawLine(x(a[0]), y(a[1]), x(b[0]), y(b[1]));    // DRAW ONE LINE ON THE SCREEN
			}

		animating = true;
	}

	void animate() 
	{
		////////// REPLACE THIS CODE BY A SEQUENCE OF TIME-VARYING MATRIX OPERATIONS //////////

		t = .1 + .3 * Math.sin(.1 * count++);       // VARY PARAMETERS TO CONTROL THE ANIMATION
		u = 2 * Math.sin(.1 * count++); 


		matrix.identity();
		if(rotate)
		{  
			matrix.rotateZ(u*.5);
		}
		if(translate)
		{
			matrix.translate(0,t*2,0);
		}
		matrix.scale(t*2, t*2, 0);
		//matrix.scale(.25, .25, 0);
		//matrix.scale(0,0,t*.5);
		//matrix.translate(0,t*-.5,0);
		///////////////////////////////////////////////////////////////////////////////////////
	}

	int x(double t) { return w/2 + (int)(t*w/4); } // CONVERT X COORDINATE TO SCREEN PIXELS
	int y(double t) { return h/2 - (int)(t*w/4); } // CONVERT Y COORDINATE TO SCREEN PIXELS

	void transform(double src[], double dst[]) 
	{

		///////// REPLACE THIS CODE WITH A METHOD CALL TO TRANSFORM THE POINT BY YOUR MATRIX		

		matrix.transform(src, dst);
		////////////////////////////////////////////////////////////////////////////////////
	}

	public void keyPressed(KeyEvent e)
	{
		// press Left to rotate, press right to stop
		int code = e.getKeyCode();

		switch(code)
		{
		case KeyEvent.VK_LEFT:
			rotate = true;
			break;

		case KeyEvent.VK_RIGHT:
			rotate = false;
			break;

		case KeyEvent.VK_UP:
			translate = true;
			break;

		case KeyEvent.VK_DOWN:
			translate = false;
			break;

		default:
			// nothing
		}
	}

	public void keyReleased(KeyEvent e)
	{
		// empty method from KeyListener interface
	}

	public void keyTyped(KeyEvent e)
	{
		// empty method from KeyListener interface
	}
}

