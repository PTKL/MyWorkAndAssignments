/**
 * The AggregateItem Class. All @methods tagged with @Override are provided by Professor David
 * Cohen. Note that all of the @methods tagged with @Override when imported where assigned a single
 * character argument name and have been refactored to be given more descriptive names.
 * 
 * @version 1
 * 
 * @author Emil Zahariev
 */



import java.util.ArrayList;
import java.util.Collections;

import javax.swing.AbstractListModel;

public class ItemList extends AbstractListModel<Item> {

  /**
   * default serial number.
   * 
   * @param serialVersionUID is the serial number
   */
  private static final long serialVersionUID = 1L;
  /**
   * List of items.
   * 
   * @param items the item list
   * 
   */
  private ArrayList<Item> items = new ArrayList<Item>();

  /**
   * returns the size of the list (number of items).
   * 
   * @return the size of the list
   */
  @Override
  public int getSize() {
    return items.size();
  }

  /**
   * @param indexToRetrieve index number of the item to return.
   * 
   * @throws IndexOutOfBoundsException. Thorws an exception if the index of the item is larger than
   *         the size of the list or does not exist
   */
  @Override
  public final Item getElementAt(int indexToRetrieve) {
    if (indexToRetrieve >= 0) {
      if (indexToRetrieve < items.size()) {
        return items.get(indexToRetrieve);
      }
    }
    throw new IndexOutOfBoundsException();
  }

  /**
   * @param nameOfItem name of the item to return.
   * 
   */
  public Item getElementByName(String nameOfItem) {
    Item itemCheck;
    for (int index = 0; index < items.size(); index++) {
      itemCheck = items.get(index);
      if (itemCheck.getName().equals(nameOfItem)) {
        return itemCheck;
      }
    }
    return null;
  }

  /**
   * The item to be added to the list.
   * 
   * @param nextItemToAdd next item to add
   */
  public void add(Item nextItemToAdd) {
    items.add(nextItemToAdd);
    Collections.sort(items);
    fireIntervalAdded(nextItemToAdd, indexOf(nextItemToAdd), indexOf(nextItemToAdd));
  }

  /**
   * Return the item's index number.
   * 
   * @param itemIndexCheck check the index of the item
   * @return item index
   */
  public int indexOf(Item itemIndexCheck) {
    return items.indexOf(itemIndexCheck);
  }

  /**
   * Remove an item from the list based on its index.
   * 
   * @param indexToRemove index number of the item to remove.
   * 
   * @throws IndexOutOfBoundsException. Thorws an exception if the index of the item is larger than
   *         the size of the list or does not exist
   */
  public Boolean remove(int indexToRemove) {
    if (indexToRemove >= 0) {
      if (indexToRemove < items.size()) {
        items.remove(indexToRemove);
        return true;
      }
    }
    throw new IndexOutOfBoundsException();
  }

  /**
   * Remove an item from the list based on the index.
   * 
   * @param itemToRemove item to remove
   * @return removed index
   */
  public Boolean remove(Item itemToRemove) {
    int index = indexOf(itemToRemove);
    if (index == -1) {
      return false;
    }
    return remove(index);
  }

  /**
   * Change the items of the list.
   * 
   * @param itemChanged item to change
   */
  public void changed(Item itemChanged) {
    int childNumber = this.indexOf(itemChanged);
    if (childNumber != -1) {
      fireContentsChanged(this, childNumber, childNumber);
    }
  }

  /**
   * Check if an item exists in the list.
   * 
   * @param itemToCheck item to check existence of
   * @return true if item is in the list
   */
  public Boolean contains(Item itemToCheck) {
    return items.contains(itemToCheck);
  }

}
