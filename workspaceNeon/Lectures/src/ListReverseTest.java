public class ListReverseTest {

	private static class ListNode {
		int v;
		ListNode next;

		public ListNode(int v, ListNode next) {
			this.v = v;
			this.next = next;
		}

		public ListNode reverse() {
			if (next == null) {
				// Base case: this is the only node
				// [ this ] -> null
				// A single node list is identical to its reverse. The head node
				// of
				// the reverse list is just this node.
				return this;
			} else {
				// General case: there is a chain of nodes after this
				// [ this ] -> [ n1 ] -> [ n2 ] -> ... -> [ nlast-1 ] -> [ nlast
				// ] -> null
				// Recursive call: reverse the tail of the list

				ListNode newHead = next.reverse();

				// Now the tail of the list is reversed, and newHead = [ nlast ]
				// Starting from [ nlast ], the list looks like this:
				// [ nlast ] -> [ nlast-1 ] -> ... -> [ n2 ] -> [ n1 ] -> null
				//
				// [ this ] will have to go behind [ n1 ] and become the new
				// last
				// node of the list starting at [ nlast ]. How do we get to [ n1
				// ]?
				// We haven't done anything to [ this ] so far, so the
				// next-reference from [ this ] still points to [ n1 ]!

				ListNode n1 = this.next;

				// Now we can simply link [ n1 ] -> [ this ]:

				n1.next = this;

				// What remains to be done is to make this node the last node of
				// the
				// list. Its next-reference currently still points to n1.

				this.next = null;

				// Now the list starting from [ nlast ] looks like this:
				// [ nlast ] -> [ nlast-1 ] -> ... -> [ n2 ] -> [ n1 ] -> [ this
				// ] -> null
				// This is the result we wanted, so we return the new head [
				// nlast ] of this list

				return newHead;
			}
		}

		// Recursive print method for printing the list starting from this node
		public void print() {
			System.out.print("[ " + v + " ] -> ");
			if (next == null) {
				System.out.println("null");
			} else {
				next.print();
			}
		}

	} // End of private static class ListNode

	public static void main(String[] args) {

		// Build the list by nesting constructor calls
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));

		// Print the list
		System.out.println("Initial list: ");
		head.print();

		// Reverse the list and print it starting from the new head
		ListNode newHead = head.reverse();
		System.out.println("Reversed list: ");
		newHead.print();

		// The old reference "head" hasn't changed. It still points to the same
		// ListNode, which is now at the end of the list. We can also print it:
		System.out.println("The old head of the list is now at the end:");
		head.print();
	}
}