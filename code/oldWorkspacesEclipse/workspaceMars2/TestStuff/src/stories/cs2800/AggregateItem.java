package stories.cs2800;
import java.util.ArrayList;

public class AggregateItem implements Item {

  private ArrayList<Item> children = new ArrayList<Item>();
  private ItemState openState = new ItemStateOpen(children);
  private ItemState closedState;
  private ItemState state;
  private String name;
  private String description;
  private float value;

  public AggregateItem(String argNameNew, String argDescriptionNew, float argValueNew) {
      this.state = this.closedState = new ItemStateClosed();
      this.name = argNameNew;
      this.description = argDescriptionNew;
      this.value = argValueNew;
  }

  @Override
  public final String getName() {
      return name;
  }

  @Override
  public final void add(Item childToAdd) {
      state.add(childToAdd);
  }

  @Override
  public final <T> void accept(ItemVisitor<T> visitorToAdd) {
    visitorToAdd.add(this);
      if (visitorToAdd.shouldRecurse()) {
          for (Item checkItem : children) {
            checkItem.accept(visitorToAdd);
          }
      }
  }

  @Override
  public final Float getValue() {
      return Float.valueOf(value);
  }

  @Override
  public final String getDescription() {
      return description;
  }

  @Override
  public final void open(boolean toOpen) {
      state = toOpen ? openState : closedState;
  }

  @Override
  public final boolean isOpen() {
      return state.isOpen();
  }

  @Override
  public final int compareTo(Item itemToCompareTo) {
      return name.compareTo(itemToCompareTo.getName());
  }
  
  
  @Override
  public String toString() {
    return "AggregateItem [children=" + children + ", openState=" + openState + ", closedState="
        + closedState + ", state=" + state + ", name=" + name + ", description=" + description
        + ", value=" + value + "]";
  }

  @Override
  public final void setValue(Float floatValue) {
      throw new IllegalStateException();
  }
}

