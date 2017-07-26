
public class CocktailSort {
  static void cocktailSort(String[] arr)
  {  
  boolean swapped = true;
    do
    {
      swapped = false;
      for (int i = 1; i<arr.length; i++)
      {
        if (arr[i-1].compareToIgnoreCase(arr[i]) > 0)
        {
          String temp = arr[i-1];
          arr[i-1] = arr[i];
          arr[i] = temp;
          swapped = true;
        }
        if (arr[arr.length - i].compareToIgnoreCase(arr[arr.length - (i+1)]) < 0)
        {
          String temp = arr[arr.length - i];
          arr[arr.length - i] = arr[arr.length - (i+1)];
          arr[arr.length - (i+1)] = temp;
          swapped = true;
        }
      }
    } while (swapped);
  }
}
