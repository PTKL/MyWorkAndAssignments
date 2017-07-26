import java.util.ArrayList;
import java.util.Random;


public class TestGenericSort {
  public static void main(String[] args)
  {
    ArrayList<Integer> arr = new ArrayList<Integer>();
      Random rnd = new Random();
      for (int i=0; i<5; i++)
      {
        arr.add(i, rnd.nextInt(20));
      }
      
      for (int v : arr)
      {
        System.out.println(v);
      }
      
      System.out.println();
      GenericBubbleSort.genericBubbleSort(arr);
      for (int v : arr)
      {
        System.out.println(v);
      }
  }
}
