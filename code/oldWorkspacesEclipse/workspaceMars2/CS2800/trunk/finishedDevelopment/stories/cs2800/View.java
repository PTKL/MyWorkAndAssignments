package stories.cs2800;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

/**
 * A View allows the user to interact with the application. Any interactions should be processed in
 * the Controller which registers Observers using appropriate helper methods. When the Controller
 * wants to change the look of the View it does this by calling other helper methods. This View uses
 * a GridBagLayout to allow flexible placement of screen items, that will be resized appropriately.
 * Since this class is so long it would probably be better to break it into several different
 * classes, one for each panel perhaps.
 *
 * @author Professor David Cohen
 */
public class View extends JFrame {

  /** The Constant serialVersionUID needed for any Serializable class. */
  private static final long serialVersionUID = 1L;

  /** The regexp DIGITS matches any number of decimal digits. */
  private static final String DIGITS = "(\\p{Digit}+)";

  /** The regexp HEX_DIGITS matches any number of hexadecimal digits. */
  private static final String HEX_DIGITS = "(\\p{XDigit}+)";

  /** The regexp EXP matches a well formed exponent. */
  private static final String EXP = "[eE][+-]?" + DIGITS;

  /** The regexp FP_REGEX matches any well formed floating point number. */
  @SuppressWarnings("unused")
  private static final String FP_REGEX = ("[\\x00-\\x20]*" + "[+-]?(" + "NaN|" + "Infinity|" + "((("
      + DIGITS + "(\\.)?(" + DIGITS + "?)(" + EXP + ")?)|" + "(\\.(" + DIGITS + ")(" + EXP + ")?)|"
      + "((" + "(0[xX]" + HEX_DIGITS + "(\\.)?)|" + "(0[xX]" + HEX_DIGITS + "?(\\.)" + HEX_DIGITS
      + ")" + ")[pP][+-]?" + DIGITS + "))" + "[fFdD]?))" + "[\\x00-\\x20]*");

  /** The Constant LIST_LENGTH is the default height on screen of a list. */
  private static final int LIST_LENGTH = 110;

  /**
   * The Constant LOW_WEIGHT is is used to prevent unimportant screen elements resizing when the
   * parent window is resized.
   */
  private static final double LOW_WEIGHT = 0.1;

  /**
   * The Constant MEDIUM_WEIGHT makes sure that standard screen elements get more space when the
   * parent window is resized.
   */
  private static final double MEDIUM_WEIGHT = 0.4;

  /** The Constant NUM_ROWS is the size of the window on an Items list. */
  private static final int NUM_ROWS = 5;

  /**
   * The Constant DEFAULT_GAP is how much space (in pixels) to leave between screen items.
   */
  private static final int DEFAULT_GAP = 10;

  /**
   * The Constant NAME_LENGTH is the size on screen of a field that is used to enter a name of an
   * item.
   */
  private static final int NAME_LENGTH = 20;

  /**
   * The Constant DESCR_LENGTH is the size on screen of a field that is used to enter the
   * description of an item.
   */
  private static final int DESCR_LENGTH = 80;

  /**
   * The Constant VALUE_LENGTH is the size (number of characters) on screen of a field that is used
   * to enter the value of an item.
   */
  private static final int VALUE_LENGTH = 4;

  /** The Constant BOTTOM_ROW is the final row of the grid of screen items. */
  private static final int BOTTOM_ROW = 3;

  /** The lists of the items (Stories, projects and developers). */
  private Map<ItemType, JList<Item>> viewList = new HashMap<ItemType, JList<Item>>();

  /** The view details. */
  private Map<ItemType, DetailsView> viewDetails = new HashMap<ItemType, DetailsView>();

  /** The add developer button. */
  // After selecting a story and a developer, you can "Add Developer", or
  // "Add Time"
  private JButton addDeveloperButton = new JButton("Add Developer to Story");

  /** The add time button. */
  private JButton addTimeButton = new JButton("Add Hours to Developer/Story");

  /** The open close project button. */
  private JButton openCloseProjectButton = new JButton("Open/Close Project");

  /** The Open close story button. */
  private JButton openCloseStoryButton = new JButton("Open/Close Story");

  /** The project personel button. */
  private JButton projectPersonelButton = new JButton("Show Project Personel");

