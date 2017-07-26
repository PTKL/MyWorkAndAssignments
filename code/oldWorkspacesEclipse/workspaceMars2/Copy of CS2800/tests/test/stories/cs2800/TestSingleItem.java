
package test.stories.cs2800;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//import stories.cs2800.Item;
import stories.cs2800.SingleItem;


public class TestSingleItem {

  
  private SingleItem testSingleItem;
  private SingleItem compareToItemTest;
  private SingleItem childAddTest;
 // private Item testChild;
  private String nameNew;
  private float value;

  @Before
  public void setUp() throws Exception {
    testSingleItem = new SingleItem(nameNew, value, childAddTest);
    compareToItemTest = new SingleItem(nameNew, 3, testSingleItem);
    nameNew = "test";
    value = 0f;
    //testChild = null;
  }

  @Test
  public void testGetName() {
    testSingleItem.getName();
    assertEquals("No Name Yet Given!", nameNew, testSingleItem.getName());
  }

  @Test
  public void testSetValue() {
    testSingleItem.setValue(5f);
    // test for the value contained in a SingleItem
    assertNotNull("No Value Yet Given!", testSingleItem.getValue());
  }

  @Test
  public void testGetValue() {
    assertNotNull("No Value Yet Given!", testSingleItem.getValue());
  }

  @Test
  public void testToString() {
    assertNotNull("toString Not implemented yet!", testSingleItem.toString());
  }

  @Test
  public void testGetDescription() {
    testSingleItem.getDescription();
    assertNotNull("No Description Yet Given!", testSingleItem.getDescription());

  }

  @Test
  public void testAdd() {
    compareToItemTest.add(testSingleItem);
    assertEquals("Child add failed!", testSingleItem, compareToItemTest.getChild());

  }

  @Test
  public void testGetChild() {
    // testSingleItem.add(testChild);
    assertEquals("No Child Yet Given!/No Value!", testSingleItem, compareToItemTest.getChild());

  }

  @Test
  public void testIsOpen() {
    assertTrue("Is not Open", testSingleItem.isOpen());
  }

  @Test
  public void testOpen() {
    testSingleItem.open(true);
  }


  @Test
  public void testCompareTo() {
    assertEquals("Items are not the same!", 0, compareToItemTest.compareTo(compareToItemTest));
  }
}
