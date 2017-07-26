package stories.cs2800;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>DetailsVisitorTest</code> contains tests for the class <code>{@link DetailsVisitor}</code>.
 *
 * @generatedBy CodePro at 12/6/15 9:13 PM
 * @author emil
 * @version $Revision: 1.0 $
 */
public class DetailsVisitorTest {
	/**
	 * Run the DetailsVisitor() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/6/15 9:13 PM
	 */
	@Test
	public void testDetailsVisitor_1()
		throws Exception {

		DetailsVisitor result = new DetailsVisitor();

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.shouldRecurse());
		assertEquals("", result.getResult());
	}

	/**
	 * Run the void add(AggregateItem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/6/15 9:13 PM
	 */
	@Test
	public void testAdd_1()
		throws Exception {
		DetailsVisitor fixture = new DetailsVisitor();
		AggregateItem u = new AggregateItem("", "", 1.0f);

		fixture.add(u);

		// add additional test code here
	}

	/**
	 * Run the void add(AggregateItem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/6/15 9:13 PM
	 */
	@Test
	public void testAdd_2()
		throws Exception {
		DetailsVisitor fixture = new DetailsVisitor();
		AggregateItem u = new AggregateItem("", "", 1.0f);

		fixture.add(u);

		// add additional test code here
	}

	/**
	 * Run the void add(AggregateItem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/6/15 9:13 PM
	 */
	@Test
	public void testAdd_3()
		throws Exception {
		DetailsVisitor fixture = new DetailsVisitor();
		AggregateItem u = new AggregateItem("", "", 1.0f);

		fixture.add(u);

		// add additional test code here
	}

	/**
	 * Run the void add(SingleItem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/6/15 9:13 PM
	 */
	@Test
	public void testAdd_4()
		throws Exception {
		DetailsVisitor fixture = new DetailsVisitor();
		SingleItem u = new SingleItem("", 1.0f, new AggregateItem("", "", 1.0f));

		fixture.add(u);

		// add additional test code here
	}

	/**
	 * Run the void add(SingleItem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/6/15 9:13 PM
	 */
	@Test
	public void testAdd_5()
		throws Exception {
		DetailsVisitor fixture = new DetailsVisitor();
		SingleItem u = new SingleItem("", 1.0f, new AggregateItem("", "", 1.0f));

		fixture.add(u);

		// add additional test code here
	}

	/**
	 * Run the void add(SingleItem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/6/15 9:13 PM
	 */
	@Test
	public void testAdd_6()
		throws Exception {
		DetailsVisitor fixture = new DetailsVisitor();
		SingleItem u = new SingleItem("", 1.0f, new AggregateItem("", "", 1.0f));

		fixture.add(u);

		// add additional test code here
	}

	/**
	 * Run the String getResult() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/6/15 9:13 PM
	 */
	@Test
	public void testGetResult_1()
		throws Exception {
		DetailsVisitor fixture = new DetailsVisitor();

		String result = fixture.getResult();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the boolean shouldRecurse() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/6/15 9:13 PM
	 */
	@Test
	public void testShouldRecurse_1()
		throws Exception {
		DetailsVisitor fixture = new DetailsVisitor();

		boolean result = fixture.shouldRecurse();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean shouldRecurse() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/6/15 9:13 PM
	 */
	@Test
	public void testShouldRecurse_2()
		throws Exception {
		DetailsVisitor fixture = new DetailsVisitor();

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
	 * @generatedBy CodePro at 12/6/15 9:13 PM
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
	 * @generatedBy CodePro at 12/6/15 9:13 PM
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
	 * @generatedBy CodePro at 12/6/15 9:13 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(DetailsVisitorTest.class);
	}
}