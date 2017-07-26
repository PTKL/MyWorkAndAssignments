// deivid dimitrov 
import java.util.*;

public class CounterOfElementsInArray {
	private static Scanner in;

	public static void main(String[] args) {
		int numElements = 0;
		int counter = 1;
		int elementsInFirst = 0;
		int current;
		System.out.println("Enter number of" + " e" + "lements: ");
		in = new Scanner(System.in);
		numElements = in.nextInt();
		int[] firstArray = new int[numElements];

		for (int i = 0; i < numElements; i++) {
			firstArray[i] = in.nextInt();
		}
		Arrays.sort(firstArray);

		for (int i = 0; i < firstArray.length; i++) {
		}
		int j = 0;
		int[] counterArray = new int[2 * firstArray.length];
		for (int i = 0; i < firstArray.length; i++) {
			current = firstArray[i];
			elementsInFirst++;
			if (i == firstArray.length - 1)
				break;
			while (current == firstArray[i + 1]) {
				counter++;
				i++;
				if (i == firstArray.length - 1)
					break;
			}
			counterArray[j] = current;
			counterArray[j + 1] = counter;
			j += 2;
			counter = 1;
		}
		for (int i = 0; i < elementsInFirst * 2; i++) {
			System.out.println(counterArray[i]);
		}

	}
}



