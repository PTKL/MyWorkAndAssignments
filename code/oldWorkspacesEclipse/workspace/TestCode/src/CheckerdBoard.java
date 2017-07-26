public class CheckerdBoard {
	public static void main(String[] args) {
		int rowCount = 10;
		int colCount = 10;
		for (int rows = 0; rows < rowCount; rows++) {
			for (int cols = 0; cols < colCount; cols++) {
				if ((rows + cols) % 2 == 0) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
