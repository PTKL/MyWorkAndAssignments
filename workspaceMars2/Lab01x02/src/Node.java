class Node
{
    public Node(String value, Node next)
    {
        this.value = value;
        this.next = next;
    }

    public String get_Value()
    {
        return value;
    }
    
    public void set_Value(String value)
    {
        this.value = value;
    }

    public Node get_Next()
    {
        return next;
    }

    public void set_Next(Node node)
    {
        next = node;
    }

    private String value;
    private Node next;
}
