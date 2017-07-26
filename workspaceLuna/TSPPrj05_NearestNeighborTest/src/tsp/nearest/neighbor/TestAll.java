package tsp.nearest.neighbor;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 1/22/17 4:12 PM
 * @author emil
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  DriverTest.class,
  CityTest.class,
  RouteNearestNeighborTest.class,
})
public class TestAll {

  /**
   * Launch the test.
   *
   * @param args the command line arguments
   *
   * @generatedBy CodePro at 1/22/17 4:12 PM
   */
  public static void main(String[] args) {
    JUnitCore.runClasses(new Class[] { TestAll.class });
  }
}
