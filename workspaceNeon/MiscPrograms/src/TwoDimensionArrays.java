//import java.util.Scanner;
// to make it ask the user for the input of the number of columns uncomment lines 1, 5 and 8 and replace int column = 10; with int column = kbd.nextInt();
class TwoDimensionArrays {

	// shortening System.out.println() to just printf() for easy access and faster typing

	public static void printf(String text) {

		System.out.println(text);

	}

	public static void main(String[] args) {
		//Scanner kbd = new Scanner(System.in);
		int sum = 0;
		int row = 2;
		//System.out.print("Enter a number of columns: ");
		int column = 10; // number of columns of the array
		int limit = row * column; // total capacity of the elements in the array in this case 2*10 = 20
		int[][] iArrays = new int[row][column]; // creating the array

		/*What is happening is the row is being set to the remainder of counter % 2 
		 * (0 if counter is even, 1 if counter is odd) 
		 * and the column is being set to the corresponding index 
		 * (with the cast to int to drop any fraction).
		 */
		for(int counter = 0; counter < limit; counter++) {

			iArrays[counter % 2][(int)counter/2] = counter + 1;
		}
		//printing out how many rows the array has	
		printf("The array has " + iArrays.length + " rows");
		//printing out how many columns the array has
		System.out.println("The array has " + iArrays[0].length + " columns");

		// calculating the sum by stepping through all the values in the array and adding them up and will also print out the array
		for(int rowCount = 0; rowCount < iArrays.length; rowCount++) {
			for(int columnCount = 0; columnCount < iArrays[0].length; columnCount++) {
				System.out.print(iArrays[rowCount][columnCount] + " ");
				sum += iArrays[rowCount][columnCount];
			}
			// this will print out the array in two rows rathar then one remove it and observe the difference
			printf("");
		}
		// printing out the sum
		printf("The sum is: " +sum);
	}
}

