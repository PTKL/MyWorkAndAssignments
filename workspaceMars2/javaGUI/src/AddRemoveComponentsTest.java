import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
/** Add or remove components from a container */
@SuppressWarnings("serial")
public class AddRemoveComponentsTest extends JFrame {
   private int numButtons = 2; // number of buttons, init to 2 (1 add, 1 remove)
   Container cp;               // content-pane of JFrame
   JButton[] buttons;          // array of buttons
   ButtonsListener listener;   // an ActionListener instance for all buttons
 
   /** Constructor to setup the UI components */
   public AddRemoveComponentsTest() {
      cp = getContentPane();
 
      // Create an instance of ActionListener to listen to all Buttons
      listener = new ButtonsListener();
      // Call helper method to create numButtons buttons
      createButtons();
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Add/Remove Components Test");
      setSize(400, 150);
      setLocationRelativeTo(null);
      setVisible(true);
   }
 
   /** Create numButtons buttons on content-pane with FlowLayout */
   private void createButtons() {
      // For demonstration, all the components are removed, instead of
      //  add or remove selected component.
      cp.removeAll();
      cp.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
 
      // Create buttons
      buttons = new JButton[numButtons];  // allocate array
      int i = 0;
      // Create (numButtons-1) "Add" buttons, but minimum one
      do {
         buttons[i] = new JButton("Add");
         cp.add(buttons[i]);
         buttons[i].addActionListener(listener);
         ++i;
      } while (i < numButtons - 1);
      // Create a "Remove" button if numButtons > 1
      if (i == numButtons - 1) {
         buttons[i] = new JButton("Remove");
         cp.add(buttons[i]);
         buttons[i].addActionListener(listener);
      }
      cp.validate(); // needed after adding/removing component
      repaint();     // needed to cleanup dirty background
   }
 
   /** Inner class used as the ActionListener for the Buttons */
   private class ButtonsListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         // adjust the number of buttons
         if (e.getActionCommand().equals("Add")) {
            ++numButtons;
         } else {
            if (numButtons >= 2) {
               --numButtons;
            }
         }
         // Call helper method to create numButtons buttons
         createButtons();
      }
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      // Run GUI codes in the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new AddRemoveComponentsTest();  // Let the constructor do the job
         }
      });
   }
}
