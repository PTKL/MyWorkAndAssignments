public class ArrayStack implements Stack
   {
      /* ==================================================
   	 A class contains: variable and/or method
   	 ================================================== */
      public int[] item;
      public int stackTop;
    
      public ArrayStack( int size )
      {
   	 item = new int[size];      // Make array
   	 stackTop = 0;
      }
    
      public void push( int x ) throws StackException
      {
   	 if ( stackTop == item.length )
   	 {
   	    throw new StackException("Stack overflow");
   	 }
    
   	 item[stackTop] = x;         // Store x in next slot
   	 stackTop++;                 // Advance one slot location
      }
    
      public int  pop ( ) throws StackException
      {
   	 int returnItem;
   
   	 if ( stackTop == 0 )
   	 {
   	    throw new StackException("Stack underflow");
   	 }
    
   	 returnItem = item[ stackTop-1 ];   // Get last stored item
   	 stackTop--;                        // Back up one slot location
    
   	 return returnItem;
      }
   }