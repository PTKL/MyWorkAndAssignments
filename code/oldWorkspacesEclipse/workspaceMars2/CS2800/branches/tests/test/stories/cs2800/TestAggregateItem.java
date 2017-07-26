/**
 * The Class TestSingleItem. Used to develop and test the class TestAggregateItem.
 * 
 * @version 1
 * 
 * @author Emil Zahariev
 */

package test.stories.cs2800;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import stories.cs2800.AggregateItem;
import stories.cs2800.Item;

public class TestAggregateItem {
  /**
   * @param aggregateItemTest is a variable to represent the AggregateItem class.
   */
  private AggregateItem aggregateItemTest;
  /**
   * @param aggregateItemTestCompareTo is a variable to test the compareTo method.
   */
  private AggregateItem aggregateItemTestCompareTo;
  /**
   * @param child - used to test the add method.
   */
  private Item child;
  /**
   * @param argValue - used to set value in the constructor.
   */
  private float argValue;

  /**
   * The AggregateItem constructor takes a String, a String and a float as its attributes.
   * @throws Exception for initialization errors.
   */
  @Before
  public void setUp() throws Exception {
    aggregateItemTest = new AggregateItem("hello", "no description yet", 5f);
    aggregateItemTestCompareTo = new AggregateItem("hello", "no description yet", 6f);

  }

  /**
   * used to test the return of the name.
   */
  @Test
  public void testGetName() {
    aggregateItemTest.getName();
    assertNotNull("No Name Given", aggregateItemTest.getName());
    assertEquals("hello", aggregateItemTest.getName());
  }

  /**
   * add method test.
   */
  @Test
  public void testAdd() {

    aggregateItemTest.add(child);
    assertEquals("Add has faild!", 1, aggregateItemTest.getSize());
  }

  /** To be implemented at a later stage. */
  @Test
  public void testAccept() {
    // to implement later according to specification
  }

  /**
   * test the return of the method getValue().
   */
  @Test
  public void testGetValue() {
    aggregateItemTest.getValue();
    assertEquals("No value to return", argValue, aggregateItemTest.getValue(), 5f);
  }

  /**
   * test the return of the method getDescription().
   */
  @Test
  public void testGetDescription() {
    // aggregateItemTest.getDescription();
    assertEquals("no description yet", aggregateItemTest.getDescription());
  }

  /**
   * Checks if the item is opened. Test isOpened method.
   */
  @Test
  public void testIsOpen() {
    assertTrue("Is not Open", aggregateItemTest.isOpen());
  }

  /**
   * Test open method. Open or close the item. If the argument is true, the item is opened.
   * Otherwise it is closed.
   */
  @Test
  public void testOpen() {
    aggregateItemTest.open(true);
    assertTrue("Is not Open", aggregateItemTest.isOpen());

  }

  /**
   * Tests compareTo method.
   */
  @Test
  public void testCompareTo() {
    aggregateItemTestCompareTo.compareTo(aggregateItemTestCompareTo);
    assertEquals("Items are not the same!", 0,
        aggregateItemTest.compareTo(aggregateItemTestCompareTo));
  }

  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    assertNotNull("toString Not implemented yet!", aggregateItemTest.toString());
  }

  /**
   * Test setValue method.
   */
  @Test(expected = IllegalStateException.class)
  public void testSetValue() {
    aggregateItemTest.setValue(6f);
  }
}
