import java.util.LinkedList;


public class Mystack<T> 
{
  
  LinkedList<T> list = new LinkedList<T>();
  static int top = 0;
  
  public void push(T s)
  {
    list.push(s);
    top = list.size();
  }
  
  public void pop()
  {
    list.pop();
    top = list.size();
  }
  
  public boolean isEmpty()
  {
    return (top == 0);
  }
}
