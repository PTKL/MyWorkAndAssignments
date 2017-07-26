import java.util.HashMap;

public class HashTableTestSI {

	public static void main(String[] args) {
		HashMap<String, Integer> numbers = new HashMap<String, Integer>();
		// Add <String, Integer> pairs using Autoboxing
		numbers.put("one", 1);
		numbers.put("two", 2);
		numbers.put("three", 3);
		// Get the value corresponding to a key
		Integer n = numbers.get("two");
		// get returns null if the element is missing
		if (n != null) {
			System.out.println("two = " + n);
		}
		// We can explicitly test
		if (numbers.containsKey("three")) {
			System.out.println("three = " + numbers.get("three"));
		}
	}

}
