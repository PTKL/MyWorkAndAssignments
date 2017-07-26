package stories.cs2800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A concrete Implementor of the DB Bridge pattern.
 * This class fakes initial items and does not store any changes.
 *
 * @author Professor David Cohen
 */
public class FakeDatabase implements DatabaseActions {

  /** Value used to fake entries. */
  private static final float LOW_COST = 0.1f;
  /** Value used to fake entries. */
  private static final float MEDIUM_COST = 0.3f;
  /** Value used to fake entries. */
  private static final float HIGH_COST = 0.7f;
  /** Value used to fake entries. */
  private static final float EXTREME_COST = 3.5f;
  /** Value used to fake entries. */
  private static final float LOW_HOURS = 1f;
  /** Value used to fake entries. */
  private static final float MEDIUM_HOURS = 5f;
  /** Value used to fake entries. */
  private static final float HIGH_HOURS = 20f;
  /** Value used to fake entries. */
  private static final float EXTREME_HOURS = 100f;

  /**
   * Fakes a list of restored items.
   *
   * @param type which type of item to fake
   * @return the list of fake items
   */
  @Override
  public final ArrayList<Item> restoreThings(final ItemType type)
      throws NameClashException {
    ArrayList<Item> retval = new ArrayList<Item>();
    switch (type) {
      case DEVELOPER:
        retval.add(ItemFactory.getInstance().createItem("FirstD", type,
            "First Developer", LOW_COST, null));
        retval.add(ItemFactory.getInstance().createItem("SecondD",
            type, "2nd Developer", MEDIUM_COST, null));
        retval.add(ItemFactory.getInstance().createItem("3SecondD",
            type, "2nd Developer", HIGH_COST, null));
        retval.add(ItemFactory.getInstance().createItem("4SecondD",
            type, "2nd Developer", EXTREME_COST, null));
        retval.add(ItemFactory.getInstance().createItem("5SecondD",
            type, "2nd Developer", LOW_COST, null));
        retval.add(ItemFactory.getInstance().createItem("6SecondD",
            type, "2nd Developer", MEDIUM_COST, null));
        retval.add(ItemFactory.getInstance().createItem("7SecondD",
            type, "2nd Developer", HIGH_COST, null));
        retval.add(ItemFactory.getInstance().createItem("8SecondD",
            type, "2nd Developer", EXTREME_COST, null));
        for (Item item : retval) {
          item.open(true);
        }
        break;
      case PROJECT:
        retval.add(ItemFactory.getInstance().createItem("FirstP", type,
            "First Project", 0.0f, null));
        retval.add(ItemFactory.getInstance().createItem("SecondP",
            type, "2nd Project", 0.0f, null));
        for (Item item : retval) {
          item.open(true);
        }
        break;
      case STORY:
        retval.add(ItemFactory.getInstance().createItem("FirstS", type,
            "First Story", 0.0f, null));
        retval.add(ItemFactory.getInstance().createItem("SecondS",
            type, "2nd Story", 0.0f, null));
        for (Item item : retval) {
          item.open(true);
        }
        break;
      case STORY_DEVELOPER:
        // First story workers
        retval.add(ItemFactory.getInstance().createItem("1", type,
            "First Worker", LOW_HOURS, null));
        retval.add(ItemFactory.getInstance().createItem("2", type,
            "First Worker", MEDIUM_HOURS, null));
        retval.add(ItemFactory.getInstance().createItem("3", type,
            "First Worker", HIGH_HOURS, null));
        retval.add(ItemFactory.getInstance().createItem("4", type,
            "First Worker", EXTREME_HOURS, null));

        // Second Story Workers
        retval.add(ItemFactory.getInstance().createItem("5", type,
            "2nd Worker", LOW_HOURS, null));
        retval.add(ItemFactory.getInstance().createItem("6", type,
            "2nd Worker", MEDIUM_HOURS, null));
        retval.add(ItemFactory.getInstance().createItem("7", type,
            "2nd Worker", HIGH_HOURS, null));
        retval.add(ItemFactory.getInstance().createItem("8", type,
            "2nd Worker", EXTREME_HOURS, null));
        break;
      default:
        break;
    }
    return retval;
  }

