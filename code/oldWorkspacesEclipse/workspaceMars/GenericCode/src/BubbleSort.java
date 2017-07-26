import java.util.ArrayList;


public class BubbleSort {
	
	public static void main (String[] args)
	{
		int[] arg = {5,3,7,8,2,4,7};
		print(Bubblesort(arg));
	}
	
	
	/**
	 * This sort method uses a do while loop to check at the end
	 * of each traversal of the array if any values were sorted.
	 * If a value was sorted then it will stop iterating over the
	 * array as the array will be sorted.
	 * 
	 * @param sort
	 * @return int array which has been sorted.
	 */
	static int[] Bubblesort(int[] sort)
	{
		boolean swapped = true;
		do 
		{
			swapped = false;
			for (int i = 1; i < sort.length; i++)
			{
				if (sort[i-1] > sort[i])
				{
					int temp = sort[i];
					sort[i] = sort[i-1];
					sort[i-1] = temp;
					swapped = true;
				}
			}
		} while (swapped);
		return sort;
	}
	
	static void print(int[] arr)
	{
		for (int x = 0; x < arr.length; x++)
		{
			System.out.print(arr[x] + ", ");
		}
	}
	
	public static <E extends Comparable<E>> void bubbleSort ( ArrayList<E> a )
	{
		boolean swapped = true;
		do 
		{
			swapped = false;
			for (int i = 1; i < a.size(); i++)
			{
				if (a.get(i - 1).compareTo(a.get(i)) == 1)
				{
					E temp = (a.get(i));
					a.set(i, a.get(i));
					a.set(i - 1, temp);
					swapped = true;
				}
			}
		} while (swapped);
	}
	
	public static String[] CombSort(String[] arr)
	{
		int gap = arr.length;
		float shrink = 1.3f;
		int i;
		boolean swapped = true;
		
		while (gap > 1 && swapped == true)
		{
			gap = (int)(gap/shrink);
			if (gap < 1)
			{
				gap = 1;
			}
			
			i = 0;
			swapped = false;
			
			while (gap + 1 < arr.length)
			{
				if (arr[i].compareTo(arr[gap + i]) == 1)
				{
					String temp = arr[i + gap];
					arr[i + gap] = arr[i];
					arr[i] = temp;
					swapped = true;
				}
				i++;
			}
		}
		return arr;
	}
	
	public int[] mergeSort(int[] A)
	{
		
	}
	
}
