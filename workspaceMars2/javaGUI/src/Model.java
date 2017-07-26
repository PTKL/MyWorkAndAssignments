
import java.math.BigDecimal;

/**
 * Model is central part of the business logic. It is the Core of Model in MVC pattern.
 * @author Nikoloz
 *
 */
public class Model {
	
	 /** Singleton of Model class. */
	private static Model model= new Model();
	/** MenuItemList instance for menu that is displayed in JList on CustomerView. */
	private MenuItemList menuItemList= new MenuItemList();
	private Model(){
		
	
	}

	public static Model getModel() {
		return model;
	}
	public MenuItemList getList(){
		return this.menuItemList;
	}
	public void setList(MenuItemList miList){
		menuItemList=miList;
	}

}
