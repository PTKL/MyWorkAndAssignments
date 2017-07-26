class StringQueue {
	String[] arr;
	int front, back;

	public StringQueue() {
		arr = new String[10];
		front = 0;
		back = 0;
	}

	public void enqueue(String s) {
		arr[back] = s;
		back = back + 1;
		if (back == arr.length) { // if queue back grows past
			back = 0;
			// end of array, wrap around
		}
	}

	public String dequeue() {
		String s = arr[front];
		front = front + 1;
		if (front == arr.length) { // if queue front grows past
			front = 0;
			// end of array, wrap around
		}
		return s;
	}
}