class SimplePower
{
  public static void main(String[] args)
  {
    double a = 2.5;
    int n = -2;

    // r is the result, i is the counter
    double r = 1;
    
    for(int i = 0; i < Math.abs(n); i++) {
    
      r = (n > 0) ? r*a : r/a;
      
    }

    System.out.println(r);
  }
}
