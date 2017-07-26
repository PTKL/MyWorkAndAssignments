package stories.cs2800;

import stories.cs2800.Item;
import stories.cs2800.ItemState;

/**
 * ItemStateClosed class from the state design patter designates that the state of any item it is
 * called on should be closed.
 * 
 * @author emil
 *
 */

public class ItemStateClosed implements ItemState {
  public ItemStateClosed() {}
  /**
   * @see stories.cs2800.ItemState#add(stories.cs2800.Item)
   */
  @Override
  public void add(Item itemToAdd) {}
  /**
   * This method should always false true in this case indicating that an add can't be performed.
   * 
   * @see stories.cs2800.ItemState#isOpen(stories.cs2800.Item)
   */
  @Override
  public boolean isOpen() {
    return false;
  }
}
