import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
/** Counter with JRadioButton and JComboBox */
@SuppressWarnings("serial")
public class SwingCounterRadioCombo extends JFrame {
   private JTextField tfCount;
   private int count = 0;  // counter's value
   private boolean countingUp = true; // counting up or down
   private int step = 1;   // increment step size
 
   /** Constructor to setup the UI */
   public SwingCounterRadioCombo () {
      Container cp = getContentPane();
      cp.setLayout(new FlowLayout());
 
      // Create JLabel and JTextField
      cp.add(new JLabel("Counter:"));
      tfCount = new JTextField("0", 5);
      tfCount.setEditable(false);
      tfCount.setHorizontalAlignment(JTextField.RIGHT);
      cp.add(tfCount);
 
      // Create JRadioButton for counting up and down
      JRadioButton rbUp = new JRadioButton("Up", true);
      rbUp.setMnemonic(KeyEvent.VK_U);
      cp.add(rbUp);
      rbUp.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            countingUp = true;
         }
      });
      JRadioButton rbDown = new JRadioButton("Down", true);
      rbDown.setMnemonic(KeyEvent.VK_D);
      cp.add(rbDown);
      rbDown.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            countingUp = false;
         }
      });
      // Setup a ButtonGroup to ensure exclusive selection
      ButtonGroup btnGp = new ButtonGroup();
      btnGp.add(rbUp);
      btnGp.add(rbDown);
 
      // Create JComboBox for setting the count step size
      add(new JLabel("Step:"));
      final Integer[] steps = {1, 2, 3, 4, 5};  // auto-upcast
      final JComboBox<Integer> comboCount = new JComboBox<Integer>(steps);
      comboCount.setPreferredSize(new Dimension(60, 20));
      cp.add(comboCount);
      comboCount.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
               step = (Integer)comboCount.getSelectedItem();
            }
         }
      });
 
      // Create JButton for "Count"
      JButton btnCount = new JButton("Count");
      btnCount.setMnemonic(KeyEvent.VK_C);
      cp.add(btnCount);
      btnCount.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (countingUp) {
               count += step;
            } else {
               count -= step;
            }
            tfCount.setText(count + "");
         }
      });
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Swing Counter with RadioButton & ComboBox");
      setSize(480, 100);
      setVisible(true);
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      // Run the GUI codes in the Event-Dispatching thread for thread-safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new SwingCounterRadioCombo(); // Let the constructor do the job
         }
      });
   }
}
