class TestNode
{
    public static void main(String [] args)
    {
      Node Nodes = new Node("Hello ",new Node("World", new Node("!", null)));
      Node tempNode = Nodes;
      
      printNodes(Nodes);
      
      System.out.println();
      
      do
      {
        
        System.out.print(tempNode.get_Value());
        tempNode = tempNode.get_Next();
      }while(tempNode != null);
      
      System.out.println();
    }
    
    public static void printNodes(Node n)
    {
      if(n.get_Next() == null)
      {
        System.out.print(n.get_Value());
      }
      else
      {
        System.out.print(n.get_Value());
        printNodes(n.get_Next());
      }
    }
}
