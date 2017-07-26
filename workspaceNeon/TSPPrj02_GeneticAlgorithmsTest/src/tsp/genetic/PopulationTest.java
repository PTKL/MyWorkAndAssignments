package tsp.genetic;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>PopulationTest</code> contains tests for the class <code>{@link Population}</code>.
 *
 * @generatedBy CodePro at 9/20/16 11:20 PM
 * @author emil
 * @version $Revision: 1.0 $
 */
public class PopulationTest {
	/**
	 * Run the Population(int,ArrayList<City>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testPopulation_1()
		throws Exception {
		int populationSize = 1;
		ArrayList<City> cities = new ArrayList();

		Population result = new Population(populationSize, cities);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Population(int,GeneticAlgorithm) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testPopulation_2()
		throws Exception {
		int populationSize = 1;
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(new ArrayList());

		Population result = new Population(populationSize, geneticAlgorithm);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<Route> getRoutes() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testGetRoutes_1()
		throws Exception {
		Population fixture = new Population(1, new GeneticAlgorithm(new ArrayList()));

		ArrayList<Route> result = fixture.getRoutes();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	/**
	 * Run the void sortRoutesByFitness() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testSortRoutesByFitness_1()
		throws Exception {
		Population fixture = new Population(1, new GeneticAlgorithm(new ArrayList()));

		fixture.sortRoutesByFitness();

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(PopulationTest.class);
	}
}