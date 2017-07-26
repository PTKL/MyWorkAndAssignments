public class ListTest {
	public static void main(String[] args) {
		IntListNode temp = new IntListNode(1);
		IntListNode head = temp;
		temp.next = new IntListNode(2);
		temp = temp.next;
		temp.next = new IntListNode(3);
	}
}

class IntListNode {
	int payload;
	IntListNode next;

	// Constructor
	public IntListNode(int n) {
		payload = n;
		next = null;
	}

	// Instance method of IntListNode
	public void print() {
		System.out.print(payload);
		if (next == null)
			return;
		System.out.print(" -> ");
		next.print();
	}
}