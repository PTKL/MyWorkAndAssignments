package tests.stories.cs2800;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import stories.cs2800.AggregateItem;
import stories.cs2800.InvolvedWithVisitor;
import stories.cs2800.Item;
import stories.cs2800.ItemList;
import stories.cs2800.SingleItem;


/**
 *
 * @author emil.
 */
public class InvolvedWithVisitorTest {

  public InvolvedWithVisitor involvingVisitorTest;

  public AggregateItem testAgregateItemAdd;

  public SingleItem testSingleItemAdd;


  /**
   * Perform pre-test initialization.
   *
   * @throws Exception if the initialization fails for some reason
   *
   */
  @Before
  public void setUp() throws Exception {
    involvingVisitorTest = new InvolvedWithVisitor(new AggregateItem("", "", 1.0f));

    testAgregateItemAdd = new AggregateItem("", "", 1.0f);

    testSingleItemAdd = new SingleItem("", 1.0f, new AggregateItem("", "", 1.0f));
  }

  /**
   * Run the InvolvedWithVisitor(Item) constructor test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testInvolvedWithVisitor() throws Exception {
    Item developer = new AggregateItem("", "", 1.0f);

    InvolvedWithVisitor result = new InvolvedWithVisitor(developer);

    // add additional test code here
    assertNotNull(result);
    assertEquals(true, result.shouldRecurse());
  }

  /**
   * Run the void add(AggregateItem) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testAdd1() throws Exception {
    involvingVisitorTest.add(testAgregateItemAdd);

    // add additional test code here
  }

  /**
   * Run the void add(SingleItem) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testAdd2() throws Exception {
    involvingVisitorTest.add(testSingleItemAdd);

    // add additional test code here
  }

  /**
   * Run the void add(SingleItem) method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testAdd3() throws Exception {
    involvingVisitorTest.add(testSingleItemAdd);

    // add additional test code here
  }

  /**
   * Run the ItemList getResult() method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testGetResult() throws Exception {

    ItemList result = involvingVisitorTest.getResult();

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.getSize());
  }

  /**
   * Run the boolean shouldRecurse() method test.
   *
   * @throws Exception
   *
   */
  @Test
  public void testRecursive() throws Exception {

    boolean result = involvingVisitorTest.shouldRecurse();

    // add additional test code here
    assertEquals(true, result);
  }

}
