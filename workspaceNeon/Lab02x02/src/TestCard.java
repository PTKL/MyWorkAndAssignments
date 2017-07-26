public class TestCard {

  public static void main (String [] args) {
  
    Card KoH = new Card(Rank.KING, Suit.HEARTS);
    Card AoS = new Card(Rank.ACE, Suit.SPADES);
    Card QoH = new Card(Rank.QUEEN, Suit.HEARTS);
    
    System.out.println(KoH);
    System.out.println(AoS);
    System.out.println(QoH);
  }

}
