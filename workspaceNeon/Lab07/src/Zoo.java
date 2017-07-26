public class Zoo {
  int i;
 



  private Animal [] park;
  
  public Zoo (){
	  
	  
    park=new Animal[10];
    
  }
  
  public boolean addAnimal(Animal animal) {

    for(i=0; i<park.length; i++) {
    
      if (park[i]==null) {
	  park[i] = animal;
      System.out.println("Zoo is not full!");
      return true;
   
      }
    }
      
      
      
      System.out.println("Zoo is full!");
       return false;
   
      
      
      
    }
		
		
	public int numberOfAnimals() {
	 int sum = 0;
	  for(i=0; i<park.length; i++) {
	    if (park[i]!=null) {
	    sum += 1;
	    }
	  }
	  return sum;
	}
	
	public double totalMass() {
	  int massTotal = 0;
	  for(i=0; i<park.length; i++) {
	    if (park[i]!=null) {
	    
	     massTotal += park[i].getMass();
	    
	    }
	    
	   }
	   
	   return massTotal;
	
	}
	
	public int numberOfLegs() {
	    int legsTotal = 0;
	   for(i=0; i<park.length; i++) {
	    if (park[i]!=null) {
	    
	     legsTotal += park[i].getLegs();
	    
	    }
	    
	   }
	   
	   return legsTotal;
	
	}
      
	
	
	public String toString() {
  
    String res = "The park has = ";
    for(i=0; i<park.length; i++) {
    
      if (park[i]!=null) {
	res += park[i].toString();
	  
  }
  
 }
    return res;
 
 }
  
  public void print() {
  
    System.out.println(toString());
  
  }

}
