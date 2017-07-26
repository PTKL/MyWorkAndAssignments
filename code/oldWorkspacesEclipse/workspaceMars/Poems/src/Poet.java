import java.util.*;

public class Poet {
	// pattern: verse ==> 'The' adjective noun verb adjective object
	// lists of words
	static String[] verblist = { "walks", "eats", "sleeps", "works", "studies" };
	static String[] nounlist = { "student", "professor" };
	static String[] pronounlist = { "i", "you" };
	static String[] adjlist = { "pretty", "smart", "fun" };
	static String[] objlist = { "flowers", "books" };

	static Random rand = new Random(); // a random number generator

	/*
	 * parameters: a list of words 'list' is given action: return a random word
	 * from the list of words
	 */
	static String word(String[] list) {

		// s is a random number in the range 0 to n-1
		int s = rand.nextInt(list.length);

		// print the s-th word from the list of words
		return list[s] + " ";
	}

	// action: return a random verb from verblist
	static String verb() {
		return word(verblist);
	}

	// action: return a random noun from nounlist
	static String noun() {
		return word(nounlist);
	}

	// action: return a random pronoun from pronounlist
	static String pronoun() {
		return word(pronounlist);
	}

	// action: return a random adjective from adjlist
	static String adjective() {
		return word(adjlist);
	}

	// action: return a random object from objlist
	static String object() {
		return word(objlist);
	}

	// action: print a verse
	static void printVerse() {

		// formula for a verse is
		// verse ==> 'The' adjective noun verb adjective object
		System.out.println("The " + adjective() + noun() + verb() + adjective()
				+ object());
	}

	// action: generate a stanza
	static void stanza() {
		int i = 0;

		// stanza of 4 verses
		while (i < 4) {
			printVerse();
			i++;
		}
		System.out.println();
	}

	public static void main(String args[]) {

		// generate one stanza
		stanza();
	}

}