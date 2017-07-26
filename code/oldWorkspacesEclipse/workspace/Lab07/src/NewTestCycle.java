import java.util.Scanner;

public class NewTestCycle {
   public static void main(String[] args) {
      //Creation of a Bicycle object in variable myBike
      Bicycle myBike = new Bicycle();
      Scanner kbd = new Scanner (System.in);
      System.out.println("Enter Speed: ");
      int speed = kbd.nextInt();
      
      System.out.println("My speed is now " + myBike.getSpeed());
      System.out.println("My price is now " + myBike.getPrice());
      myBike.print();
      
      System.out.println();
      
     for(int count = 0; count <= 10; count++) {
     
	myBike.age();
     
     }
     
     System.out.println("My speed is now " + myBike.getSpeed());
     System.out.println("My price is now " + myBike.getPrice());
     System.out.println("My price is now(age) " + myBike.age());
     myBike.print();
     System.out.println();
     myBike.speedUp(20);
     System.out.println("My speed is now " + myBike.getSpeed());
     System.out.println("My price is now(repaint) " + myBike.repaint());
     myBike.print();
     System.out.println();
     System.out.println("I have crashed. My speed and price are now " + myBike.crash());
     myBike.print();
   }
}
