class Parentheses {
  
  public static void main (String [] args) {
  
    int a, b, c, d;
    
    a = 3;
    b = 4;
    c = 5;
    d = 6;
    
    System.out.println(b-a*c+d);
    System.out.println(b-(a*c)+6);
    System.out.println((b-a)*c+d);
    System.out.println(b-(a*c+d));
    
  }

}