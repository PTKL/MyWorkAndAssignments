package tests.stories.cs2800;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import stories.cs2800.ItemList;
import stories.cs2800.SingleItem;

public class TetsItemList {
  /**
   * @param itemListTest is used to create a new ItemList to run tests on.
   */
  private ItemList itemListTest;
  /**
   * @param testSingleItemForItemList is used to create a new SingleItem to add to the ItemList and
   *        test.
   */
  private SingleItem testSingleItemForItemList;
  /**
   * @param testSingleItemChangedForItemList is used to create a new SingleItem to test the changed
   *        method.
   */
  private SingleItem testSingleItemChangedForItemList;

  /**
   * The ItemList constructor takes a String, a float and an Item as its attributes.
   * 
   * @throws java.lang.Exception is needed if a child cannot be found. (This is because child is
   *         directly effected by the Item class. Thus, if the Item class is altered or removed,
   *         child wont work as intended)
   */
  @Before
  public void setUp() throws Exception {
    itemListTest = new ItemList();
    testSingleItemForItemList = new SingleItem("SingleTestItem", 6f, null);
    testSingleItemChangedForItemList = new SingleItem("SingleTestItemChanged", 6f, null);
  }

  /**
   * Tests getSize method.
   */
  @Test
  public void testGetSize() {
    itemListTest.getSize();
    assertNotNull("It is empty!", itemListTest.getSize());
  }

  /**
   * Tests getElementAt method.
   */
  @Test
  public void testGetElementAt() {
    itemListTest.add(testSingleItemForItemList);
    itemListTest.getElementAt(0);
    assertEquals("No such elemnt!", testSingleItemForItemList, itemListTest.getElementAt(0));
    assertNotNull("No such elemnt!", itemListTest.getElementAt(0));
  }

  /**
   * Tests add method.
   */
  @Test
  public void testAdd() {
    itemListTest.add(testSingleItemForItemList);
    assertNotNull("Add Has Failed!", itemListTest.getSize());
    assertEquals("Add Has Failed!", 1, itemListTest.getSize());
    System.out.println("size after add " + itemListTest.getSize());
  }

  /**
   * Tests indexOf method.
   */
  @Test
  public void testIndexOf() {
    itemListTest.add(testSingleItemForItemList);
    itemListTest.indexOf(testSingleItemForItemList);
    assertEquals("There is no index!", 0, itemListTest.indexOf(testSingleItemForItemList));
  }

  /**
   * Tests contains method.
   */
  @Test
  public void testContains() {
    itemListTest.add(testSingleItemForItemList);
    System.out.println("contains check " + itemListTest.contains(testSingleItemForItemList));
    assertTrue("The list contains nothing!", itemListTest.contains(testSingleItemForItemList));

  }

  /**
   * Tests changed method.
   */
  @Test
  public void testChanged() {
    itemListTest.add(testSingleItemForItemList);
    itemListTest.changed(testSingleItemForItemList);
    assertNotEquals("Change has failed!", testSingleItemForItemList,
        testSingleItemChangedForItemList);
  }

  /**
   * Tests remove method.
   */
  @Test
  public void testRemoveInt() {
    itemListTest.add(testSingleItemForItemList);
    assertTrue("Remove was not successfull!", itemListTest.remove(0));
    System.out.println("remove int size " + itemListTest.getSize());

  }

  /**
   * Tests remove method.
   */
  @Test
  public void testRemoveItem() {
    itemListTest.add(testSingleItemForItemList);
    assertTrue("Remove was not successfull!", itemListTest.remove(testSingleItemForItemList));
    System.out.println("remove item size " + itemListTest.getSize());

  }

  /**
   * Tests getElementByName method.
   */
  @Test
  public void testGetElementByName() {
    itemListTest.add(testSingleItemForItemList);
    System.out.println("element by name name " + testSingleItemForItemList.getName());
    assertEquals("No such elemnt!", testSingleItemForItemList,
        itemListTest.getElementByName("SingleTestItem"));

  }
}
