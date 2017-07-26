import java.math.BigDecimal;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author emil
 */
public class MenuItemTest {
	/**
	 * Run the MenuItem(String,BigDecimal) constructor test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testMenuItem()
		throws Exception {
		String itemName = "";
		BigDecimal itemPrice = new BigDecimal(1.0);

		MenuItem result = new MenuItem(itemName, itemPrice);

		// add additional test code here
		assertNotNull(result);
		assertEquals("\n1", result.itemToString());
		assertEquals("", result.getName());
	}

	/**
	 * Run the BigDecimal getCost() method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetCost()
		throws Exception {
		MenuItem fixture = new MenuItem("", new BigDecimal(1.0));

		BigDecimal result = fixture.getCost();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.precision());
		assertEquals("1", result.toEngineeringString());
		assertEquals("1", result.toPlainString());
		assertEquals(1L, result.longValueExact());
		assertEquals(1, result.intValueExact());
		assertEquals((short) 1, result.shortValueExact());
		assertEquals((byte) 1, result.byteValueExact());
		assertEquals("1", result.toString());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
		assertEquals(1, result.signum());
		assertEquals(0, result.scale());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetName()
		throws Exception {
		MenuItem fixture = new MenuItem("", new BigDecimal(1.0));

		String result = fixture.getName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String itemToString() method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testItemToString()
		throws Exception {
		MenuItem fixture = new MenuItem("", new BigDecimal(1.0));

		String result = fixture.itemToString();

		// add additional test code here
		assertEquals("\n1", result);
	}
}