import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

/**
 * @author Emil Zahariev
 */
public class TestItemList {

  /** The itemTest variable. */
  private ItemList itemTest;

  /**
   * Sets the up.
   */
  @Before
  public void setUp() {
    itemTest = new ItemList();
  }

  /**
   * Item add.
   */
  @Test
  public void itemAdd() {
    itemTest.add(new Integer(5));
  }

  /**
   * Test size.
   */
  @Test
  public void testSize() {

  }

  /**
   * Item list.
   */
  public void itemList() {
    assertEquals(itemTest.getSize(), 0);
  }

  /**
   * Adds the then size.
   */
  @Test
  public void addThenSize() {
    itemTest.add(5);
    assertEquals(itemTest.getSize(), 1);
  }

  /**
   * Gets the element at.
   *
   * @return the element at
   * @throws Exception the exception
   */
  @Test
  public void getElementAt() throws Exception {
    try {
      itemTest.elementAt(5);
    } catch (Exception e) {
      itemTest.elementAt(5);
      assertEquals(itemTest.getSize(), 5);
    }
  }
}
