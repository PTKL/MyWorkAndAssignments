import java.awt.*;
import javax.swing.*;
 
/** Test Absolute Positioning */
public class CGAbsolutePositioning extends JFrame {
   /** Constructor to setup the GUI components */
   public CGAbsolutePositioning() {
      Container cp = getContentPane();
      cp.setLayout(null); // disable layout manager - use absolute layout
 
      JPanel p1 = new JPanel();
      p1.setBounds(30, 30, 100, 100);
      p1.setBackground(Color.RED);
      cp.add(p1);
 
      JPanel p2 = new JPanel();
      p2.setBounds(150, 50, 120, 80);
      p2.setBackground(Color.BLUE);
      cp.add(p2);
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Absolute Positioning Demo");
      setSize(400, 200);
      setVisible(true);
   }
 
   /** The entry main method */
   public static void main(String[] args) {
      // Run GUI codes in Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new CGAbsolutePositioning(); // Let the constructor do the job
         }
      });
   }
}
