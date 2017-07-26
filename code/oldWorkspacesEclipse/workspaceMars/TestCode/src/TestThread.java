import java.util.ArrayList;
import java.util.List;


public class TestThread {
  public static void main(String[] args) throws InterruptedException{
    int num = Integer.parseInt(args.toString());
    List<Thread> l = new ArrayList<Thread>();
    for (int i=0; i<num; i++){
      l.add(new Thread(new MyThread("t"+i)));
    }
    
    for (Thread t : l)
    {
      t.start();
    }
    
//    Thread t1 = new Thread(new MyThread("t1"));
//    Thread t2 = new Thread(new MyThread("t2"));
//    Thread t3 = new Thread(new MyThread("t3"));
//    t1.start();
//    t2.start();
//    t3.start();
    
  }
}