import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>RouteBruteForceTest</code> contains tests for the class
 * <code>{@link RouteBruteForce}</code>.
 * @version 1.0
 * @author emil
 */
public class RouteBruteForceTest {
  /**
   * Run the RouteBruteForce(ArrayList<City>) constructor test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testRouteBruteForce() throws Exception {
    ArrayList<City> initialRoute = new ArrayList<City>();

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
   */
  @Test
  public void testRouteBruteForce2() throws Exception {
    RouteBruteForce route = new RouteBruteForce(new ArrayList<City>());
    route.setCities(new ArrayList<City>());

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
   */
  @Test
  public void testGetCities() throws Exception {
    RouteBruteForce fixture = new RouteBruteForce(new ArrayList<City>());
    fixture.setCities(new ArrayList<City>());

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
   */
  @Test
  public void testSetCities() throws Exception {
    RouteBruteForce fixture = new RouteBruteForce(new ArrayList<City>());
    fixture.setCities(new ArrayList<City>());
    ArrayList<City> cities = new ArrayList<City>();

    fixture.setCities(cities);

    // add additional test code here
  }

  /**
   * Run the String toString() method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testToString() throws Exception {
    RouteBruteForce fixture = new RouteBruteForce(new ArrayList<City>());
    fixture.setCities(new ArrayList<City>());

    String result = fixture.toString();

    // add additional test code here
    assertEquals("[]", result);
  }

}
