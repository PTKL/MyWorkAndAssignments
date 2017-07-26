package tests.stories.cs2800;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import stories.cs2800.AggregateItem;
import stories.cs2800.Item;
import stories.cs2800.ItemStateClosed;


/**
 *
 * @author emil.
 */
public class ItemStateClosedTest {
  public ItemStateClosed itemStateClosedTest;



  /**
   * Perform pre-test initialization.
   *
   * @throws Exception if the initialization fails for some reason
   *
   */
  @Before
  public void setUp() throws Exception {
    itemStateClosedTest = new ItemStateClosed();
  }

  /**
   * Run the ItemStateClosed() constructor test.
   *
   * @throws Exception
   *
   */


  @Test
  public void testItemStateClosed() throws Exception {

    ItemStateClosed result = new ItemStateClosed();

    // add additional test code here
    assertNotNull(result);
    assertEquals(false, result.isOpen());
  }

  /**
   * Run the void add(Item) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testAdd() throws Exception {
    Item itemToAdd = new AggregateItem("", "", 1.0f);

    itemStateClosedTest.add(itemToAdd);

  }

  /**
   * Run the boolean isOpen() method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testIsOpen() throws Exception {

    boolean result = itemStateClosedTest.isOpen();

    assertEquals(false, result);
  }
}
