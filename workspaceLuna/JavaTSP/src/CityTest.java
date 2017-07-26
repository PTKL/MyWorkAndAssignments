import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>CityTest</code> contains tests for the class <code>{@link City}</code>.
 * 
 * @version 1.0
 * @author emil
 */
public class CityTest {
  /**
   * Run the City(String,double,double) constructor test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testCity() throws Exception {
    String name = "";
    double latitude = 1.0;
    double longitude = 1.0;

    City result = new City(name, latitude, longitude);

    assertNotNull(result);
    assertEquals(1.0, result.getLatitude(), 1.0);
    assertEquals(1.0, result.getLongitude(), 1.0);
    assertEquals("", result.toString());
    assertEquals("", result.getName());
  }

  /**
   * Run the double getLatitude() method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testGetLatitude() throws Exception {
    City testCity = new City("", 1.0, 1.0);
    testCity.setLatitude(1.0);
    testCity.setLongitude(1.0);

    double result = testCity.getLatitude();

    assertNotNull(result);
    assertEquals(1.0, result, 1.0);
  }

  /**
   * Run the double getLongitude() method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testGetLongitude() throws Exception {
    City testCity = new City("", 1.0, 1.0);
    testCity.setLatitude(1.0);
    testCity.setLongitude(1.0);

    double result = testCity.getLongitude();

    assertNotNull(result);
    assertEquals(1.0, result, 1.0);
  }

  /**
   * Run the String getName() method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testGetName() throws Exception {
    City testCity = new City("", 1.0, 1.0);
    testCity.setLatitude(1.0);
    testCity.setLongitude(1.0);

    String result = testCity.getName();

    assertNotNull(result);
    assertEquals("", result);
  }

  /**
   * Run the double measureDistance(City) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testMeasureDistance() throws Exception {
    City testCity = new City("", 1.0, 1.0);
    testCity.setLatitude(1.0);
    testCity.setLongitude(1.0);
    City city = new City("", 1.0, 1.0);

    double result = testCity.measureDistance(city);

    assertNotNull(result);
    assertEquals(0.0, result, 1.0);
  }

  /**
   * Run the void setLatitude(double) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testSetLatitude() throws Exception {
    City testCity = new City("", 1.0, 1.0);
    testCity.setLatitude(1.0);
    testCity.setLongitude(1.0);
    double latitude = 1.0;

    testCity.setLatitude(latitude);
    assertNotNull(latitude);

  }

  /**
   * Run the void setLongitude(double) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testSetLongitude() throws Exception {
    City testCity = new City("", 1.0, 1.0);
    testCity.setLatitude(1.0);
    testCity.setLongitude(1.0);
    double longitude = 1.0;

    testCity.setLongitude(longitude);
    assertNotNull(longitude);

  }

  /**
   * Run the void setName(String) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testSetName() throws Exception {
    City testCity = new City("name", 1.0, 1.0);
    testCity.setLatitude(1.0);
    testCity.setLongitude(1.0);
    String name = "name";

    testCity.setName(name);
    assertNotNull(name);

  }

  /**
   * Run the String toString() method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testToString() throws Exception {
    City testCity = new City("name", 1.0, 1.0);
    testCity.setLatitude(1.0);
    testCity.setLongitude(1.0);

    String result = testCity.toString();

    assertNotNull(result);
    assertEquals("name", result);
  }

}
