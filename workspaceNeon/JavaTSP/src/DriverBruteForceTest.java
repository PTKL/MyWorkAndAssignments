import java.time.Instant;
import java.util.ArrayList;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>DriverBruteForceTest</code> contains tests for the class <code>{@link DriverBruteForce}</code>.
 *
 * @author emil
 * @version 1.0
 */
public class DriverBruteForceTest {
	/**
	 * Run the DriverBruteForce() constructor test.
	 *
	 */
	@Test
	public void testDriver()
		throws Exception {
		DriverBruteForce result = new DriverBruteForce();
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

		DriverBruteForce.main(args);

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
		DriverBruteForce fixture = new DriverBruteForce();
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
		DriverBruteForce fixture = new DriverBruteForce();
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
		DriverBruteForce fixture = new DriverBruteForce();
		BruteForce bruteForce = new BruteForce();
		ArrayList<RouteBruteForce> shortestRoutes = new ArrayList<RouteBruteForce>();

		fixture.printResult(bruteForce, shortestRoutes);

		// add additional test code here
	}
}