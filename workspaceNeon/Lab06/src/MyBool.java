import java.util.Scanner;

class MyBool {

  public static boolean not(boolean b) {
    
    if (b == true) {
    
      return false;
    
    }
    
    else {
    
      return true;
    
    }

  }

  public static boolean and(boolean b, boolean c) {

    if (b == c) {
      
      return true;
    
    }
    
    else {
    
      return false;
    
    }

  }

  public static boolean or(boolean b, boolean c) {
  
    if (b == true) {
    
      if (c == true) {
      
      return true;
      
      }
      
    }
          
      return false;
  
  }
  
   public static void main(String[] args) {
   
   Scanner s = new Scanner(System.in);
   
   boolean b;
   boolean c;
   
   System.out.println("Enter a boolean value for b: ");
   b = s.nextBoolean();
   System.out.println("Enter a boolean value for c: ");
   c = s.nextBoolean();
   System.out.println("not is " + b + "=" + not(b));
   System.out.println("and is " + b + ", " + c + "=" + and(b, c));
   System.out.println("or is " + b + ", " + c + "=" + or(b, c));
   
   }
  
}