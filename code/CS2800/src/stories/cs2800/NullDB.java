/**
 *
 */
package stories.cs2800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A concrete database implementation with no pretence.
 * Used when the user does not need to see stored information.
 * All data created by the application is lost when the applciation
 * closes.
 * Perhaps used for training purposes.
 *
 * @author Professor David Cohen
 *
 */
public class NullDB implements DatabaseActions {

  /* (non-Javadoc)
   * @see stories.cs2800.DBActions#restoreItems(stories.cs2800.ItemType)
   */
  @Override
  public final ArrayList<Item> restoreThings(final ItemType key)
      throws NameClashException {
    return new ArrayList<Item>();
  }

  /* (non-Javadoc)
   * @see stories.cs2800.DBActions#restoreLinks()
   */
  @Override
  public final Map<String, ArrayList<String>> restoreLinks() {
    return new HashMap<String, ArrayList<String>>();
  }

  /* (non-Javadoc)
   * @see stories.cs2800.DBActions#getClosed()
   */
  @Override
  public final ArrayList<String> getClosed() {
    return new ArrayList<String>();
  }

  @Override
  public final String getDBStatus() {
    return "Null Database - all data is ephemeral";
  }

  @Override
  /**
   * Does nothing in this null Database.
   *
   * @param thing is ignored
   */
  public void storeItem(final ItemType key, final Item thing)
      throws NameClashException {
  }

  @Override
  /**
   * Does nothing in this fake Database.
   *
   * @param parent ignored
   * @param child ignored
   */
  public void addLink(final String parent, final String child) {
  }

  @Override
  /**
   * Does nothing in this fake Database.
   * @param name ignored
   * @param vaue ignored
   */
  public final void setValue(final String name, final float value) {
  }

  @Override
  /**
   * Does nothing in this fake Database.
   * @param name ignored
   * @param open ignored
   */
  public void setState(final String name, final boolean open) {
  }
}
