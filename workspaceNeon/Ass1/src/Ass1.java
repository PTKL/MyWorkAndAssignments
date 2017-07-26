// This program reads lines from a file of name "ages.txt" and the ages are in asending order

// importing packages
import java.io.*;
import java.util.Scanner;

class Ass1 {
	public static void main(String[] args) throws FileNotFoundException {
		// searching for file
		File myfile = new File("ages.txt");
		// creating new scanner
		Scanner scanner = new Scanner(myfile);

		int counter = 0;
		int linesNumb = 0;// linesNumb represents the number of lines in the
							// file
		int sum = 0; // represents the total sum of the array
		int tempStore;
		int mean;// mean represents the mean value of the array
		int median;// median represents the value of the median of the array
		int upperQuartile; // represents the upper quartile
		int lowerQuartile; // represents the lower quartile

		while (scanner.hasNext()) {
			counter = scanner.nextInt();
			tempStore = counter;
			sum = sum + tempStore;
			linesNumb++;
			System.out.println(tempStore + " - line " + linesNumb);
			counter++;
		}
		// creating array to hold values of file ages.txt
		int[] buffer = new int[linesNumb];

		// loading process for buffer
		Scanner scann = new Scanner(myfile);

		for (int count = 0; count < buffer.length; count++) {

			buffer[count] = scann.nextInt();

		}
		scanner.close();
		scann.close();

		// calculating median
		median = buffer[buffer.length / 2];
		// calculating mean
		mean = sum / buffer.length;
		// calculating the upper quortile
		upperQuartile = buffer[buffer.length / 4];
		// calculating the lower quortile
		lowerQuartile = buffer[buffer.length / 4 * 3 - 1];

		// printing results
		System.out.println("ages.txt contains " + linesNumb + " lines");
		System.out.println("The sum is " + sum);
		System.out.println("The mean value is " + mean);
		System.out.println("The median is " + median);
		System.out.println("The upper quartile is " + upperQuartile);
		System.out.println("The lower quartile is " + lowerQuartile);
	}
}