  /** The co workers button. */
  private JButton coWorkersButton = new JButton("Show Developer Co-Workers");

  /** The project cost button. */
  private JButton projectCostButton = new JButton("Show Project Cost");

  /** The developer cost button. */
  private JButton developerCostButton = new JButton("Show Developer Cost");

  /** The create story button. */
  // After selecting a project you can create a new story, needs the text
  // fields to be filled in.
  private JButton createStoryButton = new JButton("New Story for selected Project");

  /** The create developer button. */
  // Independent of selections you can create developers or projects, needs
  // text fields to be filled in.
  private JButton createDeveloperButton = new JButton("New Developer");

  /** The create project button. */
  private JButton createProjectButton = new JButton("New Project");

  /** The name field. */
  private JTextField nameField = new JTextField(NAME_LENGTH);

  /** The desc field. */
  private JTextField descField = new JTextField(DESCR_LENGTH);

  /** The value field. */
  private JTextField valueField = new JTextField(VALUE_LENGTH);

  /** The content pane. */
  private JPanel contentPane = new JPanel();

  /** Renders items using a JLabel to allow beauty. */
  private ItemRenderer itemRenderer = new ItemRenderer();

  /**
   * Instantiates a new view.
   *
   * @param title the description, which includes the data source
   */
  public View(final String title) {
    super("Story Management. Storage: " + title);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    viewList.put(ItemType.PROJECT, new JList<Item>());
    viewList.put(ItemType.STORY, new JList<Item>());
    viewList.put(ItemType.DEVELOPER, new JList<Item>());
    Map<ItemType, JScrollPane> viewScrollPanes = new HashMap<ItemType, JScrollPane>();

    viewList.forEach((type, list) -> {
      list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      list.setVisibleRowCount(NUM_ROWS);
      list.putClientProperty("type", type);
      list.setCellRenderer(itemRenderer);
      JScrollPane paneForScroll = new JScrollPane(list);
      paneForScroll.setMinimumSize(new Dimension(0, LIST_LENGTH));
      viewScrollPanes.put(type, paneForScroll);
    });
    viewDetails.put(ItemType.PROJECT, new DetailsView("Project Details", "Stories: "));
    viewDetails.put(ItemType.STORY, new DetailsView("Story Details", "Developers: "));
    viewDetails.put(ItemType.DEVELOPER, new DetailsView("Developer Details", "Stories: "));

    setContentPane(contentPane);
    GridBagConstraints constraintsForGrid = new GridBagConstraints();
    contentPane.setLayout(new GridBagLayout());

    constraintsForGrid.weightx = 1.0;
    constraintsForGrid.weighty = 1.0;
    constraintsForGrid.insets = new Insets(DEFAULT_GAP, DEFAULT_GAP, DEFAULT_GAP, DEFAULT_GAP);
    constraintsForGrid.fill = GridBagConstraints.BOTH;

    constraintsForGrid.gridx = 0;
    constraintsForGrid.gridy = 0;
    contentPane.add(viewScrollPanes.get(ItemType.PROJECT), constraintsForGrid);
    constraintsForGrid.gridx = 1;
    contentPane.add(viewScrollPanes.get(ItemType.STORY), constraintsForGrid);
    constraintsForGrid.gridx = 2;
    contentPane.add(viewScrollPanes.get(ItemType.DEVELOPER), constraintsForGrid);

    constraintsForGrid.fill = GridBagConstraints.BOTH;
    constraintsForGrid.anchor = GridBagConstraints.NORTHWEST;
    constraintsForGrid.gridy = 1;
    constraintsForGrid.gridx = 0;
    constraintsForGrid.weighty = 1.0;
    contentPane.add(viewDetails.get(ItemType.PROJECT), constraintsForGrid);
    constraintsForGrid.gridx = 1;
    contentPane.add(viewDetails.get(ItemType.STORY), constraintsForGrid);
    constraintsForGrid.gridx = 2;
    contentPane.add(viewDetails.get(ItemType.DEVELOPER), constraintsForGrid);

    JPanel createPanel = buildCreatePanel();

    constraintsForGrid.gridx = 0;
    constraintsForGrid.gridy = 2;
    constraintsForGrid.weighty = MEDIUM_WEIGHT;
    constraintsForGrid.fill = GridBagConstraints.HORIZONTAL;
    constraintsForGrid.gridwidth = GridBagConstraints.REMAINDER;
    contentPane.add(createPanel, constraintsForGrid);

    JPanel actionPanel = buildActionPanel();

    constraintsForGrid.gridx = 0;
    constraintsForGrid.gridy = BOTTOM_ROW;
    constraintsForGrid.weighty = MEDIUM_WEIGHT;
    constraintsForGrid.fill = GridBagConstraints.HORIZONTAL;
    constraintsForGrid.gridwidth = GridBagConstraints.REMAINDER;
    contentPane.add(actionPanel, constraintsForGrid);
    pack();
    setMinimumSize(new Dimension(getWidth(), getHeight()));

    // Of course, the list should be passed from the controller into
    // the view
    // To make the View work at all we can just create a list now here and
    // assign it to be the ItemList for each window.
    ItemList list = new ItemList();
    viewList.get(ItemType.DEVELOPER).setModel(list);
    viewList.get(ItemType.PROJECT).setModel(list);
    viewList.get(ItemType.STORY).setModel(list);

    // To test the ability of your ItemList to be displayed you want
    // to make the should add some new Items to the list here
  }

