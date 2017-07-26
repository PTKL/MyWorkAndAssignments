/**
 * Use {@link #Scope(String)} to initialise the string.
 * @author Omiros
 *@param x is a string.
 *
 *
 *
 *
 */
class Scope {
	public static String x; //scope of instance variable x starts
	private int v; //scope of instance variable v starts
	public Scope (String x) { //scope of local variable x starts
		this.x = x ; //instance variable x is used with local variable x
		v = 0 ; //instance variable v is used
		//scope of local variable x ends
	}
	private void doSomething ( float f ) { //scope of local variable f starts
		float z = f; //scope of local variable z starts
		for (int x = 1 ; ...) { //scope of local variable int x starts
			int a = x; //scope of local variable a only exists in the loop
			//scope of local variable x ends
		}
		int w = 4; //local variable w only exists in the method
		//scope of local variable z ends
		//scope of local variable f ends
	}
	//scope of instance variable x ends
	//scope of int v ends
}
