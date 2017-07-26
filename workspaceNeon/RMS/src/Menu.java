import java.util.ArrayList;
/**
 * Menu Class.
 * 
 * @author Seong
 *
 */
public class Menu {
  
  private static Menu instance = new Menu();
  private ArrayList<MenuItem> menu;
  
  private Menu() {
    menu = new ArrayList<>();
  }
  
  public static Menu getMenuInstance() {
    return instance;
  }
  
  public int getCalories(MenuItem menuItem) {
    return menuItem.getCalories();
  }
  
  public int getPrice(MenuItem menuItem) {
    return menuItem.getPrice();
  }
  
  public void addMenuItem(MenuItem menuItem) {
    menu.add(menuItem);
  }
  
  public void removeMenuItem(MenuItem menuItem) {
    menu.remove(menuItem);
  }
  
  /**
   * gets Ingredients for the Menu Item.
   * @param menuItem
   * @return String
   */
  //not sure whether to return a String or just an Ingredient[]
  public String getIngredients(MenuItem menuItem) {
    Ingredient[] ingredients = menuItem.getIngredients(); 
    //TODO
    return "";
  }

  public String getAllergies(MenuItem menuItem) {
    //TODO
    return null;
  }

  public void sortByName() {
    //TODO
  }
  
  public void sortByCost() {
    //TODO
  }
  
  public boolean checkAvailable(MenuItem menuItem) {
    //TODO
    return true;
  }
  
  public String toString() {
    //TODO
    return "";
  }
}
