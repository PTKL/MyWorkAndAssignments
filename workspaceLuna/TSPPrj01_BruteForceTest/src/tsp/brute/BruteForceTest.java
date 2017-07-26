package tsp.brute;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>BruteForceTest</code> contains tests for the class <code>{@link BruteForce}</code>.
 *
 * @generatedBy CodePro at 9/20/16 11:20 PM
 * @author emil
 * @version $Revision: 1.0 $
 */
public class BruteForceTest {
	/**
	 * Run the BruteForce() constructor test.
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testBruteForce_1()
		throws Exception {
		BruteForce result = new BruteForce();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void addToShortestRoutes(RouteBruteForce) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testAddToShortestRoutes_1()
		throws Exception {
		BruteForce fixture = new BruteForce();
		fixture.shortestRoutes = new ArrayList();
		RouteBruteForce route = new RouteBruteForce(new ArrayList());

		fixture.addToShortestRoutes(route);

		// add additional test code here
	}

	/**
	 * Run the int calculateTotalDistance(RouteBruteForce) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testCalculateTotalDistance_1()
		throws Exception {
		BruteForce fixture = new BruteForce();
		fixture.shortestRoutes = new ArrayList();
		RouteBruteForce route = new RouteBruteForce(new ArrayList());
		route.setCities(new ArrayList());

		int result = fixture.calculateTotalDistance(route);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
		//       at java.util.ArrayList.rangeCheck(ArrayList.java:653)
		//       at java.util.ArrayList.get(ArrayList.java:429)
		//       at tsp.brute.BruteForce.calculateTotalDistance(BruteForce.java:32)
		assertEquals(0, result);
	}

	/**
	 * Run the String getTotalDistance(RouteBruteForce) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testGetTotalDistance_1()
		throws Exception {
		BruteForce fixture = new BruteForce();
		fixture.shortestRoutes = new ArrayList();
		RouteBruteForce route = new RouteBruteForce(new ArrayList());

		String result = fixture.getTotalDistance(route);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
		//       at java.util.ArrayList.rangeCheck(ArrayList.java:653)
		//       at java.util.ArrayList.get(ArrayList.java:429)
		//       at tsp.brute.BruteForce.calculateTotalDistance(BruteForce.java:32)
		//       at tsp.brute.BruteForce.getTotalDistance(BruteForce.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the String getTotalDistance(RouteBruteForce) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testGetTotalDistance_2()
		throws Exception {
		BruteForce fixture = new BruteForce();
		fixture.shortestRoutes = new ArrayList();
		RouteBruteForce route = new RouteBruteForce(new ArrayList());

		String result = fixture.getTotalDistance(route);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
		//       at java.util.ArrayList.rangeCheck(ArrayList.java:653)
		//       at java.util.ArrayList.get(ArrayList.java:429)
		//       at tsp.brute.BruteForce.calculateTotalDistance(BruteForce.java:32)
		//       at tsp.brute.BruteForce.getTotalDistance(BruteForce.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the String getTotalDistance(RouteBruteForce) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testGetTotalDistance_3()
		throws Exception {
		BruteForce fixture = new BruteForce();
		fixture.shortestRoutes = new ArrayList();
		RouteBruteForce route = new RouteBruteForce(new ArrayList());

		String result = fixture.getTotalDistance(route);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
		//       at java.util.ArrayList.rangeCheck(ArrayList.java:653)
		//       at java.util.ArrayList.get(ArrayList.java:429)
		//       at tsp.brute.BruteForce.calculateTotalDistance(BruteForce.java:32)
		//       at tsp.brute.BruteForce.getTotalDistance(BruteForce.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<RouteBruteForce> permuteCities(int,RouteBruteForce,RouteBruteForce) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testPermuteCities_1()
		throws Exception {
		BruteForce fixture = new BruteForce();
		fixture.shortestRoutes = new ArrayList();
		int x = 1;
		RouteBruteForce currentRoute = new RouteBruteForce(new ArrayList());
		currentRoute.setCities(new ArrayList());
		RouteBruteForce shortestRoute = new RouteBruteForce(new ArrayList());

		ArrayList<RouteBruteForce> result = fixture.permuteCities(x, currentRoute, shortestRoute);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the ArrayList<RouteBruteForce> permuteCities(int,RouteBruteForce,RouteBruteForce) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testPermuteCities_2()
		throws Exception {
		BruteForce fixture = new BruteForce();
		fixture.shortestRoutes = new ArrayList();
		int x = 1;
		RouteBruteForce currentRoute = new RouteBruteForce(new ArrayList());
		currentRoute.setCities(new ArrayList());
		RouteBruteForce shortestRoute = new RouteBruteForce(new ArrayList());
		shortestRoute.setCities(new ArrayList());

		ArrayList<RouteBruteForce> result = fixture.permuteCities(x, currentRoute, shortestRoute);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the ArrayList<RouteBruteForce> permuteCities(int,RouteBruteForce,RouteBruteForce) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:20 PM
	 */
	@Test
	public void testPermuteCities_3()
		throws Exception {
		BruteForce fixture = new BruteForce();
		fixture.shortestRoutes = new ArrayList();
		int x = 1;
		RouteBruteForce currentRoute = new RouteBruteForce(new ArrayList());
		currentRoute.setCities(new ArrayList());
		RouteBruteForce shortestRoute = new RouteBruteForce(new ArrayList());

		ArrayList<RouteBruteForce> result = fixture.permuteCities(x, currentRoute, shortestRoute);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
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
		new org.junit.runner.JUnitCore().run(BruteForceTest.class);
	}
}