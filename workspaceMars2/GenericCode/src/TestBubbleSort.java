import java.util.Random;


public class TestBubbleSort {
  public static void main(String[] args)
  {
      int[] arr = new int[5];
      Random rnd = new Random();
      for (int i=0; i<5; i++)
      {
        arr[i] = rnd.nextInt(20);
        System.out.println("[" + i + "] = " + arr[i]);
      }
      System.out.println();
      BubbleSort.bubbleSort(arr);
      for (int i=0; i<5; i++)
      {
       System.out.println("[" + i + "] = " + arr[i]);
      }
  }
}
