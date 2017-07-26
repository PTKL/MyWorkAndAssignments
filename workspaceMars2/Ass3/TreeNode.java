public class TreeNode {
	private Node root;

	/**
	 * Creates an empty binary tree -- a null root pointer.
	 */
	public void BinaryTree() {
		root = null;
	}
	
	public void buildA() { 
		  root = new Node(2); 
		  Node left = new Node(1); 
		  Node right = new Node(3);
		  root.left = left; 
		  root.right= right; 
		}

	/**
	 * Returns true if the given target is in the binary tree. Uses a recursive
	 * helper.
	 */
	public boolean lookup(int data) {
		return (lookup(root, data));
	}

	/**
	 * Recursive lookup -- given a node, recur down searching for the given
	 * data.
	 */
	private boolean lookup(Node node, int data) {
		if (node == null) {
			return (false);
		}

		if (data == node.data) {
			return (true);
		} else if (data < node.data) {
			return (lookup(node.left, data));
		} else {
			return (lookup(node.right, data));
		}
	}

	/**
	 * Inserts the given data into the binary tree. Uses a recursive helper.
	 */
	public void insert(int data) {
		root = insert(root, data);
	}

	/**
	 * Recursive insert -- given a node pointer, recur down and insert the given
	 * data into the tree. Returns the new node pointer (the standard way to
	 * communicate a changed pointer back to the caller).
	 */
	private Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}

		return (node); // in any case, return the new pointer to the caller
	}

	/**
	 * returns the size of the tree.
	 * @return
	 */
	public int size() {
		return (size(root));
	}

	private int size(Node node) {
		if (node == null)
			return (0);
		else {
			return (size(node.left) + 1 + size(node.right));
		}
	}

	/**
	 * Will print the nodes in the correct order.
	 */
	public void printTree() {
		printTree(root);
		System.out.println();
	}

	private void printTree(Node node) {
		if (node == null)
			return;

		// left, node itself, right
		printTree(node.left);
		System.out.print(node.data + "  ");
		printTree(node.right);
	}

	/**
	 * Prints the node values in the "postorder" order. Uses a recursive helper
	 * to do the traversal.
	 */
	public void printPostorder() {
		printPostorder(root);
		System.out.println();
	}

	public void printPostorder(Node node) {
		if (node == null)
			return;

		// first recur on both subtrees
		printPostorder(node.left);
		printPostorder(node.right);

		// then deal with the node
		System.out.print(node.data + "  ");
	}
}

/**
 * 
 * public void query() { if (this.isLeaf()) { System.out.println(this.value);
 * System.out.print("Enter 'y' for yes and 'n' for no: "); char input =
 * kbd.next().charAt(0); // y or n if (input == 'y') leftChild.query(); else
 * rightChild.query(); } else this.onQueryObject(); }
 * 
 * public void onQueryObject() { System.out.println("Are you thinking of a(n) "
 * + this.value + "?"); System.out.print("Enter 'y' for yes and 'n' for no: ");
 * char input = kbd.next().charAt(0); // y or n if (input == 'y')
 * System.out.print("The Computer Wins\n"); else updateTree(); }
 * 
 * private void updateTree() {
 * System.out.print("You win! What were you thinking of?"); String userObject =
 * kbd.nextLine();
 * System.out.print("Please enter a question to distinguish a(n) " + this.value
 * + " from " + userObject + ": "); String userQuestion = kbd.nextLine();
 * System.out.print("If you were thinking of a(n) " + userObject +
 * ", what would the answer to that question be?"); char input =
 * kbd.next().charAt(0); // y or n if (input == 'y') { this.left = new
 * TreeNode(this.value); this.right = new TreeNode(userObject); } else {
 * this.leftChild = new TreeNode(this.value); this.rightChild = new
 * TreeNode(userObject); }
 * System.out.print("Thank you my knowledge has been increased");
 * this.setValue(userQuestion); } }
 */
