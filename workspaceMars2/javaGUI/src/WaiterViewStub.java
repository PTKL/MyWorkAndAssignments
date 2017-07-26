import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;
import java.awt.Dimension;
import javax.swing.LayoutStyle.ComponentPlacement;

public class WaiterViewStub {

  private JFrame frame;

  /**
   * @author emil
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          WaiterViewStub window = new WaiterViewStub();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public WaiterViewStub() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.getContentPane().setPreferredSize(new Dimension(75, 24));
    frame.getContentPane().setMinimumSize(new Dimension(75, 24));
    frame.getContentPane().setMaximumSize(new Dimension(75, 24));
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JToggleButton tglbtnTable = new JToggleButton("Table1");
    
    JToggleButton tglbtnTable_1 = new JToggleButton("Table2");
    
    JToggleButton tglbtnTable_2 = new JToggleButton("Table3");
    
    JToggleButton tglbtnTable_4 = new JToggleButton("Table4");
    
    JToggleButton tglbtnTable_5 = new JToggleButton("Table5");
    
    JToggleButton tglbtnTable_6 = new JToggleButton("Table6");
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(tglbtnTable)
            .addComponent(tglbtnTable_4))
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(tglbtnTable_1)
            .addComponent(tglbtnTable_5))
          .addGap(28)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(tglbtnTable_6)
            .addComponent(tglbtnTable_2))
          .addContainerGap(173, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(tglbtnTable)
            .addComponent(tglbtnTable_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
            .addComponent(tglbtnTable_2))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(tglbtnTable_4)
            .addComponent(tglbtnTable_5)
            .addComponent(tglbtnTable_6))
          .addContainerGap(198, Short.MAX_VALUE))
    );
    frame.getContentPane().setLayout(groupLayout);
  }
}
