import java.util.Deque;
import java.util.ArrayDeque;

public class TreeAlgorithms {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3,
				new TreeNode(4), new TreeNode(5)), new TreeNode(6,
				new TreeNode(7), new TreeNode(8))), new TreeNode(9,
				new TreeNode(10, new TreeNode(11), new TreeNode(12)),
				new TreeNode(13, new TreeNode(14), new TreeNode(15))));
		System.out.println("== Recursive algorithms ==");
		System.out.println("Max of tree");
		System.out.println(root.max());
		System.out.println("Instance-method preorder");
		root.printPreorder();
		System.out.println("\nIn-class static method preorder");
		TreeNode.printPreorder(root);
		System.out.println("\nOut-of-class static method preorder");
		recursivePreorder(root);

		System.out.println("\n\n== Iterative algorithms ==");
		System.out.println("Preorder");
		iterativePreorder(root);
		System.out.println("\nInorder");
		iterativeInorder(root);
		System.out.println("\nPostorder");
		iterativePostorder(root);
		System.out.println("\nBFS");
		bfs(root);
		System.out.println();
	}

	// Breadth-first search
	public static void bfs(TreeNode root) {
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.removeFirst();
			System.out.print(cur.getPayload() + " ");
			if (cur.getLeft() != null)
				queue.addLast(cur.getLeft());
			if (cur.getRight() != null)
				queue.addLast(cur.getRight());
		}
	}

	// Iterative pre-order traversal is a straight-forward depth-first search
	// (DFS)
	public static void iterativePreorder(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			System.out.print(cur.getPayload() + " ");
			if (cur.getRight() != null)
				stack.push(cur.getRight());
			if (cur.getLeft() != null)
				stack.push(cur.getLeft());
		}
	}

	// Iterative in-order traversal requires a cursor that moves left first
	// Alternatively, can be done with two stacks
	public static void iterativeInorder(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.getLeft();
			} else {
				cur = stack.pop();
				System.out.print(cur.getPayload() + " ");
				cur = cur.getRight();
			}
		}
	}

	// Iterative post-order traversal requires a cursor that moves left
	// and needs to change the order of elements on the stack
	// Alternatively, can be done with two stacks
	public static void iterativePostorder(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				if (cur.getRight() != null)
					stack.push(cur.getRight());
				stack.push(cur);
				cur = cur.getLeft();
			} else {
				cur = stack.pop();
				if (cur.getRight() == stack.peek()) {
					stack.pop();
					stack.push(cur);
					cur = cur.getRight();
				} else {
					System.out.print(cur.getPayload() + " ");
					cur = null;
				}
			}
		}
	}

	public static void recursivePreorder(TreeNode node) {
		if (node != null) {
			System.out.print(node.getPayload() + " ");
			recursivePreorder(node.getLeft());
			recursivePreorder(node.getRight());
		}
	}

}

class TreeNode {

	public static void printPreorder(TreeNode node) {
		if (node != null) {
			System.out.print(node.payload + " ");
			printPreorder(node.left);
			printPreorder(node.right);
		}
	}

	private final int payload;
	private final TreeNode left;
	private final TreeNode right;

	public TreeNode(int payload, TreeNode left, TreeNode right) {
		this.payload = payload;
		this.left = left;
		this.right = right;
	}

	public TreeNode(int payload) {
		this(payload, null, null);
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

	public int getPayload() {
		return payload;
	}

	public void printPreorder() {
		System.out.print(payload + " ");
		if (left != null) {
			left.printPreorder();
		}
		if (right != null) {
			right.printPreorder();
		}
	}

	public int max() {
		int max = payload;
		if (left != null) {
			max = Math.max(max, left.max());
		}
		if (right != null) {
			max = Math.max(max, right.max());
		}
		return max;
	}

}