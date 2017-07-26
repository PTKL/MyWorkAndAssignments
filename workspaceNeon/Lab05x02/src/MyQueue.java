public class MyQueue<T> {

	public int size = 0;
	public MyNode<T> front = null;
	public MyNode<T> back = null;

	public void enqueue(T payload) {

		size++;
		if (back == null) {
			back = new MyNode<T>(payload);
			front = back;
			return;
		}

		back.previous = new MyNode<T>(payload);
		back.previous.next = back;
		back = back.previous;
	}

	public T dequeue() {

		T payload = front.payload;
		front = front.previous;
		size--;

		return payload;

	}

	public boolean isEmpty() {
		return front == null;
	}

	public int size() {
		return size;
	}

	public String toString() {
		MyNode<T> currentNode = front;
		String result = "";
		while (currentNode != null) {
			result += currentNode.getPayload() + "\n";
			currentNode = currentNode.previous;
		}

		return result;
	}

	public void remove(T payload) {
		MyNode<T> currentNode = front;
		if (front == null) {
			return;
		}
		while (currentNode != null) {
			if (currentNode.payload == payload) {
				size--;
				if (currentNode.previous != null) {
					
					currentNode.previous.next = currentNode.next;
				} else {
					back = back.next; // currentNode == back
				}

				if (currentNode.next != null) {
					currentNode.next.previous = currentNode.previous;
				} else {
					front = front.previous; // currentNode == front
				}

			}

			currentNode = currentNode.previous;

		}

	}

	public void insertAt(int i, T payload) {
		MyNode<T> currentNode = front;

		if (i >= size) {
			enqueue(payload);
		} else {
		for(int j = 0; j < i; j++){
			currentNode = currentNode.previous;
		}
		
		
		MyNode<T> newNode = new MyNode<T>(payload);
		newNode.next = currentNode.next;
		if(currentNode.next != null) {
		currentNode.next.previous = newNode;
		} else {
			front = newNode;
		}
		newNode.previous = currentNode;
		currentNode.next = newNode;
		}
	}
}
