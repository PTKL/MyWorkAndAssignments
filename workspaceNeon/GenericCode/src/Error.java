//BEFORE
//public class Error {
//	int y = 2;
//	public static void main (String[] args) {
//		int x = 42;
//		{
//			int y = 3;
//		}
//	System.out.println(x/y);
//	}
//}
//AFTER
public class Error {
	static int y = 2;
	public static void main (String[] args) {
		int x = 42;
		y = 3;
		
		System.out.println(x/y);
	}
}