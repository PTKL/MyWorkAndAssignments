import java.util.*;

class Tree {
	public TreeNode rootNode;

	public Tree() {
		rootNode = null;
	}

	public TreeNodes returnRoot() {
		return rootNode;
	}

	public boolean isEmpty() {
		return rootNode == null;
	}

	public void insert(String value) {
		if (isEmpty()) {
			rootNode = new TreeNode(value);
		} else {
			rootNode.add(value);
		}
	}

	public TreeNodes getRoot() {
		return rootNode;
	}

	public void preOrder() {
		preOrder(rootNode);
	}

	// using the function ...
	public void preOrder(TreeNodes rootNode) {
		if (rootNode != null) {
			System.out.println(rootNode.getWord()); // rootNode
			preOrder(rootNode.getLeft()); // left
			preOrder(rootNode.getRight()); // right
		}
	}
}

class TreeNode {

	private String word; // The data in this node.
	private TreeNodes left; // Pointer to the left subtree.
	private TreeNodes right; // Pointer to the right subtree.

	public TreeNode(String s) {
		word = s;
		left = null;
		right = null;
	}

	public void add(String value) {
		if (left == null) {
			left = new TreeNodes(value);
		} else if (right == null) {
			right = new TreeNodes(value);
		} else {
			if (countNodes(left) <= countNodes(right)) {
				left.add(value);
			} else {
				right.add(value);
			}
		}
	}

	// Count the nodes in the binary tree to which rootNode points, and
	public static int countNodes(TreeNodes rootNode) {
		if (rootNode == null) {
			// The tree is empty. It contains no nodes.
			return 0;
		} else {
			// Start by counting the rootNode.
			int count = 1;
			// Add the number of nodes in the left subtree.
			count += countNodes(rootNode.left);
			// Add the number of nodes in the right subtree.
			count += countNodes(rootNode.right);
			return count; // Return the total.
		}
	}

	public TreeNodes getLeft() {
		return left;
	}

	public TreeNodes getRight() {
		return right;
	}

	public String getWord() {
		return word;
	}

}

 class CelebrityGame {

	public static void main(String[] args) {

	}

}
