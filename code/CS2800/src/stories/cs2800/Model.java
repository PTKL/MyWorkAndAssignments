package stories.cs2800;

import java.util.HashMap;
import java.util.Map;
import stories.cs2800.CostVisitor;
import stories.cs2800.Database;
import stories.cs2800.DetailsVisitor;
import stories.cs2800.InvolvedWithVisitor;
import stories.cs2800.Item;
import stories.cs2800.ItemFactory;
import stories.cs2800.ItemList;
import stories.cs2800.ItemType;
import stories.cs2800.NameClashException;

public final class Model {
  @SuppressWarnings({"unchecked", "rawtypes"})
  private Map<ItemType, ItemList> lists = new HashMap();
  private ItemFactory itemFactory = ItemFactory.getInstance();
  private static Model instanceOfModel = new Model();

  private Model() {
    lists.put(ItemType.DEVELOPER, new ItemList());
    lists.put(ItemType.PROJECT, new ItemList());
    lists.put(ItemType.STORY, new ItemList());
    lists.put(ItemType.STORY_DEVELOPER, new ItemList());
  }

  public static Model getModel() {
    return instanceOfModel;
  }



  public Item addItem(String name, ItemType itemType, String description, float value, Item child)
      throws NameClashException {
    Item itemToAdd = itemFactory.createItem(name, itemType, description, value, child, false);
    (lists.get(itemType)).add(itemToAdd);
    return itemToAdd;
  }

  public ItemList getItems(ItemType type) {
    return lists.get(type);
  }

  public String getDetails(Item item) {
    DetailsVisitor visitorDetails = new DetailsVisitor();
    item.accept(visitorDetails);
    return visitorDetails.getResult();
  }

  public ItemList getPersonnel(Item item) {
    InvolvedWithVisitor person = new InvolvedWithVisitor(item);
    item.accept(person);
    return person.getResult();
  }

  public Float getCost(Item item, ItemType type) {
    CostVisitor cost = new CostVisitor(item, type);
    item.accept(cost);
    return cost.getResult();
  }

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

