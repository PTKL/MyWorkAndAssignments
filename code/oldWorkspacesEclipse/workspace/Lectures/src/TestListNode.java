class ListNode {

	public Object payload;
	public ListNode next;

	public ListNode(Object o) {
		payload = o;
		next = null;
	}

}

public class TestListNode {
	public static void main(String[] args) {
		ListNode n = new ListNode("Hello");
		n.next = new ListNode("World");
		String s = (String) n.payload; // ClassCastException
		System.out.println(s);
	}
}
