import java.util.ArrayList;
import java.util.Scanner;


public class Reverse {
  
  public static ArrayList<String> rev = new ArrayList<String>();
  public static int count = 0;
  public static boolean isQ = false;
  public static String rd;
  public static void main(String[] args){
        
    System.out.println("Give me a line");
    Scanner sc = new Scanner(System.in);
        
    //if (!rd.toLowerCase().startsWith(check, 0))
    //if (rd.charAt(0)!='q')
    do
    {
      rd = sc.next();
      if (rd.charAt(0)!='q')
      {
        rev.add(rd);
        count++;
        System.out.println("Give me a line");
      }
      else
      {
        System.out.println("Letter \"q\" detected.");
        isQ = true;
      }
    }
    while (!isQ);
    if (count!=0)
    {
      
      for (int i = count-1; i>=0; i--)
      {
        
        System.out.print(rev.get(i)+" ");
      }
      
    }
   sc.close(); 
  }
}
