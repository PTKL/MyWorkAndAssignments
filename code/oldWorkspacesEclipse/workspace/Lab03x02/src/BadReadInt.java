import java.util.Scanner;

class BadReadInt {
	public static void main(String[] args) {
		int n;
		Scanner s = new Scanner(System.in);

		System.out.print("Enter an integer: ");
		n = s.nextInt();

		System.out.println("Good job!");
	}
}
