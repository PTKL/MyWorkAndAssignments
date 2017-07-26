package stories.cs2800;
public class SingleItem implements Item {
  
  private String name;
  private float value;
  private Item child;

  public SingleItem(String argNameNew, float argValueNew, Item argChildNew) {
    this.name = argNameNew;
    this.value = argValueNew;
    this.child = argChildNew;
  }

  @Override
  public final String getName() {
    return name;
  }

  @Override
  public final void add(Item argChildNew) {
    if (child != null) {
      throw new IllegalStateException();
    }
    child = argChildNew;
  }

  @Override
  public final <T> void accept(ItemVisitor<T> visitorToAdd) {
    visitorToAdd.add(this);
  }

  @Override
  public final Float getValue() {
    return Float.valueOf(value);
  }

  @Override
  public final String getDescription() {
    return "Single Items have no Description";
  }

  @Override
  public final void open(boolean toOpen) {
    throw new IllegalStateException();
  }

  @Override
  public final String toString() {
    return getName();
  }

  @Override
  public final int compareTo(Item itemToCompareTo) {
    return name.compareTo(itemToCompareTo.getName());
  }

  public final Item getChild() {
    return child;
  }

  @Override
  public final void setValue(Float newValueToSet) {
    value = newValueToSet.floatValue();
  }

  @Override
  public final boolean isOpen() {
    return true;
  }
}
