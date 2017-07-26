package tsp.nearest.neighbor;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>RouteNearestNeighborTest</code> contains tests for the class <code>{@link RouteNearestNeighbor}</code>.
 *
 * @author emil
 */
public class RouteNearestNeighborTest {
  /**
   * Run the RouteNearestNeighbor(ArrayList<City>) constructor test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testRouteNearestNeighbor_1()
    throws Exception {
    ArrayList<City> cities = new ArrayList<City>();

    RouteNearestNeighbor result = new RouteNearestNeighbor(cities);

    // add additional test code here
    assertNotNull(result);
    assertEquals("[]", result.toString());
  }

  /**
   * Run the int calculateTotalDistance() method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testCalculateTotalDistance_1()
    throws Exception {
    RouteNearestNeighbor fixture = new RouteNearestNeighbor(new ArrayList<City>());

    int result = fixture.calculateTotalDistance();

    
    assertEquals(0, result);
  }

  /**
   * Run the ArrayList<City> getCities() method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testGetCities_1()
    throws Exception {
    RouteNearestNeighbor fixture = new RouteNearestNeighbor(new ArrayList<City>());

    ArrayList<City> result = fixture.getCities();

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the String toString() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 1/22/17 4:11 PM
   */
  @Test
  public void testToString_1()
    throws Exception {
    RouteNearestNeighbor fixture = new RouteNearestNeighbor(new ArrayList<City>());

    String result = fixture.toString();

    // add additional test code here
    assertNotNull(result);
   // assertEquals("[]", result);
  }

  
  /**
   * Launch the test.
   *
   * @param args the command line arguments
   *
   */
  public static void main(String[] args) {
    new org.junit.runner.JUnitCore().run(RouteNearestNeighborTest.class);
  }
}