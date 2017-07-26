package test.stories.cs2800;
import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

import stories.cs2800.ItemList;
import stories.cs2800.Item;


/**
 * @author Emil Zahariev
 */
public class TestItemList {

  /** The itemTest variable. */
  private ItemList itemTest;
  private Item testAdd;

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
    itemTest.add();
    assertEquals("Item Add Has Failed!", itemTest, 5);
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
    itemTest.add();
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
      itemTest.getElementAt(5);
    } catch (Exception e) {
      itemTest.getElementAt(5);
      assertEquals(itemTest.getSize(), 5);
    }
  }
}
