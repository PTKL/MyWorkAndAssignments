package tests.stories.cs2800;

import org.junit.*;

import stories.cs2800.AggregateItem;
import stories.cs2800.Database;
import stories.cs2800.DatabaseActions;
import stories.cs2800.Item;
import stories.cs2800.ItemFactory;
import stories.cs2800.ItemType;
import stories.cs2800.NameClashException;

import static org.junit.Assert.*;

/**
 *
 * @author emil
 */
public class ItemFactoryTest {

  public ItemFactory itemFactoryTestVar;

  /**
   * Perform pre-test initialization.
   *
   * @throws Exception if the initialization fails for some reason
   *
   */
  @Before
  public void setUp()  {
    itemFactoryTestVar = ItemFactory.getInstance();
  }
  /**
   * Run the Item createItem(String,ItemType,String,float,Item,boolean) method test.
   * @throws NameClashException 
   *
   *
   */
  @Test
  public void testCreateItem() throws NameClashException  {
    itemFactoryTestVar.setDatabase(new Database((DatabaseActions) null));
    String name = "";
    ItemType type = ItemType.DEVELOPER;
    String desc = "";
    float value = 1.0f;
    Item child = new AggregateItem("", "", 1.0f);
    boolean save = false;

    Item result = itemFactoryTestVar.createItem(name, type, desc, value, child, save);

    assertEquals(null, result);
  }

  
  /**
   * Run the ItemFactory getInstance() method test.
   *
   *
   */
  @Test
  public void testGetInstance()  {

    ItemFactory result = ItemFactory.getInstance();


    assertNotNull(result);
  }

  /**
   * Run the void setDatabase(Database) method test.
   *
   *
   */
  @Test
  public void testSetDatabase()  {
    itemFactoryTestVar.setDatabase(new Database((DatabaseActions) null));
    Database argdb = new Database((DatabaseActions) null);

    itemFactoryTestVar.setDatabase(argdb);
    assertNotNull(argdb);
  }


}
