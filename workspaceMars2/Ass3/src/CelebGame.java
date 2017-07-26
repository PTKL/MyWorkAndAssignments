import java.util.Scanner;

public class CelebGame {

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
				
		// System.out.println("Give me a question relating to the person you thought of: ");
		
		//String userInput = kbd.nextLine();

		TreeNodes theTree = new TreeNodes();

		theTree.addNodes(50, "Boss");

		theTree.addNodes(25, "Vice President");

		theTree.addNodes(15, "Office Manager");

		theTree.addNodes(30, "Secretary");

		theTree.addNodes(75, "Sales Manager");

		theTree.addNodes(85, "Salesman 1");

		// Different ways to traverse binary trees

		// theTree.inOrderTraverseTree(theTree.root);

		theTree.preOrderTraverseTree(theTree.root);

		// theTree.postOrderTraverseTree(theTree.root);

		// Find the Nodes with key 75

		System.out.println("\nNode with the key 75");

		System.out.println(theTree.findNode(75));
		
		kbd.close();

	}

}
