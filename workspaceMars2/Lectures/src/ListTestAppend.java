public class ListTestAppend {
	public static void main(String[] args) {
		IntListNodeAppend head = new IntListNodeAppend(1);
		head.append(2);
		// Can use call to append now instead
		head.append(3);
		// of creating and linking nodes manually
	}
}

class IntListNodeAppend {
	int payload;
	IntListNodeAppend next;

	IntListNodeAppend(int n) {
		payload = n;
		next = null;
	}

	void append(int n) {
		if (next == null) {
			// If there is no next node
			next = new IntListNodeAppend(n); // link the new one here
		} else {
			next.append(n);
			// Else, append to next node
		}
	}
}
