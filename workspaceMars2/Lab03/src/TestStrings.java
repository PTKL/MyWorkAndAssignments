import java.util.Scanner;

  class TestStrings {
  
    public static void main(String [] args) {
    
    Scanner kbd = new Scanner(System.in);
    
    String a, b;
    
    System.out.println("Imput first string: ");
    
    a = kbd.nextLine();
    
    System.out.println("Imput second string: ");
    
    b = kbd.nextLine();
    
    if(a.equals(b)) {
    
    System.out.println("The strings are equal");
    
    }
    
    else {
    
    System.out.println("The strings are different");
    
    }
    
    }
  
  }