package tsp.genetic;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>RouteTest</code> contains tests for the class <code>{@link Route}</code>.
 *
 * @generatedBy CodePro at 9/20/16 11:20 PM
 * @author emil
 * @version $Revision: 1.0 $
 */
public class RouteTest {
	/**
	 * Run the Route(ArrayList<City>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testRoute_1()
		throws Exception {
		ArrayList<City> cities = new ArrayList();

		Route result = new Route(cities);

		// add additional test code here
		assertNotNull(result);
		assertEquals("[]", result.toString());
	}

	/**
	 * Run the Route(GeneticAlgorithm) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testRoute_2()
		throws Exception {
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(new ArrayList());

		Route result = new Route(geneticAlgorithm);

		// add additional test code here
		assertNotNull(result);
		assertEquals("[]", result.toString());
	}

	/**
	 * Run the double calculateTotalDistance() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testCalculateTotalDistance_1()
		throws Exception {
		Route fixture = new Route(new GeneticAlgorithm(new ArrayList()));

		double result = fixture.calculateTotalDistance();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
		//       at java.util.ArrayList.rangeCheck(ArrayList.java:653)
		//       at java.util.ArrayList.get(ArrayList.java:429)
		//       at tsp.genetic.Route.calculateTotalDistance(Route.java:34)
		assertEquals(0.0, result, 0.1);
	}

	/**
	 * Run the ArrayList<City> getCities() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testGetCities_1()
		throws Exception {
		Route fixture = new Route(new GeneticAlgorithm(new ArrayList()));

		ArrayList<City> result = fixture.getCities();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the double getFitness() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testGetFitness_1()
		throws Exception {
		Route fixture = new Route(new GeneticAlgorithm(new ArrayList()));

		double result = fixture.getFitness();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
		//       at java.util.ArrayList.rangeCheck(ArrayList.java:653)
		//       at java.util.ArrayList.get(ArrayList.java:429)
		//       at tsp.genetic.Route.calculateTotalDistance(Route.java:34)
		//       at tsp.genetic.Route.getFitness(Route.java:22)
		assertEquals(0.0, result, 0.1);
	}

	/**
	 * Run the double getFitness() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testGetFitness_2()
		throws Exception {
		Route fixture = new Route(new GeneticAlgorithm(new ArrayList()));

		double result = fixture.getFitness();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
		//       at java.util.ArrayList.rangeCheck(ArrayList.java:653)
		//       at java.util.ArrayList.get(ArrayList.java:429)
		//       at tsp.genetic.Route.calculateTotalDistance(Route.java:34)
		//       at tsp.genetic.Route.getFitness(Route.java:22)
		assertEquals(0.0, result, 0.1);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Route fixture = new Route(new GeneticAlgorithm(new ArrayList()));

		String result = fixture.toString();

		// add additional test code here
		assertEquals("[]", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
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
	 * @generatedBy CodePro at 9/20/16 11:20 PM
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
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(RouteTest.class);
	}
}