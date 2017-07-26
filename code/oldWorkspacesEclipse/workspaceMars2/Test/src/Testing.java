public class Testing {
  public static class A { // Now accepts a Visitor
    public void accept(Caller1 caller) {
      caller.call(this);
    }
  }
  public static class B extends A { // Now accepts a Visitor
    public void accept(Caller1 caller) {
      caller.call(this);
    }
  }
  public static class Caller1 { // Operates as a Visitor
    public void call(A a) {
      System.out.println("Calling with A");
    }

    public void call(B b) {
      System.out.println("Calling with B");
    }
  }

  public static void main(String args[]) {
    A a = new A();
    B b = new B();
    A bAsA = b;
    Caller1 c = new Caller1();
    System.out.println("Double Dispatch");
    a.accept(c);
    b.accept(c);
    bAsA.accept(c);
  }
}
