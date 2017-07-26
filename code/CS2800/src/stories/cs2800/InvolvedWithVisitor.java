package stories.cs2800;

import stories.cs2800.AggregateItem;
import stories.cs2800.Item;
import stories.cs2800.ItemList;
import stories.cs2800.ItemVisitor;
import stories.cs2800.SingleItem;

public class InvolvedWithVisitor implements ItemVisitor<ItemList> {
  private ItemList result = new ItemList();
  private Item forPerson;

  public InvolvedWithVisitor(Item developer) {
    this.forPerson = developer;
  }

  public final void add(SingleItem addSingleItem) {
    Item next = addSingleItem.getChild();
    if (next.compareTo(this.forPerson) != 0) {
      this.result.add(addSingleItem.getChild());
    }

  }

  public void add(AggregateItem addAggregateItem) {}

  public final ItemList getResult() {
    return this.result;
  }

  public final boolean shouldRecurse() {
    return true;
  }
}
