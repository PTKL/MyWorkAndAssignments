package stories.cs2800;


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
