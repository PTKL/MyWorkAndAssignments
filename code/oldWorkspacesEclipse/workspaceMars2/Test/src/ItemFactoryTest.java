package tests.stories.cs2800;

import org.junit.*;

import stories.cs2800.Database;
import stories.cs2800.DatabaseActions;
import stories.cs2800.ItemFactory;

import static org.junit.Assert.*;

/**
 * The class <code>ItemFactoryTest</code> contains tests for the class <code>{@link ItemFactory}</code>.
 *
 * @author emil
 */
public class ItemFactoryTest {
	/**
	 * Run the ItemFactory getInstance() method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetInstance_1()
		throws Exception {

		ItemFactory result = ItemFactory.getInstance();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void setDB(Database) method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testSetDB_1()
		throws Exception {
		ItemFactory fixture = ItemFactory.getInstance();
		fixture.setDB(new Database((DatabaseActions) null));
		Database argDb = new Database((DatabaseActions) null);

		fixture.setDB(argDb);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

}