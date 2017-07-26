import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class WordPuzzle {

	public static void main(String[] args) throws FileNotFoundException {
		long startTime = 0;
		long elapsedTime = 0;

		DictionaryGame newDictionary = new DictionaryGame();
		Scanner keyboard = new Scanner(System.in);

		while (true) {
			System.out.print("Enter a String to search: ");
			String userInput = keyboard.nextLine();
			startTime = System.nanoTime();
			System.out.println(newDictionary.linearSearch(userInput));
			
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
