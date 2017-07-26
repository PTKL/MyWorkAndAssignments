import java.util.HashSet;

public class HashTableTest {

	public static void main(String[] args) {
		HashSet<String> s = new HashSet<String>();
		s.add("Hello"); // Add element to hash set
		s.add("World");
		s.add("!");
		s.add("Hello"); // Element already present
		System.out.println(s.size());
		// Prints 3
		System.out.println(s.contains("Hello")); // Prints true
		s.remove("!");
		System.out.println(s); // Prints [Hello, World]
		// Iterate over all elements
		for (String str : s) {
			System.out.println("Element: " + str);
		}
	}

}
