package stories.cs2800;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

/**
 * The Class DetailsView is a JPanel for displaying the details of an Item.
 * It is resizable.  Once created it is updated using the setter methods.
 *
 * @author Professor David Cohen
 */
public class DetailsView extends JPanel {

    /** The constant gap around GUI items. */
    private static final int DEFAUL_GAP = 10;

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The name used to display the name of the item. */
    private JLabel nameLbl = new JLabel(
            "Click to See Details");

    /** The description text area. */
    private JTextArea descArea = new JTextArea();

    /** The details text area which shows extra details about an Item. */
    private JTextArea detailsArea = new JTextArea();

    /**
     * Instantiates a new details view.
     *
     * @param mainTitle
     *            the main heading that describes this view
     * @param detailTitle
     *            the heading that decribes the special details for these items
     */
    public DetailsView(final String mainTitle, final String detailTitle) {
        Font font = getFont();
        // get metrics from the graphics
        FontMetrics metrics = getFontMetrics(font);
        // get the height of a line of text in this
        // font and render context
        int hgt = metrics.getHeight();
        // get the advance of my text in this font
        // and render context
        int adv = metrics.stringWidth("A long Title  si necessary");
        // calculate the size of a box to hold the
        // text with some padding.
        Dimension detailsSize = new Dimension(adv + 2, hgt + 2 * hgt + 2);
        Dimension descSize = new Dimension(adv + 2, 2 * hgt + 2);
        detailsArea.setEditable(false);
        descArea.setEditable(false);
        setBorder(new TitledBorder(BorderFactory.createBevelBorder(
                BevelBorder.RAISED), mainTitle));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 1.0;
        c.insets = new Insets(DEFAUL_GAP, DEFAUL_GAP, 0, DEFAUL_GAP);
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Name: "), c);

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 0;
        c.weighty = 1.0;
        c.insets = new Insets(DEFAUL_GAP, DEFAUL_GAP, 0, DEFAUL_GAP);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        add(nameLbl, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(DEFAUL_GAP, DEFAUL_GAP, 0, DEFAUL_GAP);
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Description: "), c);

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.insets = new Insets(DEFAUL_GAP, DEFAUL_GAP, 0, DEFAUL_GAP);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        JScrollPane scrollPane =
                new JScrollPane(descArea, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(descSize);
        add(scrollPane, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 1.0;
        c.insets = new Insets(DEFAUL_GAP, DEFAUL_GAP, 0, DEFAUL_GAP);
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel(detailTitle), c);

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 2;
        c.weighty = 1.0;
        c.weightx = 1.0;
        c.insets = new Insets(DEFAUL_GAP, DEFAUL_GAP, 2 * DEFAUL_GAP,
                DEFAUL_GAP);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        JScrollPane scrollPaneDetails = new JScrollPane(detailsArea);
        scrollPaneDetails.setPreferredSize(detailsSize);
        add(scrollPaneDetails, c);
    }

    /**
     * Set the name of the item being displayed.
     *
     * @param the name of the item
     */
    @Override
    public final void setName(final String name) {
        nameLbl.setText(name);
    }

    /**
     * Sets the description of the item being displayed.
     *
     * @param description
     *            the new description of the item
     */
    public final void setDescription(final String description) {
        descArea.setText(description);
    }

    /**
     * Sets the details String for the item being displayed.
     *
     * @param details
     *            the new details
     */
    public final void setDetails(final String details) {
        detailsArea.setText(details);
    }
}
