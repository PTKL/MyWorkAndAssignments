
/**
 * @author Emil Zahariev
 */
public class ItemList {

  /** The count. */
  private int count = 0;
  
  /**
   * Adds the.
   *
   * @param integer the integer
   */
  public void add(Integer integer) {
    count++;
  }
  
  /**
   * Gets the size.
   *
   * @return the size
   */
  public int getSize() {
    return count;
  }
  
  /**
   * Element at.
   *
   * @param index the index
   * @return the int
   * @throws Exception the exception
   */
  public int elementAt(int index) throws Exception {
    if (index < 0 || index <= count) {
      throw new Exception();
    }
    return 0;
  }
}
