package tsp.nearest.neighbor;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>CityTest</code> contains tests for the class <code>{@link City}</code>.
 *
 * @generatedBy CodePro at 9/20/16 11:19 PM
 * @author emil
 * @version $Revision: 1.0 $
 */
public class CityTest {
	/**
	 * Run the City(String,double,double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:19 PM
	 */
	@Test
	public void testCity_1()
		throws Exception {
		String name = "";
		double latitude = 1.0;
		double longitude = 1.0;

		City result = new City(name, latitude, longitude);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.017453292519943295, result.getLatitude(), 1.0);
		assertEquals(0.017453292519943295, result.getLongitude(), 1.0);
		assertEquals("", result.toString());
		assertEquals("", result.getName());
	}

	/**
	 * Run the double getLatitude() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:19 PM
	 */
	@Test
	public void testGetLatitude_1()
		throws Exception {
		City fixture = new City("", 1.0, 1.0);

		double result = fixture.getLatitude();

		// add additional test code here
		assertEquals(0.017453292519943295, result, 0.1);
	}

	/**
	 * Run the double getLongitude() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:19 PM
	 */
	@Test
	public void testGetLongitude_1()
		throws Exception {
		City fixture = new City("", 1.0, 1.0);

		double result = fixture.getLongitude();

		// add additional test code here
		assertEquals(0.017453292519943295, result, 0.1);
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:19 PM
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		City fixture = new City("", 1.0, 1.0);

		String result = fixture.getName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the double measureDistance(City) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:19 PM
	 */
	@Test
	public void testMeasureDistance_1()
		throws Exception {
		City fixture = new City("", 1.0, 1.0);
		City city = new City("", 1.0, 1.0);

		double result = fixture.measureDistance(city);

		// add additional test code here
		assertEquals(0.0, result, 0.1);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/20/16 11:19 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		City fixture = new City("", 1.0, 1.0);

		String result = fixture.toString();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 9/20/16 11:19 PM
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
	 * @generatedBy CodePro at 9/20/16 11:19 PM
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
	 * @generatedBy CodePro at 9/20/16 11:19 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(CityTest.class);
	}
}