import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable {

	protected LinkedBlockingQueue<String> blockingQueue;

	public Consumer(LinkedBlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = blockingQueue.take();
				System.out.println(Thread.currentThread().getName()
						+ " take(): " + data);
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}