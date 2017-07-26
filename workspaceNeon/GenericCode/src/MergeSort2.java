import java.util.Arrays;
import java.util.Random;


public class MergeSort2 {
	
int[] result;
final static long startTime = System.currentTimeMillis();
static Random rng = new Random();

	public static void main (String[] args){
		MergeSort2 m = new MergeSort2();
		
		int[] input = new int[1000000];
		for (int x = 0; x < input.length; x++)
		{
			input[x] = rng.nextInt(input.length);
		}
		m.print(input);
		System.out.println("");
		m.print(m.merge_sort(input));
		final long endTime = System.currentTimeMillis();
		System.out.println("\nTotal execution time: " + (endTime - startTime) );
		
	}
	
	public int[] merge(int[] left, int[] right)
	{
		result = new int[left.length + right.length];
		int count = 0;
		while (left.length > 0 || right.length > 0)
		{
			if (left.length > 0 && right.length > 0)
			{
				if (left[0] <= right[0])
				{
					result[count++] = left[0];
					left = Arrays.copyOfRange(left, 1, left.length );
				}
				else
				{
					result[count++] = right[0];
					right = Arrays.copyOfRange(right, 1, right.length );
				}
			}
			else if (left.length > 0)
			{
				result[count++] = left[0];
				left = Arrays.copyOfRange(left, 1, left.length);
			}
			else if (right.length > 0)
			{
				result[count++] = right[0];
				right = Arrays.copyOfRange(right, 1, right.length );
			}
		}
		return result;
	}
	
	public int[] merge_sort(int[] arr)
	{
		if (arr.length <= 1)
		{
			return arr;
		} 
		
		int[] left = Arrays.copyOfRange(arr, 0, arr.length/2);
		int[] right = Arrays.copyOfRange(arr, arr.length/2, arr.length);
		
		left = merge_sort(left);
		right = merge_sort(right);
		
		return merge(left, right);
		
	}
	
	public void print(int[] arr)
	{
		for (int x = 0; x < arr.length; x++)
		{
			System.out.print(arr[x] + ", ");
		}
	}
	
	
	
}
