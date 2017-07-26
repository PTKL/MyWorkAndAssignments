public class TriangleNumber {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(triangleNumber(n));
	}

	public static int triangleNumber(int n) {
		if (n == 1)
			return 1;
		return n + triangleNumber(n - 1);
	}
}