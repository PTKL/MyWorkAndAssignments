import java.util.Scanner;
import java.lang.Math;

class IntLog2 {
	public static int intLog2(int n) {
		if (n == 1)
			return 0;
		return 1 + intLog2(n / 2);
	}

	public static int remainder(int n) {
		return n - (int) (Math.pow(2, intLog2(n)));
	}

	public static void main(String[] args) {
		Scanner keys = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int i = keys.nextInt();
		keys.close();
		System.out.println("p=" + intLog2(i) + ", r=" + remainder(i));
	}
}