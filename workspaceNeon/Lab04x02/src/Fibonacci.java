public class Fibonacci {

	public static void main(String[] args) {

		for (int counter = 0; counter < 20; counter++)
			System.out.println(fibonacci(counter));
	}

	public static int fibonacci(int number) {
		if ((number == 0) || (number == 1)) // base cases
			return number;
		else
			// recursion step
			return fibonacci(number - 1) + fibonacci(number - 2);
	}

}
