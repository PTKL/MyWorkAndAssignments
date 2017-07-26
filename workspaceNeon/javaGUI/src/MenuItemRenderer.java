import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Helper class to draw the menuItem when rendered in a JList. Uses nice colours, pictures and html.
 *
 * @author Nikoloz
 *
 */

public class MenuItemRenderer extends JLabel implements ListCellRenderer<MenuItem> {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor makes the background of each returned Jlabel opaque.
   */
  public MenuItemRenderer() {
    setOpaque(true);
  }

  @Override
  public Component getListCellRendererComponent(JList<? extends MenuItem> mList, MenuItem mItem,
      int index, boolean isSelected, boolean cellHasFocus) {
    // TODO Auto-generated method stub
    String color;
    // if (mItem.isOpen()) {
    color = "green";
    // } else {
    // color = "E0E0E0";
    // }
    try {
      URL url = new URL(mItem.getImageURL());
      BufferedImage img = ImageIO.read(url);
      ImageIcon i = new ImageIcon(img);
      setIcon(i);
    } catch (Exception e) {
    }
    setText("<html>" + "<font color='" + color + "'>" + "<strong>" + mItem.getName() + "</strong> ("
        + mItem.getCost() + ")</font></html>");

    Color background;
    Color foreground;

    // check if this cell is selected
    if (isSelected) {
      background = Color.RED;
      foreground = Color.WHITE;

      // unselected
    } else {
      background = Color.LIGHT_GRAY;
      foreground = Color.BLACK;
    }

    setBackground(background);
    setForeground(foreground);

    return this;
  }



}
