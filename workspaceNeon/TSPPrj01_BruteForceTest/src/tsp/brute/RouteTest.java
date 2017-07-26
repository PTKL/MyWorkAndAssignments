package tsp.brute;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>RouteTest</code> contains tests for the class <code>{@link Route}</code>.
 *
 * @generatedBy CodePro at 9/20/16 11:21 PM
 * @author emil
 * @version $Revision: 1.0 $
 */
public class RouteTest {
	/**
	 * Run the Route(ArrayList<City>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:21 PM
	 */
	@Test
	public void testRoute_1()
		throws Exception {
		ArrayList<City> initialRoute = new ArrayList();

		Route result = new Route(initialRoute);

		// add additional test code here
		assertNotNull(result);
		assertEquals("[]", result.toString());
	}

	/**
	 * Run the Route(Route) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:21 PM
	 */
	@Test
	public void testRoute_2()
		throws Exception {
		Route route = new Route(new ArrayList());
		route.setCities(new ArrayList());

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
	 * @generatedBy CodePro at 9/20/16 11:21 PM
	 */
	@Test
	public void testGetCities_1()
		throws Exception {
		Route fixture = new Route(new ArrayList());
		fixture.setCities(new ArrayList());

		ArrayList<City> result = fixture.getCities();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the void setCities(ArrayList<City>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:21 PM
	 */
	@Test
	public void testSetCities_1()
		throws Exception {
		Route fixture = new Route(new ArrayList());
		fixture.setCities(new ArrayList());
		ArrayList<City> cities = new ArrayList();

		fixture.setCities(cities);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:21 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Route fixture = new Route(new ArrayList());
		fixture.setCities(new ArrayList());

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
		new org.junit.runner.JUnitCore().run(RouteTest.class);
	}
}