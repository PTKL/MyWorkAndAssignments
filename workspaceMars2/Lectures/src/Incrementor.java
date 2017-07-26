public class Incrementor implements Runnable {

	private Counter counter;

	public Incrementor(Counter c) {
		this.counter = c;
	}

	public void run() {
		for (int i = 0; i < 1000; i++) {
			counter.increment();
		}
	}
}
