import java.util.LinkedList;


public class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;
  
  public TreeNode(int x){
    data = x; 
  }
  
  public void printPreOrder(TreeNode n){
    if (n != null){
      System.out.println(n.data);
      printPreOrder(n.left);
      printPreOrder(n.right);
    }
  }
  
  public void printInOrder(TreeNode n){
    if (n != null){
      printInOrder(n.left);
      System.out.println(n.data);
      printInOrder(n.right);
    }
  }
  
  public void printPostOrder(TreeNode n){
    if (n != null){
      printPostOrder(n.left);
      printPostOrder(n.right);
      System.out.println(n.data);
    }
  }
  
  public void printBFS(TreeNode root){
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while(!queue.isEmpty()){
      TreeNode node = queue.remove();
      if(node !=null){
        System.out.println(node.data);
        queue.add(node.left);
        queue.add(right);
      }
    }
  }
  
  public int getSum(TreeNode root){
    int sum = 0;
    if (root != null){
      sum = sum + root.data + getSum(root.left) + getSum(root.right);
    }
    return sum;
  }
  
  public boolean find(int v){
    if (data == v){
    return true;
    }
    else if (left != null){
      return left.find(v);
    }
    else if (right != null){
      return right.find(v);
    }
  }
}
