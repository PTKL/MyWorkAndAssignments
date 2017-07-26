import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
/** Changing the LayoutManager of the Container
     between 3*2 GridLayout and 2*3 GridLayout */
@SuppressWarnings("serial")
public class SetLayoutTest extends JFrame {
   private int rows = 3;
   private int cols = 2;
   private Container cp;  // content-pane of JFrame
 
   /** Constructor to setup the UI components */
   public SetLayoutTest() {
      cp = this.getContentPane();
      cp.setLayout(new GridLayout(rows, cols, 3, 3));
 
      // Create an instance of ActionListener to listen to all Buttons
      ButtonsListener listener = new ButtonsListener();
 
      // Create rows*cols Buttons and add to content-pane
      JButton[] buttons = new JButton[rows * cols];
      for (int i = 0; i < buttons.length; ++i) {
         buttons[i] = new JButton("Click [" + (i+1) + "]");
         cp.add(buttons[i]);
         buttons[i].addActionListener(listener);
      }
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("setLayout() Test");
      setSize(280, 150);
      setLocationRelativeTo(null);  // center the application window
      setVisible(true);
   }
 
   /** Inner class used as the ActionListener for the Buttons */
   private class ButtonsListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         // Swap rows and cols
         int temp = rows;
         rows = cols;
         cols = temp;
 
         // Set to new rows-by-cols GridLayout
         cp.setLayout(new GridLayout(rows, cols, 5, 5));
         cp.validate();  // ask LayoutManager to re-layout
      }
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      // Run GUI codes in the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new SetLayoutTest();  // Let the constructor do the job
         }
      });
   }
}

/*
 * @Override
public void actionPerformed(ActionEvent e) {
   // Swap rows and cols
   int temp = rows;
   rows = cols;
   cols = temp;
 
   GridLayout layout = (GridLayout)cp.getLayout();
   layout.setRows(rows);
   layout.setColumns(cols);
   cp.doLayout();
}*/
