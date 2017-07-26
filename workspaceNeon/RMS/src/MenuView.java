import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class MenuView extends JFrame {
 
  String[] names =
      {"banana split", "chicken with rice", "rice", "noodles", "fried vermicelli", "smoothie"};
  String[] namesImage = {"banana split.jpeg", "chicken with rice.jpeg", "rice.jpeg", "noodles.jpeg",
      "fried vermicelli.jpeg", "smoothie.jpeg"};

  ImageIcon[] foodImages = new ImageIcon[namesImage.length];
  JButton[] jbtChoc = new JButton[names.length];

  {

    for (int i = 0; i < names.length; i++) {
      jbtChoc[i] = new JButton(names[i]);
      for (int x = 0; x < names.length; x++) {
        foodImages[x] = new ImageIcon(namesImage[x]);
      }
    }
  }



  /**
   * Constructor for the MenuView.
   */

  public MenuView() {
    Container cont = getContentPane();
    cont.setLayout(new BorderLayout(5, 5));;
    cont.setBackground(Color.white);

    JPanel girdSetup = new JPanel(new GridLayout(2, 3, 5, 5));

    for (int i = 0; i < foodImages.length; i++) {
      jbtChoc[i].setIcon(foodImages[i]);
      girdSetup.add(jbtChoc[i]);
      jbtChoc[i].setVerticalTextPosition(AbstractButton.BOTTOM);
      jbtChoc[i].setHorizontalTextPosition(AbstractButton.CENTER);
    }

    cont.add(girdSetup, BorderLayout.CENTER);
    try {
      URL urlTest = new URL("http://icecreamjournal.turkeyhill.com/blog/wp-content/uploads/2010/08/banana-split.jpg");
      } catch (Exception e) {
        
      }
  }

  /**
   * Main method for test.
   * 
   * @param args Initial setup.
   */

  public static void main(String[] args) {
    MenuView frame = new MenuView();
    frame.setTitle("MenuView");
    frame.setSize(950, 400);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}

