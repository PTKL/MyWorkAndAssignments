package stories.cs2800;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 12/9/15 7:50 PM
 * @author emil
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	ItemStateOpenTest.class,
	ItemStateClosedTest.class,
	ItemStateTest.class,
	ItemListTest.class,
	ModelTest.class,
	ControllerTest.class,
	DetailsVisitorTest.class,
	ItemFactoryTest.class,
	ItemTest.class,
	InvolvedWithVisitorTest.class,
	ItemVisitorTest.class,
})
public class TestAll {

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 12/9/15 7:50 PM
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
