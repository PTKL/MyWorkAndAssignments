import java.util.*;


public class TreeNode {
  int payload;
  static TreeNode left;
  static TreeNode right;
  
  public TreeNode(int payload) {
    this.payload = payload; 
  }
  
  public void printPreOrder(TreeNode n){
    if (n != null){
      System.out.println(n.payload);
      printPreOrder(n.left);
      printPreOrder(n.right);
    }
  }
  
  public void printInOrder(TreeNode n){
    if (n != null){
      printInOrder(n.left);
      System.out.println(n.payload);
      printInOrder(n.right);
    }
  }
  
  public void printPostOrder(TreeNode n){
    if (n != null){
      printPostOrder(n.left);
      printPostOrder(n.right);
      System.out.println(n.payload);
    }
  }
  
  public void breadthFirstSearch(Queue queue) {

		if (queue.isEmpty()) {
			return;
		}

		TreeNode node = (TreeNode) queue.poll();

		System.out.println("polling node: " + node);

		if (node.right != null) {
			queue.offer(node.right);
		}

		if (node.left != null) {
			queue.offer(node.left);
		}

		breadthFirstSearch(queue);
	}
  
  public int getSum(TreeNode root){
    int sum = 0;
    if (root != null){
      sum = sum + root.payload + getSum(root.left) + getSum(root.right);
    }
    return sum;
  }
  
  public boolean find(int v){
    if (payload == v){
    return true;
    }
    else if (left != null && left.find(v)){
      return true;
    }
    else if (right != null && right.find(v)){
      return true;
    }
	return false;
  }
  
  public String toString() {
		return "" + payload;
	}
}