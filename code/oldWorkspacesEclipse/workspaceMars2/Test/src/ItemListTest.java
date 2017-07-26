import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemListTest {



  @Test
  public void testItemList_1()
      throws Exception {
      ItemList result = new ItemList();
      assertNotNull(result);
      // add additional test code here
  }
  @Test
  public void testAdd_1()
      throws Exception {
      ItemList fixture = new ItemList();
      fixture.add(new AggregateItem("", "", 1.0f));
      Item nextItemToAdd = new AggregateItem("", "", 1.0f);

      fixture.add(nextItemToAdd);
      assertNotNull("Add Has Failed!", fixture.getSize());

  }
  @Test
  public void testChanged_1()
      throws Exception {
      ItemList fixture = new ItemList();
      fixture.add(new AggregateItem("", "", 1.0f));
      Item itemChanged = new AggregateItem("", "", 1.0f);

      fixture.changed(itemChanged);

      // add additional test code here
  }
  @Test
  public void testChanged_2()
      throws Exception {
      ItemList fixture = new ItemList();
      fixture.add(new AggregateItem("", "", 1.0f));
      Item itemChanged = new AggregateItem("", "", 1.0f);

      fixture.changed(itemChanged);

      // add additional test code here
  }
  @Test
  public void testContains_1()
      throws Exception {
      ItemList fixture = new ItemList();
      fixture.add(new AggregateItem("", "", 1.0f));
      Item itemToCheck = new AggregateItem("", "", 1.0f);

      Boolean result = fixture.contains(itemToCheck);

      // add additional test code here
      assertNotNull(result);
      assertEquals("false", result.toString());
      assertEquals(false, result.booleanValue());
  }
  @Test
  public void testContains_2()
      throws Exception {
      ItemList fixture = new ItemList();
      fixture.add(new AggregateItem("", "", 1.0f));
      Item itemToCheck = new AggregateItem("", "", 1.0f);

      Boolean result = fixture.contains(itemToCheck);

      // add additional test code here
      assertNotNull(result);
      assertEquals("false", result.toString());
      assertEquals(false, result.booleanValue());
  }

  /**
   * Run the Item getElementAt(int) method test.
   *
   * @throws Exception
   *
   */
//  @Test
//  public void testGetElementAt_1()
//      throws Exception {
//      ItemList fixture = new ItemList();
//      fixture.add(new AggregateItem("", "", 1.0f));
//      int indexToRetrieve = 1;
//
//      Item result = fixture.getElementAt(indexToRetrieve);
//
//      // add additional test code here
//      // An unexpected exception was thrown in user code while executing this test:
//      //    java.lang.IndexOutOfBoundsException
//      //       at stories.cs2800.ItemList.getElementAt(ItemList.java:57)
//      assertNotNull(result);
//  }

  /**
   * Run the Item getElementAt(int) method test.
   *
   * @throws Exception
   *
   */
  @Test(expected = java.lang.IndexOutOfBoundsException.class)
  public void testGetElementAt_2()
      throws Exception {
      ItemList fixture = new ItemList();
      fixture.add(new AggregateItem("", "", 1.0f));
      int indexToRetrieve = 1;

      Item result = fixture.getElementAt(indexToRetrieve);

      // add additional test code here
      assertNotNull(result);
  }

  /**
   * Run the Item getElementAt(int) method test.
   *
   * @throws Exception
   *
   */
  @Test(expected = java.lang.IndexOutOfBoundsException.class)
  public void testGetElementAt_3()
      throws Exception {
      ItemList fixture = new ItemList();
      fixture.add(new AggregateItem("", "", 1.0f));
      int indexToRetrieve = -1;

      Item result = fixture.getElementAt(indexToRetrieve);

      // add additional test code here
      assertNotNull(result);
  }

  /**
   * Run the Item getElementByName(String) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testGetElementByName_1()
      throws Exception {
      ItemList fixture = new ItemList();
      fixture.add(new AggregateItem("", "", 1.0f));
      String nameOfItem = "";

      Item result = fixture.getElementByName(nameOfItem);

      // add additional test code here
      assertNotNull(result);
      assertEquals("", result.getDescription());
      assertEquals("AggregateItem [name  description  value 1.0]", result.toString());
      assertEquals("", result.getName());
      assertEquals(new Float(1.0f), result.getValue());
      assertEquals(true, result.isOpen());
  }

  /**
   * Run the Item getElementByName(String) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testGetElementByName_2()
      throws Exception {
      ItemList fixture = new ItemList();
      fixture.add(new AggregateItem("", "", 1.0f));
      String nameOfItem = "";

      Item result = fixture.getElementByName(nameOfItem);

      // add additional test code here
      assertNotNull(result);
      assertEquals("", result.getDescription());
      assertEquals("AggregateItem [name  description  value 1.0]", result.toString());
      assertEquals("", result.getName());
      assertEquals(new Float(1.0f), result.getValue());
      assertEquals(true, result.isOpen());
  }

  /**
   * Run the Item getElementByName(String) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testGetElementByName_3()
      throws Exception {
      ItemList fixture = new ItemList();
      String nameOfItem = "";

      Item result = fixture.getElementByName(nameOfItem);

      // add additional test code here
      assertEquals(null, result);
  }

  /**
   * Run the int getSize() method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testGetSize_1()
      throws Exception {
      ItemList fixture = new ItemList();
      fixture.add(new AggregateItem("", "", 1.0f));

      int result = fixture.getSize();

      // add additional test code here
      assertEquals(1, result);
  }

  /**
   * Run the int indexOf(Item) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testIndexOf_1()
      throws Exception {
      ItemList fixture = new ItemList();
      fixture.add(new AggregateItem("", "", 1.0f));
      Item itemIndexCheck = new AggregateItem("", "", 1.0f);

      int result = fixture.indexOf(itemIndexCheck);

      // add additional test code here
      assertEquals(-1, result);
  }

  /**
   * Run the Boolean remove(int) method test.
   *
   * @throws Exception
   *
   */
//  @Test
//  public void testRemove_1()
//      throws Exception {
//      ItemList fixture = new ItemList();
//      fixture.add(new AggregateItem("", "", 1.0f));
//      int indexToRemove = 1;
//
//      Boolean result = fixture.remove(indexToRemove);
//
//      // add additional test code here
//      // An unexpected exception was thrown in user code while executing this test:
//      //    java.lang.IndexOutOfBoundsException
//      //       at stories.cs2800.ItemList.remove(ItemList.java:111)
//      assertNotNull(result);
//  }

  /**
   * Run the Boolean remove(int) method test.
   *
   * @throws Exception
   *
   */
  @Test(expected = java.lang.IndexOutOfBoundsException.class)
  public void testRemove_2()
      throws Exception {
      ItemList fixture = new ItemList();
      fixture.add(new AggregateItem("", "", 1.0f));
      int indexToRemove = 1;

      Boolean result = fixture.remove(indexToRemove);

      // add additional test code here
      assertNotNull(result);
  }

  /**
   * Run the Boolean remove(int) method test.
   *
   * @throws Exception
   *
   */
  @Test(expected = java.lang.IndexOutOfBoundsException.class)
  public void testRemove_3()
      throws Exception {
      ItemList fixture = new ItemList();
      fixture.add(new AggregateItem("", "", 1.0f));
      int indexToRemove = -1;

      Boolean result = fixture.remove(indexToRemove);

      // add additional test code here
      assertNotNull(result);
  }

  /**
   * Run the Boolean remove(Item) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testRemove_4()
      throws Exception {
      ItemList fixture = new ItemList();
      fixture.add(new AggregateItem("", "", 1.0f));
      Item itemToRemove = new AggregateItem("", "", 1.0f);

      Boolean result = fixture.remove(itemToRemove);

      // add additional test code here
      assertNotNull(result);
      assertEquals("false", result.toString());
      assertEquals(false, result.booleanValue());
  }

  /**
   * Run the Boolean remove(Item) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testRemove_5()
      throws Exception {
      ItemList fixture = new ItemList();
      fixture.add(new AggregateItem("", "", 1.0f));
      Item itemToRemove = new AggregateItem("", "", 1.0f);

      Boolean result = fixture.remove(itemToRemove);

      // add additional test code here
      assertNotNull(result);
      assertEquals("false", result.toString());
      assertEquals(false, result.booleanValue());
  }
}
