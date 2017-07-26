import java.util.ArrayList;
import java.util.LinkedList;


public class MyList {
  static LinkedList<Integer> list1 = new LinkedList<Integer>();
  static LinkedList<Integer> list2 = new LinkedList<Integer>();
  
  
  public static void main(String[] args)
  {
    list1.add(2);
    list1.add(3);
    list1.add(4);
    list1.add(8);
    list2.add(1);
    list2.add(4);
    list2.add(7);
    
    for (int j = 0; j<list1.size(); j++)
    {
      System.out.println(list1.get(j));
    }
    System.out.println();
    
    for (int j = 0; j<list2.size(); j++)
    {
      System.out.println(list2.get(j));
    }
    System.out.println();
    
    merge(list1, list2);
    
    for (int j = 0; j<list1.size(); j++)
    {
      System.out.println(list1.get(j));
    }
    System.out.println();
    
  }
  
  public static double getAvg(LinkedList<Double> list)
  {
    double avg = 0;

    for (int j = 0; j<list.size(); j++)
    {
      avg = avg +list.get(j);
    }
    return avg/list.size();
  }
  
  public static boolean isAsc(LinkedList<Integer> list)
  {
    boolean asc = false;
    int maxN = list.size()-1;
    int i = list.size()-1;
    for (int j = 0; j<list.size(); j++)
    {
      while (i >= j)
      {
        if (!(list.get(i) <= list.get(maxN)))
        {
          asc = false;
        }
        else
        {
          asc = true;
        }
        i--;
      }
    }
    return asc;
  }
  
  public static void merge (LinkedList<Integer> list1, LinkedList<Integer> list2)
  {
    for (int i = 0; i<list2.size(); i++)
    {
      list1.add(list2.get(i));
    }
    
    for (int i = 0; i<list1.size(); i++)
    {
      int min = min(list1,i);
      int temp = list1.get(i);
      list1.set(i, list1.get(min));
      list1.set(min,  temp);
    }
      
  
  }

  public static int min (LinkedList<Integer> list12, int start)
  {
    int min = list12.size()-1;
    int i = list12.size()-1;
    
    while (i >= start)
    {
      if (list12.get(i) < list12.get(min))
      {
        min = i;
      }
      i--;
    }
    return min;
}
}
