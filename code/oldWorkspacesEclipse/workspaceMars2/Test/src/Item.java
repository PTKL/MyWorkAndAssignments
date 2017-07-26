

/**
 * The Interface Item.  In this system an Item will represent either a project,
 *  a developer, a task, or a developer working on a task (task-worker).
 * In each case the value will mean something to the object.
 *    The value of a project is the total expected cost (in pounds)
 *    The value of a task is the expected cost of that task (in developer hours)
 *    The value of a developer is their hourly rate (in pounds)
 *    The value of a developer associated with a task (task-worker) is the
 *        number of hours they have spent on the task.
 *
 * The links between objects are natural:
 *    A project's children are the tasks associated with that project.
 *    A developer's children are the tasks that they are assigned to.
 *    A task's children should be the developers working  on the task, but
 *        since we need to keep track of the hours each developer has spent on
 *        each task we use a task-worker object
 *    The single child of a task-worker is the developer.
 *
 *  For this reason we never display a task-worker on the screen.  The child
 *     links are enough to find out who is working on what and how long they
 *     have spent.
 *
 *  So the SingleItem object should throw an Exception if you try to set
 *     the description, or if you add a child and it already had one.  Also
 *     setting the value on an AggregateItem should throw an Exception.
 *
 *  In the first instance when developing these classes with TDD it is wise
 *    just to have a minimal SingleItem implementation that has
 *    stubs for all setters and returns fixed (fake) values to the getters.
 *
 *  If you have no Visitor classes implemented then it is safe for the accept
 *    method to be a stub.
 *  The accept method for an aggregate item does nothing except
 *    1) add its own details (by calling the add() method of the Visitor
 *    2) asks the Visitor if wants to process more children by calling the
 *       shouldRecurse() method
 *    3) If it should recurse then calls accept for each of its children,
 *       passing in the Visitor.
 *
 * The accept method for a single item just adds its own details by calling
 *     the add method of the Visitor
 *
 * This allows us to pass a visitor to an Item to get it to find total costs,
 * co-workers etc.,
 *
 * @author Professor David Cohen
 */
public interface Item extends Comparable {

    /**
     * Generate a String representation of the Item (for debugging purposes).
     *
     * @return the string
     */
    @Override
    String toString();

    /**
     * Gets the name which is the unique identifier of this Item.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets the value, whose meaning depends on the use of the Item.
     *
     * @return the value
     */
    Float getValue();

    /**
     * Sets the value, whose meaning depends on the use of the Item..
     *
     * @param f
     *            the new value
     */
    void setValue(Float f);

    /**
     * Gets the description, which can be quite long and should be informative.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Adds a child Item.  the maximum number, and the meaning of a child Item
     * depend on the use of the Item.
     *
     * @param child
     *            the child
     */
    void add(Item child);

    /**
     * Accept.  This is the accept method of the Visitor pattern.
     * The Visitor object itself is of type ItemVisitor<T>.
     * Visitor objects are passed through an Item structure, following children
     * and building a return value of type T.
     *
     * @param <T>
     *            the type that will be returned by the Visitor
     * @param u
     *            the Visitor that collects data on an Item structure
     */
    <T> void accept(ItemVisitor<T> u);

    /**
     * Open or close the item.
     * If the argument is true then open, otherwise close.
     *
     * @param b open (true) or close (false)
     */
    void open(boolean b);

    /**
     * Compare this Item with another.  Returns an integer which is zero if they
     * are equal.  The sign of a non-zero return should indicate which Item is
     * larger.
     * Since two Items are considered equal if their names are the same, this
     * method should compare the names (probably ignoring case)
     *
     * @param item
     *            the other item for comparison
     * @return greater, less than or equal zero depending on whether
     * this.name > item.name, equal to it, or less than it in a dictionary
     * order, perhaps ignoring case.
     */
    int compareTo(Item item);

    /**
     * check whether an item is open.
     * @return whether the item is open
     */
    boolean isOpen();
}
