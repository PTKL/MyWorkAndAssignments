import java.util.Scanner;

public class CelebrityGame {
	static GameTree tree;
	static TreeNode node;
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
		} else {
			tree.saveGame();
			System.out.println();
			return false;
		}
	}

	static void startNewGame() {
		System.out.println("No previous knowledge found!");
		System.out.println("Initializing a new game.\n");
		System.out.println("Enter a question about an object: ");
		String question = kbd.nextLine();
		System.out.print("Enter a guess if the response is Yes: ");
		String yesGuess = kbd.nextLine();
		System.out.print("Enter a guess if the response is No: ");
		String noGuess = kbd.nextLine();
		tree = new GameTree(question, yesGuess, noGuess);
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
