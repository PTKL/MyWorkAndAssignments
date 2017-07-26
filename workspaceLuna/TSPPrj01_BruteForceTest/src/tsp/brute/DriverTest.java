package tsp.brute;

import java.time.Instant;
import java.util.ArrayList;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>DriverTest</code> contains tests for the class <code>{@link Driver}</code>.
 *
 * @author emil
 * @version 1.0
 */
public class DriverTest {
	/**
	 * Run the Driver() constructor test.
	 *
	 */
	@Test
	public void testDriver()
		throws Exception {
		Driver result = new Driver();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testMain()
		throws Exception {
		String[] args = new String[] {};

		Driver.main(args);

		// add additional test code here
	}


	/**
	 * Run the void printDuration(Instant) method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testPrintDuration()
		throws Exception {
		Driver fixture = new Driver();
		Instant startInstant = Instant.EPOCH;

		fixture.printDuration(startInstant);

		// add additional test code here
	}


	/**
	 * Run the void printHeading(String,String) method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testPrintHeading()
		throws Exception {
		Driver fixture = new Driver();
		String headingColumn1 = "";
		String remainingHeadingColumns = "";

		fixture.printHeading(headingColumn1, remainingHeadingColumns);

		// add additional test code here
	}

	/**
	 * Run the void printResult(BruteForce,ArrayList<RouteBruteForce>) method test.
	 *
	 * @throws Exception
	 *
	 */
  @Test
	public void testPrintResult()
		throws Exception {
		Driver fixture = new Driver();
		BruteForce bruteForce = new BruteForce();
		ArrayList<RouteBruteForce> shortestRoutes = new ArrayList<RouteBruteForce>();

		fixture.printResult(bruteForce, shortestRoutes);

		// add additional test code here
	}


	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(DriverTest.class);
	}
}