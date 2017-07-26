package stories.cs2800;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ItemFactoryTest</code> contains tests for the class <code>{@link ItemFactory}</code>.
 *
 * @generatedBy CodePro at 12/8/15 7:02 PM
 * @author emil
 * @version $Revision: 1.0 $
 */
public class ItemFactoryTest {
	/**
	 * Run the Item createItem(String,ItemType,String,float,Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testCreateItem_1()
		throws Exception {
		ItemFactory fixture = ItemFactory.getInstance();
		fixture.setDatabase(new Database((DatabaseActions) null));
		String name = "";
		ItemType type = ItemType.DEVELOPER;
		String desc = "";
		float value = 1.0f;
		Item child = new AggregateItem("", "", 1.0f);

		Item result = fixture.createItem(name, type, desc, value, child);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at stories.cs2800.Database.insertItem(Database.java:119)
		//       at stories.cs2800.ItemFactory.createItem(ItemFactory.java:46)
		//       at stories.cs2800.ItemFactory.createItem(ItemFactory.java:23)
		assertNotNull(result);
	}

	/**
	 * Run the Item createItem(String,ItemType,String,float,Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testCreateItem_2()
		throws Exception {
		ItemFactory fixture = ItemFactory.getInstance();
		fixture.setDatabase(new Database((DatabaseActions) null));
		String name = "";
		ItemType type = ItemType.DEVELOPER;
		String desc = "";
		float value = 1.0f;
		Item child = new AggregateItem("", "", 1.0f);

		Item result = fixture.createItem(name, type, desc, value, child);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at stories.cs2800.Database.insertItem(Database.java:119)
		//       at stories.cs2800.ItemFactory.createItem(ItemFactory.java:46)
		//       at stories.cs2800.ItemFactory.createItem(ItemFactory.java:23)
		assertNotNull(result);
	}

	/**
	 * Run the Item createItem(String,ItemType,String,float,Item,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testCreateItem_3()
		throws Exception {
		ItemFactory fixture = ItemFactory.getInstance();
		fixture.setDatabase(new Database((DatabaseActions) null));
		String name = "";
		ItemType type = ItemType.DEVELOPER;
		String desc = "";
		float value = 1.0f;
		Item child = new AggregateItem("", "", 1.0f);
		boolean save = true;

		Item result = fixture.createItem(name, type, desc, value, child, save);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at stories.cs2800.Database.insertItem(Database.java:119)
		//       at stories.cs2800.ItemFactory.createItem(ItemFactory.java:46)
		assertNotNull(result);
	}

	/**
	 * Run the Item createItem(String,ItemType,String,float,Item,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testCreateItem_4()
		throws Exception {
		ItemFactory fixture = ItemFactory.getInstance();
		fixture.setDatabase(new Database((DatabaseActions) null));
		String name = "";
		ItemType type = ItemType.DEVELOPER;
		String desc = "";
		float value = 1.0f;
		Item child = new AggregateItem("", "", 1.0f);
		boolean save = false;

		Item result = fixture.createItem(name, type, desc, value, child, save);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Item createItem(String,ItemType,String,float,Item,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testCreateItem_5()
		throws Exception {
		ItemFactory fixture = ItemFactory.getInstance();
		fixture.setDatabase((Database) null);
		String name = "";
		ItemType type = ItemType.DEVELOPER;
		String desc = "";
		float value = 1.0f;
		Item child = new AggregateItem("", "", 1.0f);
		boolean save = true;

		Item result = fixture.createItem(name, type, desc, value, child, save);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Item createItem(String,ItemType,String,float,Item,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testCreateItem_6()
		throws Exception {
		ItemFactory fixture = ItemFactory.getInstance();
		fixture.setDatabase((Database) null);
		String name = "";
		ItemType type = ItemType.DEVELOPER;
		String desc = "";
		float value = 1.0f;
		Item child = new AggregateItem("", "", 1.0f);
		boolean save = true;

		Item result = fixture.createItem(name, type, desc, value, child, save);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Item createItem(String,ItemType,String,float,Item,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testCreateItem_7()
		throws Exception {
		ItemFactory fixture = ItemFactory.getInstance();
		fixture.setDatabase((Database) null);
		String name = "";
		ItemType type = ItemType.DEVELOPER;
		String desc = "";
		float value = 1.0f;
		Item child = new AggregateItem("", "", 1.0f);
		boolean save = true;

		Item result = fixture.createItem(name, type, desc, value, child, save);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the ItemFactory getInstance() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testGetInstance_1()
		throws Exception {

		ItemFactory result = ItemFactory.getInstance();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void setDatabase(Database) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/8/15 7:02 PM
	 */
	@Test
	public void testSetDatabase_1()
		throws Exception {
		ItemFactory fixture = ItemFactory.getInstance();
		fixture.setDatabase(new Database((DatabaseActions) null));
		Database argdb = new Database((DatabaseActions) null);

		fixture.setDatabase(argdb);

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(ItemFactoryTest.class);
	}
}