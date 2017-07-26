import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {
	public static void main(String[] args) {
		final LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>();

		Producer queueProducer = new Producer(linkedBlockingQueue);
		new Thread(queueProducer).start();

		Producer queueProducer2 = new Producer(linkedBlockingQueue);
		new Thread(queueProducer2).start();

		Consumer queueConsumer = new Consumer(linkedBlockingQueue);
		new Thread(queueConsumer).start();

	}
}