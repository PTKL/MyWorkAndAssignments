
public class TestCocktailSort {
  public static void main(String[] args)
  {
      String[] arr = new String[5];
      arr[0] = "c";
      arr[1] = "e";
      arr[2] = "b";
      arr[3] = "d";
      arr[4] = "a";
      
      for (int i=0; i<5; i++)
      {
        System.out.println("[" + i + "] = " + arr[i]);
      }
      System.out.println();
      CocktailSort.cocktailSort(arr);
      for (int i=0; i<5; i++)
      {
       System.out.println("[" + i + "] = " + arr[i]);
      }
  }
}
