/**
 *
 */
package stories.cs2800;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class PsqlDB.
 *
 * @author Professor David Cohen
 *
 * This is an Adaptor to the Postgres Facade Class.
 * It is also a Bridge Concrete Implementer for the DBActions Bridge.
 * It provides persistent storage for items in the system.
 */
public class PsqlDB implements DatabaseActions {
  /** Connection to Postgres server. */
  private Connection conn = null;

  /** The database name used for this Bridge. */
  private String database = null;

  /**
   * Instantiates a new PostGres connection to a database.
   *
   * @param name the name of the database
   * @throws SQLException many things can go wrong
   */
  public PsqlDB(final String name) throws SQLException {
    database = name;
    conn = DriverManager.getConnection("jdbc:postgresql:" + database,
        "dave", "dave");
  }

  /**
   * <p>Restores the items from the postscript database things table.</p>
   * <p>Uses the mapping of key to database values:
   * <ul>
   *    <li>STORY -> "story"</li>
   *    <li>PROJECT -> "project"</li>
   *    <li>DEVELOPER -> "developer"</li>
   *    <li>STORY_DEVELOPER -> "worker"</li>
   * </ul>
   * </p>
   *
   * <p>Because there may already be some items in memory this process can
   * raise a NameClashException</p>
   *
   * @param key which kind of items to restore
   * @throws NameClashException when one of the restored items already
   *         exists in memory
   *
   */
  @Override
  public final ArrayList<Item> restoreThings(final ItemType key)
      throws NameClashException {
    ArrayList<Item> retval = new ArrayList<Item>();
    try {
      Statement st = conn.createStatement();
      ResultSet rs = null;
      final String sql = "SELECT * FROM things WHERE type = ";
      switch (key) {
        case DEVELOPER:
          rs = st.executeQuery(sql + "'developer'");
          break;
        case STORY:
          rs = st.executeQuery(sql + "'story'");
          break;
        case PROJECT:
          rs = st.executeQuery(sql + "'project'");
          break;
        case STORY_DEVELOPER:
          rs = st.executeQuery(sql + "'worker'");
          break;
        default:
          break;
      }
      while (rs.next()) {
        String name = rs.getString("id");
        float value = rs.getFloat("value");
        String desc = rs.getString("description");
        Item item = ItemFactory.getInstance().createItem(name, key,
            desc, value, null, false);
        retval.add(item);
        if (key != ItemType.STORY_DEVELOPER) {
          item.open(rs.getBoolean("open"));
        }
      }
      rs.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return retval;

  }

  /**
   * Restores the items from the postscript database things table.  Links
   * are keyed by the names of items.
   *
   * @return a list of links found in the database
   */
  @Override
  public final Map<String, ArrayList<String>> restoreLinks() {
    Map<String, ArrayList<String>> retval =
        new HashMap<String, ArrayList<String>>();
    try {
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM links");
      while (rs.next()) {
        String parent = rs.getString("parent");
        String child = rs.getString("child");
        System.out.println(parent + " " + child);
        if (!retval.containsKey(parent)) {
          retval.put(parent, new ArrayList<String>());
        }
        retval.get(parent).add(child);
      }
      rs.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return retval;
  }

  /**
   * Gets a list of all closed items from the database.
   * Whether an item is closed is an attribute in the things table.
   */
  @Override
  public final ArrayList<String> getClosed() {
    return new ArrayList<String>();
  }

  /**
   * A useful message string describing this implementation of the
   * database Bridge pattern.
   */
  @Override
  public final String getDBStatus() {
    return "Using a Postgres Database: " + database;
  }

  @Override
  /**
   * Attempts to store the item in the database.
   *
   * @param thing is the item to be saved
   * @throws NameClashException whenever the store fails
   */
  public final void storeItem(final ItemType key, final Item thing)
      throws NameClashException {
    // assume that a name clash is the only reason for failure;
    String sql = "INSERT INTO things (type, id, value, description)"
        + "VALUES (?::thing_type,?,?,?)";
    try {
      PreparedStatement st = conn.prepareStatement(sql);
      int param = 1;
      switch (key) {
        case PROJECT:
          st.setString(param, "project");
          break;
        case STORY:
          st.setString(param, "story");
          break;
        case DEVELOPER:
          st.setString(param, "developer");
          break;
        case STORY_DEVELOPER:
          st.setString(param, "worker");
          break;
        default:
          break;
      }
      param++;
      st.setString(param++, thing.getName());
      st.setFloat(param++, thing.getValue());
      st.setString(param++, thing.getDescription());
      if (st.executeUpdate() == 0) {
        throw new NameClashException();
      }
    } catch (SQLException e) {
      throw new NameClashException();
    }

  }

  @Override
  /**
   * Stores a link in the links table of the Database.
   *
   * @param parent text field value
   * @param child text field value
   */
  public final void addLink(final String parent, final String child) {
    String sql = "INSERT INTO links (parent, child) VALUES (?,?)";
    try {
      PreparedStatement st = conn.prepareStatement(sql);
      int param = 1;
      st.setString(param++, parent);
      st.setString(param++, child);
      st.executeUpdate();
    } catch (SQLException e) {
    }
  }

  @Override
  /**
   * set the value of an item.
   *
   * @param name the name of the item
   * @param addedValue the value to add
   */
  public final void setValue(final String name, final float value) {
    String sql = "UPDATE things SET value = ? WHERE id = ?";
    try {
      PreparedStatement st = conn.prepareStatement(sql);
      int param = 1;
      st.setFloat(param++, value);
      st.setString(param++, name);
      st.executeUpdate();
    } catch (SQLException e) {
    }
  }

  @Override
  /**
   * Set state of an item.
   *
   * @param name the name of the item
   * @param open the new state
   */
  public final void setState(final String name, final boolean open) {
    String sql = "UPDATE things SET open = ? WHERE id = ?";
    try {
      PreparedStatement st = conn.prepareStatement(sql);
      int param = 1;
      st.setBoolean(param++, open);
      st.setString(param++, name);
      st.executeUpdate();
    } catch (SQLException e) {
      System.out.println(
          "Hmmm - something unexpected happened opening or closing");
    }
  }
}
