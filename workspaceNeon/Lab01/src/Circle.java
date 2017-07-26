class Circle {

  public static void main (String [] args) {
  // C - circumference, r - radius
    double C, r, A;
    
    r = Math.random()*10;
    
    C = 2*Math.PI*r;
    
    A = Math.PI*Math.pow(r, 2);
      
    System.out.println("the circumference is " + C);
    System.out.println("the area is " + A);

  }
  
}