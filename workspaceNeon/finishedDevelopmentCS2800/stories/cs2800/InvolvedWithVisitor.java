package stories.cs2800;

import stories.cs2800.AggregateItem;
import stories.cs2800.Item;
import stories.cs2800.ItemList;
import stories.cs2800.ItemVisitor;
import stories.cs2800.SingleItem;

/**
 * The Class InvolvedWithVisitor.
 * 
 * @author emil
 */
public class InvolvedWithVisitor implements ItemVisitor<ItemList> {

  /** The result. */
  private ItemList result = new ItemList();

  /** The for person. */
  private Item forPerson;

  /**
   * Instantiates a new involved with visitor.
   *
   * @param developer the developer
   */
  public InvolvedWithVisitor(Item developer) {
    forPerson = developer;
  }

  /**
   * @see stories.cs2800.ItemVisitor#add(stories.cs2800.SingleItem)
   */
  public final void add(SingleItem addSingleItem) {
    Item next = addSingleItem.getChild();
    if (next.compareTo(forPerson) != 0) {
      this.result.add(addSingleItem.getChild());
    }

  }

  /**
   * @see stories.cs2800.ItemVisitor#add(stories.cs2800.AggregateItem)
   */
  public void add(AggregateItem addAggregateItem) {}

  /**
   * @see stories.cs2800.ItemVisitor#getResult()
   */
  public final ItemList getResult() {
    return this.result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see stories.cs2800.ItemVisitor#shouldRecurse()
   */
  public final boolean shouldRecurse() {
    return true;
  }
}
