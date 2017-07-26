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

public class SingleItem implements Item {


  /** The name of the SingleItem. */
  private String name;

  /**
   * The state check. Can be opened (true) or closed (false). To be finished for the final project
   * according to the specification
   *
   * @see Project specification for additional details
   */
  @SuppressWarnings("unused")
  private boolean openCheck;

  /** The value of the SingleItem. */
  private float value;

  /** The child of the SingleItem. */
  private Item child;

  /**
   * Instantiates a new SingleItem.
   *
   * @param argName the name to be initialized
   * @param argValue the value to be initialized
   * @param argChild the child to be initialized
   */
  public SingleItem(String argName, float argValue, Item argChild) {
    this.name = argName;
    this.value = argValue;
    this.child = argChild;
  }

  /**
   * @param floatNumber. is the numerical float value to be set to the SingleItem object
   */
  @Override
  public void setValue(Float floatNumber) {
    this.value = floatNumber;

  }

  /**
   * @return name. retrieves the name of the SingleItem object
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * @return value. retrieves the value of the SingleItem object
   */
  @Override
  public Float getValue() {
    return value;
  }



  /**
   * @return "Single Items have no description". returns the description of the SingleItem object.
   *         At this stage it is a simple string.
   * @see Project specification for additional details
   */
  @Override
  public String getDescription() {
    return "Single Items have no description";
  }

  /**
   * Returns the child of the SingleItem object.
   * 
   * @return the child.
   */
  public Item getChild() {
    return child;

  }

  /**
   * @param childNewToAdd adding a child to the SingleItem object
   * 
   * @throws IllegalStateException. Thorws an exception if the the SingleItem object we try to add
   *         to already has a child
   */
  @Override
  public void add(Item childNewToAdd) {
    if (childNewToAdd == null) {
      throw new IllegalStateException();

    } else {
      this.child = childNewToAdd;
    }
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
  public <T> void accept(ItemVisitor<T> itemVisitorData) {
    // to be implemented at a later stage.

  }

  /**
   * 
   * @param cheker to open the Item depending on the state.
   * 
   * @see open Chek
   * 
   */
  @Override
  public void open(boolean checker) {
    openCheck = checker;
  }

  /**
   * @param itemToCompareTo the other item for comparison
   * 
   * @return greater, less than or equal zero depending on whether this.name > item.name, equal to
   *         it, or less than it in a dictionary order, perhaps ignoring case.
   */
  @Override
  public int compareTo(Item itemToCompareTo) {
    if (child.getName().equals(itemToCompareTo.getName())) {
      return 0;
    } else {
      return 1;
    }
  }


  /**
   * check the state of the item.
   * 
   * @return whether the item is open
   */
  @Override
  public boolean isOpen() {
    return true;
  }

  /**
   * toString used to display the contents of the SingleItem object.
   */
  @Override
  public String toString() {
    return "SingleItem [name=" + name + ", value=" + value + ", child=" + child + "]";
  }

  @Override
  public int compareTo(Object o) {
    // TODO Auto-generated method stub
    return 0;
  }

}
