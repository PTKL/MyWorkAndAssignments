package tsp.genetic;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>GeneticAlgorithmTest</code> contains tests for the class <code>{@link GeneticAlgorithm}</code>.
 *
 * @generatedBy CodePro at 9/20/16 11:21 PM
 * @author emil
 * @version $Revision: 1.0 $
 */
public class GeneticAlgorithmTest {
	/**
	 * Run the GeneticAlgorithm(ArrayList<City>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:21 PM
	 */
	@Test
	public void testGeneticAlgorithm_1()
		throws Exception {
		ArrayList<City> initialRoute = new ArrayList();

		GeneticAlgorithm result = new GeneticAlgorithm(initialRoute);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Population crossoverPopulation(Population) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:21 PM
	 */
	@Test
	public void testCrossoverPopulation_1()
		throws Exception {
		GeneticAlgorithm fixture = new GeneticAlgorithm(new ArrayList());
		Population population = new Population(1, new GeneticAlgorithm(new ArrayList()));

		Population result = fixture.crossoverPopulation(population);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Route crossoverRoute(Route,Route) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:21 PM
	 */
	@Test
	public void testCrossoverRoute_1()
		throws Exception {
		GeneticAlgorithm fixture = new GeneticAlgorithm(new ArrayList());
		Route route1 = new Route(new GeneticAlgorithm(new ArrayList()));
		Route route2 = new Route(new GeneticAlgorithm(new ArrayList()));

		Route result = fixture.crossoverRoute(route1, route2);

		// add additional test code here
		assertNotNull(result);
		assertEquals("[]", result.toString());
	}

	/**
	 * Run the Route crossoverRoute(Route,Route) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:21 PM
	 */
	@Test
	public void testCrossoverRoute_2()
		throws Exception {
		GeneticAlgorithm fixture = new GeneticAlgorithm(new ArrayList());
		Route route1 = new Route(new GeneticAlgorithm(new ArrayList()));
		Route route2 = new Route(new GeneticAlgorithm(new ArrayList()));

		Route result = fixture.crossoverRoute(route1, route2);

		// add additional test code here
		assertNotNull(result);
		assertEquals("[]", result.toString());
	}

	/**
	 * Run the Population evolve(Population) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:21 PM
	 */
	@Test
	public void testEvolve_1()
		throws Exception {
		GeneticAlgorithm fixture = new GeneticAlgorithm(new ArrayList());
		Population population = new Population(1, new GeneticAlgorithm(new ArrayList()));

		Population result = fixture.evolve(population);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<City> getInitialRoute() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:21 PM
	 */
	@Test
	public void testGetInitialRoute_1()
		throws Exception {
		GeneticAlgorithm fixture = new GeneticAlgorithm(new ArrayList());

		ArrayList<City> result = fixture.getInitialRoute();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Population mutatePopulation(Population) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:21 PM
	 */
	@Test
	public void testMutatePopulation_1()
		throws Exception {
		GeneticAlgorithm fixture = new GeneticAlgorithm(new ArrayList());
		Population population = new Population(1, new GeneticAlgorithm(new ArrayList()));

		Population result = fixture.mutatePopulation(population);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Route mutateRoute(Route) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:21 PM
	 */
	@Test
	public void testMutateRoute_1()
		throws Exception {
		GeneticAlgorithm fixture = new GeneticAlgorithm(new ArrayList());
		Route route = new Route(new GeneticAlgorithm(new ArrayList()));

		Route result = fixture.mutateRoute(route);

		// add additional test code here
		assertNotNull(result);
		assertEquals("[]", result.toString());
	}

	/**
	 * Run the Population selectTournamentPopulation(Population) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:21 PM
	 */
	@Test
	public void testSelectTournamentPopulation_1()
		throws Exception {
		GeneticAlgorithm fixture = new GeneticAlgorithm(new ArrayList());
		Population population = new Population(1, new GeneticAlgorithm(new ArrayList()));

		Population result = fixture.selectTournamentPopulation(population);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
		//       at java.util.ArrayList.rangeCheck(ArrayList.java:653)
		//       at java.util.ArrayList.get(ArrayList.java:429)
		//       at tsp.genetic.Route.calculateTotalDistance(Route.java:34)
		//       at tsp.genetic.Route.getFitness(Route.java:22)
		//       at tsp.genetic.Population.lambda$2(Population.java:16)
		//       at java.util.TimSort.countRunAndMakeAscending(TimSort.java:355)
		//       at java.util.TimSort.sort(TimSort.java:220)
		//       at java.util.Arrays.sort(Arrays.java:1512)
		//       at java.util.ArrayList.sort(ArrayList.java:1454)
		//       at tsp.genetic.Population.sortRoutesByFitness(Population.java:14)
		//       at tsp.genetic.GeneticAlgorithm.selectTournamentPopulation(GeneticAlgorithm.java:75)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 9/20/16 11:21 PM
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
	 * @generatedBy CodePro at 9/20/16 11:21 PM
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
	 * @generatedBy CodePro at 9/20/16 11:21 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GeneticAlgorithmTest.class);
	}
}