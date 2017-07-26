class StringNode {

	StringNode next;
	StringNode prev;
	String payload;

	public StringNode(String s) {
		payload = s;
		next = null;
		prev = null;
	}

}
