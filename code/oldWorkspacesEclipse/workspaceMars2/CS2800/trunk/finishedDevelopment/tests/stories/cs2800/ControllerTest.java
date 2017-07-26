package tests.stories.cs2800;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import stories.cs2800.Controller;



/**
 * @author emil.
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
}
