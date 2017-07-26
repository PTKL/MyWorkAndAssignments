/**
 *
 */


import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Helper class to draw the Item when rendered in a JList.
 * Uses nice colours and html.  In particular it colours the
 * selected item in a stand out way.
 *
 * @author Professor David Cohen
 *
 */
public final class ItemRenderer extends JLabel implements
        ListCellRenderer<Item> {

    /**
     * Required field for any serializable class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor makes the background of each returned Jlabel opaque.
     */
    public ItemRenderer() {
        setOpaque(true);
    }

    /**
     * Renders the current item in a Jlist of Items.
     *
     * @param list the displayed list of items
     * @param item the current item to render
     * @param index the index of the item in the list
     * @param isSelected whether the item is currently selected
     * @param cellHasFocus whether the item has the mouse focus
     * @return the JLabel used to render this item
     */
    @Override
    public Component getListCellRendererComponent(
            final JList<? extends Item> list,
            final Item item,
            final int index,
            final boolean isSelected,
            final boolean cellHasFocus) {

        String color;
        if (item.isOpen()) {
            color = "black";
        } else {
            color = "E0E0E0";
        }
        setText("<html>"
                + "<font color='"
                + color
                + "'>"
                + "<strong>"
                + item.getName()
                + "</strong> ("
                + item.getValue()
                + ")</font></html>");

        Color background;
        Color foreground;

        // check if this cell is selected
        if (isSelected) {
            background = Color.RED;
            foreground = Color.WHITE;

            // unselected
        } else {
            background = Color.WHITE;
            foreground = Color.BLACK;
        }

        setBackground(background);
        setForeground(foreground);

        return this;
    }
}
