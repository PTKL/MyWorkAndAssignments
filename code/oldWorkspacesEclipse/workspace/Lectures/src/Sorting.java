import java.util.*;

public class Sorting {

	// //////////////////////////////////////
	// /// SELECTION SORT

	// Swaps to entries in a list at positions i and j
	private static void swap(List<Integer> list, int i, int j) {
		Integer temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	// Finds index with minimum value in "list" starting from "start"
	private static int findMin(List<Integer> list, int start) {
		int min = start;
		for (int i = start; i < list.size(); i++) {
			if (list.get(i) < list.get(min)) {
				min = i;
			}
		}
		return min;
	}

	// Sorts the list given as argument using Selection Sort
	public static void selectionSort(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			int minIndex = findMin(list, i);
			// swap the minimum with i-th element
			swap(list, i, minIndex);
		}
	}

	// //////////////////////////////////////
	// /// INSERTION SORT

	// Sorts the list given as argument using Insertion Sort
	public static void insertionSort(List<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			// Get current element
			int cur = list.get(i);
			int j;
			// Starting from left neighbour, shift all elements
			// greater than cur to the right
			for (j = i - 1; j >= 0 && cur < list.get(j); j--) {
				list.set(j + 1, list.get(j));
			}
			// Now, j points to the first element smaller or
			// equal to cur, so put cur in slot j+1
			list.set(j + 1, cur);
		}
	}

	// //////////////////////////////////////
	// /// MERGE SORT

	// Merges two sorted lists a and b into a new sorted list
	public static List<Integer> merge(List<Integer> a, List<Integer> b) {
		// This will hold the resulting merged list
		List<Integer> result = new ArrayList<Integer>();
		// Indices for iterating over a and b
		int i = 0, j = 0;
		// As long as there are items left in both lists
		while (i < a.size() && j < b.size()) {
			if (a.get(i) < b.get(j)) {
				// If a's current element is smaller, add it to result list
				result.add(a.get(i));
				// And increment the index for a
				i++;
			} else {
				// Else, b's current element is smaller so it goes into result
				result.add(b.get(j));
				// Increment index for b
				j++;
			}
		}
		// Cleanup phase - only one of these loops will actually run
		// Copy over any remaining elements in a
		while (i < a.size()) {
			result.add(a.get(i));
			i++;
		}
		// Copy over any remaining elements in b
		while (j < b.size()) {
			result.add(b.get(j));
			j++;
		}
		return result;
	}

	// Returns a new list which is a sorted copy of the input list
	public static List<Integer> mergeSort(List<Integer> list) {
		// Base case
		if (list.size() == 1) {
			return list;
		}

		// Middle position in list
		int mid = list.size() / 2;

		// Recursive calls to sort left and right sublists
		// subList(s,t) is a sublist from s (inclusive) to t (exclusive)
		List<Integer> left = mergeSort(list.subList(0, mid));
		List<Integer> right = mergeSort(list.subList(mid, list.size()));

		// Merge the sorted sublists
		return merge(left, right);
	}

	// //////////////////////////////////////
	// /// MAIN METHOD FOR TESTING

	// Sorts a list of 10 random integers
	public static void main(String[] args) {
		Random rand = new Random();

		// Generate list of 10 random integers
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(rand.nextInt(100));
		}

		System.out.println("Sorting " + list);
		// Call merge sort (returns a new sorted list)
		list = mergeSort(list);

		// Call insertion sort (sorts the list given as argument)
		// insertionSort(list);

		// Call selection sort (sorts the list given as argument)
		// selectionSort(list);

		System.out.println("Result: " + list);
	}
}