import java.util.Scanner;

public class TicTacToe {
	/** This game uses Scanner(System.in) to get players'input */
	private static Scanner keyboard = new Scanner(System.in);

	/** The game board - 0: Empty; 1: Cross; 2: Nought */
	private static int[][] gameBoard;

	/** The current playing player - 1: Player 1; 2: Player 2 */
	private static int currentPlayer;

	/**
	 * The state of the game - 0: Game in progress; 1: Player 1 won; 2: Player 2
	 * won; 3: Draw;
	 */
	private static int gameState;

	/** Prepare the game board for playing */
	private static void prepareGameboard() {
		gameBoard = new int[3][3];
		for (int row = 0; row < gameBoard.length; row++) {
			for (int column = 0; column < gameBoard[0].length; column++) {
				gameBoard[row][column] = 0;
			}
		}

		currentPlayer = 1; // Default, player 1 starts
		gameState = 0; // Set game state to "Game in progress"
	}

	/** The main progression of the game */
	private static void play() {
		boolean validMove = false;
		int selectedRow = 0;
		int selectedColumn = 0;

		while (!validMove) {
			if (currentPlayer == 1) {
				System.out.println("Player X's turn: ");
			} else if (currentPlayer == 2) {
				System.out.println("Player O's turn: ");
			}

			System.out.print("Row no.? ");
			selectedRow = keyboard.nextInt();
			System.out.print("Column no.? ");
			selectedColumn = keyboard.nextInt();

			if (selectedRow > 0 && selectedRow <= gameBoard.length
					&& selectedColumn > 0
					&& selectedColumn <= gameBoard[0].length
					&& gameBoard[selectedRow - 1][selectedColumn - 1] == 0) {
				gameBoard[selectedRow - 1][selectedColumn - 1] = currentPlayer;
				validMove = true;
			} else {
				System.out.println("Invalid Move! Please try again.");
			}

		}
		System.out.println();
		if (checkWinning(selectedRow - 1, selectedColumn - 1)) {
			gameState = currentPlayer;
			printGameBoard();
			if (currentPlayer == 1) {
				System.out.println("Congrats Player X!");
			} else if (currentPlayer == 2) {
				System.out.println("Congrats Player O!");
			} else {
				System.out.println("Something is wrong!");
				System.exit(0);
			}

		} else if (checkDraw()) {
			System.out.println("DRAW!");
			gameState = 3;
		}
		switchPlayer();
	}

	/** Print the current state of the game board */
	private static void printGameBoard() {
		for (int row = 0; row < gameBoard.length; row++) {
			for (int column = 0; column < gameBoard[0].length; column++) {
				if (gameBoard[row][column] == 0) {
					System.out.print("   ");
				} else if (gameBoard[row][column] == 1) {
					System.out.print(" X ");
				} else if (gameBoard[row][column] == 2) {
					System.out.print(" O ");
				}

				if (column != gameBoard[0].length - 1) {
					System.out.print("|");
				}
			}
			System.out.println();
			if (row != gameBoard.length - 1) {
				System.out.println("-----------");
			}
		}
		System.out.println();
	}

	/** Check if the game has been won */
	private static boolean checkWinning(int selectedRow, int selectedColumn) {
		if (gameBoard[selectedRow][0] == gameBoard[selectedRow][1]
				&& gameBoard[selectedRow][0] == gameBoard[selectedRow][2]) {
			return true;
		}
		if (gameBoard[0][selectedColumn] == gameBoard[1][selectedColumn]
				&& gameBoard[0][selectedColumn] == gameBoard[2][selectedColumn]) {
			return true;
		}
		if (gameBoard[0][0] == gameBoard[1][1]
				&& gameBoard[0][0] == gameBoard[2][2] && gameBoard[1][1] != 0) {
			return true;
		}
		if (gameBoard[0][2] == gameBoard[1][1]
				&& gameBoard[0][2] == gameBoard[2][0] && gameBoard[1][1] != 0) {
			return true;
		}
		return false;
	}

	/** Check if the game is drawn */
	private static boolean checkDraw() {

		for (int rowCount = 0; rowCount < gameBoard.length; rowCount++) {
			for (int colCount = 0; colCount < gameBoard[0].length; colCount++) {
				if (gameBoard[rowCount][colCount] == 0) {
					return false;
				}
			}

		}
		return true;
	}

	/** Switch to another player's turn */
	private static void switchPlayer() {
		if (currentPlayer == 1) {
			currentPlayer = 2;
		} else if (currentPlayer == 2) {
			currentPlayer = 1;
		}
	}

	/**
	 * The main function of the program. Utilises all other functions to make
	 * this game playable.
	 */
	public static void main(String[] args) {
		prepareGameboard();
		while (gameState == 0) {
			printGameBoard();
			play();
		}
		
		printGameBoard();

	}

}