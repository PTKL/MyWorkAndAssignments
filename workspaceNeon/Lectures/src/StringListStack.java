public class StringListStack {

	StringNode top;

	public StringListStack() {
		top = null;
	}

	public void push(String s) {
		StringNode n = new StringNode(s);
		n.next = top; // Make new node link to old top
		top = n;
		// New node is now on top
	}

	public String pop() {
		String s = top.payload; // Read payload from top
		top = top.next; // Second node is now on top
		return s;
	}

}
