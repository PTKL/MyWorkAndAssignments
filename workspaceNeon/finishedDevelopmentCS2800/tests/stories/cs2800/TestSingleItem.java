/**
 * The Class TestSingleItem. Used to develop and test the class SingleItem.
 * 
 * @version 1
 * 
 * @author Emil Zahariev
 */

package tests.stories.cs2800;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import stories.cs2800.SingleItem;

public class TestSingleItem {


  /**
   * @param testSingleItem. Used to test the creation and initialization of an object of the type
   *        SingleItem
   */
  private SingleItem testSingleItem;

  /**
   * @param compareToItemTest. Used to test the compareTo method
   */
  private SingleItem compareToItemTest;

  /**
   * The SingleItem constructor takes a String, a float and an Item as its attributes.
   * 
   * @throws java.lang.Exception is needed if a child cannot be found. (This is because child is
   *         directly effected by the Item class. Thus, if the Item class is altered or removed,
   *         child wont work as intended)
   */
  @Before
  public void setUp() throws Exception {
    testSingleItem = new SingleItem("test", 1, null);
    compareToItemTest = new SingleItem("test", 3, testSingleItem);
  }

  /**
   * Test getName method.
   */
  @Test
  public void testGetName() {
    assertEquals("No Name Yet Given!", "test", testSingleItem.getName());
  }

  /**
   * Test setValue method.
   */
  @Test
  public void testSetValue() {
    testSingleItem.setValue(1f);
    assertEquals("No Value Yet Given!", 1f, testSingleItem.getValue(), 0);
  }

  /**
   * Test getValue method.
   */
  @Test
  public void testGetValue() {
    assertNotNull("No Value Yet Given!", testSingleItem.getValue());
  }

  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    assertNotNull("toString Not implemented yet!", testSingleItem.toString());
  }

  /**
   * Test getDescription method.
   */
  @Test
  public void testGetDescription() {
    testSingleItem.getDescription();
    assertNotNull("No Description Yet Given!", testSingleItem.getDescription());

  }

  /**
   * Test add method.
   */
  @Test
  public void testAdd() {
    compareToItemTest.add(testSingleItem);
    assertEquals("Child add failed!", testSingleItem, compareToItemTest.getChild());

  }

  /**
   * Test getChild method.
   */
  @Test
  public void testGetChild() {
    testSingleItem.add(compareToItemTest);
    assertNotNull("No Child Yet Given!/No Value!", testSingleItem.getChild());

  }

  /**
   * Checks if the item is opened. Test isOpened method.
   */
  @Test
  public void testIsOpen() {
    assertTrue("Is not Open", testSingleItem.isOpen());
  }

  /**
   * Test open method. Open or close the item. If the argument is true, the item is opened.
   * Otherwise it is closed.
   */
  @Test
  public void testOpen() {
    testSingleItem.open(true);
    assertTrue("Is not Open", testSingleItem.isOpen());
  }


  /**
   * Tests compareTo method Compare this Item with another.
   */
  @Test
  public void testCompareTo() {
    assertEquals("Items are not the same!", 0, compareToItemTest.compareTo(compareToItemTest));
  }
}
