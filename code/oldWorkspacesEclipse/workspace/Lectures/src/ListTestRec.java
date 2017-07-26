public class ListTestRec {
	public static void main(String[] args) {
		ListNodeRec n = new ListNodeRec(3, new ListNodeRec(2, new ListNodeRec(
				1, null)));
	}
}

class ListNodeRec {
	int v;
	ListNodeRec next;

	public ListNodeRec(int v, ListNodeRec next) {
		this.v = v;
		this.next = next;
		
		public ListNodeRec last() {
			 if (next == null) {
			 return this;
			 } else {
			 return next.last();
			 }
		} 
	}
}
