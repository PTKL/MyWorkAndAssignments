import java.util.Scanner;

  class Signal {
  
    public static void main(String [] args) {
  
    Scanner keys = new Scanner(System.in);
    
    int n;
    
    System.out.println("Input int: ");
    n = keys.nextInt();
    
    if(n >= 0) {
      System.out.println("Positive!"); 
    
    }
    
    else {
      
      System.out.println("Negative");
      
    }

  }
  
}
    