import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author emil
 */
public class MenuReaderTest {
	/**
	 * Run the MenuReader(File) constructor test.
	 *
	 * @throws Exception
	 *
	 */
	@Test(expected = java.io.FileNotFoundException.class)
	public void testMenuReader() throws Exception {
		File inputMenu = new File("");

		MenuReader result = new MenuReader(inputMenu);

		// add additional test code here
		assertNotNull(result);
	}

	
	/**
	 * Run the ArrayList<MenuItem> getMenuItems() method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetMenuItems() throws Exception {
		MenuReader fixture = new MenuReader(new File(""));
		fixture.logOrder(new ArrayList(), new BigDecimal(1.0));

		ArrayList<MenuItem> result = fixture.getMenuItems();

		assertNotNull(result);
	}

	/**
	 * Run the void logOrder(ArrayList<MenuItem>,BigDecimal) method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test(expected = java.io.FileNotFoundException.class)
	public void testLogOrder() throws Exception {
		MenuReader fixture = new MenuReader(new File(""));
		fixture.logOrder(new ArrayList(), new BigDecimal(1.0));
		ArrayList<MenuItem> itemsOrdered = new ArrayList();
		BigDecimal orderPrice = new BigDecimal(1.0);

		fixture.logOrder(itemsOrdered, orderPrice);
		assertNotNull(fixture);
		// add additional test code here
	}

	
	/**
	 * Run the void readInputFile() method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testReadInputFile() throws Exception {
		MenuReader fixture = new MenuReader(new File(""));
		fixture.logOrder(new ArrayList(), new BigDecimal(1.0));

		fixture.readInputFile();

	}

}