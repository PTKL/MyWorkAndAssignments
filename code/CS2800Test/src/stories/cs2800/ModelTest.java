package stories.cs2800;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ModelTest</code> contains tests for the class <code>{@link Model}</code>.
 *
 * @generatedBy CodePro at 12/8/15 7:02 PM
 * @author emil
 * @version $Revision: 1.0 $
 */
public class ModelTest {
	/**
	 * Run the boolean addDeveloper(Database,Item,Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testAddDeveloper_1()
		throws Exception {
		Model fixture = Model.getModel();
		Database db = new Database((DatabaseActions) null);
		Item developer = new AggregateItem("", "", 1.0f);
		Item story = new AggregateItem("", "", 1.0f);

		boolean result = fixture.addDeveloper(db, developer, story);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at stories.cs2800.Database.addLink(Database.java:134)
		//       at stories.cs2800.Model.addDeveloper(Model.java:106)
		assertTrue(result);
	}

	/**
	 * Run the boolean addDeveloper(Database,Item,Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testAddDeveloper_2()
		throws Exception {
		Model fixture = Model.getModel();
		Database db = new Database((DatabaseActions) null);
		Item developer = new AggregateItem("", "", 1.0f);
		Item story = new AggregateItem("", "", 1.0f);

		boolean result = fixture.addDeveloper(db, developer, story);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.Error: Unresolved compilation problem: 
		//       The type SingleItem must implement the inherited abstract method Comparable.compareTo(Object)
		//       
		//       at stories.cs2800.SingleItem.compareTo(SingleItem.java:13)
		//       at java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:320)
		//       at java.util.ComparableTimSort.sort(ComparableTimSort.java:188)
		//       at java.util.Arrays.sort(Arrays.java:1312)
		//       at java.util.Arrays.sort(Arrays.java:1506)
		//       at java.util.ArrayList.sort(ArrayList.java:1454)
		//       at java.util.Collections.sort(Collections.java:141)
		//       at stories.cs2800.ItemList.add(ItemList.java:82)
		//       at stories.cs2800.Model.addItem(Model.java:39)
		//       at stories.cs2800.Model.addItem(Model.java:34)
		//       at stories.cs2800.Model.addDeveloper(Model.java:99)
		assertTrue(result);
	}

	/**
	 * Run the boolean addDeveloper(Database,Item,Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testAddDeveloper_3()
		throws Exception {
		Model fixture = Model.getModel();
		Database db = new Database((DatabaseActions) null);
		Item developer = new AggregateItem("", "", 1.0f);
		Item story = new AggregateItem("", "", 1.0f);

		boolean result = fixture.addDeveloper(db, developer, story);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.Error: Unresolved compilation problem: 
		//       The type SingleItem must implement the inherited abstract method Comparable.compareTo(Object)
		//       
		//       at stories.cs2800.SingleItem.compareTo(SingleItem.java:13)
		//       at java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:320)
		//       at java.util.ComparableTimSort.sort(ComparableTimSort.java:188)
		//       at java.util.Arrays.sort(Arrays.java:1312)
		//       at java.util.Arrays.sort(Arrays.java:1506)
		//       at java.util.ArrayList.sort(ArrayList.java:1454)
		//       at java.util.Collections.sort(Collections.java:141)
		//       at stories.cs2800.ItemList.add(ItemList.java:82)
		//       at stories.cs2800.Model.addItem(Model.java:39)
		//       at stories.cs2800.Model.addItem(Model.java:34)
		//       at stories.cs2800.Model.addDeveloper(Model.java:99)
		assertTrue(result);
	}

	/**
	 * Run the boolean addDeveloper(Database,Item,Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testAddDeveloper_4()
		throws Exception {
		Model fixture = Model.getModel();
		Database db = new Database((DatabaseActions) null);
		Item developer = new AggregateItem("", "", 1.0f);
		Item story = new AggregateItem("", "", 1.0f);

		boolean result = fixture.addDeveloper(db, developer, story);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.Error: Unresolved compilation problem: 
		//       The type SingleItem must implement the inherited abstract method Comparable.compareTo(Object)
		//       
		//       at stories.cs2800.SingleItem.compareTo(SingleItem.java:13)
		//       at java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:320)
		//       at java.util.ComparableTimSort.sort(ComparableTimSort.java:188)
		//       at java.util.Arrays.sort(Arrays.java:1312)
		//       at java.util.Arrays.sort(Arrays.java:1506)
		//       at java.util.ArrayList.sort(ArrayList.java:1454)
		//       at java.util.Collections.sort(Collections.java:141)
		//       at stories.cs2800.ItemList.add(ItemList.java:82)
		//       at stories.cs2800.Model.addItem(Model.java:39)
		//       at stories.cs2800.Model.addItem(Model.java:34)
		//       at stories.cs2800.Model.addDeveloper(Model.java:99)
		assertTrue(result);
	}

	/**
	 * Run the boolean addHours(Database,Item,Item,Float) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testAddHours_1()
		throws Exception {
		Model fixture = Model.getModel();
		Database db = new Database((DatabaseActions) null);
		Item developer = new AggregateItem("", "", 1.0f);
		Item story = new AggregateItem("", "", 1.0f);
		Float hours = new Float(1.0f);

		boolean result = fixture.addHours(db, developer, story, hours);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at stories.cs2800.Database.addValue(Database.java:144)
		//       at stories.cs2800.Model.addHours(Model.java:87)
		assertTrue(result);
	}

	/**
	 * Run the boolean addHours(Database,Item,Item,Float) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testAddHours_2()
		throws Exception {
		Model fixture = Model.getModel();
		Database db = new Database((DatabaseActions) null);
		Item developer = new AggregateItem("", "", 1.0f);
		Item story = new AggregateItem("", "", 1.0f);
		Float hours = new Float(1.0f);

		boolean result = fixture.addHours(db, developer, story, hours);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at stories.cs2800.Database.addValue(Database.java:144)
		//       at stories.cs2800.Model.addHours(Model.java:87)
		assertTrue(result);
	}

	/**
	 * Run the boolean addHours(Database,Item,Item,Float) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testAddHours_3()
		throws Exception {
		Model fixture = Model.getModel();
		Database db = new Database((DatabaseActions) null);
		Item developer = new AggregateItem("", "", 1.0f);
		Item story = new AggregateItem("", "", 1.0f);
		Float hours = new Float(1.0f);

		boolean result = fixture.addHours(db, developer, story, hours);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at stories.cs2800.Database.addValue(Database.java:144)
		//       at stories.cs2800.Model.addHours(Model.java:87)
		assertTrue(result);
	}

	/**
	 * Run the Item addItem(String,ItemType,String,float) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testAddItem_1()
		throws Exception {
		Model fixture = Model.getModel();
		String name = "";
		ItemType itemType = ItemType.DEVELOPER;
		String description = "";
		float value = 1.0f;

		Item result = fixture.addItem(name, itemType, description, value);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Item addItem(String,ItemType,String,float) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testAddItem_2()
		throws Exception {
		Model fixture = Model.getModel();
		String name = "";
		ItemType itemType = ItemType.DEVELOPER;
		String description = "";
		float value = 1.0f;

		Item result = fixture.addItem(name, itemType, description, value);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:320)
		//       at java.util.ComparableTimSort.sort(ComparableTimSort.java:188)
		//       at java.util.Arrays.sort(Arrays.java:1312)
		//       at java.util.Arrays.sort(Arrays.java:1506)
		//       at java.util.ArrayList.sort(ArrayList.java:1454)
		//       at java.util.Collections.sort(Collections.java:141)
		//       at stories.cs2800.ItemList.add(ItemList.java:82)
		//       at stories.cs2800.Model.addItem(Model.java:39)
		//       at stories.cs2800.Model.addItem(Model.java:34)
		assertNotNull(result);
	}

	/**
	 * Run the Item addItem(String,ItemType,String,float,Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testAddItem_3()
		throws Exception {
		Model fixture = Model.getModel();
		String name = "";
		ItemType itemType = ItemType.DEVELOPER;
		String description = "";
		float value = 1.0f;
		Item child = new AggregateItem("", "", 1.0f);

		Item result = fixture.addItem(name, itemType, description, value, child);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:320)
		//       at java.util.ComparableTimSort.sort(ComparableTimSort.java:188)
		//       at java.util.Arrays.sort(Arrays.java:1312)
		//       at java.util.Arrays.sort(Arrays.java:1506)
		//       at java.util.ArrayList.sort(ArrayList.java:1454)
		//       at java.util.Collections.sort(Collections.java:141)
		//       at stories.cs2800.ItemList.add(ItemList.java:82)
		//       at stories.cs2800.Model.addItem(Model.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the Item addItem(String,ItemType,String,float,Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testAddItem_4()
		throws Exception {
		Model fixture = Model.getModel();
		String name = "";
		ItemType itemType = ItemType.DEVELOPER;
		String description = "";
		float value = 1.0f;
		Item child = new AggregateItem("", "", 1.0f);

		Item result = fixture.addItem(name, itemType, description, value, child);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:320)
		//       at java.util.ComparableTimSort.sort(ComparableTimSort.java:188)
		//       at java.util.Arrays.sort(Arrays.java:1312)
		//       at java.util.Arrays.sort(Arrays.java:1506)
		//       at java.util.ArrayList.sort(ArrayList.java:1454)
		//       at java.util.Collections.sort(Collections.java:141)
		//       at stories.cs2800.ItemList.add(ItemList.java:82)
		//       at stories.cs2800.Model.addItem(Model.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the boolean addStory(Database,Item,Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testAddStory_1()
		throws Exception {
		Model fixture = Model.getModel();
		Database db = new Database((DatabaseActions) null);
		Item project = new AggregateItem("", "", 1.0f);
		Item story = new AggregateItem("", "", 1.0f);

		boolean result = fixture.addStory(db, project, story);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at stories.cs2800.Database.addLink(Database.java:134)
		//       at stories.cs2800.Model.addStory(Model.java:119)
		assertTrue(result);
	}

	/**
	 * Run the boolean addStory(Database,Item,Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testAddStory_2()
		throws Exception {
		Model fixture = Model.getModel();
		Database db = new Database((DatabaseActions) null);
		Item project = new AggregateItem("", "", 1.0f);
		Item story = new AggregateItem("", "", 1.0f);

		boolean result = fixture.addStory(db, project, story);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at stories.cs2800.Database.addLink(Database.java:134)
		//       at stories.cs2800.Model.addStory(Model.java:119)
		assertTrue(result);
	}

	/**
	 * Run the Float getCost(Item,ItemType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testGetCost_1()
		throws Exception {
		Model fixture = Model.getModel();
		Item item = new AggregateItem("", "", 1.0f);
		ItemType type = ItemType.DEVELOPER;

		Float result = fixture.getCost(item, type);

		// add additional test code here
		assertNotNull(result);
		assertEquals("0.0", result.toString());
		assertEquals((byte) 0, result.byteValue());
		assertEquals((short) 0, result.shortValue());
		assertEquals(0, result.intValue());
		assertEquals(0L, result.longValue());
		assertEquals(0.0f, result.floatValue(), 1.0f);
		assertEquals(0.0, result.doubleValue(), 1.0);
		assertEquals(false, result.isNaN());
		assertEquals(false, result.isInfinite());
	}

	/**
	 * Run the String getDetails(Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testGetDetails_1()
		throws Exception {
		Model fixture = Model.getModel();
		Item item = new AggregateItem("", "", 1.0f);

		String result = fixture.getDetails(item);

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the ItemList getItems(ItemType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testGetItems_1()
		throws Exception {
		Model fixture = Model.getModel();
		ItemType type = ItemType.DEVELOPER;

		ItemList result = fixture.getItems(type);

		// add additional test code here
		assertNotNull(result);
		assertEquals(4, result.getSize());
	}

	/**
	 * Run the Model getModel() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testGetModel_1()
		throws Exception {

		Model result = Model.getModel();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ItemList getPersonnel(Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testGetPersonnel_1()
		throws Exception {
		Model fixture = Model.getModel();
		Item item = new AggregateItem("", "", 1.0f);

		ItemList result = fixture.getPersonnel(item);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getSize());
	}

	/**
	 * Run the void openClose(Database,ItemType,Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testOpenClose_1()
		throws Exception {
		Model fixture = Model.getModel();
		Database db = new Database((DatabaseActions) null);
		ItemType type = ItemType.DEVELOPER;
		Item item = new AggregateItem("", "", 1.0f);

		fixture.openClose(db, type, item);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at stories.cs2800.Database.setState(Database.java:156)
		//       at stories.cs2800.Model.openClose(Model.java:128)
	}

	/**
	 * Run the String restoreState(Database) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testRestoreState_1()
		throws Exception {
		Model fixture = Model.getModel();
		Database db = null;

		String result = fixture.restoreState(db);

		// add additional test code here
		assertEquals("No DB at all - anything goes", result);
	}

	/**
	 * Run the String restoreState(Database) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testRestoreState_2()
		throws Exception {
		Model fixture = Model.getModel();
		Database db = new Database((DatabaseActions) null);

		String result = fixture.restoreState(db);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at stories.cs2800.Database.restoreItems(Database.java:60)
		//       at stories.cs2800.Model.restoreState(Model.java:70)
		assertNotNull(result);
	}

	/**
	 * Run the String restoreState(Database) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testRestoreState_3()
		throws Exception {
		Model fixture = Model.getModel();
		Database db = new Database((DatabaseActions) null);

		String result = fixture.restoreState(db);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at stories.cs2800.Database.restoreItems(Database.java:60)
		//       at stories.cs2800.Model.restoreState(Model.java:70)
		assertNotNull(result);
	}

	/**
	 * Run the String restoreState(Database) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testRestoreState_4()
		throws Exception {
		Model fixture = Model.getModel();
		Database db = new Database((DatabaseActions) null);

		String result = fixture.restoreState(db);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at stories.cs2800.Database.restoreItems(Database.java:60)
		//       at stories.cs2800.Model.restoreState(Model.java:70)
		assertNotNull(result);
	}

	/**
	 * Run the String restoreState(Database) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testRestoreState_5()
		throws Exception {
		Model fixture = Model.getModel();
		Database db = new Database((DatabaseActions) null);

		String result = fixture.restoreState(db);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at stories.cs2800.Database.restoreItems(Database.java:60)
		//       at stories.cs2800.Model.restoreState(Model.java:70)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
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
	 * @generatedBy CodePro at 12/8/15 7:02 PM
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
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ModelTest.class);
	}
}