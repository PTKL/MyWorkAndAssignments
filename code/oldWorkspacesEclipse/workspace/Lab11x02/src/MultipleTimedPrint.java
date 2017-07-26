public class MultipleTimedPrint {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new TimedPrint("Hello", 700));
        Thread thread2 = new Thread(new TimedPrint("World", 1000));
        Thread thread3 = new Thread(new TimedPrint("!", 1300));

        thread1.start();
        thread2.start();
        thread3.start();
        
        System.out.println("All the threads are GO!");
    }
}