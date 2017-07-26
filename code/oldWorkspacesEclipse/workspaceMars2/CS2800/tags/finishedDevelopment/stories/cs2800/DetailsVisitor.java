package stories.cs2800;

import stories.cs2800.AggregateItem;
import stories.cs2800.ItemVisitor;
import stories.cs2800.SingleItem;

/**
 * The Class DetailsVisitor.
 * 
 * @author emil
 */
public class DetailsVisitor implements ItemVisitor<String> {

  /** The result. */
  private StringBuilder result = new StringBuilder();

  /** The first node. */
  private Boolean firstNode = Boolean.valueOf(true);


  /**
   * @see stories.cs2800.ItemVisitor#shouldRecurse()
   */
  public final boolean shouldRecurse() {
    boolean recResult = firstNode.booleanValue();
    firstNode = Boolean.valueOf(false);
    return recResult;
  }

  /**
   * @see stories.cs2800.ItemVisitor#add(stories.cs2800.AggregateItem)
   */
  public final void add(AggregateItem aggregateItemToAdd) {
    if (!firstNode.booleanValue()) {
      if (result.length() > 0) {
        result.append("");
      }

      result.append(aggregateItemToAdd.getName());
    }

  }

  /**
   * @see stories.cs2800.ItemVisitor#add(stories.cs2800.SingleItem)
   */
  public final void add(SingleItem singleItemToAdd) {
    if (!firstNode.booleanValue()) {
      if (result.length() > 0) {
        result.append("");
      }

      result.append(singleItemToAdd.getChild().getName());
    }

  }

  /**
   * @see stories.cs2800.ItemVisitor#getResult()
   */
  public final String getResult() {
    return result.toString();
  }
}
