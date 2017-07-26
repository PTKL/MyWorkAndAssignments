public class Test {
  public static class A {
    public void fred() {
      System.out.println("I am an A");
    }
  }
  public static class B extends A {
    public void fred() {
      System.out.println("I am a B");
    }
  }
  public static class Caller1 {
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
    c.call(a);
    c.call(b);
    c.call(bAsA);
    bAsA.fred();
  }
}
