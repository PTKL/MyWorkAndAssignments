
public class Ingredient {
	private String name;
	private int cost, calories;
	private Allergry[] allergies;
	
	public Ingredient(String name, int cost, int calories, Allergry[] allergies){
		this.name = name;
		this.cost = cost;
		this.calories = calories;
		this.allergies = allergies;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getCost(){
		return this.cost;
	}
	
	public int getCalories(){
		return this.calories;
	}
	
	public Allergry[] getAllergies(){
		return this.allergies;
	}
	
	/**
	 * //TODO
	 * @author Callum
	 */
	@Override
	public String toString(){
		return "Ingredient{"+this.name+","+this.cost+","+this.calories+","+Allergry.toString(this.allergies)+"}";
	}
	
	/**
	 * //TODO
	 * @author Callum
	 */
	public static String toString(Ingredient[] ing){
		String returning = "Ingredients{";
		for(int i = 0;i < ing.length;i++){
			returning += ing[i].toString();
			if(i != (ing.length -1)){
				returning += ",";
			}
		}
		return (returning+"}");
	}
	
	/**
	 * //TODO
	 * @author Callum
	 */
	public static Ingredient toIngredient(String s){
		s = s.substring(11);
		s = s.substring(0, s.length()-1);
		String[] splitString = s.split("Allergies");
		String[] splitString2 = (splitString[0].substring(0, splitString[0].length() -1)).split(",");
		
		splitString[1] = "Allergies" + splitString[1];
		
		return new Ingredient(splitString2[0], Integer.parseInt(splitString2[1]), Integer.parseInt(splitString2[2]), Allergry.toAllergryArray( (splitString[1])) );
	}
	
	/**
	 * //TODO
	 * @author Callum
	 */
	public static Ingredient[] toIngredientArray(String s){
		s = s.substring(12);
		s = s.substring(0, s.length() - 1);
		String[] splitString = s.split("Ingredient");
		//-1 length as first is blank so only have length -1 ingredients
		Ingredient[] returning = new Ingredient[splitString.length-1];	
		System.out.println();
		
		//start at 1 as [0] is blank
		//so start at 1 to skip blank, 
		for(int i =1; i < splitString.length; i++){
			//returning is -1, as it has one less that the split length and we start i at 1
			if(i != (splitString.length -1)){
				returning[i-1] = Ingredient.toIngredient( ("Ingredient"+splitString[i].substring(0, splitString[i].length() -1)) );
			}else{
				//as last ingredient in array doesnt have comma after it
				returning[i-1] = Ingredient.toIngredient( ("Ingredient"+splitString[i]) );
			}
		}	
		
		return returning;
	}

	/**
	 * //TODO
	 * @author Callum
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Ingredient){
			Ingredient i = (Ingredient) obj;
			if(this.name.equals(i.getName())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * //TODO
	 * @author Callum
	 */
	@Override
	public int hashCode() {
		return ( this.name.hashCode() );
	}

}
