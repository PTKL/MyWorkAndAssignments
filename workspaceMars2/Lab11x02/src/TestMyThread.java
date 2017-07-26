public class TestMyThread {

	public static void main(String[] args) {
		Thread thread;
			
		for(int i = 1; i < 6; i++) {	
			thread = new Thread(new MyThread("thread" + i));
			thread.start();
		}

	}

}
