import java.util.Random;

public class Deck {
	
	static Random generator = new Random();

	public static Card[] deck;
	public final int NB_OF_CARDS = 52;

	
	public int cardsUsed;

	/**
	 * Constructs a deck of playing cards, The deck contains the usual 52 cards.
	 * Initially the cards are in a sorted order. The shuffle() method can be
	 * called to randomize the order.
	 * 
	 */
	public Deck() {

		deck = new Card[NB_OF_CARDS];
		int cardCt = 0; // How many cards have been created so far.
		for (Suit suit : Suit.values()) {
			for (Rank value : Rank.values()) {
				deck[cardCt] = new Card(value, suit);
				cardCt++;
			}
		}

		cardsUsed = 0;
	}

	/**
	 * Put all the used cards back into the deck (if any), and shuffle the deck
	 * into a random order.
	 */
	public void shuffle(int n) {
		int pos1;
		int pos2;
		
		for (int i = n; i > 0; i--) {
			pos1 = generator.nextInt(NB_OF_CARDS);
			pos2 = generator.nextInt(NB_OF_CARDS);
			Card temp = deck[pos1];
			deck[pos1] = deck[pos2];
			deck[pos2] = temp;
		}
		cardsUsed = 0;
	}

	/**
	 * As cards are dealt from the deck, the number of cards left decreases.
	 * This function returns the number of cards that are still left in the
	 * deck. The return value would be 52 or 54 (depending on whether the deck
	 * includes Jokers) when the deck is first created or after the deck has
	 * been shuffled. It decreases by 1 each time the dealCard() method is
	 * called.
	 */
	public int cardsLeft() {
		return deck.length - cardsUsed;
	}

	/**
	 * Removes the next card from the deck and return it. It is illegal to call
	 * this method if there are no more cards in the deck. You can check the
	 * number of cards remaining by calling the cardsLeft() function.
	 * 
	 * @return the card which is removed from the deck.
	 * @throws IllegalStateException
	 *             if there are no cards left in the deck
	 */
	
	
	public Card getRandomCard() {
		int cardIndex = generator.nextInt(NB_OF_CARDS);
		return deck[cardIndex];
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < deck.length; i++) {
			result += deck[i].toString() + "\n";
			// System.out.println(deck[i]);
		}
		return "Card is: " + result;

	}
}