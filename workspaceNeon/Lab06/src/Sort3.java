import java.util.Scanner;

class Sort3
{
  public static int first( int a, int b, int c)
  {
    if (a > b && a > c) {
      return a;
    } else if (b > c)
    {
      return b;
    }
    return c;
  }
  
   public static int second( int a, int b, int c)
  {
    /*if (b > a && b > c) {
      if (a >c ) return a;
      else return c;
    } else if (a > c)
    {
      return a;
    }
      return c;*/
      if (a>b) {
	if (a>c) {
	    if (c>b) return c;
	    else return b;
	}
	return a;
      } else {
         if (a>c) return a;
         else {
           if (b>c) return c;
           else return b;
         }
      }
      //return a; // broken 
  }
  
   public static int third( int a, int b, int c){
    if (a < b && a < c) {
      return a;
    } else if (b < c)
    {
      return b;
    }
    return c;
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
    enterPrint("third");
    int c = s.nextInt();
    
    System.out.println( "max(" + a + ", " + b + ", "+c+ ") = " + first(a, b, c) );
    System.out.println( "middle(" + a + ", " + b + ", "+c+ ") = " + second(a, b, c) );
    System.out.println( "min(" + a + ", " + b + ", "+c+ ") = " + third(a, b, c) );
  }
}