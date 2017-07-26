package stories.cs2800;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>InvolvedWithVisitorTest</code> contains tests for the class <code>{@link InvolvedWithVisitor}</code>.
 *
 * @generatedBy CodePro at 12/6/15 9:13 PM
 * @author emil
 * @version $Revision: 1.0 $
 */
public class InvolvedWithVisitorTest {
	/**
	 * Run the InvolvedWithVisitor(Item) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/6/15 9:13 PM
	 */
	@Test
	public void testInvolvedWithVisitor_1()
		throws Exception {
		Item developer = new AggregateItem("", "", 1.0f);

		InvolvedWithVisitor result = new InvolvedWithVisitor(developer);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.shouldRecurse());
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
		InvolvedWithVisitor fixture = new InvolvedWithVisitor(new AggregateItem("", "", 1.0f));
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
	public void testAdd_2()
		throws Exception {
		InvolvedWithVisitor fixture = new InvolvedWithVisitor(new AggregateItem("", "", 1.0f));
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
	public void testAdd_3()
		throws Exception {
		InvolvedWithVisitor fixture = new InvolvedWithVisitor(new AggregateItem("", "", 1.0f));
		SingleItem u = new SingleItem("", 1.0f, new AggregateItem("", "", 1.0f));

		fixture.add(u);

		// add additional test code here
	}

	/**
	 * Run the ItemList getResult() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/6/15 9:13 PM
	 */
	@Test
	public void testGetResult_1()
		throws Exception {
		InvolvedWithVisitor fixture = new InvolvedWithVisitor(new AggregateItem("", "", 1.0f));

		ItemList result = fixture.getResult();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getSize());
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
		InvolvedWithVisitor fixture = new InvolvedWithVisitor(new AggregateItem("", "", 1.0f));

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
		new org.junit.runner.JUnitCore().run(InvolvedWithVisitorTest.class);
	}
}