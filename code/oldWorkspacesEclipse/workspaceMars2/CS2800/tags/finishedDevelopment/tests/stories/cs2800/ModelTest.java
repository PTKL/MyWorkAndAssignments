package tests.stories.cs2800;

import org.junit.*;

import stories.cs2800.AggregateItem;
import stories.cs2800.Database;
import stories.cs2800.DatabaseActions;
import stories.cs2800.Item;
import stories.cs2800.ItemList;
import stories.cs2800.ItemType;
import stories.cs2800.Model;
import stories.cs2800.NameClashException;

import static org.junit.Assert.*;

/**
 *
 * @author emil
 */
public class ModelTest {

  public Model modelTestVar;

  public Database databaseTest;


  /**
   * Perform pre-test initialization.
   *
   *
   */
  @Before
  public void setUp() {
    modelTestVar = Model.getModel();
    databaseTest = new Database((DatabaseActions) null);
  }

  /**
   * Run the Item addItem(String,ItemType,String,float,Item) method test.
   * @throws NameClashException 
   *
   *
   */
  @Test
  public void testAddItem() throws NameClashException {
    String name = "";
    ItemType itemType = ItemType.DEVELOPER;
    String description = "";
    float value = 1.0f;
    Item child = new AggregateItem("", "", 1.0f);

    Item result = modelTestVar.addItem(name, itemType, description, value, child);

    assertEquals(null, result);
  }


  /**
   * Run the Float getCost(Item,ItemType) method test.
   *
   *
   */
  @Test
  public void testGetCost() {
    Item item = new AggregateItem("", "", 1.0f);
    ItemType type = ItemType.DEVELOPER;

    Float result = modelTestVar.getCost(item, type);

    assertNotNull(result);
    assertEquals("0.0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
    assertEquals(false, result.isNaN());
    assertEquals(false, result.isInfinite());
  }

  /**
   * Run the String getDetails(Item) method test.
   *
   *
   */
  @Test
  public void testGetDetails() {
    Item item = new AggregateItem("", "", 1.0f);

    String result = modelTestVar.getDetails(item);

    assertEquals("", result);
  }

  /**
   * Run the ItemList getItems(ItemType) method test.
   *
   *
   */
  @Test
  public void testGetItems() {
    ItemType type = ItemType.DEVELOPER;

    ItemList result = modelTestVar.getItems(type);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the Model getModel() method test.
   *
   *
   */
  @Test
  public void testGetModel() {

    Model result = Model.getModel();

    assertNotNull(result);
  }

  /**
   * Run the ItemList getPersonnel(Item) method test.
   *
   *
   */
  @Test
  public void testGetPersonnel() {
    Item item = new AggregateItem("", "", 1.0f);

    ItemList result = modelTestVar.getPersonnel(item);

    assertNotNull(result);
    assertEquals(0, result.getSize());
  }

  /**
   * Run the String restoreState(Database) method test.
   *
   *
   */
  @Test
  public void testRestoreState() {
    Database db = null;

    String result = modelTestVar.restoreState(db);

    assertEquals("There is no database present", result);
  }

}
