package stories.cs2800;

import stories.cs2800.Item;
import stories.cs2800.ItemState;

import java.util.ArrayList;

/**
 * ItemStateOpen class from the state design patter designates that the state of any item it is
 * called on should be open.
 * 
 * @author emil
 *
 */
public class ItemStateOpen implements ItemState {
  private ArrayList<Item> argChildren;

  /**
   * Constructor for the class.
   * 
   * @param argChildren the children to be assigned
   */
  public ItemStateOpen(ArrayList<Item> argChildren) {
    this.argChildren = argChildren;
  }

  /**
   * @see stories.cs2800.ItemState#add(stories.cs2800.Item)
   */
  @Override
  public void add(Item itemToAdd) {
    this.argChildren.add(itemToAdd);
  }

  /**
   * This method should always return true in this case indicating that an add can be performed.
   * 
   * @see stories.cs2800.ItemState#isOpen(stories.cs2800.Item)
   */
  @Override
  public boolean isOpen() {
    return true;
  }
}
