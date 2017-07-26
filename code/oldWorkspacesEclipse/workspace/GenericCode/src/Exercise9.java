public class Exercise9 {
  public static void main(String[] args) {
    try {
      wrongMethod();
      System.out.print("A");
    }
    catch (Exception ex) {
      System.out.print("B");
    }
    finally {
      System.out.print("C");
    }
    System.out.print("D");
  }
  
  public static void wrongMethod() {
    throw new Error();
  }
}