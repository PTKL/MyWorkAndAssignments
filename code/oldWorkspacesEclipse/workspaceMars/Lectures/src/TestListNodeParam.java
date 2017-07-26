class ListParam<T> {
	public T payload;
	public ListParam<T> next;

	public T getPayload() {
		return this.payload;
	}
	
	public static <T extends TestAnimal> void soundFirst(ListParam<T> n) {
		n.payload.sound();
		}

	public ListParam(T o) {
		payload = o;
		next = null;
	}

	public static <T> T getFirst(ListParam<T> list) {
		return list.payload;
	}

	public static class TestListNodeParam {
		public static void main(String[] args) {
			ListParam<String> n = new ListParam<String>("Hello");
			// n.next = new ListParam<String>(new Integer(5));
			// would give a compiler error
			n.next = new ListParam<String>("World");
			String s = n.payload; // No cast required
			System.out.println(s);
		}
	}
}
