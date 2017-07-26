/**
 * The AggregateItem Class. All @methods tagged with @Override are provided by Professor David
 * Cohen. Note that all of the @methods tagged with @Override when imported where assigned a single
 * character argument name and have been refactored to be given more descriptive names.
 * 
 * @version 1
 * 
 * @author Emil Zahariev
 */

package stories.cs2800;

import java.util.ArrayList;

public class AggregateItem implements Item {

  private ArrayList<Item> children = new ArrayList<Item>();
  /** temporary value for the open method. */
  private boolean stateOpen = true;
  /** the name to be initialized. */
  private String name;
  /** the description of the item. */
  private String description;
  /** the value to be initialized. */
  private float value;

  /**
   * Instantiates a new AggregateItem.
   *
   * @param argName the name to be initialized
   * @param argValue the value to be initialized
   * @param argDescription the description of the item
   */
  public AggregateItem(String argName, String argDescription, float argValue) {
    this.name = argName;
    this.description = argDescription;
    this.value = argValue;
  }

  /**
   * @return name. retrieves the name of the AggregateItem object
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * @param childToAdd adding a child to the AggregateItem object.
   * 
   */
  @Override
  public void add(Item childToAdd) {
    children.add(childToAdd);
  }

  /**
   * @param <T> the return type for the Visitor.
   * 
   * @param itemVisitorData the Visitor that collects the data
   * 
   *        method not yet implemented
   * 
   * @see Project specification for additional details
   */
  @Override
  public <T> void accept(ItemVisitor<T> visitorToAdd) {
    // to be implemented at a later stage
  }

  /**
   * @return value. retrieves the value of the AggregateItem object
   */
  @Override
  public Float getValue() {
    return value;
  }

  /**
   * @return returns the description of the AggregateItem object.
   * @see Project specification for additional details
   */
  @Override
  public String getDescription() {
    return description;
  }

  /**
   * 
   * @param toOpen to open the Item depending on the state.
   * 
   * @see open Chek
   * 
   */
  @Override
  public void open(boolean toOpen) {
    stateOpen = toOpen;
  }

  /**
   * check the state of the item.
   * 
   * @return whether the item is open
   */
  @Override
  public boolean isOpen() {
    return stateOpen;
  }

  /**
   * @param itemToCompareTo the other item for comparison
   * 
   * @return greater, less than or equal zero depending on whether this.name > item.name, equal to
   *         it, or less than it in a dictionary order, perhaps ignoring case.
   */
  @Override
  public int compareTo(Item itemToCompareTo) {
    if (this.getName().equals(itemToCompareTo.getName())) {
      return 0;
    } else {
      return 1;
    }
  }

  /**
   * toString used to display the contents of the AggregateItem object.
   */
  @Override
  public String toString() {
    return "AggregateItem [name " + name + " description " + description + " value " + value + "]";
  }

  /**
   * @param floatNumber. is the numerical float value to be set to the AggregateItem object
   */
  @Override
  public final void setValue(Float floatValue) {
    throw new IllegalStateException();
  }

  /**
   * returns the size of the AggregateItem object (number of items/children).
   * 
   * @return size of the object
   */
  public Object getSize() {
    return children.size();
  }

  @Override
  public int compareTo(Object o) {
    // TODO Auto-generated method stub
    return 0;
  }
}

