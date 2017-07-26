import java.util.*;

public class ArrayTreeNodeTest {

	public static void main(String[] args) {
		final ArrayTreeNode nodeA = new ArrayTreeNode(1, 2);
		
		ArrayTreeNode nodeB = new ArrayTreeNode(2, 2);
		nodeA.succ[0] = nodeB;
		
		
		ArrayTreeNode nodeC = new ArrayTreeNode(3, 2);
		nodeA.succ[1] = nodeC;
		
		ArrayTreeNode nodeD =  new ArrayTreeNode(4, 0);
		nodeB.succ[0] = nodeD;
		
		ArrayTreeNode nodeE = new ArrayTreeNode(5, 0);
		nodeB.succ[1] = nodeE;


		ArrayTreeNode nodeF = new ArrayTreeNode(6, 0);
		nodeC.succ[0] = nodeF;
		
		ArrayTreeNode nodeG = new ArrayTreeNode(7, 0);
		nodeC.succ[1] = nodeG;
		

		nodeB.left = nodeD;
		nodeB.right = nodeE;
		
		nodeC.left = nodeF;
		nodeC.right = nodeG;
		
		nodeA.left = nodeB;
		nodeA.right = nodeC;

		// Do breadth first search

		System.out.println("***  Breadth First search *** ");

		Queue queue = new java.util.LinkedList() {
			{
				offer(nodeA);
			}
		};

		nodeA.breadthFirstSearch(queue);

		System.out.println("***  PreOrder *** ");
		nodeA.printPreOrder(nodeA, 5);

		System.out.println("***  InOrder *** ");
		nodeA.printInOrder(nodeA);

		System.out.println("***  PostOrder *** ");
		nodeA.printPostOrder(nodeA);

		System.out.println("***  Sum *** " + nodeA.getSum(nodeA));

		System.out.println("***  Find *** " + nodeA.find(6));
	}
}
