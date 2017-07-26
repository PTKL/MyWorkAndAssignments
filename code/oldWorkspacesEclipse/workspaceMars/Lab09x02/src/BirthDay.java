import java.util.Scanner;

public class BirthDay {

	static boolean loopState = true;

	public static void main(String[] args) {

		System.out.println("This program simulates taking people at random");
		System.out.println("until two have been found who were born on the");
		System.out.println("same day of the year.\n");
		
		Scanner kbd = new Scanner(System.in);
		

		while (loopState) {

			birthdayProblem();
			System.out.println("\nAgain? ");
			String state = kbd.nextLine();
			if (state.equals("no")) {
				loopState = false;
			}
		}

	}// end main()

	static void birthdayProblem() {
		// Simulate choosing people at random and checking the
		// day of the year they were born on. If the birthday
		// is the same as one that was seen previously, stop,
		// and output the number of people who were checked.

		boolean[] used; // For recording the possible birthdays
						// that have been seen so far. A value
						// of true in used[i] means that a person
						// whose birthday is the i-th day of the
						// year has been found.

		int count; // The number of people who have been checked.

		used = new boolean[365]; // Initally, all entries are false.

		count = 0;

		while (loopState) {
			// Select a birthday at random, from 0 to 364.
			// If the birthday has already been used, quit.
			// Otherwise, record the birthday as used.
			int birthday; // The selected birthday.
			birthday = (int) (Math.random() * 365);
			count++;
			if (used[birthday])
				break;
			used[birthday] = true;
		}

		System.out.println("A duplicate birthday was found after " + count
				+ " tries.");

	} // end birthdayProblem()

} // end class BirthdayProblemDemo

