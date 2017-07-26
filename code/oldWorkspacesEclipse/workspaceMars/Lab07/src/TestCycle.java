import java.util.Scanner;

public class TestCycle {
   public static void main(String[] args) {
      // Creation of a Bicycle object in variable myBike
      Bicycle myBike = new Bicycle();
      Scanner kbd = new Scanner (System.in);
      System.out.println("Enter Speed: ");
      int speed = kbd.nextInt();
      
      myBike.Bicycle(speed);
      if (speed <= 0) {
      
      System.out.println("My speed is now " + myBike.stop());
      
      }
      
      else {
      // Method calls
      myBike.speedUp(0);
      // I am late to the lab
      myBike.speedUp(0);
      // Red light!
      myBike.applyBrake(0);
      System.out.println("My speed is now " + myBike.getSpeed());
      
      }
      
      System.out.println("My price is now " + myBike.getPrice());
      System.out.println("My price is now(age) " + myBike.age());
      System.out.println("My price is now(repaint) " + myBike.repaint());
      myBike.print();
      System.out.println("I have crashed. My speed and price are now " + myBike.crash());
      myBike.print();
   }
}
