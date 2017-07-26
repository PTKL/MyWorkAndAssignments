import java.util.Scanner;

public class CelebrityGame {
	static TreeNode tree;
	static TreeNode node;
	static String question;
	private static Scanner kbd = new Scanner(System.in);

	static boolean playAgain() {
		System.out.print("\nPlay Another Game? ");
		char inputCharacter = kbd.next().charAt(0);
		while (inputCharacter != 'y' && inputCharacter != 'n') {
			System.out.println("Incorrect input please enter again: ");
			inputCharacter = kbd.next().charAt(0);
		}
		if (inputCharacter == 'y') {
			return true;
		} /*else {  ////// corresponds to GameTree.java save load methods
			tree.saveGame();
			System.out.println();
			return false;
		}*/
		return false;
	}

	static void startNewGame() {
		System.out.println("No previous knowledge found!");
		System.out.println("Initializing a new game.\n");
		System.out.println("Enter a question about an object: ");
		question = kbd.nextLine();
		System.out.print("Enter a guess if the response is Yes: ");
		String yesGuess = kbd.nextLine();
		System.out.print("Enter a guess if the response is No: ");
		String noGuess = kbd.nextLine();
		tree = new TreeNode(question, tree, node, node, yesGuess, noGuess, null);
	}

	public static void main(String[] args) {
		startNewGame();
		System.out.println("\nStarting the Game");
		tree.question(); // play one game
		while (playAgain()) {
			System.out.println();
			tree.question(); // play one game
		}
	}
}
