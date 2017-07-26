import java.util.Scanner;

public class TreeNode {

	private Scanner kbd = new Scanner(System.in);
	public Object value;
	private TreeNode leftChild;
	private TreeNode rightChild;

	public TreeNode(Object value, TreeNode leftChild, TreeNode rightChild) {
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public TreeNode(Object value) {
		this(value, null, null);
	}

	public Object getValue() {
		return value;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setLeftChild(TreeNode subtree) throws IllegalArgumentException {
		if (contains(subtree, this)) {
			throw new IllegalArgumentException("Subtree " + this
					+ " already contains " + subtree);
		}
		leftChild = subtree;
	}

	public void setRightChild(TreeNode subtree) throws IllegalArgumentException {
		if (contains(subtree, this)) {
			throw new IllegalArgumentException("Subtree " + this
					+ " already contains " + subtree);
		}
		rightChild = subtree;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public boolean isLeaf() {
		if (leftChild == null && rightChild == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof TreeNode)) {
			return false;
		}
		TreeNode otherTree = (TreeNode) o;
		return equals(value, otherTree.value)
				&& equals(leftChild, otherTree.getLeftChild())
				&& equals(rightChild, otherTree.getRightChild());
	}

	private boolean equals(Object x, Object y) {
		if (x == null) {
			return y == null;
		}
		return x.equals(y);
	}

	protected boolean contains(TreeNode tree, TreeNode targetNode) {
		if (tree == null)
			return false;
		if (tree == targetNode)
			return true;
		return contains(targetNode, tree.getLeftChild())
				|| contains(targetNode, tree.getRightChild());
	}

	public String toString() {
		if (isLeaf()) {
			return value.toString();
		} else {
			String root, left = "null", right = "null";
			root = value.toString();
			if (getLeftChild() != null) {
				left = getLeftChild().toString();
			}
			if (getRightChild() != null) {
				right = getRightChild().toString();
			}
			return root + " (" + left + ", " + right + ")";
		}
	}

	public int hashCode() {
		int result = value.hashCode();
		if (leftChild != null) {
			result += 3 * leftChild.hashCode();
		}
		if (rightChild != null) {
			result += 7 * leftChild.hashCode();
		}
		return result;
	}

	public void print() {
		print(this, 0);
	}

	private void print(TreeNode root, int indent) {
		for (int i = 0; i < indent; i++) {
			System.out.print("   ");
		}
		if (root == null) {
			System.out.println("null");
			return;
		}
		System.out.println(root.value);
		if (root.isLeaf())
			return;
		print(root.leftChild, indent + 1);
		print(root.rightChild, indent + 1);
	}

	public void question() {
		if (this.isLeaf()) {
			System.out.println(this.value);
			System.out.print("Enter 'y' for yes and 'n' for no: ");
			char input = kbd.next().charAt(0); // y or n
			if (input == 'y') {
				leftChild.question();

			} else {
				rightChild.question();
			}
		} else {
			this.checkGuess();
		}
	}

	public void checkGuess() {
		System.out.println("Are you thinking of " + this.value + "?");
		System.out.print("Enter 'y' for yes and 'n' for no: ");
		char input = kbd.next().charAt(0); // y or n
		if (input == 'y') {
			System.out.print("The Computer Wins\n");

		} else {
			updateTree();
		}
	}

	private void updateTree() {
		System.out.print("You win! What were you thinking of?");
		String userObject = kbd.nextLine();
		System.out.print("Please enter a question to distinguish " + this.value
				+ " from " + userObject + ": ");
		String userQuestion = kbd.nextLine();
		System.out.print("If you were thinking of" + userObject
				+ ", what would the answer to that question be?");
		char input = kbd.next().charAt(0); // y or n
		if (input == 'y') {
			this.leftChild = new TreeNode(this.value);
			this.rightChild = new TreeNode(userObject);
		} else {
			this.leftChild = new TreeNode(this.value);
			this.rightChild = new TreeNode(userObject);
		}
		System.out.print("Thank you my knowledge has been increased");
		this.setValue(userQuestion);
	}

}