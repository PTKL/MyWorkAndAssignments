package resizableImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ResizableImage extends JFrame {
  /**
   * Here we display an image by overriding the paintComponent() method of JLable. It is placed in a
   * custom class called MyJLable. We are drawing the image having width and height as that of
   * JLabel. And we use a WindowListener on the parent container and repaint the Jlabel instance
   * each time the parent container is resized
   */
  private static final long serialVersionUID = 1L;

  public ImageIcon imageIcon;
  MyJLabel jLabel;


  public void buildGUI() {
    imageIcon = new ImageIcon("china_countries_ofdi.png");
    jLabel = new MyJLabel(imageIcon);
    getContentPane().add(jLabel);
    addWindowListener(new WindowAdapter() {
      @SuppressWarnings("unused")
      public void windowResized(WindowEvent evt) {
        jLabel.repaint();
      }
    });
    setSize(500, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    jLabel.repaint();
  }

  public static void main(String st[]) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        ResizableImage demo = new ResizableImage();
        demo.buildGUI();
      }
    });
  }
}


class MyJLabel extends JLabel {
  /**
   * The override was taken from here:
   * http://stackoverflow.com/questions/36519178/how-to-make-my-images-in-jpanel-scalable-to-window-size
   * all credit for it goes to camickr
   */
  private static final long serialVersionUID = 1L;
  ImageIcon imageIcon;

  public MyJLabel(ImageIcon icon) {
    this.imageIcon = icon;
  }

  @Override
  public void paintComponent(Graphics graphic) {
    super.paintComponent(graphic);
    graphic.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
  }
}
