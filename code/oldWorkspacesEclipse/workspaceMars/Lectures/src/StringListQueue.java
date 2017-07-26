public class StringListQueue {
	StringNode back;
	StringNode front;

	public StringListQueue() {
		back = null;
		front = null;
	}

	public void enqueue(String s) {
		StringNode n = new StringNode(s);
		n.next = back; // Make new node link to old back
		if (back != null) { // If the queue wasn't empty
			back.prev = n; // tell the old back what's behind it
		}
		back = n; // New node is now at the back
	}

	public String dequeue() {
		String s = front.payload; // Read payload from front
		front = front.prev;		// Second node is now at front
		front.next = null;		// Delete reference to old front
		return s;
	}
}
