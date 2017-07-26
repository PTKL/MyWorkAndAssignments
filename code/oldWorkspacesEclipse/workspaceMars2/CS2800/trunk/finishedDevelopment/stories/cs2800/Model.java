package stories.cs2800;

import stories.cs2800.CostVisitor;
import stories.cs2800.Database;
import stories.cs2800.DetailsVisitor;
import stories.cs2800.InvolvedWithVisitor;
import stories.cs2800.Item;
import stories.cs2800.ItemFactory;
import stories.cs2800.ItemList;
import stories.cs2800.ItemType;
import stories.cs2800.NameClashException;

import java.util.HashMap;
import java.util.Map;

/**
 * The model class is used to process the item data and is observed by the Controller.
 * 
 * @author emil
 *
 */
public class Model {

  /** The lists. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  private Map<ItemType, ItemList> lists = new HashMap();

  /** The item factory. */
  private ItemFactory itemFactory = ItemFactory.getInstance();

  /** The instance of model. */
  private static Model instanceOfModel = new Model();

  /**
   * Instantiates a new model.
   */
  private Model() {
    lists.put(ItemType.DEVELOPER, new ItemList());
    lists.put(ItemType.PROJECT, new ItemList());
    lists.put(ItemType.STORY, new ItemList());
    lists.put(ItemType.STORY_DEVELOPER, new ItemList());
  }

  /**
   * Gets the model.
   *
   * @return the model
   */
  public static Model getModel() {
    return instanceOfModel;
  }



  /**
   * Adds the item.
   *
   * @param name the name
   * @param itemType @see ItemType
   * @param description the description
   * @param value the value
   * @param child the child
   * @return the item @see Item
   * @throws NameClashException the name clash exception
   */
  public Item addItem(String name, ItemType itemType, String description, float value, Item child)
      throws NameClashException {
    Item itemToAdd = itemFactory.createItem(name, itemType, description, value, child, false);
    (lists.get(itemType)).add(itemToAdd);
    return itemToAdd;
  }

  /**
   * Gets the items.
   *
   * @param type @see ItemType
   * @return the items
   */
  public ItemList getItems(ItemType type) {
    return lists.get(type);
  }

  /**
   * Gets the details.
   *
   * @param item @see Item
   * @return the details
   */
  public String getDetails(Item item) {
    DetailsVisitor visitorDetails = new DetailsVisitor();
    item.accept(visitorDetails);
    return visitorDetails.getResult();
  }

  /**
   * Gets the personnel.
   *
   * @param item @see Item
   * @return the personnel
   */
  public ItemList getPersonnel(Item item) {
    InvolvedWithVisitor person = new InvolvedWithVisitor(item);
    item.accept(person);
    return person.getResult();
  }

  /**
   * Gets the cost.
   *
   * @param item the item
   * @param type @see ItemType
   * @return the cost
   */
  public Float getCost(Item item, ItemType type) {
    CostVisitor cost = new CostVisitor(item, type);
    item.accept(cost);
    return cost.getResult();
  }

  /**
   * Restore state and save for items in database.
   *
   * @param db the database
   * @return the state of the items in the database
   */
  public String restoreState(Database db) {
    if (db == null) {
      return "There is no database present";
    } else {
      try {
        lists.put(ItemType.DEVELOPER, db.restoreItems(ItemType.DEVELOPER));
        lists.put(ItemType.STORY, db.restoreItems(ItemType.STORY));
        lists.put(ItemType.PROJECT, db.restoreItems(ItemType.PROJECT));
        lists.put(ItemType.STORY_DEVELOPER, db.restoreItems(ItemType.STORY_DEVELOPER));
        db.restoreRelationships();
        db.restoreState();
      } catch (NameClashException nameClash) {
        nameClash.printStackTrace();
      }

      return db.getStorageDescription();
    }
  }
}

