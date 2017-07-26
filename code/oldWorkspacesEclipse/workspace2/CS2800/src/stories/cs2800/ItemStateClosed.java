package stories.cs2800;

import stories.cs2800.Item;
import stories.cs2800.ItemState;

public class ItemStateClosed implements ItemState {
  public ItemStateClosed() {}

  public void add(Item itemToAdd) {}

  public final boolean isOpen() {
    return false;
  }
}
