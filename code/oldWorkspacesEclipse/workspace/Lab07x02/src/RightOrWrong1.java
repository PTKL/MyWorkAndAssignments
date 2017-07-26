public class RightOrWrong1 {
	 static int y = 2;

	public static void main(String[] args) {
		int x = 42;
		{
			int y = 3;
		}
		System.out.println(x / y);
	}
}
