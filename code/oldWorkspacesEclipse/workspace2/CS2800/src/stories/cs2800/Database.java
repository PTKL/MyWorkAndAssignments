package stories.cs2800;

import java.util.ArrayList;
import java.util.Map;

/**
 * The Class Database.
 *
 * It is the (only) abstraction for the DB Bridge pattern.
 * A Database abstracts the requirements of persistent storage
 * for the system.  hence it provides storage and retrieval methods
 * as defined by the system designers.
 *
 * These actual storage and retrieval operations occur in the implementations
 * of the Bridge pattern.  This class has no reliance on any actual database
 * or storage method.
 *
 * @author Professor David Cohen
 *
 */
public class Database {

  /** An abstract view of the storage in the real database. */
  private ItemList items = new ItemList();

  /** The names of all items in the store to make finding name clashes
   *  more efficient. */
  private ArrayList<String> names = new ArrayList<String>();

  /** The concrete implementation part of the Bridge pattern. */
  private DatabaseActions db;

  /**
   * Instantiates a new database.
   *
   * @param concreteDB
   *            the concrete db to use as the implementation for this
   *            abstraction
   */
  public Database(final DatabaseActions concreteDB) {
    items = new ItemList();
    this.db = concreteDB;
  }

  /**
   * Fetches the appropriate "items" from the (concrete) database
   * Adds them all to the returned items list.  None of these restored items
   * have any children.
   * Also stores them in the abstract list in this class.
   *
   * @param type
   *            the type of Item to fetch from the database
   * @return the list of retrieved items
   * @throws NameClashException
   *             if a retrieved item clashes with one already in the store
   */
  //
  public final ItemList restoreItems(final ItemType type)
      throws NameClashException {
    ArrayList<Item> fetchedItems = db.restoreThings(type);
    ItemList retval = new ItemList();
    for (Item t : fetchedItems) {
      retval.add(t);
      items.add(t);
      names.add(t.getName());
    }
    return retval;
  }

  /**
   * Restore child relationships from the concrete database.
   */
  public final void restoreRelationships() {
    Map<String, ArrayList<String>> links = db.restoreLinks();
    for (String parentName : links.keySet()) {
      Item parent = items.getElementByName(parentName);
      if (parent != null) {
        for (String childName : links.get(parentName)) {
          Item child = items.getElementByName(childName);
          if (child != null) {
            parent.add(child);
          }
        }
      }
    }
  }

  /**
   * Restore state (open or closed) of all items.
   */
  public final void restoreState() {
    ArrayList<String> closed = db.getClosed();
    for (String name : closed) {
      Item item = items.getElementByName(name);
      item.open(false);
    }
  }

  /**
   * This Bridge abstraction can return a String giving the details of the
   * implementation in use.
   *
   * @return the implementation information
   */
  public final String getStorageDescription() {
    return db.getDBStatus();
  }

  /**
   * Stores the data for a new item in the database.
   * @param key the type of the item to be stored
   * @param thing the item to be stored
   *
   * @throws NameClashException when name already exists
   */
  public final void insertItem(final ItemType key, final Item thing)
      throws NameClashException {
    // First check names in local store
    if (names.contains(thing.getName())) {
      throw new NameClashException();
    }
    // Now try to store the new item
    db.storeItem(key, thing);

  }

  /**
   * Add a link between items into the database.
   *
   * @param parent the head of the link
   * @param child the tail of the link
   */
  public final void addLink(final Item parent, final Item child) {
    db.addLink(parent.getName(), child.getName());
  }

  /**
   * Finds the appropriate item and updates it.
   * @param name the item name
   * @param addedValue the amount of value to add
   */
  public final void addValue(final String name, final Float addedValue) {
    Item thing = items.getElementByName(name);
    float value = thing.getValue() + addedValue;
    thing.setValue(value);
    db.setValue(name, value);
  }

  /**
   * Sets the state of the item in the database.
   *
   * @param item the item to open or close.  Uses the item's state to
   * set that in the database.
   */
  public final void setState(final Item item) {
    db.setState(item.getName(), item.isOpen());
  }
}
