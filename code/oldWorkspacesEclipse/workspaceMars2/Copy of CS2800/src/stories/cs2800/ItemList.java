package stories.cs2800;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

/**
 * @author Emil Zahariev
 */
public class ItemList extends AbstractListModel<Item> {

  private ArrayList<Item> items = new ArrayList<Item>();
  
  public final void add(Item nextItemToAdd) {
    int index;
    for (index = 0; index < items.size()
        && items.get(index).compareTo(nextItemToAdd) < 0; index++) {
    }
    if (index == items.size() || items.get(index).compareTo(nextItemToAdd) != 0) {
      items.add(index, nextItemToAdd);
      fireIntervalAdded(this, index, index);
    }
  }

   @Override
  public int getSize() {
    return items.size();
  }

  @Override
  public Item getElementAt(int indexToRetrieve) {
    if (indexToRetrieve >= 0 && indexToRetrieve < items.size()) {
      return items.get(indexToRetrieve);
    }
    throw new IndexOutOfBoundsException();
  }
}
