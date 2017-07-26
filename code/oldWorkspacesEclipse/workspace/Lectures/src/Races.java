public class Races {
	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread[] threads = new Thread[20];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Incrementor(counter));
			threads[i].start();
		}
		try {
			for (Thread t : threads)
				// Wait for all threads to complete
				t.join();
		} catch (InterruptedException e) {
		}
		System.out.println("Counter should be " + (threads.length * 1000));
		System.out.println("Counter is now " + counter.getCounter());
	}
}
