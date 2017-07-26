
import java.util.ArrayList;

import javax.swing.AbstractListModel;

/**
 * MenuItemList class extends AbstractListModel. It is used to hold the MenuItem instances.
 * It will hold all the Meals (Dishes-Courses) that are displayed to the customer on
 * CustomerView screen.
 *
 * @see MenuItem
 * @see MenuItemTest
 * @see Model
 * @see CustomerView
 * @author Nikoloz
 *
 */
public class MenuItemList extends AbstractListModel<MenuItem>{
	
	/**	The Constant serialVersionUID needed for any Serializable class. */
	private static final long serialVersionUID = 1L;

	 /** an ArrayList of menuItems to hold the courses that will be displayed in JList on CustomerView. */
	  private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	  
	//public MenuItem getMenuItemByName(String name){
		
		//return MenuItem menuItem;
	//}

	@Override
	public MenuItem getElementAt(int index) {
		 if ((index >= 0) && (index < this.menuItems.size())) {
		      return this.menuItems.get(index);
		    }
		    throw new IndexOutOfBoundsException();
		  }
	

	//returns the size of a list
	@Override
	public int getSize() {
		return this.menuItems.size();
	}

	public void add(MenuItem menuItem) {
		 int count = 0;
		    while ((count < this.menuItems.size()) && (this.menuItems.get(count).compareTo(menuItem) < 0)) {
		      count = count + 1;
		    }
		    if ((count == this.menuItems.size()) || (this.menuItems.get(count).compareTo(menuItem)) != 0) {
		      this.menuItems.add(count, menuItem);
		      fireIntervalAdded(this, count, count);
		    }
		
	}

}

