import java.util.Scanner;

public class Euclides {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter first number to find GCD");
		int number1 = scanner.nextInt();
		System.out.println("Please enter second number to find GCD");
		int number2 = scanner.nextInt();

		System.out.println("GCD of two numbers " + number1 + " and " + number2
				+ " is :" + gdc(number1, number2));

	}

	/*
	 * Java method to find GCD of two number using Euclid's method
	 */
	private static int gdc(int p, int q) {
		// base case
		
		if (q == 0) {
			return p;
		}
		
		int case2 = p % q;
		
		if (q > p) {
			
			return gdc(q, p);
		}
		
		if (p > q) {
			
			return gdc(q, case2);
		}
		
		
		return gdc(q, p % q);
	}
}
