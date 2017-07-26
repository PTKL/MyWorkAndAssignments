package stories.cs2800;

import stories.cs2800.Item;
import stories.cs2800.ItemState;

import java.util.ArrayList;

public class ItemStateOpen implements ItemState {
  private ArrayList<Item> argChildren;

  public ItemStateOpen(ArrayList<Item> argChildren) {
    this.argChildren = argChildren;
  }

  public final void add(Item itemToAdd) {
    this.argChildren.add(itemToAdd);
  }

  public final boolean isOpen() {
    return true;
  }
}
