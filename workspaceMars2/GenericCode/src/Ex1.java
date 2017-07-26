
public class Ex1 {
  public static void main(String[] args){
    try {
      while (true){
        System.out.println("Hello");
        Thread.sleep(1000);
        System.out.println("World");
        Thread.sleep(1700);
        System.out.println("!");
        Thread.sleep(700);
      }
    }catch (InterruptedException iex){}
  }
}
