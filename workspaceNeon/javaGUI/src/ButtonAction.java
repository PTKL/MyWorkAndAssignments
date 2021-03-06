import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
 
public class ButtonAction {
 
    private static void createAndShowGUI()  {
 
        JFrame frame1 = new JFrame("JAVA");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JButton button = new JButton(" >> click me <<");
        //Add action listener to button
        button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                JFrame frame2 = new JFrame("JAVA2");
                frame2.setVisible(true);
                frame2.setSize(950, 400);
				//frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                System.out.println("You clicked the button");
            }
        });      
 
        frame1.getContentPane().add(button);
        frame1.pack();
        frame1.setVisible(true);
    }
 
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
