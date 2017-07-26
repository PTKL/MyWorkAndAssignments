import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;


public class RestaurantTester {

	/**
	 * @author - emil
	 * Tester runs the GUI program
	 * Handles exceptions
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		try{
		
			File inputFile = new File(JOptionPane.showInputDialog("Enter Restaurant MenuView (menu.txt)"));
			
			MainFrame guiFrame = new MainFrame(inputFile);
		}
		
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error! MenuView File not found!", "Please reinput", JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception e) {
		
			JOptionPane.showMessageDialog(null, "Error! Program terminated"
					 , " Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

}
