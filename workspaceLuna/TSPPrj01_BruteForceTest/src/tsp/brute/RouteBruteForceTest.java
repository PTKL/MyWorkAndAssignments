package tsp.brute;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>RouteBruteForceTest</code> contains tests for the class <code>{@link RouteBruteForce}</code>.
 *
 * @generatedBy CodePro at 1/12/17 5:13 PM
 * @author emil
 */
public class RouteBruteForceTest {
  /**
   * Run the RouteBruteForce(ArrayList<City>) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 1/12/17 5:13 PM
   */
  @Test
  public void testRouteBruteForce_1()
    throws Exception {
    ArrayList<City> initialRoute = new ArrayList();

    RouteBruteForce result = new RouteBruteForce(initialRoute);

    // add additional test code here
    assertNotNull(result);
    assertEquals("[]", result.toString());
  }

  /**
   * Run the RouteBruteForce(RouteBruteForce) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 1/12/17 5:13 PM
   */
  @Test
  public void testRouteBruteForce_2()
    throws Exception {
    RouteBruteForce route = new RouteBruteForce(new ArrayList());
    route.setCities(new ArrayList());

    RouteBruteForce result = new RouteBruteForce(route);

    // add additional test code here
    assertNotNull(result);
    assertEquals("[]", result.toString());
  }

  /**
   * Run the ArrayList<City> getCities() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 1/12/17 5:13 PM
   */
  @Test
  public void testGetCities_1()
    throws Exception {
    RouteBruteForce fixture = new RouteBruteForce(new ArrayList());
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
   * @generatedBy CodePro at 1/12/17 5:13 PM
   */
  @Test
  public void testSetCities_1()
    throws Exception {
    RouteBruteForce fixture = new RouteBruteForce(new ArrayList());
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
   * @generatedBy CodePro at 1/12/17 5:13 PM
   */
  @Test
  public void testToString_1()
    throws Exception {
    RouteBruteForce fixture = new RouteBruteForce(new ArrayList());
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
   * @generatedBy CodePro at 1/12/17 5:13 PM
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
   * @generatedBy CodePro at 1/12/17 5:13 PM
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
   * @generatedBy CodePro at 1/12/17 5:13 PM
   */
  public static void main(String[] args) {
    new org.junit.runner.JUnitCore().run(RouteBruteForceTest.class);
  }
}