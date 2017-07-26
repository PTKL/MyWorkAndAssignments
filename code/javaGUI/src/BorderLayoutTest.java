import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
/** BorderLayout Demo */
@SuppressWarnings("serial")
public class BorderLayoutTest extends JFrame {
   public static final String TITLE = "BorderLayout Demo";
 
   // Private variables of GUI components
   private Container cp;  // content-pane of this JFrame
   private JButton btnNorth, btnSouth, btnCenter, btnEast, btnWest;
   private boolean leftToRight = true;
 
   /** Constructor to setup the UI components */
   public BorderLayoutTest() {
      cp = this.getContentPane();
      btnNorth = new JButton("PAGE_START [HIDE]");
      btnSouth = new JButton("PAGE_END [HIDE]");
      btnWest = new JButton("LINE_START [HIDE]");
      btnEast = new JButton("LINE_END [HIDE]");
      btnCenter = new JButton("CENTER [SHOW ALL, CHANGE ORIENTATION]");
      btnCenter.setPreferredSize(new Dimension(300, 100)); // set size for CENTER
 
      ActionListener listener = new ButtonListener();
      btnNorth.addActionListener(listener);
      btnSouth.addActionListener(listener);
      btnEast.addActionListener(listener);
      btnWest.addActionListener(listener);
      btnCenter.addActionListener(listener);
 
      // Add all buttons to the content-pane
      addButtons();
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit if close button clicked
      setTitle(TITLE); // "this" JFrame sets title
      pack();  // "this" JFrame packs all its components
      setLocationRelativeTo(null);  // center the application window
      setVisible(true);             // show it
   }
 
   /** Helper method to add all buttons to the content-pane */
   private void addButtons() {
      cp.removeAll();
      cp.setComponentOrientation(leftToRight ?
            ComponentOrientation.LEFT_TO_RIGHT : ComponentOrientation.RIGHT_TO_LEFT);
      cp.add(btnNorth, BorderLayout.PAGE_START);
      cp.add(btnSouth, BorderLayout.PAGE_END);
      cp.add(btnWest, BorderLayout.LINE_START);
      cp.add(btnEast, BorderLayout.LINE_END);
      cp.add(btnCenter, BorderLayout.CENTER);
      cp.validate();
   }
 
   /** Inner class used as ActionListener for all buttons */
   private class ButtonListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent evt) {
         JButton source = (JButton)evt.getSource();
         if (source == btnCenter) {
            leftToRight = !leftToRight;  // toggle
            addButtons();
         } else {
            cp.remove(source);
            cp.validate();
         }
      }
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      // Run GUI codes in the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new BorderLayoutTest();  // Let the constructor do the job
         }
      });
   }
}
