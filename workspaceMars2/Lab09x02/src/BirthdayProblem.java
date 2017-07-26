import java.util.InputMismatchException;
import java.util.Scanner;

public class BirthdayProblem {
	public static void main(String[] args) {
		int rooms = userInput("enter number of rooms");
		int maxPersons = userInput("Max number of pepole");

		for (int i = 1; i <= maxPersons; ++i) {
			Hotel hotel = new Hotel(rooms, i);
			System.out.println(hotel);
		}
	}

	public static int userInput(String prompt) {
		// System.out.println(prompt);
		Scanner input = new Scanner(System.in);
		int number = 0;
		while (true) {
			try {
				System.out.print(prompt + " >");
				number = input.nextInt();

				if (number > 0) {
					return number;
				}
				else {
					System.out.println("Enter a positive integet");
				}
			} catch (InputMismatchException e) {
				if (input.hasNext()) {
					input.nextLine();
				}
				System.out.println("Enter a integet");
			}
		}
	}

}
