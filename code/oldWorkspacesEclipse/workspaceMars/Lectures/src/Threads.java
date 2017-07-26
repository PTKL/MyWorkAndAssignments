public class Threads {

	public static void main(String[] args) {
		// Anonymous class definition
		Thread myThread = new Thread(new Runnable() {
			// run() is the thread's "main" method and called by start()
			@Override
			public void run() {
				try {
					for (int i = 0; i < 5; i++) {
						System.out.println("Hello " + i);
						Thread.sleep(1000); // Wait for 1 second
					}
				} catch (InterruptedException e) {
					// Thrown by Thread.sleep when it's interrupted
				}
			}
		});

		// This starts the thread
		myThread.start();
		System.out.println("New thread runs in parallel!");
	}

}
