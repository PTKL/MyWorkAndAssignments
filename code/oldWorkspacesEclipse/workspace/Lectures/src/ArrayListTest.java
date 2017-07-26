import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("Enter some integers:");
		// Finishes when there are no more integers
		// or when the next entry is not an integer
		while (input.hasNextInt()) {
			list.add(new Integer(input.nextInt()));
		}
		// Test if 0 is among the integers.
		System.out.println(list.contains(new Integer(0)));

		// Convert to an array
		Integer[] array = new Integer[0];
		array = list.toArray(array);
		// toString is defined properly on ArrayList
		System.out.println(list);

	}

}
