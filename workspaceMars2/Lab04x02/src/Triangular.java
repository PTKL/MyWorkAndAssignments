import java.util.Scanner;

public class Triangular {

	static Scanner kbd = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Enter a number: ");

		int num = kbd.nextInt();

		System.out.println(t(num));

	}

	public static int t(int n) {

		if (n < 0) {
			
			System.out.println("Negative Number");
			
			return n;
			
		}

		if (n == 0) {

			return 0;
		}

		if (n == 1) {

			return 1;

		} else {

			int result = n + t(n - 1);

			return result;

		}

	}

}
