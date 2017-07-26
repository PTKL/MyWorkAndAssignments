import java.io.*;
import java.util.*;

/** 
 * @version 1.0
 * @param wordList used to store the contents of the file to be used in HashSet and HashMap
 * @param wordArray used to store the contents of the file to be searched through
 * @param lineRead used to read the contents of the file with the use of a Scanner
 * @param fileName used to specify the file name and location (directory)
 * @param fileScanner used to scan the file
 * @param input used as an argument for searching for the user input @see search(String input)
 * @throws FileNotFoundException in case the file is not found (must add try catch block)
 */

public class DictionaryGame {

	// make HashSet and HashMap

	private ArrayList<String> wordList;
	private HashMap<String, String> wordMap;
	String input;
	String lineRead = "";
	File fileName = new File("words.txt");
	Scanner fileScanner = new Scanner(fileName);

	public DictionaryGame() throws FileNotFoundException { // add try catch
		wordList = new ArrayList<String>();
		wordMap = new HashMap<String, String>();

		while (fileScanner.hasNext()) {
			lineRead = fileScanner.nextLine();
			
			wordList.add(lineRead.toLowerCase());
			
			char[] ch = lineRead.toCharArray();
			Arrays.sort(ch);
			String sorted = String.valueOf(ch);
			wordMap.put(sorted.toLowerCase(), lineRead);

		}


		System.out.println(wordList.size());

	}

	/**
	 * Uses linear search to find the user input (1)
	 * <p>
	 * A linear search looks down a list, one item at a time, without jumping.  [2]
	 * In complexity terms this is an O(n) search - the time taken to search the list gets bigger at the same rate as the list does.
	 * Definition for linear search taken from StackOverflow: http://stackoverflow.com/questions/700241/what-is-the-difference-between-linear-search-and-binary-search 
	 * <p>
	 * @param String (3)
	 * @return method search(String input) returns true or false 
	 */
	
	public void anagram(String s) {
		System.out.println("Anagram");
		System.out.println(wordMap.get(s));
	}

	public boolean linearSearch(String input) {
		

		   for (int index = 0; index < wordList.size(); index++) {
				if (wordList.get(index).equals(input.toLowerCase())) {
					return true;
				}
			}
			return false;
			
		}

}
