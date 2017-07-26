import java.util.ArrayList;


public class GenericBubbleSort {
  public static <E extends Comparable<E>> void genericBubbleSort(ArrayList<E> a)
  {
    boolean swapped = true;
    
    do
    {
      swapped = false;
      for (int i=0; i<a.size(); i++)
      {
        
        for (int j=i+1; j<a.size(); j++)
        {
          if (a.get(i).compareTo(a.get(j)) > 0)
          {
            E temp = a.get(i);
            a.set(i, a.get(j));
            a.set(j, temp);
            swapped = true;
          }
        }
      }
    }
    while (swapped);
  }
}
