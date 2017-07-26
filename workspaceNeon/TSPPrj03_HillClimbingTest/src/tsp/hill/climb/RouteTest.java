package tsp.hill.climb;

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
	 * Run the Route(Route) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testRoute_2()
		throws Exception {
		Route route = new Route(new ArrayList());

		Route result = new Route(route);

		// add additional test code here
		assertNotNull(result);
		assertEquals("[]", result.toString());
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
		Route fixture = new Route(new ArrayList());

		ArrayList<City> result = fixture.getCities();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the double getTotalDistance() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testGetTotalDistance_1()
		throws Exception {
		Route fixture = new Route(new ArrayList());

		double result = fixture.getTotalDistance();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: -1
		//       at java.util.ArrayList.elementData(ArrayList.java:418)
		//       at java.util.ArrayList.get(ArrayList.java:431)
		//       at tsp.hill.climb.Route.getTotalDistance(Route.java:20)
		assertEquals(0.0, result, 0.1);
	}

	/**
	 * Run the String getTotalStringDistance() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testGetTotalStringDistance_1()
		throws Exception {
		Route fixture = new Route(new ArrayList());

		String result = fixture.getTotalStringDistance();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: -1
		//       at java.util.ArrayList.elementData(ArrayList.java:418)
		//       at java.util.ArrayList.get(ArrayList.java:431)
		//       at tsp.hill.climb.Route.getTotalDistance(Route.java:20)
		//       at tsp.hill.climb.Route.getTotalStringDistance(Route.java:23)
		assertNotNull(result);
	}

	/**
	 * Run the String getTotalStringDistance() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testGetTotalStringDistance_2()
		throws Exception {
		Route fixture = new Route(new ArrayList());

		String result = fixture.getTotalStringDistance();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: -1
		//       at java.util.ArrayList.elementData(ArrayList.java:418)
		//       at java.util.ArrayList.get(ArrayList.java:431)
		//       at tsp.hill.climb.Route.getTotalDistance(Route.java:20)
		//       at tsp.hill.climb.Route.getTotalStringDistance(Route.java:23)
		assertNotNull(result);
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
		Route fixture = new Route(new ArrayList());

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