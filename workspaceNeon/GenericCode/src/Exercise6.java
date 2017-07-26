import java.util.Scanner;
class Exercise6 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int size;
    System.out.println("Please enter the array size");
    size = input.nextInt();
    int[] unsorted = new int[size];
    for (int x = 0; x < unsorted.length; x++) {
      System.out.println("Please enter an integer");
      unsorted[x] = input.nextInt();
    }
    sortRecursion(unsorted, 2);
    for (int x = 0; x < unsorted.length; x++) {
      System.out.println("output " + unsorted[x]);
    }
  }
  public static void sort(int[] unsorted) {
    for (int x = 0; x < unsorted.length; x++) {
      int y = x, temp = 0;
      while ((y > 0) && (unsorted[y - 1] > unsorted[y])) {
	temp = unsorted[y];
	unsorted[y] = unsorted[y -1];
	unsorted[y - 1] = temp;
	y--;
	for (int q = 0; q < unsorted.length; q++) {
	  System.out.println("sorting " + unsorted[q]);
	}
      }
    }
  }
  
  public static int[] sortRecursion(int[] unsorted, int n) {
    int y;
    if (n < 1) {
      return unsorted;
    }
    else {
      sortRecursion(unsorted, n - 1);
      int key = unsorted[n];
      y = n - 1;
      while (y >= 0 && unsorted[y] > key) {
	unsorted[y + 1] = unsorted[y];
	y--;
	for (int q = 0; q < unsorted.length; q++) {
	  System.out.println("sorting " + unsorted[q]);
	}
      }
      unsorted[y + 1] = key;
    }
    return unsorted;
  }
}