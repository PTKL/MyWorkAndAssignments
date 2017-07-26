import java.util.Scanner;

public class MaxMin {
	
	static Scanner kbd = new Scanner(System.in);

	
	static int max = 1;
	static int min = kbd.nextInt();

	public static void max(int n) {
		if (n > max) {
			max = n;
		}
	}

	public static void min(int n) {
		if (n < min) {
			min = n;
		}
	}

	public static void main(String[] args) {
		// System.out.print("Enter an Integer: ");


		int num;
		do {
			//System.out.print("Enter an Integer: ");
			num = kbd.nextInt();

			if (num < 0) {
				break;
			}
			max(num);
			min(num);

		} while (num >= 0);
		//System.out.println(num);
		System.out.println(max);
		System.out.println(min);


	}
}
