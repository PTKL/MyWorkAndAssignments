
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Test Actions which are ActionListeners that can be applied to more than one sources.
 * An action can specify the state and functionality of an ActionListener.
 */
@SuppressWarnings("serial")
public class TestAction extends JFrame {
   private JTextField tfCount;
   private int count;
 
   /** Constructor to setup the GUI */
   public TestAction() {
      // Create the Actions shared by the button and menu-item
      Action countUpAction = new CountUpAction("Count Up",
            "To count up", new Integer(KeyEvent.VK_U));
      Action countDownAction = new CountDownAction("Count Down",
            "To count down", new Integer(KeyEvent.VK_D));
      Action resetAction = new ResetAction("Reset",
            "To reset to zero", new Integer(KeyEvent.VK_R));
 
      Container cp = getContentPane();
      cp.setLayout(new FlowLayout());
 
      // Create buttons
      cp.add(new JLabel("Counter: "));
      tfCount = new JTextField("0", 8);
      tfCount.setHorizontalAlignment(JTextField.RIGHT);
      cp.add(tfCount);
      JButton btnCountUp = new JButton();
      cp.add(btnCountUp);
      JButton btnCountDown = new JButton();
      cp.add(btnCountDown);
      JButton btnReset = new JButton();
      cp.add(btnReset);
      // Set actions for buttons
      btnCountUp.setAction(countUpAction);
      btnCountDown.setAction(countDownAction);
      btnReset.setAction(resetAction);
 
      // Create menu-bar
      JMenuBar menuBar = new JMenuBar();
      JMenu menu;
      JMenuItem menuItem;;
 
      // Create the first menu
      menu = new JMenu("Count");
      menu.setMnemonic(KeyEvent.VK_C);
      menuItem = new JMenuItem(countUpAction);   // allocate menu-item and set action
      menu.add(menuItem);
      menuItem = new JMenuItem(countDownAction); // allocate menu-item and set action
      menu.add(menuItem);
      menuBar.add(menu);
 
      // Create the second menu
      menu = new JMenu("Reset");
      menu.setMnemonic(KeyEvent.VK_R);
      menuItem = new JMenuItem(resetAction);  // allocate menu-item and set action
      menu.add(menuItem);
      menuBar.add(menu);
 
      setJMenuBar(menuBar); // "this" JFrame sets menu-bar
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Action Test");
      setSize(550, 120);
      setVisible(true);
   }
 
   /**
    * Action inner classes
    */
   public class CountUpAction extends AbstractAction {
      /** Constructor */
      public CountUpAction(String name, String shortDesc, Integer mnemonic) {
         super(name);
         putValue(SHORT_DESCRIPTION, shortDesc);
         putValue(MNEMONIC_KEY, mnemonic);
      }
 
      @Override
      public void actionPerformed(ActionEvent e) {
         ++count;
         tfCount.setText(count + "");
      }
   }
 
   public class CountDownAction extends AbstractAction {
      /** Constructor */
      public CountDownAction(String name, String shortDesc, Integer mnemonic) {
         super(name);
         putValue(SHORT_DESCRIPTION, shortDesc);
         putValue(MNEMONIC_KEY, mnemonic);
      }
 
      @Override
      public void actionPerformed(ActionEvent e) {
         --count;
         tfCount.setText(count + "");
      }
   }
 
   public class ResetAction extends AbstractAction {
      /** Constructor */
      public ResetAction(String name, String shortDesc, Integer mnemonic) {
         super(name);
         putValue(SHORT_DESCRIPTION, shortDesc);
         putValue(MNEMONIC_KEY, mnemonic);
      }
 
      @Override
      public void actionPerformed(ActionEvent e) {
         count = 0;
         tfCount.setText(count + "");
      }
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      // Run GUI codes in the Event-Dispatching thread for thread safety
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new TestAction();  // Let the constructor does the job
         }
      });
   }
}
