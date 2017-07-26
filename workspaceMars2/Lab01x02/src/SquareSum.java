class SquareSum {
	public static int sqSum(long n) {
		if (n == 0) {
			return 0;
		} else {
			return (int) (n * n) + sqSum(n - 1);
		}
	}

	public static void main(String[] args) {
		long n = Integer.parseInt(args[0]);

		System.out.println(sqSum(n));
	}
}
