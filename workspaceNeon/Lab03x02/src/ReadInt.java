//import java.util.InputMismatchException;
import java.util.Scanner;

class ReadInt {
	public static void main(String[] args) {
		boolean gotInt = false;
		int n;
		Scanner s = new Scanner(System.in);
		do {
			try {
				System.out.println("Enter an integer: ");
				n = s.nextInt();
				System.out.println("Good job!");
				gotInt = true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("The input has to be an integer!");
				s.next();
			}
		} while (!gotInt);

	}
}
