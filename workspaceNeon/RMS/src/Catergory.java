//TODO add all the catergories that our dishes will have
//NOTE each time we add a catergory, add the reveleant toString & toCatergory

/**
 * A Catergory class is used as a attribute of an MenuItem class instance. To
 * hold the dishes Catergory information. Dishes can have multiple catergories.
 * Which in the menu is used to filter which menuItems to display, depending on
 * what the customer has specified to filter by. <br>
 * 
 * @author Callum
 */
public enum Catergory {
	Starter, Main, Dessert, Drink, Alcohol,Vegetarian;

	/**
	 * Returns a debug string for the current Enum instance. Which
	 * representatives the value the Enum holds. Passing this debug string to
	 * Catergory.toCatergory(debugString) will return an Enum from which this
	 * debug string was created and has the corresponds values off. <br>
	 * <br>
	 * <b>Therefore:</b><br>
	 * Catergory.test1 == Catergory.toCatergory(Catergory.test1.toString())<br>
	 * 
	 * @return <b>String</b><br>
	 *         A debug string, representative of the enum value.<br>
	 * @author Callum
	 */
	public String toString() {
		if (this.equals(Catergory.Starter)) {
			return "Starter";
		} else if (this.equals(Catergory.Main)) {
			return "Main";
		} else if (this.equals(Catergory.Dessert)) {
			return "Dessert";
		} else if (this.equals(Catergory.Drink)) {
			return "Drink";
		} else if (this.equals(Catergory.Alcohol)) {
			return "Alcohol";
		} else if (this.equals(Catergory.Vegetarian)) {
			return "Vegetarian";
		}

		return "";
	}

	/**
	 * Is a function which takes a Catergory array and compiles a debug string
	 * containing the debug string of each element in the array. It will begin
	 * the debug String with 'Catergories{' and end it with '}'. Each debug String
	 * of each Catergory will be separated by a colon. <br>
	 * <br>
	 * <b>Therefore:</b><br>
	 * Catergories[] cat = {Catergory.test1,Catergory.test2,Catergory.test3};<br>
	 * cat == Catergory.toCatergoryArray(Catergory.toString(cat));<br>
	 * 
	 * @param Catergory [] <br>
	 *            The Catergory Array you wish to compile a debug String for.
	 * @return <b>String</b><br>
	 *         A debug String, containing debug info for each Catergory in the
	 *         array. <br>
	 *         <b>format:</b>Catergories{debugString,debugString....}
	 * @author Callum
	 */
	public static String toString(Catergory[] catergoryArrayToString) {
		String returning = "Catergories{";
		for (int i = 0; i < catergoryArrayToString.length; i++) {
			if (i != (catergoryArrayToString.length - 1)) {
				returning += catergoryArrayToString[i].toString() + ",";
			} else {
				returning += catergoryArrayToString[i].toString();
			}
		}
		return (returning + "}");
	}

	/**
	 * Is a function which takes a String and converts the debug string, back
	 * into the Catergory enum the debug string was created from. If the debug string
	 * can't be parsed back into a Catergory then it will return null. <br>
	 * <br>
	 * <b>Therefore:</b><br>
	 * Catergory.test1 == Catergory.toCatergory(Catergory.test1.toString())<br>
	 * 
	 * @param String <br>
	 *			The string to be converted back into a Catergory.
	 * @return <b>Allergry</b><br>
	 *         Returns an Catergory enum, which corresponds to the debug String
	 *         input. If one isn't found; returns null.
	 * @author Callum
	 */
	public static Catergory toCatergory(String stringToCatergory) {
		if (stringToCatergory.equals("Starter")) {
			return Catergory.Starter;
		} else if (stringToCatergory.equals("Main")) {
			return Catergory.Main;
		} else if (stringToCatergory.equals("Dessert")) {
			return Catergory.Dessert;
		} else if (stringToCatergory.equals("Drink")) {
			return Catergory.Drink;
		} else if (stringToCatergory.equals("Alcohol")) {
			return Catergory.Alcohol;
		} else if (stringToCatergory.equals("Vegetarian")) {
			return Catergory.Vegetarian;
		}

		return null;
	}

	/**
	 * Is a function which takes a String and converts the debug string, back
	 * into the Catergory Array the debug string was created from. Will return
	 * null if it can't be parsed. Returned Arrays may have elements which are
	 * null.
	 * <br>
	 * <br>
	 * <b>Therefore:</b><br>
	 * Catergory[] cat = {Catergory.test1,Catergory.test2,Catergory.test3};<br>
	 * cat == Catergory.toCatergoryArray(Catergory.toString(alg));<br>
	 * 
	 * @param String <br>
	 *            Catergory Array debug string you wish to convert back to an
	 *            array.
	 * @return <b>Catergory[]</b><br>
	 *         Returns an Catergory Array which corresponds to the debug String
	 *         input.
	 * @author Callum
	 */
	public static Catergory[] toCatergoryArray(String stringToCatergoryArray) {
		stringToCatergoryArray = stringToCatergoryArray.substring(12);
		stringToCatergoryArray = stringToCatergoryArray.substring(0, stringToCatergoryArray.length() - 1);

		String[] splitString = stringToCatergoryArray.split(",");
		Catergory[] returning = new Catergory[splitString.length];

		for (int i = 0; i < splitString.length; i++) {
			returning[i] = Catergory.toCatergory(splitString[i]);
		}

		return returning;
	}
}
