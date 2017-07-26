package stories.cs2800;

import org.junit.*;

import static org.junit.Assert.*;

/**
 *
 * @author emil
 */
public class ControllerTest {
	/**
	 * Run the Controller getInstance() method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetInstance() throws Exception {

		Controller result = Controller.getInstance();

		assertNotNull(result);
	}
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ControllerTest.class);
	}
}