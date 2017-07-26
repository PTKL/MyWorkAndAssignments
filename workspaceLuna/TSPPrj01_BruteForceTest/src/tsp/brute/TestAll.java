package tsp.brute;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 1/12/17 5:13 PM
 * @author emil
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestHarnessTest.class,
  RouteBruteForceTest.class,
  CityTest.class,
  DriverTest.class,
  BruteForceTest.class,
})
public class TestAll {

  /**
   * Launch the test.
   *
   * @param args the command line arguments
   *
   * @generatedBy CodePro at 1/12/17 5:13 PM
   */
  public static void main(String[] args) {
    JUnitCore.runClasses(new Class[] { TestAll.class });
  }
}
