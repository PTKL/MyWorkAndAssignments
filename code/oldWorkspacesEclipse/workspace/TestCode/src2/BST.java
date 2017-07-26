import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class BST {
	public TreeNode root = null;

	public TreeNode get(int element) {
		if (root == null) {
			return null;
		}
		TreeNode runner = root;
		while (true) {
			if (runner.data > element) {
				if (runner.leftNode == null) {
					return null;
				}
				runner = runner.leftNode;
			} else if (runner.data < element) {
				if (runner.rightNode == null) {
					return null;
				}
				runner = runner.rightNode;
			} else {
				return runner;
			}
		}
	}

	public void insert(int element) {
		if (root == null) {
			root = new TreeNode(element);
			return;
		}
		TreeNode runner = root;
		while (runner.data != element) {
			if (runner.data > element) {
				if (runner.leftNode == null) {
					runner.leftNode = new TreeNode(element);
					return;
				}
				runner = runner.leftNode;
			} else {
				if (runner.rightNode == null) {
					runner.rightNode = new TreeNode(element);
					return;
				}
				runner = runner.rightNode;
			}
		}
	}

	public static void breathFirstSearch(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode runner = root;
		while (!queue.isEmpty()) {
			runner = (TreeNode) queue.remove();
			if (runner.leftNode != null) {
				queue.add(runner.leftNode);
			}
			if (runner.rightNode != null) {
				queue.add(runner.rightNode);
			}
			System.out.println("visited node " + runner.data);
		}
	}

	public static void depthFirstSearch(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return;
		}
		TreeNode runner = null;
		stack.add(root);
		while (!stack.empty()) {
			runner = stack.peek();
			if (runner.leftNode != null && !runner.leftNode.visited) {
				stack.add(runner.leftNode);
				continue;
			}
			if (runner.rightNode != null && !runner.rightNode.visited) {
				stack.add(runner.rightNode);
				continue;
			}
			stack.pop();
			runner.visited = true;
			System.out.println("visited node " + runner.data);
		}
	}

	public static void preOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrderTraversal(root.leftNode);
		preOrderTraversal(root.rightNode);
	}

	public static void inOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.leftNode);
		System.out.print(root.data + " ");
		inOrderTraversal(root.rightNode);
	}

	private class TreeNode {
		public int data;
		public TreeNode leftNode;
		public TreeNode rightNode;
		public boolean visited;

		TreeNode(int data) {
			this.data = data;
		}
	}

	@Test
	public void basicTest() {
		BST tree = new BST();
		int[] data = { 9, 5, 3, 1, 4, 8, 15, 11, 21, 20, 29 };
		for (int i : data) {
			tree.insert(i);
		}
		assertEquals(tree.get(3).data, 3);
	}

}
