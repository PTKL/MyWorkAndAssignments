import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class StaticRPS {
	private static int ROCK = 1;
	private static int PAPER = 2;
	private static int SCIS = 3;

	public static String choice(int play) {
		if (play == 1) {
			return "Rock";
		} else if (play == 2) {
			return "Paper";
		} else {
			return "Scissors";
		}
	}

	public static void checkWinning(int playersPlay, int aiPlay) {
		boolean won = false;
		if (playersPlay == aiPlay) {
			System.out.println("tie");
			return;
		}
		if (playersPlay == ROCK) {
			if (aiPlay == PAPER) {
				won = true;
			} else if (playersPlay == PAPER) {
				if (aiPlay == ROCK) {
					won = true;
				}
			} else if (playersPlay == SCIS) {
				if (aiPlay == PAPER) {
					won = true;
				}
			}

			if (won) {
				System.out.println("You Won!");
			} else {
				System.out.println("You Lost!");
			}
		}
	}

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int playersPlay = 0;
		try {
			System.out.println("What do you want to play 1R 2P 3S");
			playersPlay = kbd.nextInt();
			if (playersPlay > 0 && playersPlay < 4) {

				Random randomGenerator = new Random();
				int aiPlay = randomGenerator.nextInt(3) + 1;
				kbd.close();
				System.out.println("You played: " + choice(playersPlay));
				System.out.println("The AI played: " + choice(aiPlay));
				checkWinning(playersPlay, aiPlay);
			} else {
				System.out.println("INVALID INPUT");

			}
		} catch (InputMismatchException e) {

			System.out.println("INVALID INPUT");

		}
	}
}
