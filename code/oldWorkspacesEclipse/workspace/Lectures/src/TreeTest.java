public class TreeTest {
	public static void main(String[] args) {
		IntTreeNode temp = new IntTreeNode(1);
		IntTreeNode root = temp;
		temp.left = new IntTreeNode(2);
		temp.right = new IntTreeNode(3);
		temp = temp.left;
		temp.left = new IntTreeNode(4);
		temp.right = new IntTreeNode(5);
		temp = root.right;
		temp.left = new IntTreeNode(6);
		temp.right = new IntTreeNode(7);
	}
}

class IntTreeNode {

	// Instance method of IntTreeNode
	public void print() {
		System.out.println(node);
		if (left != null) {
			left.print();
		}
		if (right != null) {
			right.print();
		}
	}

	int node;
	IntTreeNode left;
	IntTreeNode right;

	IntTreeNode(int n) {
		node = n;
		left = null;
		right = null;
	}
}
