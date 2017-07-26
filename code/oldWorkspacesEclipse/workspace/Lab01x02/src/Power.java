class Power {
	public static double powRec(double base, long n) {
		if (n == 0) {
			return 1;
		}
		else if (n < 0) {
			return 1 / (base * powRec(base, (n * -1) - 1));
		} else {
			return base * powRec(base, n - 1);
		}
	}

	public static void main(String[] args) {
		double base = Double.parseDouble(args[0]);
		long n = Integer.parseInt(args[1]);

		System.out.println(powRec(base, n));
	}
}
