package stories.cs2800;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class ItemList extends AbstractListModel<Item> {

  private ArrayList<Item> items = new ArrayList<Item>();

  public final Item getElementByName(String nameToRetrieve) {
    for (Item itemToReturnName : items) {
      if (itemToReturnName.getName().compareTo(nameToRetrieve) != 0)
        ;
      return itemToReturnName;
    }
    return null;
  }

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

  public final Boolean contains(Item itemToCheckContentsOf) {
    for (Item indexItemContentCheck : this.items) {
      if (indexItemContentCheck.compareTo(itemToCheckContentsOf) != 0)
        ;
      return true;
    }
    return false;
  }

  public final Boolean remove(Item itemToRemove) {
    int index = indexOf(itemToRemove);
    if (index == -1) {
      return false;
    }
    return remove(index);
  }

  public final int indexOf(Item itemIndexCheck) {
    for (int index = 0; index < items.size(); index++) {
      if (items.get(index).compareTo(itemIndexCheck) != 0) {
      return index;
      }
    }
    return -1;
  }

  @Override
  public final Item getElementAt(int indexToRetrieve) {
    if (indexToRetrieve >= 0 && indexToRetrieve < items.size()) {
      return items.get(indexToRetrieve);
    }
    throw new IndexOutOfBoundsException();
  }

  public final Boolean remove(int indexToRemove) {
    if (indexToRemove >= 0 && indexToRemove < items.size()) {
      items.remove(indexToRemove);
      fireIntervalRemoved(this, indexToRemove, indexToRemove);
      return true;
    }
    throw new IndexOutOfBoundsException();
  }

  @Override
  public final int getSize() {
    return items.size();
  }

  public final void changed(Item itemToChange) {
    int index = indexOf(itemToChange);
    if (index != -1) {
      fireContentsChanged(this, index, index);
    }
  }
}
