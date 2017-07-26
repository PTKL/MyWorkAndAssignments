//import java.util.*;

//Below is code needed for Exercise 4 

class NegativeInteger extends Exception
{
	public void NegativeInteger()
	{
		System.out.println("Error: Input is negative");
	}
}
//Note: Exception methods need to be placed before the method it's being thrown at, else there is an error
//And now, back to the show :P 

class Factorial
{
    private static long fact( long n ) 
    {
        System.out.println(n);
        
        if ( n == 0)
        {	
            return 1;
        }    
        else
        {	
            return n*fact(n-1);
        }   
    }

    public static void main (String[] args) throws NegativeInteger //throws = Ex4
    {
        try
        {
        	long a = Integer.parseInt(args[0]);
        	if(a < 0)
        	{	
        		throw new NegativeInteger();
        	}	
        	System.out.println( fact(a) );
        } 
        catch(ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
            System.out.println("Error: No input found "+e.toString());
        }
        catch(NumberFormatException e)
        {
        	e.printStackTrace();
        	System.out.println("Error: Something other than an integer was used as input "+e.toString());
        }
        catch(NegativeInteger e)
        {
        	e.printStackTrace();
        	e.NegativeInteger();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	System.out.println("Error:EEEEERRRRRRRRRROOOOORRRRR");
        }
    } 
}