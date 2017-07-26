package tests.stories.cs2800;

import org.junit.*;

import stories.cs2800.AggregateItem;
import stories.cs2800.DetailsVisitor;
import stories.cs2800.SingleItem;

import static org.junit.Assert.*;

/**
 *
 * @author emil
 */
public class DetailsVisitorTest {

  public DetailsVisitor visitorDetailsTestVar;

  public SingleItem singleItemTestVar;

  public AggregateItem aggregateItemTestVar;

  /**
   * Perform pre-test initialization.
   *
   *
   */
  @Before
  public void setUp() throws Exception {
    visitorDetailsTestVar = new DetailsVisitor();
    singleItemTestVar = new SingleItem("", 1.0f, new AggregateItem("", "", 1.0f));
    aggregateItemTestVar = new AggregateItem("", "", 1.0f);
  }

  /**
   * Run the DetailsVisitor() constructor test.
   *
   *
   */
  @Test
  public void testDetailsVisitor() {

    DetailsVisitor result = new DetailsVisitor();

    assertNotNull(result);
    assertEquals(true, result.shouldRecurse());
    assertEquals("", result.getResult());
  }

  /**
   * Run the void add(AggregateItem) method test.
   *
   *
   */
  @Test
  public void testAddAggregateItem() {

    visitorDetailsTestVar.add(aggregateItemTestVar);
    assertNotNull(visitorDetailsTestVar);

  }

  /**
   * Run the void add(SingleItem) method test.
   *
   *
   */
  @Test
  public void testAddSingleItem() {

    visitorDetailsTestVar.add(singleItemTestVar);
    assertNotNull(visitorDetailsTestVar);

  }

  /**
   * Run the String getResult() method test.
   *
   *
   */
  @Test
  public void testGetResult() throws Exception {

    String result = visitorDetailsTestVar.getResult();

    assertEquals("", result);
  }

  /**
   * Run the boolean shouldRecurse() method test.
   *
   *
   */
  @Test
  public void testShouldRecurse() {

    boolean result = visitorDetailsTestVar.shouldRecurse();

    assertEquals(true, result);
  }
}