  /**
   * Fake the children of the (fake) items.
   *
   * @return a list of fake links to (fake) children
   */
  @Override
  public final Map<String, ArrayList<String>> restoreLinks() {
    ArrayList<String> someStories = new ArrayList<String>();
    someStories.add("FirstS");
    ArrayList<String> otherStories = new ArrayList<String>();
    otherStories.add("SecondS");
    ArrayList<String> allStories = new ArrayList<String>();
    allStories.add("FirstS");
    allStories.add("SecondS");

    Map<String, ArrayList<String>> retval =
        new HashMap<String, ArrayList<String>>();
    retval.put("FirstP", someStories);
    retval.put("SecondP", otherStories);

    retval.put("FirstD", someStories);
    retval.put("3SecondD", otherStories);
    retval.put("4SecondD", allStories);
    retval.put("6SecondD", someStories);
    retval.put("7SecondD", otherStories);
    retval.put("8SecondD", allStories);

    ArrayList<String> firstWorkers = new ArrayList<String>();
    firstWorkers.add("1");
    firstWorkers.add("2");
    firstWorkers.add("3");
    firstWorkers.add("4");
    retval.put("FirstS", firstWorkers);

    ArrayList<String> secondWorkers = new ArrayList<String>();
    secondWorkers.add("5");
    secondWorkers.add("6");
    secondWorkers.add("7");
    secondWorkers.add("8");
    retval.put("SecondS", secondWorkers);

    ArrayList<String> dev1 = new ArrayList<String>();
    ArrayList<String> dev2 = new ArrayList<String>();
    ArrayList<String> dev3 = new ArrayList<String>();
    ArrayList<String> dev4 = new ArrayList<String>();
    ArrayList<String> dev5 = new ArrayList<String>();
    ArrayList<String> dev6 = new ArrayList<String>();
    ArrayList<String> dev7 = new ArrayList<String>();
    ArrayList<String> dev8 = new ArrayList<String>();
    dev1.add("FirstD");
    dev2.add("4SecondD");
    dev3.add("6SecondD");
    dev4.add("8SecondD");
    dev5.add("3SecondD");
    dev6.add("4SecondD");
    dev7.add("7SecondD");
    dev8.add("8SecondD");
    retval.put("1", dev1);
    retval.put("2", dev2);
    retval.put("3", dev3);
    retval.put("4", dev4);
    retval.put("5", dev5);
    retval.put("6", dev6);
    retval.put("7", dev7);
    retval.put("8", dev8);
    return retval;
  }

  /**
   * All fake items are open.
   *
   * @return an empty list of closed items
   */
  @Override
  public final ArrayList<String> getClosed() {
    return new ArrayList<String>();
  }

  /**
   * Returns a useful message!
   */
  @Override
  public final String getDBStatus() {
    return "Fake Database - Initial data is Fake - changes are ephemeral";
  }

  @Override
  /**
   * Does nothing in this fake Database.
   *
   * @param thing is ignored
   */
  public void storeItem(final ItemType key, final Item thing)
      throws NameClashException {
  }

  @Override
  /**
   * Does nothing in this fake Database.
   *
   * @param parent ignored
   * @param child ignored
   */
  public void addLink(final String parent, final String child) {
  }

  @Override
  /**
   * Does nothing in this fake Database.
   * @param name ignored
   * @param value ignored
   */
  public final void setValue(final String name, final float value) {
  }

  @Override
  /**
   * Does nothing in this fake Database.
   * @param name ignored
   * @param open ignored
   */
  public void setState(final String name, final boolean open) {
  }
}
