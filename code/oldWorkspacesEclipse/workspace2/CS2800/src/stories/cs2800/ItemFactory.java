package stories.cs2800;

import stories.cs2800.AggregateItem;
import stories.cs2800.Database;
import stories.cs2800.Item;
import stories.cs2800.ItemType;
import stories.cs2800.NameClashException;
import stories.cs2800.SingleItem;

public class ItemFactory {
  private static ItemFactory instanceOfItemFactory = new ItemFactory();
  private Database db;


  public static ItemFactory getInstance() {
    return instanceOfItemFactory;
  }

  public Item createItem(String name, ItemType type, String desc, float value, Item child,
      boolean save) throws NameClashException {
    Object createdItem;


    if (ItemType.PROJECT.equals(type) || ItemType.STORY.equals(type)
        || ItemType.STORY.equals(ItemType.DEVELOPER)) {
      createdItem = new AggregateItem(name, desc, value);
    } else if (ItemType.STORY_DEVELOPER.equals(type)) {
      createdItem = new SingleItem(name, value, child);
    } else {
      createdItem = null;
    }

    if (save && this.db != null) {
      db.insertItem(type, (Item) createdItem);
    }

    return (Item) createdItem;
  }

  public void setDatabase(Database argdb) {
    db = argdb;
  }
}
