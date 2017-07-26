import java.util.Scanner;

class MaxIntsClean
{
  public static double max( int m, int n)
  {
    if (m<n)
    {
      return n;
    }
    else
    {
      return m;
    }
  }
  
  public static void enterPrint (String text)
  {
  
    System.out.print("Enter the " + text + " integer: " ) ;
  
  }
   
  public static void main(String[] args)
  {
    Scanner s = new Scanner(System.in);
    enterPrint("first");
    int a = s.nextInt(); 
    enterPrint("second");
    int b = s.nextInt(); 
    
    System.out.println( "max(" + a + ", " + b + ") = " + max(a, b) );
  }
}