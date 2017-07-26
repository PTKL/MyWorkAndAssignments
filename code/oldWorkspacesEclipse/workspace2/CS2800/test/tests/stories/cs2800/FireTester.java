package tests.stories.cs2800;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.stream.IntStream;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import org.junit.Before;
import org.junit.Test;

import stories.cs2800.AggregateItem;
import stories.cs2800.ItemList;

public class FireTester {
  private static ItemList tested;
  private static ListDataEvent saveEvent;
  private static AggregateItem[] items = {
      new AggregateItem("E", "First one", 0.0f),
      new AggregateItem("D", "First one", 0.0f),
      new AggregateItem("C", "First one", 0.0f),
      new AggregateItem("B", "First one", 0.0f),
      new AggregateItem("A", "First one", 0.0f)
  };
  private static int indexes[];

  @Before
  public void startTest() {
    tested = new ItemList();

    tested.addListDataListener(new ListDataListener() {
      @Override
      public void intervalAdded(final ListDataEvent e) {
        saveEvent = e;
      }

      @Override
      public void intervalRemoved(final ListDataEvent e) {
        saveEvent = e;
      }

      @Override
      public void contentsChanged(final ListDataEvent e) {
        saveEvent = e;
      }
    });
    IntStream.range(0, items.length).forEach(i -> {
      tested.add(items[i]);
    });
    indexes =
        IntStream.range(0, items.length)
            .map(i -> tested.indexOf(items[i])).toArray();
    saveEvent = null;
  }

  @Test
  public void testAdd() {
    final AggregateItem next =
        new AggregateItem("ABC", "Another one", 0.0f);
    tested.add(next);
    int index = tested.indexOf(next);
    assertNotNull(
        "Adding element at " + index
            + "should have fired an event and did not",
        saveEvent);
    assertEquals(
        "The type of the ListDataEvent object should be INTERVAL_ADDED and was not",
        saveEvent.getType(), ListDataEvent.INTERVAL_ADDED);
    assertTrue(
        "The removed index should be just " + index,
        saveEvent.getIndex0() == saveEvent.getIndex1()
            && saveEvent.getIndex0() == index);
  }

  @Test
  public void testRemoveInt() {
    final int WHERE = 4;
    tested.remove(WHERE);
    assertNotNull(
        "removing element " + WHERE
            + "should have fired an event and did not",
        saveEvent);
    assertEquals(
        "The type of the ListDataEvent object should be INTERVAL_REMOVED and was not",
        saveEvent.getType(), ListDataEvent.INTERVAL_REMOVED);
    assertTrue(
        "The removed index should be just " + WHERE,
        saveEvent.getIndex0() == saveEvent.getIndex1()
            && saveEvent.getIndex0() == WHERE);
  }

  @Test
  public void testRemoveItem() {
    final int WHERE = 4;
    tested.remove(items[WHERE]);
    assertNotNull(
        "removing element " + indexes[WHERE]
            + "should have fired an event and did not",
        saveEvent);
    assertEquals(
        "The type of the ListDataEvent object should be INTERVAL_REMOVED and was not",
        saveEvent.getType(), ListDataEvent.INTERVAL_REMOVED);
    assertTrue(
        "The removed index should be just " + indexes[WHERE],
        saveEvent.getIndex0() == saveEvent.getIndex1()
            && saveEvent.getIndex0() == indexes[WHERE]);
  }

  @Test
  public void testChanged() {
    final int WHERE = 3;
    tested.changed(items[WHERE]);
    assertNotNull(
        "Calling change should have fired a change event and did not",
        saveEvent);
    assertEquals(
        "The type of the ListDataEvent object should be CONTENTS_CHANGED and was not",
        saveEvent.getType(), ListDataEvent.CONTENTS_CHANGED);
    assertTrue(
        "After sorting the changed object should have index 1",
        saveEvent.getIndex0() == saveEvent.getIndex1()
            && saveEvent.getIndex0() == indexes[WHERE]);
  }
}
