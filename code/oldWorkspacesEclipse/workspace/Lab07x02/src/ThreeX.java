public class ThreeX {
	
	static int x = 3;

	public static int printX() {
		int x = 4;
		return x;
	}

//	public static int printX2() {
//		int x = 5;
//		return x;
//	}

	public static void main(String[] args) {
		
		for (int x = 0; x <= 10; x++) {
			System.out.println(x);

		}

		System.out.println(x);
		System.out.println(printX());
		//System.out.println(printX2());

	}

}
