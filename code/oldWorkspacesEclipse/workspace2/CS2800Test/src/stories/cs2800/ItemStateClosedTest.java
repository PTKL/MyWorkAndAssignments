package stories.cs2800;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ItemStateClosedTest</code> contains tests for the class <code>{@link ItemStateClosed}</code>.
 *
 * @generatedBy CodePro at 12/5/15 2:20 PM
 * @author emil
 * @version $Revision: 1.0 $
 */
public class ItemStateClosedTest {
	/**
	 * Run the ItemStateClosed() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/5/15 2:20 PM
	 */
	@Test
	public void testItemStateClosed_1()
		throws Exception {

		ItemStateClosed result = new ItemStateClosed();

		// add additional test code here
		assertNotNull(result);
		assertEquals(false, result.isOpen());
	}

	/**
	 * Run the void add(Item) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/5/15 2:20 PM
	 */
	@Test
	public void testAdd_1()
		throws Exception {
		ItemStateClosed fixture = new ItemStateClosed();
		Item e = new AggregateItem("", "", 1.0f);

		fixture.add(e);

		// add additional test code here
	}

	/**
	 * Run the boolean isOpen() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/5/15 2:20 PM
	 */
	@Test
	public void testIsOpen_1()
		throws Exception {
		ItemStateClosed fixture = new ItemStateClosed();

		boolean result = fixture.isOpen();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 12/5/15 2:20 PM
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
	 * @generatedBy CodePro at 12/5/15 2:20 PM
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
	 * @generatedBy CodePro at 12/5/15 2:20 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ItemStateClosedTest.class);
	}
}