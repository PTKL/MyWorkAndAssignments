import java.util.*;

public class ArrayTreeNode {
	int payload;
	ArrayTreeNode[] succ;
	public ArrayTreeNode left;
	public ArrayTreeNode right;

	// Constructor
	public ArrayTreeNode(int x, int children) {
		payload = x;
		succ = new ArrayTreeNode[children];
	}

	public void printPreOrder(ArrayTreeNode n) {

		if (n != null) {
			System.out.println("Test" + ArrayTreeNode.left);
			System.out.println("Test" +  ArrayTreeNode.right);
			System.out.println(n.payload);
			printPreOrder(ArrayTreeNode.left);
			printPreOrder(ArrayTreeNode.right);
		}
	}

	public void printInOrder(ArrayTreeNode n) {
		
		if (n != null) {
			
			printInOrder(ArrayTreeNode.left);
			System.out.println(n.payload);
			printInOrder(ArrayTreeNode.right);
		}
	}

	public void printPostOrder(ArrayTreeNode n) {
		if (n != null) {
			printPostOrder(ArrayTreeNode.left);
			printPostOrder(ArrayTreeNode.right);
			System.out.println(n.payload);
		}
	}

	public void breadthFirstSearch(Queue queue) {

		if (queue.isEmpty()) {
			return;
		}

		ArrayTreeNode node =  (ArrayTreeNode) queue.poll();

		System.out.println("polling node: " + node);

		if (TreeNode.right != null) {
			queue.offer(node.right);
		}

		if (TreeNode.left != null) {
			queue.offer(node.left);
		}

		breadthFirstSearch(queue);
	}

	public int getSum(ArrayTreeNode nodeA) {
		int sum = 0;
		if (nodeA != null) {
			sum = sum + nodeA.payload + getSum(ArrayTreeNode.left)
					+ getSum(ArrayTreeNode.right);
		}
		return sum;
	}

	public boolean find(int v) {
		if (payload == v) {
			return true;
		} else if (TreeNode.left != null && TreeNode.left.find(v)) {
			return true;
		} else if (TreeNode.right != null && TreeNode.right.find(v)) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "" + payload;
	}

}
