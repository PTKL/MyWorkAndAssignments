import java.util.Random;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {
	

	protected LinkedBlockingQueue<String> blockingQueue;
	final Random random = new Random();
	

	public Producer(LinkedBlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				int randomSleep = random.nextInt(4);
				String data = UUID.randomUUID().toString();
				System.out.println("Put: " + data);
				blockingQueue.put(data);
				Thread.sleep(randomSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}