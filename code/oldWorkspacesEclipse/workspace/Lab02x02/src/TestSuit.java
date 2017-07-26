public class TestSuit
{
    public static void main(String[] args)
    {
        Suit a = Suit.HEARTS;
        Suit b = Suit.HEARTS;
        Suit c = Suit.CLUBS;
        System.out.println(a.name() + " = " + b.name() +" ? " + a.equals(b));
        System.out.println(a.name() + " = " + c.name() +" ? " + a.equals(c));
        System.out.println(a.equals(c));

        for (int s = 0; s < Suit.values().length; s++)
            System.out.println( Suit.values()[s] );            
    }
}