  /**
   * Builds the create panel.
   *
   * @return a JPanel with appropriate LayoutManager
   */
  private JPanel buildCreatePanel() {
    JPanel retval = new JPanel();
    retval.setBorder(new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
        "Create a Project, Developer or Story"));
    retval.setLayout(new GridBagLayout());
    GridBagConstraints constraintsGrid = new GridBagConstraints();

    constraintsGrid.gridx = 0;
    constraintsGrid.gridy = 0;
    constraintsGrid.weighty = 0;
    constraintsGrid.weightx = 0;
    constraintsGrid.insets = new Insets(DEFAULT_GAP, DEFAULT_GAP, 0, DEFAULT_GAP);
    constraintsGrid.anchor = GridBagConstraints.FIRST_LINE_END;
    retval.add(new JLabel("Name: "), constraintsGrid);

    constraintsGrid = new GridBagConstraints();
    constraintsGrid.fill = GridBagConstraints.NONE;
    constraintsGrid.gridx = 1;
    constraintsGrid.gridy = 0;
    constraintsGrid.weighty = 0;
    constraintsGrid.weightx = 0;
    constraintsGrid.insets = new Insets(DEFAULT_GAP, DEFAULT_GAP, 0, DEFAULT_GAP);
    nameField.setMinimumSize(nameField.getPreferredSize());
    constraintsGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    retval.add(nameField, constraintsGrid);

    // /////////// ROW 1 /////////////////////////////////
    constraintsGrid = new GridBagConstraints();
    constraintsGrid.gridx = 0;
    constraintsGrid.gridy = 1;
    // c.fill = GridBagConstraints.BOTH;
    constraintsGrid.weighty = 0;
    constraintsGrid.weightx = 0;
    constraintsGrid.insets = new Insets(DEFAULT_GAP, DEFAULT_GAP, 0, DEFAULT_GAP);
    constraintsGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    retval.add(new JLabel("Description: "), constraintsGrid);

    constraintsGrid = new GridBagConstraints();
    constraintsGrid.fill = GridBagConstraints.NONE;
    constraintsGrid.gridx = 1;
    constraintsGrid.gridy = 1;
    constraintsGrid.weighty = 0;
    constraintsGrid.weightx = LOW_WEIGHT;
    constraintsGrid.insets = new Insets(DEFAULT_GAP, DEFAULT_GAP, 0, DEFAULT_GAP);
    constraintsGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    descField.setMinimumSize(descField.getPreferredSize());
    retval.add(descField, constraintsGrid);

    // /////////// ROW 2 /////////////////////////////////
    constraintsGrid = new GridBagConstraints();
    constraintsGrid.gridx = 0;
    constraintsGrid.gridy = 2;
    // c.fill = GridBagConstraints.BOTH;
    constraintsGrid.weighty = 0;
    constraintsGrid.weightx = 0;
    constraintsGrid.insets = new Insets(DEFAULT_GAP, DEFAULT_GAP, 0, DEFAULT_GAP);
    constraintsGrid.anchor = GridBagConstraints.FIRST_LINE_END;
    retval.add(new JLabel("Value: "), constraintsGrid);

