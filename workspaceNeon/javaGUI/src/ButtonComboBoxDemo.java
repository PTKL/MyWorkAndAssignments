import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
 
/** Test JRadioButton, JCheckBox and JComboBox */
@SuppressWarnings("serial")
public class ButtonComboBoxDemo extends JFrame {
   // private variables of GUI components
   private JLabel lblForTest;
   private String imgCrossFilename = "cross.gif";
   private String lblText = "Cross";
   private Icon iconCross;
 
   private JRadioButton rbLeft, rbCenter, rbRight, rbTop, rbMiddle, rbBottom;
   private JCheckBox cbText, cbIcon;
   private JComboBox<String> comboColor;
 
   /** Constructor to setup the UI components */
   public ButtonComboBoxDemo() {
      // Create a JLabel with text and icon for manipulation
      URL imgURL = getClass().getClassLoader().getResource(imgCrossFilename);
      if (imgURL != null) {
         iconCross = new ImageIcon(imgURL);
      } else {
         System.err.println("Couldn't find file: " + imgCrossFilename);
      }
      lblForTest = new JLabel(lblText, iconCross, SwingConstants.CENTER);
      lblForTest.setOpaque(true);
      lblForTest.setBackground(new Color(204, 238, 241));
      lblForTest.setForeground(Color.RED);
      lblForTest.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 18));
 
      // Create radio buttons for setting horizontal alignment of the JLabel
      rbLeft = new JRadioButton("Left");
      rbLeft.setMnemonic(KeyEvent.VK_L);
      rbCenter = new JRadioButton("Center", true);  // selected
      rbCenter.setMnemonic(KeyEvent.VK_C);
      rbRight = new JRadioButton("Right");
      rbRight.setMnemonic(KeyEvent.VK_R);
      // Put the radio buttons into a ButtonGroup to ensure exclusive selection
      ButtonGroup btnGroupH = new ButtonGroup();
      btnGroupH.add(rbLeft);
      btnGroupH.add(rbRight);
      btnGroupH.add(rbCenter);
      // Set up a JPanel to hold all radio buttons
      JPanel pnlRbtnH = new JPanel(new GridLayout(1, 0)); // single row
      pnlRbtnH.add(rbLeft);
      pnlRbtnH.add(rbCenter);
      pnlRbtnH.add(rbRight);
      pnlRbtnH.setBorder(BorderFactory.createTitledBorder("Horizontal Alignment"));
 
      // A ItemListener for all Radio buttons
      ItemListener listener = new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
               if (e.getSource() == rbLeft) {
                  lblForTest.setHorizontalAlignment(SwingConstants.LEFT);
               } else if (e.getSource() == rbCenter) {
                  lblForTest.setHorizontalAlignment(SwingConstants.CENTER);
               } else if (e.getSource() == rbRight) {
                  lblForTest.setHorizontalAlignment(SwingConstants.RIGHT);
               }
            }
         }
      };
      rbLeft.addItemListener(listener);
      rbCenter.addItemListener(listener);
      rbRight.addItemListener(listener);
 
      // Create radio buttons for setting vertical alignment of the JLabel
      rbTop = new JRadioButton("Top");
      rbTop.setMnemonic(KeyEvent.VK_T);
      rbMiddle = new JRadioButton("Middle", true);  // selected
      rbMiddle.setMnemonic(KeyEvent.VK_M);
      rbBottom = new JRadioButton("Bottom");
      rbBottom.setMnemonic(KeyEvent.VK_B);
      // Put the radio buttons into a ButtonGroup to ensure exclusive selection
      ButtonGroup btnGroupV = new ButtonGroup();
      btnGroupV.add(rbTop);
      btnGroupV.add(rbMiddle);
      btnGroupV.add(rbBottom);
      // Set up a JPanel to hold all radio buttons
      JPanel pnlRbtnV = new JPanel(new GridLayout(1, 0)); // single row
      pnlRbtnV.add(rbTop);
      pnlRbtnV.add(rbMiddle);
      pnlRbtnV.add(rbBottom);
      pnlRbtnV.setBorder(BorderFactory.createTitledBorder("Vertical Alignment"));
 
      // Radio buttons also fire ActionEvent
      rbTop.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            lblForTest.setVerticalAlignment(SwingConstants.TOP);
         }
      });
      rbMiddle.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            lblForTest.setVerticalAlignment(SwingConstants.CENTER);
         }
      });
      rbBottom.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            lblForTest.setVerticalAlignment(SwingConstants.BOTTOM);
         }
      });
 
      // Create checkboxes for selecting text, icon, or both, or none
      cbText = new JCheckBox("Text", true);  // selected
      cbText.setMnemonic(KeyEvent.VK_T);
      cbIcon = new JCheckBox("Icon", true);  // selected
      cbIcon.setMnemonic(KeyEvent.VK_I);
      cbIcon.setSelected(true);
      // Set up a JPanel to hold all checkboxes
      JPanel pnlCbox = new JPanel(new GridLayout(0, 1)); // single column
      pnlCbox.add(cbText);
      pnlCbox.add(cbIcon);
      // Checkboxes fire ItemEvent. Use an anonymous inner class as ItemListener
      cbText.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            // Need to handle both SELECTED and DESELECTED
            if (e.getStateChange() == ItemEvent.SELECTED) {
               lblForTest.setText(lblText);
            } else {
               lblForTest.setText("");
            }
         }
      });
      cbIcon.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            // Need to handle both SELECTED and DESELECTED
            if (e.getStateChange() == ItemEvent.SELECTED) {
               lblForTest.setIcon(iconCross);
            } else {
               lblForTest.setIcon(null);
            }
         }
      });
 
      // Create combobox (drop-down menu) for the foreground color of the JLabel
      String[] strColors = {"Red", "Blue", "Green",
                            "Cyan", "Magenta", "Yellow", "Black"};
      final Color[] colors = {Color.RED, Color.BLUE, Color.GREEN,
                        Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.BLACK};
      comboColor = new JComboBox<String>(strColors);
      comboColor.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
               lblForTest.setForeground(colors[comboColor.getSelectedIndex()]);
            }
         }
      });
      // Set up a JPanel for the combobox
      JPanel pnlCombo = new JPanel(new FlowLayout());
      pnlCombo.add(comboColor);
 
      // Set up the content-pane with BorderLayout and adds the panels
      Container cp = this.getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(lblForTest, BorderLayout.CENTER);
      cp.add(pnlRbtnH, BorderLayout.NORTH);
      cp.add(pnlRbtnV, BorderLayout.SOUTH);
      cp.add(pnlCbox, BorderLayout.WEST);
      cp.add(pnlCombo, BorderLayout.EAST);
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Button and ComboBox Demo");
      setSize(400, 300);  // or pack() the components
      setLocationRelativeTo(null);
      setVisible(true);
   }
 
   /** The entry main() method */
   public static void main(String[] args) {
      // Run GUI codes in the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new ButtonComboBoxDemo();  // Let the constructor do the job
         }
      });
   }
}
