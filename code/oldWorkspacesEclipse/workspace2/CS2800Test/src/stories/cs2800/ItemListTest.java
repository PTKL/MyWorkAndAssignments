package stories.cs2800;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ItemListTest</code> contains tests for the class <code>{@link ItemList}</code>.
 *
 * @generatedBy CodePro at 12/4/15 9:39 PM
 * @author emil
 * @version $Revision: 1.0 $
 */
public class ItemListTest {
	/**
	 * Run the ItemList() constructor test.
	 *
	 * @generatedBy CodePro at 12/4/15 9:39 PM
	 */
	@Test
	public void testItemList_1()
		throws Exception {
		ItemList result = new ItemList();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void add(Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/15 9:39 PM
	 */
	@Test
	public void testAdd_1()
		throws Exception {
		ItemList fixture = new ItemList();
		fixture.add(new AggregateItem("", "", 1.0f));
		Item nextItemToAdd = new AggregateItem("", "", 1.0f);

		fixture.add(nextItemToAdd);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.Error: Unresolved compilation problem: 
		//       The type AggregateItem must implement the inherited abstract method Comparable.compareTo(Object)
		//       
		//       at stories.cs2800.AggregateItem.compareTo(AggregateItem.java:15)
		//       at java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:320)
		//       at java.util.ComparableTimSort.sort(ComparableTimSort.java:188)
		//       at java.util.Arrays.sort(Arrays.java:1312)
		//       at java.util.Arrays.sort(Arrays.java:1506)
		//       at java.util.ArrayList.sort(ArrayList.java:1454)
		//       at java.util.Collections.sort(Collections.java:141)
		//       at stories.cs2800.ItemList.add(ItemList.java:82)
	}

	/**
	 * Run the void changed(Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/15 9:39 PM
	 */
	@Test
	public void testChanged_1()
		throws Exception {
		ItemList fixture = new ItemList();
		fixture.add(new AggregateItem("", "", 1.0f));
		Item itemChanged = new AggregateItem("", "", 1.0f);

		fixture.changed(itemChanged);

		// add additional test code here
	}

	/**
	 * Run the void changed(Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/15 9:39 PM
	 */
	@Test
	public void testChanged_2()
		throws Exception {
		ItemList fixture = new ItemList();
		fixture.add(new AggregateItem("", "", 1.0f));
		Item itemChanged = new AggregateItem("", "", 1.0f);

		fixture.changed(itemChanged);

		// add additional test code here
	}

	/**
	 * Run the Boolean contains(Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/15 9:39 PM
	 */
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

	/**
	 * Run the Boolean contains(Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/15 9:39 PM
	 */
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
	 * @generatedBy CodePro at 12/4/15 9:39 PM
	 */
	@Test
	public void testGetElementAt_1()
		throws Exception {
		ItemList fixture = new ItemList();
		fixture.add(new AggregateItem("", "", 1.0f));
		int indexToRetrieve = 1;

		Item result = fixture.getElementAt(indexToRetrieve);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException
		//       at stories.cs2800.ItemList.getElementAt(ItemList.java:57)
		assertNotNull(result);
	}

	/**
	 * Run the Item getElementAt(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/15 9:39 PM
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
	 * @generatedBy CodePro at 12/4/15 9:39 PM
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
	 * @generatedBy CodePro at 12/4/15 9:39 PM
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
	 * @generatedBy CodePro at 12/4/15 9:39 PM
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
	 * @generatedBy CodePro at 12/4/15 9:39 PM
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
	 * @generatedBy CodePro at 12/4/15 9:39 PM
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
	 * @generatedBy CodePro at 12/4/15 9:39 PM
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
	 * @generatedBy CodePro at 12/4/15 9:39 PM
	 */
	@Test
	public void testRemove_1()
		throws Exception {
		ItemList fixture = new ItemList();
		fixture.add(new AggregateItem("", "", 1.0f));
		int indexToRemove = 1;

		Boolean result = fixture.remove(indexToRemove);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException
		//       at stories.cs2800.ItemList.remove(ItemList.java:111)
		assertNotNull(result);
	}

	/**
	 * Run the Boolean remove(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/15 9:39 PM
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
	 * @generatedBy CodePro at 12/4/15 9:39 PM
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
	 * @generatedBy CodePro at 12/4/15 9:39 PM
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
	 * @generatedBy CodePro at 12/4/15 9:39 PM
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

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 12/4/15 9:39 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 12/4/15 9:39 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 12/4/15 9:39 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ItemListTest.class);
	}
}