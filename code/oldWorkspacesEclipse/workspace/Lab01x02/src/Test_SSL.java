
public class Test_SSL
{
    public static void main(String[] args)
    {
	SinglyStringList SSL = new SinglyStringList(args);       
 
        SSL.append("Last");
	
	System.out.println("\n\n--------------------------------------------------------\n\n");
	System.out.println(SSL.toString());
	System.out.println(SSL.size());
        
        SSL.insertHead("First");

        System.out.println("\n\n--------------------------------------------------------\n\n");
	System.out.println(SSL.toString());
	System.out.println(SSL.size());
	
        SSL.reverse();
        System.out.println("\n\n--------------------------------------------------------\n\n");
        System.out.println(SSL.toString());
        System.out.println(SSL.size());

	System.out.println("\n\n--------------------------------------------------------\n\n"); 	
      
	System.out.println("is First a element? " + SSL.find("First"));
	System.out.println("\n\n--------------------------------------------------------\n\n");

    }

}
