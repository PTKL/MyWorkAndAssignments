package stories.cs2800;

/**
 * The Interface ItemVisitor is an example of the Visitor pattern.
 * Passed to the accept method of an Item it then collects data about that Item
 *     and  its descendants.
 * Each Item is responsible for calling the add method of the Visor to add its
 *     own details.
 * AggregateItems then pass the Visitor on to (selected) children
 * So, after passing a Visitor to an Item, you can call getResult and will
 *     get the accumulated answer for the tree.
 *
 * @param <T>
 *            the generic type that will be calculated returned by a Visitor
 *
 * @author Professor David Cohen
 */
public interface ItemVisitor<T> {

    /**
     * Adds the appropriate contents of the item to the accumulated
     * return value.
     *
     * @param u
     *            the item whose details are being added
     */
    void add(AggregateItem u);

    /**
     * Adds the appropriate contents of the item to the accumulated
     * return value.
     *
     * @param u
     *            the item whose details are being added
     */
    void add(SingleItem u);

    /**
     * Gets the final accumulated result of passing the Visitor to an Item.
     *
     * @return the result
     */
    T getResult();

    /**
     * An AggregateItem calls this method in its accept method to decide whether
     * the Visitor be passed onto children, or is just finding out local
     * information.
     *
     * @return true, if the Item should pass the Visitor on to its children
     */
    boolean shouldRecurse();
}
