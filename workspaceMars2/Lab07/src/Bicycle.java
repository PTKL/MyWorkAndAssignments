public class Bicycle {
   // the Bicycle class has several fields
   private int speed;
   private double price;
   private double t;
        
   // the Bicycle class has several constructors
   public Bicycle() {
       speed = 10;
       price = 1000;
       t = price;
   }   
   
    public void Bicycle(int startspeed) 
    {
	if (startspeed <= 0) {
	
	  if ( this.isNegative() ) speed = 0;
	  
	}
	else {
	
	  speed = startspeed;
	
	}
	
	
    
    }
   
   // the Bicycle class has several methods       
   public void applyBrake(int decrement) {
       speed -= decrement;
       
       if ( this.isNegative() ) speed = 0;
   }
       
   public void speedUp(int increment) {
       speed += increment;
   }
   
   public void setPrice(int increment) {
       speed += increment;
   }
   
   public int stop()
   
   {
   
      speed = 0;
      
      return speed;
   
   }
   
   public int adjustSpeed()
   
   {
   
      if (speed < 0) {
	speed = stop();
	
      }
      
      return speed;
   
   }

   public int getSpeed() {
       return speed;
   }
   
   public boolean isNegative()
  {
    return ( speed<0 );
  }
  
  public double getPrice() {
  
    return price;
  
  }
  
  public double age(){
  
   price = (t/100)*10;
   
   return price;
  
  }
  
  public double repaint(){
  
    price = ((t/100)*10) + price;
   
   return price;
  
  }
  
  public double crash() {
  
    stop();
    price = 0.0;
    
    return price;
    
  
  }
  
  public String toString() {
      
    return "cycle(price="+price+", speed="+speed+")";
  
  }
  public void print() {
  
    System.out.println(toString());
  
  }
    
}
