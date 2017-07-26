import java.util.*;

public class TestTreeNode {

	public static void main(String[] args) {

		final TreeNode nodeA = new TreeNode(1);

		TreeNode nodeB = new TreeNode(2);

		TreeNode nodeC = new TreeNode(3);

		TreeNode nodeD = new TreeNode(4);

		TreeNode nodeE = new TreeNode(5);

		TreeNode nodeF = new TreeNode(6);

		TreeNode nodeG = new TreeNode(7);

		// build the tree

		nodeD.left = nodeE;

		nodeB.left = nodeC;

		nodeB.right = nodeD;

		nodeF.right = nodeG;

		nodeA.left = nodeB;

		nodeA.right = nodeF;

		// Do breadth first search

		System.out.println("***  Breadth First search *** ");

		Queue queue = new java.util.LinkedList() {
			{
				offer(nodeA);
			}
		};

		nodeA.breadthFirstSearch(queue);
		
		System.out.println("***  PreOrder *** ");
		nodeA.printPreOrder(nodeA);
		
		System.out.println("***  InOrder *** ");
		nodeA.printInOrder(nodeA);
		
		System.out.println("***  PostOrder *** ");
		nodeA.printPostOrder(nodeA);
		
		System.out.println("***  Sum *** " + nodeA.getSum(nodeA));
		
		
		System.out.println("***  Find *** " + nodeA.find(6));

	}
	
}
