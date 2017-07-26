package stories.cs2800;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>CostVisitorTest</code> contains tests for the class <code>{@link CostVisitor}</code>.
 *
 * @generatedBy CodePro at 12/4/15 12:32 PM
 * @author emil
 * @version $Revision: 1.0 $
 */
public class CostVisitorTest {
	/**
	 * Run the CostVisitor(Item,ItemType) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/15 12:32 PM
	 */
	@Test
	public void testCostVisitor_1()
		throws Exception {
		Item item = new AggregateItem("", "", 1.0f);
		ItemType type = ItemType.DEVELOPER;

		CostVisitor result = new CostVisitor(item, type);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.shouldRecurse());
		assertEquals(new Float(0.0f), result.getResult());
	}

	/**
	 * Run the CostVisitor(Item,ItemType) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/15 12:32 PM
	 */
	@Test
	public void testCostVisitor_2()
		throws Exception {
		Item item = new AggregateItem("", "", 1.0f);
		ItemType type = ItemType.DEVELOPER;

		CostVisitor result = new CostVisitor(item, type);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.shouldRecurse());
		assertEquals(new Float(0.0f), result.getResult());
	}

	/**
	 * Run the void add(AggregateItem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/15 12:32 PM
	 */
	@Test
	public void testAdd_1()
		throws Exception {
		CostVisitor fixture = new CostVisitor(new AggregateItem("", "", 1.0f), ItemType.DEVELOPER);
		AggregateItem item = new AggregateItem("", "", 1.0f);

		fixture.add(item);

		// add additional test code here
	}

	/**
	 * Run the void add(SingleItem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/15 12:32 PM
	 */
	@Test
	public void testAdd_2()
		throws Exception {
		CostVisitor fixture = new CostVisitor(new AggregateItem("", "", 1.0f), ItemType.DEVELOPER);
		SingleItem item = new SingleItem("", 1.0f, new AggregateItem("", "", 1.0f));

		fixture.add(item);

		// add additional test code here
	}

	/**
	 * Run the void add(SingleItem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/15 12:32 PM
	 */
	@Test
	public void testAdd_3()
		throws Exception {
		CostVisitor fixture = new CostVisitor(new AggregateItem("", "", 1.0f), ItemType.DEVELOPER);
		SingleItem item = new SingleItem("", 1.0f, new AggregateItem("", "", 1.0f));

		fixture.add(item);

		// add additional test code here
	}

	/**
	 * Run the void add(SingleItem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/15 12:32 PM
	 */
	@Test
	public void testAdd_4()
		throws Exception {
		CostVisitor fixture = new CostVisitor(new AggregateItem("", "", 1.0f), ItemType.DEVELOPER);
		SingleItem item = new SingleItem("", 1.0f, new AggregateItem("", "", 1.0f));

		fixture.add(item);

		// add additional test code here
	}

	/**
	 * Run the Float getResult() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/15 12:32 PM
	 */
	@Test
	public void testGetResult_1()
		throws Exception {
		CostVisitor fixture = new CostVisitor(new AggregateItem("", "", 1.0f), ItemType.DEVELOPER);

		Float result = fixture.getResult();

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
	 * Run the boolean shouldRecurse() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/15 12:32 PM
	 */
	@Test
	public void testShouldRecurse_1()
		throws Exception {
		CostVisitor fixture = new CostVisitor(new AggregateItem("", "", 1.0f), ItemType.DEVELOPER);

		boolean result = fixture.shouldRecurse();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 12/4/15 12:32 PM
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
	 * @generatedBy CodePro at 12/4/15 12:32 PM
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
	 * @generatedBy CodePro at 12/4/15 12:32 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(CostVisitorTest.class);
	}
}