import java.util.ArrayList;
import java.util.Random;


public class Algo {
  static ArrayList<Integer> list = new ArrayList<Integer>();
  static int linPos, binPos;
  public static void main(String[] args)
  {
    int n = 10;
    int max = 20;
    randomArray(n, max);

      for (int i = 0; i<list.size(); i++)
      {
        int min = min(list,i);
        int temp = list.get(i);
        list.set(i, list.get(min));
        list.set(min,  temp);
      }
    
      for (int i = 0; i<list.size(); i++)
      {
        System.out.println(list.get(i));
      }
      System.out.println();
      System.out.println(getMax(list));
      System.out.println();
      System.out.println(testSorted(list));
      System.out.println(linSearch(list, list.get(list.size()/2)));
      System.out.println(linPos);
      System.out.println(linSearch(list, 1000));
      System.out.println(binSearch(list, list.get(0), 0, list.size()-1));
      
  }
  
  public static void randomArray(int n , int max)
  {
    Random rnd= new Random();
     for (int i=0; i<n; i++)
     {
       list.add(rnd.nextInt(max));
     }
  }
  
  public static int min (ArrayList<Integer> list, int start)
  {
    int min = list.size()-1;
    int i = list.size()-1;
    
    while (i >= start)
    {
      if (list.get(i) < list.get(min))
      {
        min = i;
      }
      i--;
    }
    return min;
  }
  
  public static int getMax(ArrayList<Integer> list)
  {
    int maxN = list.size()-1;
    int i = list.size()-1;
    for (int j = 0; j<list.size(); j++)
    {
      while (i >= j)
      {
        if (list.get(i) > list.get(maxN))
        {
          maxN = i;
        }
        i--;
      }
    }
    return list.get(maxN);
  }
  
  public static boolean testSorted(ArrayList<Integer> list)
  {
    boolean sorted = false;
    int maxN = list.size()-1;
    int i = list.size()-1;
    for (int j = 0; j<list.size(); j++)
    {
      while (i >= j)
      {
        if (!(list.get(i) <= list.get(maxN)))
        {
          sorted = false;
        }
        else
        {
          sorted = true;
        }
        i--;
      }
    }
    if (!sorted)
    {
      for (int j = 0; j<list.size(); j++)
      {
        while (i >= j)
        {
          if (!(list.get(i) >= list.get(maxN)))
          {
            sorted = false;
          }
          else
          {
            sorted = true;
          }
          i--;
        }
      }
    }
    
    return sorted;
  }

  public static boolean linSearch(ArrayList<Integer> list, int term)
  {
    boolean exist = false;
    
    for (int j = 0; j<list.size(); j++)
    {
      if (list.get(j) == term)
      {
        exist = true;
        linPos = j;
      }
    }
    return exist;
  }

  public static boolean binSearch(ArrayList<Integer> list, int val, int start, int end)
  {
    if (start > end)
    {
      return false;
    }
    int middle = (start + end)/2;
    if (list.get(middle) == val)
    {
      binPos = middle;
      return true;
    }
    else if (val < list.get(middle))
    {
      return binSearch(list, val, start, middle-1);
    }
    else
    {
      return binSearch(list, val, middle+1, end);
    }
  }
}



