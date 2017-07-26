package stories.cs2800;

import java.util.ArrayList;
import java.util.Map;

/**
 * The Interface DBActions.
 *
 * This is part of the Bridge pattern.  It is the Bridge database implementer.
 * All concrete implementations of the database must implement this interface.
 * Hence this interface decouples the abstraction from its concrete
 * implementations.
 *
 * @author Professor David Cohen
 */
public interface DatabaseActions {

  /**
   * Restore from the things table (Items).
   *
   * @param key
   *            the String name of a type of Item
   * @return the array list of Items
   * @throws NameClashException
   *             if a restored Item has a name which clashes
   */
  ArrayList<Item> restoreThings(ItemType key) throws NameClashException;

  /**
   * Restore from the links table (children).
   *
   * @return the map from Item name to names of the child Items
   */
  Map<String, ArrayList<String>> restoreLinks();

  /**
   * Gets a list of the names of all closed items.
   *
   * @return the closed items
   */
  ArrayList<String> getClosed();

  /**
   * The Database status is a String containing information relevant to the
   * implementation of the Bridge pattern actually in use.
   *
   * @return the information String
   */
  String getDBStatus();

  /**
   * Stores an item using a concrete implementation.
   * @param key the type of the item to be stored
   * @param thing to be stored
   *
   * @throws NameClashException if the name already exists
   */
  void storeItem(ItemType key, Item thing) throws NameClashException;

  /**
   * Make a permanent record of a child as a link in the database.
   *
   * @param parent the head of the link
   * @param child the tail of the link
   */
  void addLink(String parent, String child);

  /**
   * Set the value of an item.
   * @param name the name of the item
   * @param value the new value
   */
  void setValue(String name, float value);

  /**
   * Updates the state of an item in the database.
   *
   * @param name the key of the item
   * @param open the new value of the open attribute
   */
  void setState(String name, boolean open);
}
