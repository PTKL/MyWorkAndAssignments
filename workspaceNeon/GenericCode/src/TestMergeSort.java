import java.util.Random;


public class TestMergeSort {
  public static void main(String[] args)
  {
    int[] arr = new int[20];
    Random rnd = new Random();
    for (int i=0; i<20; i++)
    {
      arr[i] = rnd.nextInt(20);
      System.out.println("[" + i + "] = " + arr[i]);
    }
    System.out.println();
    
    arr = MergeSort.mergeSort(arr);
    
    for (int i=0; i<20; i++)
    {
     System.out.println("[" + i + "] = " + arr[i]);
    }
    
  }
}
