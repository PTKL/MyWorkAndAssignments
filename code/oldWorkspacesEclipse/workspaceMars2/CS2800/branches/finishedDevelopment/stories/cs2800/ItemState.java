package stories.cs2800;

import stories.cs2800.Item;


/**
 * The Interface ItemState.
 * 
 * @author emil
 */
public interface ItemState {

  /**
   * Adds the next possible item.
   *
   * @param itemToAdd the item to add
   */
  void add(Item itemToAdd);

  /**
   * Checks if is open.
   * For ItemStateOpen should always return true.
   * For ItemStateClosed should always return false.
   * @return true, if is open
   */
  boolean isOpen();
}
