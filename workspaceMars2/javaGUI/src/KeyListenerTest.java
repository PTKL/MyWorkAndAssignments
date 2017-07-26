import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
/** Test KeyListener */
public class KeyListenerTest extends JFrame implements KeyListener {
   /** Constructor to setup the GUI */
   public KeyListenerTest() {
      Container cp = getContentPane();
      cp.addKeyListener(this);
      // Need to enables receiving of key inputs for this GUI component.
      cp.setFocusable(true);
      // "May" need to request keyboard focus on this component.
      cp.requestFocus();
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Testing Key Listener");
      setSize(300, 200);
      setVisible(true);
   }
 
   @Override
   public void keyTyped(KeyEvent e) {
      char keyChar = e.getKeyChar();
      System.out.println("keyTyped: Key char is " + keyChar);
   }
 
   @Override
   public void keyPressed(KeyEvent e) {
      int keyCode = e.getKeyCode();
      char keyChar = e.getKeyChar();
      System.out.println("keyPressed: VK Code is " + keyCode + ", Key char is " + keyChar);
   }
 
   @Override
   public void keyReleased(KeyEvent e) {}  // Ignored
 
   /** The entry main method */  
   public static void main(String[] args) {
      // Run GUI codes on the Event-Dispatching thread for thread safety */
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new KeyListenerTest();  // Let the constructor do the job
         }
      });
   }
}
