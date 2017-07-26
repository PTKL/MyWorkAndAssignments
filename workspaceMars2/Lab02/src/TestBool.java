class TestBool {

  public static void main (String [] args) {
  
  boolean a, b, c, d, e, f, g, h;
  
    a = 10 > 5;
    b = false | (5 != 4);
    c = 10 == 5;
    d = false & (5 != 4);
    e = 5 == 5;
    f = !(30 % 3 == 0);
    g = 5 == 11 - 6;
    h = 0.3 - 0.2 == 0.2 - 0.1;
    
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
    System.out.println(e);
    System.out.println(f);
    System.out.println(g);
    System.out.println(h);
  }
  
}