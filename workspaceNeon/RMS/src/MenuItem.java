
public class MenuItem {

	private String itemName;
	private int itemPrice, itemCost, calories;
	private Ingredient[] ingredients;
	private Catergory[] catergories;
	private String imageURL;
	
	public MenuItem(String itemName, String imageURL, int itemPrice, Ingredient[] ingredients, Catergory[] catergories) {	
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.ingredients = ingredients;
		this.itemCost = workOutCost();
		this.calories = workOutCalories();
		this.catergories = catergories;
		this.imageURL = imageURL;
	}
	
	private int workOutCost(){
		int cost = 0;
		for(Ingredient currentIngredient : this.ingredients){
			cost += currentIngredient.getCost();
		}
		
		return cost;
	}
	
	private int workOutCalories(){
		int calories = 0;
		
		for(Ingredient currentIngredient : this.ingredients){
			calories += currentIngredient.getCalories();
		}
		
		return calories;
	}
	
	public String getName(){
		return this.itemName;
	}
	
	public int getCost(){
		return this.itemCost;
	}
	
	public int getPrice(){
		return this.itemPrice;
	}
	
	public int getCalories(){
		return this.calories;
	}
	
	public Ingredient[] getIngredients(){
		return this.ingredients;
	}
	
	public String getImageURL(){
		return imageURL;
	}
	
	/**
	 * TODO
	 * @param isCatergory
	 * @return
	 * @author Callum
	 */
	public boolean is(Catergory isCatergory){
		for(Catergory cat : this.catergories){
			if(isCatergory.equals(cat)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A function which returns a string containing
	 * debug information for the menuItem instance for which
	 * it was called from.<br>
	 * 
	 * @return A debug string for the menuItem instance.
	 * @author Callum
	 */
	public String toString(){
		return "MenuItem{"+this.itemName+","+this.imageURL+","+this.itemPrice+","+this.itemCost+","+this.calories+","+Catergory.toString(catergories)+","+Ingredient.toString(ingredients)+"}";
	}
	
	/**
	 * TODO
	 * @param s
	 * @return
	 * @author Callum
	 */
	public static MenuItem toMenuItem(String s){
		s = s.substring(9);
		s = s.substring(0, s.length() -1);
		String[] splitString = s.split("Ingredients");
		String IngredientString = "Ingredients"+splitString[1];
		
		String stringWithRemovedIngredients = splitString[0].substring(0, splitString[0].length()-1);//remove the colon left
		
		String[] splitString2 = stringWithRemovedIngredients.split("Catergories");
		String CatergoryString = "Catergories"+splitString2[1];
		
		String stringWithRemovedIngredientsAndCatergory = splitString2[0].substring(0, splitString2[0].length()-1);//remove the colon left
		String[] splitString3 = stringWithRemovedIngredientsAndCatergory.split(",");
		
		
		return new MenuItem(splitString3[0], splitString3[1],Integer.parseInt(splitString3[2]), Ingredient.toIngredientArray(IngredientString), Catergory.toCatergoryArray(CatergoryString));//TODO
	}
	
	/**
	 * TODO
	 * @author Callum
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MenuItem){
			MenuItem temp = (MenuItem) obj;
			if(temp.itemName.equals(this.itemName)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * TODO
	 * @author Callum
	 */
	@Override
	public int hashCode() {
		return (this.itemName.hashCode());
	}
		
}


