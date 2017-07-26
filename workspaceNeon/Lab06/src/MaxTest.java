import java.util.Scanner;

class MaxTest
{
  public static boolean max( int a, int b, int c)
  {
    if (a<b)
    {
      return true;
    }
    /*else if (a<c)
    {
      return c;
    }*/
    else
    {
      return false;
    }
  }
   
  public static void main(String[] args)
  {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter the first integer: ");
    int a = s.nextInt(); 
    System.out.print("Enter the second integer: ");
    int b = s.nextInt(); 
    System.out.print("Enter the third integer: ");
    int c = s.nextInt();
    
    System.out.println( "max(" + a + ", " + b + ", "+c+ ") = " + max(a, b, c) );
  }
}