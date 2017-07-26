import java.util.ArrayList;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>BruteForceTest</code> contains tests for the class
 * <code>{@link BruteForce}</code>.
 *
 * @author emil
 * @version 1.0
 */
public class BruteForceTest {



  /**
   * Run the BruteForce() constructor test.
   *
   */
  @Test
  public void testBruteForce() throws Exception {
    BruteForce brueteTest = new BruteForce();

    assertNotNull(brueteTest);
  }
  

  /**
   * Run the ArrayList<RouteBruteForce> permuteCities(int,RouteBruteForce,RouteBruteForce) method
   * test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testPermuteCities() throws Exception {
    BruteForce brueteTest = new BruteForce();
    brueteTest.shortestRoutes = new ArrayList<RouteBruteForce>();
    int x = 1;
    RouteBruteForce currentRoute = new RouteBruteForce(new ArrayList<City>());
    currentRoute.setCities(new ArrayList<City>());
    RouteBruteForce shortestRoute = new RouteBruteForce(new ArrayList<City>());
    shortestRoute.setCities(new ArrayList<City>());

    ArrayList<RouteBruteForce> result = brueteTest.permuteCities(x, currentRoute, shortestRoute);

    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the void addToShortestRoutes(RouteBruteForce) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testAddToShortestRoutes() throws Exception {
    BruteForce brueteTest = new BruteForce();
    brueteTest.shortestRoutes = new ArrayList<RouteBruteForce>();
    RouteBruteForce route = new RouteBruteForce(new ArrayList<City>());

    brueteTest.addToShortestRoutes(route);

    assertNotNull(route);
  }

  /**
   * Run the int calculateTotalDistance(RouteBruteForce) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testCalculateTotalDistance() throws Exception {
    BruteForce brueteTest = new BruteForce();
    brueteTest.shortestRoutes = new ArrayList<RouteBruteForce>();
    RouteBruteForce route = new RouteBruteForce(new ArrayList<City>());
    route.setCities(new ArrayList<City>());

    int result = BruteForce.calculateTotalDistance(route);

    // assertNotNull(result);
    assertEquals(0, result);
  }

  /**
   * Run the String getTotalDistance(RouteBruteForce) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testGetTotalDistance() throws Exception {
    BruteForce brueteTest = new BruteForce();
    brueteTest.shortestRoutes = new ArrayList<RouteBruteForce>();
    RouteBruteForce route = new RouteBruteForce(new ArrayList<City>());

    String result = BruteForce.getTotalDistance(route);

    // assertNotNull(result);
    assertEquals(0, result);
  }


}
