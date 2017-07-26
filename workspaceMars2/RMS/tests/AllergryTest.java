import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests of Allergry.
 * 
 * @author Callum
 */
public class AllergryTest {
  
  /**
   * Tests each Allergry toString and toAllergry works.
   * and each returns the same Allergry as the
   * Allergry which created the debug string which
   * was passed into it.
   */
  @Test
  public void toAllergryReturnedEqualsToStringTest() {
    for (Allergry testing : Allergry.values()) {
      assertEquals(testing,Allergry.toAllergry(testing.toString()));
    }
  }
  
  /**
   * Tests that toString(Allergry[]) & toAllergryArray() both work.
   * That toAllergryArray, returns the same array that passed its
   * toString to it.
   */
  @Test
  public void toAllergryArrayReturnedEqualsToStringTest() {
    Allergry[] alg = {Allergry.test1, Allergry.test2, Allergry.test3};
    Allergry[] alg2 = {Allergry.test2,Allergry.test3};
    
    assertArrayEquals(alg, Allergry.toAllergryArray(Allergry.toString(alg)));
    assertArrayEquals(alg2, Allergry.toAllergryArray(Allergry.toString(alg2)));
  }
}
