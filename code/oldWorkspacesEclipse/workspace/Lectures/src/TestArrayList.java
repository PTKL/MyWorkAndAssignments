import java.util.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {
		// Create an ArrayList
		ArrayList<String> list = new ArrayList<String>();

		// Adding a value
		list.add("Hello");
		list.add("World");
		// Direct access
		String s = list.get(1);
		// Replacing an element
		list.set(1, "World!");
		int i = 0;
		// Removing an element
		list.remove("Hello"); // removes a given element
		String t = list.remove(i); // returns the i-th element

	}

}
