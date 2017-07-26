import java.io.FileNotFoundException;
import java.util.*;

/**
 * @version 1.0
 * @param startTime used to measure the time the program takes to return a result in nanoseconds @see nanoTime()
 * @param elapsedTime used to measure the time that passes from the start of the program until a result is returned @see nanoTime()
 * @param newDictionary create a new object of type Dictionary @see DictionaryGame.java
 * @param keyboard scanner used to read input from the keyboard by the user
 * @param userInput used to read the input from the keyboard by the user
 * @throws FileNotFoundException in case the file is not found (must add try catch block)
 */

public class DictionaryGameTest {

	public static void main(String[] args) throws FileNotFoundException { // add try catch

		long startTime = 0;
		long elapsedTime = 0;

		DictionaryGame newDictionary = new DictionaryGame();
		Scanner keyboard = new Scanner(System.in);

		while (true) {
			System.out.print("Enter a String to search: ");
			String userInput = keyboard.nextLine();
			startTime = System.nanoTime();
			//System.out.println(newDictionary.linearSearch(userInput));
			newDictionary.binarySearch(userInput);
			
			char[] ch = userInput.toCharArray();
			Arrays.sort(ch);
			String sorted = String.valueOf(ch);
			
			newDictionary.anagram(sorted);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("The time it took to return the result was: " + elapsedTime / 1000 + " nanoseconds.");

			if (userInput.isEmpty()) {
				break;
			}

		}

	}
}
