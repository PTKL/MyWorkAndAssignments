package tsp.rec.hill.climbing;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>RRHillClimbingTest</code> contains tests for the class <code>{@link RRHillClimbing}</code>.
 *
 * @generatedBy CodePro at 9/20/16 11:22 PM
 * @author emil
 * @version $Revision: 1.0 $
 */
public class RRHillClimbingTest {
	/**
	 * Run the RRHillClimbing() constructor test.
	 *
	 * @generatedBy CodePro at 9/20/16 11:22 PM
	 */
	@Test
	public void testRRHillClimbing_1()
		throws Exception {
		RRHillClimbing result = new RRHillClimbing();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the Route findShortestRoute(Route) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:22 PM
	 */
	@Test
	public void testFindShortestRoute_1()
		throws Exception {
		RRHillClimbing fixture = new RRHillClimbing();
		Route currentRoute = new Route(new ArrayList());

		Route result = fixture.findShortestRoute(currentRoute);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Route findShortestRoute(Route) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:22 PM
	 */
	@Test
	public void testFindShortestRoute_2()
		throws Exception {
		RRHillClimbing fixture = new RRHillClimbing();
		Route currentRoute = new Route(new ArrayList());

		Route result = fixture.findShortestRoute(currentRoute);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Route findShortestRoute(Route) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:22 PM
	 */
	@Test
	public void testFindShortestRoute_3()
		throws Exception {
		RRHillClimbing fixture = new RRHillClimbing();
		Route currentRoute = new Route(new ArrayList());

		Route result = fixture.findShortestRoute(currentRoute);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<Route> findShortestRoutes(Route) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:22 PM
	 */
	@Test
	public void testFindShortestRoutes_1()
		throws Exception {
		RRHillClimbing fixture = new RRHillClimbing();
		Route route = new Route(new ArrayList());

		ArrayList<Route> result = fixture.findShortestRoutes(route);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<Route> findShortestRoutes(Route) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:22 PM
	 */
	@Test
	public void testFindShortestRoutes_2()
		throws Exception {
		RRHillClimbing fixture = new RRHillClimbing();
		Route route = new Route(new ArrayList());

		ArrayList<Route> result = fixture.findShortestRoutes(route);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void sortRoutesByDistance(ArrayList<Route>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:22 PM
	 */
	@Test
	public void testSortRoutesByDistance_1()
		throws Exception {
		RRHillClimbing fixture = new RRHillClimbing();
		ArrayList<Route> routes = new ArrayList();

		fixture.sortRoutesByDistance(routes);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 9/20/16 11:22 PM
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
	 * @generatedBy CodePro at 9/20/16 11:22 PM
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
	 * @generatedBy CodePro at 9/20/16 11:22 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(RRHillClimbingTest.class);
	}
}