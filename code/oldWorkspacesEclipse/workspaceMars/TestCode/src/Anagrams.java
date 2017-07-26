import java.util.*;
import java.io.*;

public class Anagrams {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException {
		File fileName = new File("words.txt");
		Scanner fileScanner = new Scanner(fileName);
		System.out.print("Input a String: ");
		String userInput = input.nextLine();

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		while (fileScanner.hasNextLine()) {
			String word = fileScanner.nextLine();
			String sortedWord = sortString(word); // this is a key

			ArrayList<String> anagrams = map.get(sortedWord); // this is a value

			if (anagrams == null) {
				anagrams = new ArrayList<String>();
			}

			anagrams.add(word);
			map.put(sortedWord, anagrams);
		}
		System.out.println(map.get(sortString(userInput))); // testing

	}

	private static String sortString(String w) {
		char[] ch = w.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}
