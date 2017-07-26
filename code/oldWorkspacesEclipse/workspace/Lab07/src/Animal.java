public class Animal {
  
  // field instances
  
  private double mass;
  
  private String name;
  
  private int legs;
  
  
  
  public Animal(String newName) { 
  
  mass = 0;
  
  legs = 0;
  
  name = newName;
  
  }
  
  // constructors
  
  public Animal(double newMass, int newLegs, String newName) {
  
  mass = newMass;
  
  legs = newLegs;
  
  name = newName;
 
  }
  
  // methods
  
  public void setMass(double newMass) {
      
      mass = newMass;
  }
  
  public double getMass() {
  
      return mass;
   
  }
  
   
 public int getLegs() {
      
      return legs; 
  
  }
  
  public String getName() {
  
      return name;
 }
  
  public String toString() {
  
    return "Animal mass = " + mass + " name= " +name+ " legs=" + legs + ".";
      
  }

 
 }
