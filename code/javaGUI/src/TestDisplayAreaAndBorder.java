import java.awt.*;
import javax.swing.*;

// A Swing application inherits from top-level container javax.swing.JFrame 
public class TestDisplayAreaAndBorder extends JFrame {
   /** Constructor to setup the GUI */
   public TestDisplayAreaAndBorder() {
      Container cp = getContentPane();
      cp.setLayout(new FlowLayout());
 
      JTextArea comp = new JTextArea(10, 25);  // row and columns
      comp.setBackground(new Color(200, 200, 200));
      comp.setForeground(Color.BLUE);
      comp.setBorder(BorderFactory.createLineBorder(Color.CYAN, 15));
            // set border to line-border with the given color and thickness
      comp.setPreferredSize(new Dimension(350, 200));
      cp.add(comp);
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Appearance and Border");
      setSize(400, 300);
      setVisible(true);
 
      StringBuffer msg = new StringBuffer();
      msg.append("Width = " + comp.getWidth());
      msg.append("\nHeight = " + comp.getHeight());
      msg.append("\nOrigin-X = " + comp.getX());
      msg.append("\nOrigin-Y = " + comp.getY());
      msg.append("\nOrigin-X (on screen) = " + comp.getLocationOnScreen().x);
      msg.append("\nOrigin-Y (on screen) = " + comp.getLocationOnScreen().y);
 
      Insets insets = comp.getInsets();
      msg.append("\nInsets (top, right, bottom, left)  = "
         + insets.top + "," + insets.right + "," + insets.bottom + "," + insets.left);
      msg.append("\nReal Width  = " + (comp.getWidth() - insets.left - insets.right));
      msg.append("\nReal Height  = " + (comp.getHeight() - insets.top - insets.bottom));
 
      comp.setText(msg.toString());
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      // Run the GUI codes on Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new TestDisplayAreaAndBorder(); // Let the constructor do the job
         }
      });
   }
}
