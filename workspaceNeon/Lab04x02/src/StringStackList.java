public class StringStackList {
	StringNode top;
	int count = -1;

	public StringStackList() {
		top = null;
	}

	public void push(String s) {
		StringNode n = new StringNode(s);
		n.next = top;
		top = n;
	}

	public String pop() throws Underflow {

		if (count < 0) {
			throw new Underflow(null);
		}
		String s = top.payload;
		count = count - 1;
		return s;

	}

	public boolean isEmpty() {

		if (count == 0) {

			return true;

		}

		return false;
	}

	public int size() throws Underflow {

		if (count < 0) {
			throw new Underflow(null);
		}
		
		return count + 1;

	}
	
	public String peek() {
        if (isEmpty()) throw new Underflow(null);
        return top.payload;
    }
}
