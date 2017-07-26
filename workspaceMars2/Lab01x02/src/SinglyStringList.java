class SinglyStringList
{
    public SinglyStringList()
    {
        this.headNode = null;
    }

    public SinglyStringList(String value)
    {
        headNode = new Node(value, null);
    }

    public SinglyStringList(String[] value)
    {
        for (int i = 0; i < value.length; ++i)
        {
            this.append(value[i]);
        }

    }

    public boolean isEmply()
    {
        return headNode == null;
    }

    public boolean find(String needle)
    {
        Node temp_Node = headNode;
        do
        {
            if (temp_Node.get_Value() == needle) return true;
            temp_Node = temp_Node.get_Next();
        } while (temp_Node != null);

        return false;
    }

    /*
     * The cost of append is N
     */
    public void append(String s)
    {
        if (headNode == null)
        {
            headNode = new Node(s, null);
            return;
        }

        Node currentNode = headNode;

        while (currentNode.get_Next() != null)
            currentNode = currentNode.get_Next();

        currentNode.set_Next(new Node(s, null));

    }
    
    public void reverse()
    {
        append(reverse(headNode).get_Value());
    }
    
    private Node reverse(Node tempNode)
    {
        if(tempNode.get_Next() == null)
        {
            headNode = null;
            return tempNode;
        }
        else
        {
            append(reverse(tempNode.get_Next()).get_Value());
            return tempNode;
        }
    }

    /*
     * The cost of insertHead is 1
     */
    public void insertHead(String value)
    {
        Node temp_Node = new Node(value, headNode);
        this.headNode = temp_Node;
    }

    public String removeHead()
    {
        String value = headNode.get_Value();
        headNode = headNode.get_Next();

        return value;
    }

    public String toString()
    {
        return printNodes(headNode);
    }
    
    private String printNodes(Node n)
    {
        if (n.get_Next() == null)
        {
            return n.get_Value();
        } else
        {
            return n.get_Value() + " " + printNodes(n.get_Next());
        }
    }

    public int size()
    {
        return size(headNode);
    }
    
    public String getElt(int i)
    {
        int size_Of_List = size();
        
        System.out.println(size_Of_List);
        
        if((size_Of_List-1) < i)
            return "";
        
        Node tempNode = headNode;
        
        for(int j = 0; j < i; ++j)
        {
            tempNode = tempNode.get_Next();
        }
        
        return tempNode.get_Value();
    }
    
    public String[] toArray()
    {
        String[] tempArray = new String[size()];
        Node holder = headNode;
        int possion = 0;
        
        while(holder.get_Next() != null)
        {
            tempArray[possion++] = holder.get_Value();
            holder = holder.get_Next();
        }
        
        return tempArray;
    }

    private int size(Node n)
    {
        if (n.get_Next() == null)
        {
            return 1;
        } else
        {
            return 1 + size(n.get_Next());
        }
    }

    private Node headNode;
}
