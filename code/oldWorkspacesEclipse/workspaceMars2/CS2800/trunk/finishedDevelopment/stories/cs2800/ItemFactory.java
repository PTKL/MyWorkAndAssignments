
package stories.cs2800;

import stories.cs2800.AggregateItem;
import stories.cs2800.Database;
import stories.cs2800.Item;
import stories.cs2800.ItemType;
import stories.cs2800.NameClashException;
import stories.cs2800.SingleItem;


/**
 * A factory for creating Item objects.
 * 
 * @author emil
 */
public class ItemFactory {

  /** The instance of item factory. */
  private static ItemFactory instanceOfItemFactory = new ItemFactory();

  /** The db. */
  private Database db;


  /**
   * Gets the single instance of ItemFactory.
   *
   * @return single instance of ItemFactory
   */
  public static ItemFactory getInstance() {
    return instanceOfItemFactory;
  }

  /**
   * Creates a new Item object.
   *
   * @param name the name
   * @param type @see ItemType
   * @param description the description
   * @param value the value
   * @param child the child
   * @param save the save
   * @return the item @see Item
   * @throws NameClashException the name clash exception
   */
  public Item createItem(String name, ItemType type, String description, float value, Item child,
      boolean save) throws NameClashException {
    Object createdItem;


    if (ItemType.PROJECT.equals(type) || ItemType.STORY.equals(type)
        || ItemType.STORY.equals(ItemType.DEVELOPER)) {
      createdItem = new AggregateItem(name, description, value);
    } else if (ItemType.STORY_DEVELOPER.equals(type)) {
      createdItem = new SingleItem(name, value, child);
    } else {
      createdItem = null;
    }

    if (save && db != null) {
      db.insertItem(type, (Item) createdItem);
    }

    return (Item) createdItem;
  }

  /**
   * Sets the database.
   *
   * @param argdb the new database
   */
  public void setDatabase(Database argdb) {
    db = argdb;
  }
}
