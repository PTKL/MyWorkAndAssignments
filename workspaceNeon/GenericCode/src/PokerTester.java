public class PokerTester{
	public static void main(String[] args){
		Hand hand = new Hand();
		
		for (int i = 0; i < HandType.values().length; i++){
			do {
			hand.deal();
			} while (hand.getHandType() != HandType.values()[i]);
			System.out.println(hand);
			System.out.println("Points: " + hand.points());
			System.out.println(hand.getHandType()+"\n");
		}
		
		Deck deck = new Deck();
		deck.shuffle();
		System.out.println(deck);
		deck.sort();
		System.out.println(deck);
		
	}
}
