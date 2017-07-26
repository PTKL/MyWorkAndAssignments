
public class Hand {
	
	Deck deck = new Deck();
	static final int cardInHand = 5;
	Card [] hand;
	
	public Hand () {
		 int j;
		hand =  new Card [cardInHand];
		for(int i = 0; i < cardInHand; i++){
		hand[i] = deck.getRandomCard();
			for(j = 0; hand[i] != hand[j] && j <= i; j++ ) { // check if cards have been chosen before
				
			}
			
			if (i != j) { // give new card;
				i--;
			}
		}
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < hand.length; i++) {
			if(hand[i] != null) {
			result += hand[i].toString() + "\n";
			}
			// System.out.println(deck[i]);
		}
		return "Card is: " + result;

	}
	
}
