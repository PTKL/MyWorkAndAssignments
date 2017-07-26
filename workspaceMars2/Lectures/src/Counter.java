public class Counter {
	private int value;

	public Counter() {
		value = 0;
	}

	public void increment() {
		value = value + 1;
	}

	public int getCounter() {
		return value;
	}
}