    constraintsGrid = new GridBagConstraints();
    constraintsGrid.gridx = 1;
    constraintsGrid.gridy = 2;
    constraintsGrid.weighty = 0;
    constraintsGrid.weightx = 0;
    constraintsGrid.insets = new Insets(DEFAULT_GAP, DEFAULT_GAP, DEFAULT_GAP, DEFAULT_GAP);
    constraintsGrid.anchor = GridBagConstraints.FIRST_LINE_START;
    valueField.setMinimumSize(valueField.getPreferredSize());
    retval.add(valueField, constraintsGrid);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(createProjectButton);
    createProjectButton.putClientProperty("type", ItemType.PROJECT);
    buttonPanel.add(createStoryButton);
    createStoryButton.putClientProperty("type", ItemType.STORY);
    buttonPanel.add(createDeveloperButton);
    createDeveloperButton.putClientProperty("type", ItemType.DEVELOPER);

    constraintsGrid = new GridBagConstraints();
    constraintsGrid.gridx = 0;
    constraintsGrid.gridy = BOTTOM_ROW;
    constraintsGrid.gridwidth = 2;
    constraintsGrid.weighty = 0;
    constraintsGrid.weightx = 0;
    constraintsGrid.insets = new Insets(DEFAULT_GAP, DEFAULT_GAP, DEFAULT_GAP, DEFAULT_GAP);
    constraintsGrid.anchor = GridBagConstraints.CENTER;
    retval.add(buttonPanel, constraintsGrid);

    return retval;
  }

  /**
   * Builds the action panel which is a JPanel containing action buttons.
   *
   * @return A JPanel with an appropriate LayoutManager
   */
  private JPanel buildActionPanel() {
    JPanel developerPanel = new JPanel();
    developerPanel.setBorder(new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
        "Make changes to Projects"));
    developerPanel.setLayout(new GridBagLayout());
    GridBagConstraints constraintsGrid = new GridBagConstraints();
    
    constraintsGrid.gridx = 0;
    constraintsGrid.gridy = 0;
    constraintsGrid.fill = GridBagConstraints.NONE;
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(0, 2));
    buttonPanel.add(addDeveloperButton);
    buttonPanel.add(addTimeButton);
    buttonPanel.add(openCloseProjectButton);
    buttonPanel.add(openCloseStoryButton);
    developerPanel.add(buttonPanel, constraintsGrid);

    // //////////// The View Main Panel ///////////////////////////
    JPanel viewPanel = new JPanel();
    viewPanel.setBorder(new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
        "Show Involvement/Costs"));
    viewPanel.setLayout(new GridBagLayout());
    GridBagConstraints constraintsForTheGrid1 = new GridBagConstraints();
    
    constraintsForTheGrid1.gridx = 0;
    constraintsForTheGrid1.gridy = 0;
    constraintsForTheGrid1.fill = GridBagConstraints.NONE;
    JPanel buttonVPanel = new JPanel();
    buttonVPanel.setLayout(new GridLayout(0, 2));
    buttonVPanel.add(projectPersonelButton);
    projectPersonelButton.putClientProperty("type", ItemType.PROJECT);
    buttonVPanel.add(coWorkersButton);
    coWorkersButton.putClientProperty("type", ItemType.DEVELOPER);
    buttonVPanel.add(projectCostButton);
    projectCostButton.putClientProperty("type", ItemType.PROJECT);
    buttonVPanel.add(developerCostButton);
    developerCostButton.putClientProperty("type", ItemType.DEVELOPER);
    viewPanel.add(buttonVPanel, constraintsForTheGrid1);

    JPanel retval = new JPanel();
    retval.setLayout(new GridLayout(0, 2));
    retval.add(developerPanel);
    retval.add(viewPanel);
    return retval;
  }

  /**
   * @author emil.
   * @param type @see ItemType
   * @return the type of item @see ItemType
   */

  public Item getSelectedItem(ItemType type) {
    return viewList.get(type).getSelectedValue();
  }

  /**
   * By adding this method we specify that this part of the view will be observed by the
   * corresponding method in the Controller class.
   * 
   * @author emil
   * @param hoursListener sets the listener for the hours button.
   */

  public void setAddHoursListener(ActionListener hoursListener) {
    addTimeButton.addActionListener(hoursListener);
  }
}
