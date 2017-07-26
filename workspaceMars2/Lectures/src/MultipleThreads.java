public class MultipleThreads {

	public static void main(String[] args) {
		Thread threadA = new Thread(new BusyPrinter("Thread A", 250));
		threadA.start();
		Thread threadB = new Thread(new BusyPrinter("Thread B", 400));
		threadB.start();
		Thread threadC = new Thread(new BusyPrinter("Thread C", 800));
		threadC.start();
		System.out.println("main method finished.");
	}

}
