package stories.cs2800;

/**
 * The Class CostVisitor.  Passed to the accept method of an Item, it traverses
 * the Item structure to work out the cost of that Item
 *
 * <p>The cost of a Developer is the total cost (hours * hourly rate) of work done
 *     by that developer on any story
 * The cost of a Project is the total cost of work done by any developer on
 *     any story of the project
 * The cost of a Story is the total cost of work done by any developer on
 *     that story
 *
 * @author Professor David Cohen
 */
public class CostVisitor implements ItemVisitor<Float> {

  /** The total cost. */
  private Float result = 0f;

  /** If we are costing a developer then we are only interested in work done
   *  by that developer. */
  private String forName = null;

  /**
   * Instantiates a new cost visitor.
   *
   * @param item the item for which we are aggregating costs
   * @param type the type of the item
   */
  public CostVisitor(final Item item, final ItemType type) {
    if (type == ItemType.DEVELOPER) {
      forName = item.getName();
    }
  }

  /**
   * Called by the Item being visited to add its own cost.  Since it is
   * a SingleItem it must be a STORY_WORKER.  Its child is the developer,
   * whose value is their hourly rate.  So the cost to this story is the
   * hours worked (the value of the parameter Item) times the value of
   * its child Item.
   *
   * @param item the the Item whose cost we are adding
   */
  @Override
  public final void add(final SingleItem item) {
    if (forName == null || item.getChild().getName().equals(forName)) {
      result += item.getValue() * item.getChild().getValue();
    }
  }

  /**
   * No aggregate Item adds cost to an ongoing story so they can be ignored.
   *
   * @param item not a STORY_WORKER so ignored
   */
  @Override
  public void add(final AggregateItem item) {
    // Does nothing except wait for the children to be processed.
  }

  /**
   * The total cost accumulated by the Visitor.
   *
   * @returns the total cost
   */
  @Override
  public final Float getResult() {
    return result;
  }

  /**
   * Called by aggregate Items to find out whether they should pass the
   * Visitor onto their children.
   * A Cost Visitor needs to process items until it gets to the
   * STORY_WORKER Items so we should get aggregate items to recurse.
   */
  @Override
  public final boolean shouldRecurse() {
    return true;
  }
}
