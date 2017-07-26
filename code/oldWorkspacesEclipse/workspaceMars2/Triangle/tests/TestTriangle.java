import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestTriangle {
  private Triangle t;
  private Triangle tEq;

  @Before
  public void setUp() throws Exception {
    t = new Triangle(3, 4, 5);
    tEq = new Triangle(4, 4, 4);
  }

  @Test
  public void scaleneOk() {
    assertTrue(t.isScalene());
  }

  @Test
  public void testIsEquilateral() {
    assertTrue(tEq.isEquilateral());

  }
}
