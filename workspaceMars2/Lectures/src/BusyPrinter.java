public class BusyPrinter implements Runnable {
	private final String name;
	private final long delay;

	public BusyPrinter(String name, long delay) {
		this.name = name;
		this.delay = delay;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hello " + i + " from " + name);
				Thread.sleep(delay);
			}
		} catch (InterruptedException e) {
		}
	}
}
