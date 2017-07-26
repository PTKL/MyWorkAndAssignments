/////// THIS IS A PROGRAM FOR CONWAY'S GAME OF LIFE FOR MORE INFORMATION ON THE GAME VISIT http://en.wikipedia.org/wiki/Conway%27s_Game_of_Life  //////////
/////// rulues of the game //////
/*1. A filled cell with fewer than two filled neighbors dies through loneliness and is empty in the next generation.

 2. A filled cell with more than three filled neighbors dies through over-crowding, and is empty in the next generation.

 3. An empty cell with exactly three filled neighbors ‘gives birth’ and is filled in the next generation.

 4. Filled cells with two or three neighbors live on to the next generation. */

import java.awt.*;

import javax.swing.*;

import java.util.*;
import java.util.Timer;

@SuppressWarnings("serial")
public class LifeGrid extends Canvas {

	public static void printf(String text) { // shortening System.out.println()
												// to just printf() for easy
												// access and
												// faster typing

		System.out.print(text);

	}

	/*static {
		printf("Enter a value to set the size of the grid: ");
	}*/
	
	static String str1 = JOptionPane.showInputDialog("Enter a value to set the size of the grid: "); // the dialog displayed in the pop up window giving the user instructions
	static int gridSize = (int) Double.parseDouble(str1);
	int[][] oldGen = new int[gridSize + 1][gridSize + 1]; // array for the old
															// generation
	int[][] newGen = new int[gridSize + 1][gridSize + 1]; // array for the new
															// generation

	// int[][] oldGen and int[][] newGen constantly change to display the update
	// for the "living cells"

	public LifeGrid() { // filling int[][] Old with the data for the x
						// coordinate and cell status
		Random rand = new Random();
		for (int xCoord = 0; xCoord < gridSize; xCoord++) {
			for (int status = 0; status < gridSize; status++) {
				oldGen[xCoord][status] = rand.nextInt(2);
			}
		}
	}

	public void paint(Graphics graphics) { // creating the graphical
											// representation
		for (int xCoord = 0; xCoord < gridSize; xCoord++) {
			for (int status = 0; status < gridSize; status++) {
				if (oldGen[xCoord][status] == 1) {
					Color color = new Color(0, 0, 0);
					graphics.setColor(color);
					graphics.fillOval(xCoord * 10, status * 10, 10, 10);
				} /*else {
					Color color = new Color(0, 0, 0);
					graphics.setColor(color);
					graphics.fillRect(xCoord * 10, status * 10, 10, 10);
				}*/
			}
		}
	}

	public void Generations() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new Neighbours(), 100, 100); // timer for
		// refreshing the
		// grid
	}

	class Neighbours extends TimerTask { // cheking the status of the
											// neighbouring cells

		public void run() {

			for (int countX = 0; countX < gridSize; countX++) {
				for (int countY = 0; countY < gridSize; countY++) {
					int neighboursCount = 0;

					for (int x_offset = -1; x_offset < 2; ++x_offset) {
						for (int y_offset = -1; y_offset < 2; ++y_offset) {
							int new_x = countX + x_offset;
							int new_y = countY + y_offset;

							if ((x_offset == 0 && y_offset == 0)
									|| (new_x > gridSize || new_y > gridSize)
									|| (new_x < 0 || new_y < 0))
								continue;

							if (oldGen[new_x][new_y] == 1)
								neighboursCount++;
						}
					}

					// rules for determining cell life status
					if (oldGen[countX][countY] == 1
							& (neighboursCount == 2 | neighboursCount == 3)) {
						newGen[countX][countY] = 1;
					} else if (oldGen[countX][countY] == 0
							& neighboursCount == 3) {
						newGen[countX][countY] = 1;
					} else {
						newGen[countX][countY] = 0;
					}

				}
			}

			for (int countX = 0; countX < gridSize; countX++) {
				{
					for (int countY = 0; countY < gridSize; countY++) {
						{
							oldGen[countX][countY] = newGen[countX][countY];
						}
					}

					repaint();
				}
			}
		}
	}

	public static void main(String[] args) {

		LifeGrid canvas = new LifeGrid();
		JFrame frame = new JFrame();
		frame.setTitle("CONWAY'S GAME OF LIFE");
		frame.setSize((gridSize * 10), (gridSize * 10));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(canvas);
		frame.setVisible(true);
		canvas.Generations();
	}

}