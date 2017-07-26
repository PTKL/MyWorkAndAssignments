public class CardTest {


	public static void main(String[] args) {
		Card card = new Card("bob", 3478, Rank.UNCOMMON);
		
		System.out.println(card.toString());
		System.out.println();
		Deck deck = new Deck();
		System.out.println(deck.toString());

	}

}
