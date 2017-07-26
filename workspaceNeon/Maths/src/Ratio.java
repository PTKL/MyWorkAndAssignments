import javax.swing.*;

public class Ratio {
	
	public static void main(String args[]) {
		do {
		String str1 = JOptionPane.showInputDialog("Enter index finger length");
		String str2 = JOptionPane.showInputDialog("Enter ring finger length");
		double fn = Double.parseDouble(str1);
		double sn = Double.parseDouble(str2);
		JOptionPane.showMessageDialog(null, "The Ratio is " + fn / sn,
				"Ratio", JOptionPane.INFORMATION_MESSAGE);
		} while (true);
	}
}
