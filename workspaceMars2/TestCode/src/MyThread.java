
public class MyThread implements Runnable {
  String name;
  MyThread(String s){
    name = s;
  }
  
  public void run(){
    try{
      while(true){
        System.out.println("Hello, I am " + getName());
        Thread.sleep(1000);
      }
    }catch(InterruptedException e){}
  }

  private String getName() {
    // TODO Auto-generated method stub
    return name;
  }
}