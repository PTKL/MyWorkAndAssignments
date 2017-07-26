import java.util.Scanner;

  class TestRing {
  
    public static void main(String [] args) {
    
    Scanner kbd = new Scanner(System.in);
    

    
    String a = "Frodo", b = "trash";
        
    System.out.println("Imput a sting for b : ");
    
    b = kbd.nextLine();
    
    while(b.equals(a)) {
    
    System.out.println("You have found the Ring!");
    
    break;
    
    }
    
    }
    
}
