public class Z
{
    private static String silly() {
        try
        {
            //int n = 1/0;
            return "A";
        }
        catch (Exception ex)
        {
            System.out.println("B");
        }
        /*finally
        {
            System.out.println("C");
        }*/
        return "D";
    }

    public static void main(String[] args)
    {
        System.out.println( silly() );
    }
}
