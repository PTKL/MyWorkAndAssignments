package application;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>CustomerTest</code> contains tests for the class <code>{@link Customer}</code>.
 *
 * @generatedBy CodePro at 19/02/16 02:20
 * @author emil
 * @version $Revision: 1.0 $
 */
public class CustomerTest {
	/**
	 * Run the Customer(String,String,String,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testCustomer_1()
		throws Exception {
		String name = "";
		String email = "";
		String pass = "";
		boolean login = false;

		Customer result = new Customer(name, email, pass, login);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.createCustomer(DatabaseAdapter.java:185)
		//       at application.Customer.<init>(Customer.java:62)
		assertNotNull(result);
	}

	/**
	 * Run the Customer(String,String,String,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testCustomer_2()
		throws Exception {
		String name = "";
		String email = "";
		String pass = "";
		boolean login = true;

		Customer result = new Customer(name, email, pass, login);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:65)
		assertNotNull(result);
	}

	/**
	 * Run the Customer(String,String,String,String,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testCustomer_3()
		throws Exception {
		String name = "";
		String email = "";
		String pass = "";
		String creditCarNum = "";
		boolean login = false;

		Customer result = new Customer(name, email, pass, creditCarNum, login);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.createCustomer(DatabaseAdapter.java:185)
		//       at application.Customer.<init>(Customer.java:36)
		assertNotNull(result);
	}

	/**
	 * Run the Customer(String,String,String,String,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testCustomer_4()
		throws Exception {
		String name = "";
		String email = "";
		String pass = "";
		String creditCarNum = "";
		boolean login = true;

		Customer result = new Customer(name, email, pass, creditCarNum, login);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the void addFavoritesList(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testAddFavoritesList_1()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		int restaurantId = 1;

		fixture.addFavoritesList(restaurantId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void addFavoritesList(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testAddFavoritesList_2()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		int restaurantId = 1;

		fixture.addFavoritesList(restaurantId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void deleteFromFavorites(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testDeleteFromFavorites_1()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		int restaurantId = 1;

		fixture.deleteFromFavorites(restaurantId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the String getCurrentOrderInfo() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testGetCurrentOrderInfo_1()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);

		String result = fixture.getCurrentOrderInfo();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the String getCurrentOrderInfo() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testGetCurrentOrderInfo_2()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);

		String result = fixture.getCurrentOrderInfo();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<String> getFavoritesList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testGetFavoritesList_1()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);

		ArrayList<String> result = fixture.getFavoritesList();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
		assertNotNull(result);
	}

	/**
	 * Run the String login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testLogin_1()
		throws Exception {
		String email = "test";
		String pass = "test";

		String result = Customer.login(email, pass);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.checkLoginInfo(DatabaseAdapter.java:35)
		//       at application.Customer.login(Customer.java:78)
		assertNotNull(result);
	}

	/**
	 * Run the String login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testLogin_2()
		throws Exception {
		String email = "";
		String pass = "";

		String result = Customer.login(email, pass);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.checkLoginInfo(DatabaseAdapter.java:35)
		//       at application.Customer.login(Customer.java:78)
		assertNotNull(result);
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_1()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = "";
		String newPass = "";
		String newEmail = "";
		String creditCarNum = "";

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_2()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = null;
		String newPass = null;
		String newEmail = "";
		String creditCarNum = "";

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_3()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = null;
		String newPass = null;
		String newEmail = "";
		String creditCarNum = null;

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_4()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = null;
		String newPass = null;
		String newEmail = "";
		String creditCarNum = "";

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_5()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = null;
		String newPass = "";
		String newEmail = "";
		String creditCarNum = "";

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_6()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = null;
		String newPass = "";
		String newEmail = "";
		String creditCarNum = null;

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_7()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = null;
		String newPass = "";
		String newEmail = "";
		String creditCarNum = "";

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_8()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = "";
		String newPass = "";
		String newEmail = "";
		String creditCarNum = "";

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_9()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = "";
		String newPass = "";
		String newEmail = "";
		String creditCarNum = null;

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_10()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = "";
		String newPass = "";
		String newEmail = "";
		String creditCarNum = "";

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_11()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = "";
		String newPass = null;
		String newEmail = "";
		String creditCarNum = "";

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_12()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = "";
		String newPass = null;
		String newEmail = "";
		String creditCarNum = null;

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_13()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = "";
		String newPass = null;
		String newEmail = "";
		String creditCarNum = "";

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_14()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = "";
		String newPass = "";
		String newEmail = "";
		String creditCarNum = "";

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_15()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = "";
		String newPass = "";
		String newEmail = "";
		String creditCarNum = null;

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Run the void manageAccount(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Test
	public void testManageAccount_16()
		throws Exception {
		Customer fixture = new Customer("", "", "", "", true);
		String newName = "";
		String newPass = "";
		String newEmail = "";
		String creditCarNum = "";

		fixture.manageAccount(newName, newPass, newEmail, creditCarNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at Utils.DatabaseAdapter.getCustomerId(DatabaseAdapter.java:610)
		//       at application.Customer.<init>(Customer.java:42)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 19/02/16 02:20
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(CustomerTest.class);
	}
}