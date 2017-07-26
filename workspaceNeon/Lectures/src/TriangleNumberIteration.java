public class TriangleNumberIteration {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(iterativeTriangleNumber(n));
	}

	public static int iterativeTriangleNumber(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result = result + i;
		}
		return result;
	}
}
