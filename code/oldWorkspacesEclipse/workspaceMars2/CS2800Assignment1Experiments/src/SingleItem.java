
/**
 * @author Emil Zahariev The Class SingleItem.
 */
public class SingleItem implements Item {

  /** The name. */
  private String name;
  
  /** The status checker. */
  private boolean openCheck;

  /** The value. */
  private float value;

  /** The child. */
  private Item child;

  /**
   * Instantiates a new single item.
   *
   * @param nameNew the name new
   * @param valueNew the value new
   * @param childNew the child new
   */
  public SingleItem(String nameNew, float valueNew, Item childNew) {
    this.name = nameNew;
    this.value = valueNew;
    this.child = childNew;
  }

  
  @Override
  public void setValue(Float floatNumber) {
    this.value = floatNumber;

  }

  
  @Override
  public String getName() {
    name = "test";
    return name;
  }

  
  @Override
  public Float getValue() {
    return value;
  }



  
  @Override
  public String getDescription() {
    return "Single Items have no description";
  }

  /**
   * Gets the child.
   *
   * @return the child
   */
  public Item getChild() {
    return child;

  }

  
  @Override
  public void add(Item childNewToAdd) {
    if (childNewToAdd == null) {
      throw new IllegalStateException();

    } else {
      this.child = childNewToAdd;
    }
  }

  
  @Override
  public <T> void accept(ItemVisitor<T> u) {
    // TODO Auto-generated method stub

  }

  
  @Override
  public void open(boolean checker) {
    openCheck = checker;
  }

  
  @Override
  public int compareTo(Item itemToCompareTo) {
    if (child.getName().equals(itemToCompareTo.getName())) {
      return 0;
    }
    return 1;
  }


  
  @Override
  public boolean isOpen() {
    return true;
  }

  
  @Override
  public String toString() {
    return "SingleItem [name=" + name + ", value=" + value + ", child=" + child + "]";
  }



}
