//NOTE Each time we add an allergry add the relevent if statement to the toString() & toAllergry()

/**
 * An Allergy class is used as a attribute of an Ingredient class instance.
 * To hold allergry information about the ingredient.
 * Which in the menuItem all Ingredient attributes of the menuItem will have their Allergys
 * complied to give the customer the needed Allergry information about the menuItems.
 * <br>
 * @author Callum
 */
public enum Allergry {
  Milk,Egg,Wheat,Nut,Fish,Shellfish;
  
  /**
   * Returns a debug string for the current Enum instance.
   * Which representatives the value the Enum holds.
   * Passing this debug string to Allergry.toAllergry(debugString)
   * will return an Enum from which this debug string was
   * created and has the corresponds values off.
   * <br><br>
   * <b>Therefore:</b><br>
   * Allergry.test1 == Allergry.toAllergry(Allergry.test1.toString())<br>
   * 
   * @return <b>String</b><br>
   *     A debug string, representative of the enum value.<br>
   * @author Callum
   */
  public String toString() {
    if (this.equals(Allergry.Milk)) {
      return "Milk";
    } else if (this.equals(Allergry.Egg)) {
      return "Egg";
    } else if (this.equals(Allergry.Wheat)) {
      return "Wheat";
    } else if (this.equals(Allergry.Nut)) {
        return "Nut";
    } else if (this.equals(Allergry.Fish)) {
        return "Fish";
    } else if (this.equals(Allergry.Shellfish)) {
        return "Shellfish";
    }
    
    return "";//will only ever be "" if we forget to add an enum to the elif's 
  }
  
  /**
   * Is a function which takes an Allergry array 
   * and compiles a debug string containing the debug string
   * of each element in the array.
   * It will begin the debug String with 'Allergies{' and end it with '}'.
   * Each debug String of each Allergry will be separated by a colon.
   * <br><br>
   * <b>Therefore:</b><br>
   * Allergry[] alg = {Allergry.test1,Allergry.test2,Allergry.test3};<br>
   * alg == Allergry.toAllergryArray(Allergry.toString(alg));<br>
   * 
   * @param Allergry [] <br> 
   *     The Allergry Array you wish to compile a debug String for.
   * @return <b>String</b><br>
   *     A debug String, containing debug info for each Allergry in the array.
   *     <br><b>format:</b>Allergies{debugString,debugString....}
   * @author Callum
   */
  public static String toString(Allergry[] allergies) {
    String returning = "Allergies{";
    
    //not using for each so know when to add the comma
    for (int i = 0; i < allergies.length;i++) {
      returning += allergies[i].toString();
      if (i != (allergies.length - 1)) {
        returning += ",";
      }
    }
    
    return (returning += "}");
  }
  
  /**
   * Is a function which takes a String
   * and converts the debug string, back into the Allergry
   * the debug string was created from. If the debug string
   * can't be parsed back into a Allergry then it will return null.
   * <br><br>
   * <b>Therefore:</b><br>
   * Allergry.test1 == Allergry.toAllergry(Allergry.test1.toString())<br>
   * 
   * @param String <br> 
   * 	Allergry debug string you wish to convert back to an Allergry object.
   * @return <b>Allergry</b><br>
   *     Returns an Allergry object, which corresponds to the debug String input.
   *     If one isn't found; returns null.
   * @author Callum
   */
  public static Allergry toAllergry(String stringToAllergry) {
    if (stringToAllergry.equalsIgnoreCase("Milk")) {
      return Allergry.Milk;
    } else if (stringToAllergry.equalsIgnoreCase("Egg")) {
      return Allergry.Egg;
    } else if (stringToAllergry.equalsIgnoreCase("Fish")) {
      return Allergry.Fish;
    } else if (stringToAllergry.equalsIgnoreCase("Nut")) {
        return Allergry.Nut;
    } else if (stringToAllergry.equalsIgnoreCase("Shellfish")) {
        return Allergry.Shellfish;
    } else if (stringToAllergry.equalsIgnoreCase("Wheat")) {
        return Allergry.Wheat;
    }
    
    return null;  
  }
  
  /**
   * Is a function which takes a String
   * and converts the debug string, back into the Allergry Array
   * the debug string was created from. Will return null if it can't be parsed.
   * Returned Arrays may have elements which are null.
   * 
   * <br><br>
   * <b>Therefore:</b><br>
   * Allergry[] alg = {Allergry.test1,Allergry.test2,Allergry.test3};<br>
   * alg == Allergry.toAllergryArray(Allergry.toString(alg));<br>
   * 
   * @param String <br> 
   *     Allergry Array debug string you wish to convert back to an Allergry array.
   * @return <b>Allergry[]</b><br>
   *     Returns an Allergry Array which corresponds to the debug String input.
   * @author Callum
   */
  public static Allergry[] toAllergryArray(String stringToAllergryArray) {
    if (stringToAllergryArray.length() < 11) {
      return null;
    } //would be able to sub first 10 and last 1
    
    if ( !(stringToAllergryArray.startsWith("Allergies{")) ) {
      return null;
    } //isnt an Allergry[] toString as doesnt start with 'Allergies{'
    
    //removes the Allergies{
    stringToAllergryArray = stringToAllergryArray.substring(10);
    //remove the last {
    stringToAllergryArray = stringToAllergryArray.substring(0, stringToAllergryArray.length() - 1);

    String[] splitStringToAllergryArray = stringToAllergryArray.split(",");  
    Allergry[] returning = new Allergry[splitStringToAllergryArray.length];
    
    for (int i = 0;i < splitStringToAllergryArray.length;i++) {
      returning[i] = Allergry.toAllergry(splitStringToAllergryArray[i]);
    }
    
    return returning;
  }
}
