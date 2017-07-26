public class TreeNodes {

	Nodes root;

	public void addNodes(int key, String name) {

		// Create a new Nodes and initialize it

		Nodes newNode = new Nodes(key, name);

		// If there is no root this becomes root

		if (root == null) {

			root = newNode;

		} else {

			// Set root as the Nodes we will start
			// with as we traverse the tree

			Nodes currentNode = root;

			// Future parent for our new Nodes

			Nodes parent;

			while (true) {

				// root is the top parent so we start
				// there

				parent = currentNode;

				// Check if the new Nodes should go on
				// the left side of the parent Nodes

				if (key < currentNode.key) {

					// Switch focus to the left child

					currentNode = currentNode.leftChild;

					// If the left child has no children

					if (currentNode == null) {

						// then place the new Nodes on the left of it

						parent.leftChild = newNode;
						return; // All Done

					}

				} else { // If we get here put the Nodes on the right

					currentNode = currentNode.rightChild;

					// If the right child has no children

					if (currentNode == null) {

						// then place the new Nodes on the right of it

						parent.rightChild = newNode;
						return; // All Done

					}

				}

			}
		}

	}

	// check if the Node is a leaf (has no child nodes to the left and right)

	public boolean isLeaf() {

		Nodes currentNode = root;

		// boolean isLeftChild = true;

		if (currentNode.leftChild == null && currentNode.rightChild == null) {

			return true;
		}

		return false;

	}

	// All nodes are visited in ascending order
	// Recursion is used to go to one Nodes and
	// then go to its child nodes and so forth

	public void inOrderTraverseTree(Nodes currentNode) {

		if (currentNode != null) {

			// Traverse the left Nodes

			inOrderTraverseTree(currentNode.leftChild);

			// Visit the currently focused on Nodes

			System.out.println(currentNode);

			// Traverse the right Nodes

			inOrderTraverseTree(currentNode.rightChild);

		}

	}

	public void preOrderTraverseTree(Nodes currentNode) {

		if (currentNode != null) {

			System.out.println(currentNode);

			preOrderTraverseTree(currentNode.leftChild);
			preOrderTraverseTree(currentNode.rightChild);

		}

	}

	public void postOrderTraverseTree(Nodes currentNode) {

		if (currentNode != null) {

			postOrderTraverseTree(currentNode.leftChild);
			postOrderTraverseTree(currentNode.rightChild);

			System.out.println(currentNode);

		}

	}

	public Nodes findNode(int key) {

		// Start at the top of the tree

		Nodes currentNode = root;

		// While we haven't found the Nodes
		// keep looking

		while (currentNode.key != key) {

			// If we should search to the left

			if (key < currentNode.key) {

				// Shift the focus Nodes to the left child

				currentNode = currentNode.leftChild;

			} else {

				// Shift the focus Nodes to the right child

				currentNode = currentNode.rightChild;

			}

			// The Nodes wasn't found

			if (currentNode == null)
				return null;

		}

		return currentNode;

	}

}
