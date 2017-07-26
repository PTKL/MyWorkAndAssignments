import java.util.Random;

public class Hand{
	Card[] cards;
	
	public Hand(){ cards = new Card[5]; }
	
	public Hand(Card c1, Card c2, Card c3, Card c4, Card c5){
		cards = new Card[5];
		cards[0] = c1;
		cards[1] = c2;
		cards[2] = c3;
		cards[3] = c4;
		cards[4] = c5;
	}
	
	public void deal(){
		Random rnd = new Random();
		int[] deck = new int[52];
		int s, r;
		for (int i = 0; i < 5; i++){
			do {
				s = rnd.nextInt(4);
				r = rnd.nextInt(13);
			} while (deck[s*r] == 1);
			deck[s*r] = 1;
			cards[i] = new Card(Rank.values()[r], Suit.values()[s]);
		}		
	}
	
	public int points(){
		return cards[0].getRank().points +
				cards[1].getRank().points +
				cards[2].getRank().points +
				cards[3].getRank().points +
				cards[4].getRank().points;
	}
	
	public String toString(){
		return cards[0] + ", " + cards[1] + ", " + cards[2] + ", " + cards[3] + ", " + cards[4]; 
	}
	
	public HandType getHandType(){
		int h = 0, d = 0, c = 0, s = 0;
		for (int i = 0; i < 5; i++){
			switch (cards[i].getSuit()){
				case Hearts:
					h++;
					break;
				case Diamonds:
					d++;
					break;
				case Spades:
					s++;
					break;
				case Clubs:
					c++;
					break;
			}
		}
		if (h==5 | d==5 | s==5 | c==5) return HandType.Flush;
		
		int[] numbers = new int[13];
		for(int i = 0; i < 5; i++){
			numbers[cards[i].getNumber()-1]++;
		}
		for (int i = 0; i < 13; i++){
			for (int j = 0; j < 13; j++){
				if (numbers[i] == 4) return HandType.FourOfAKind;
				if (i!=j){
					if (numbers[i] == 2 & numbers[j] == 3){
						return HandType.FullHouse;
					}
					if (numbers[i] == 2 & numbers[j] == 2){
						return HandType.TwoPair;
					}
					if (numbers[i] == 3) return HandType.ThreeOfAKind;
				}
			}
			if (numbers[i] == 2) return HandType.Pair;
		}
		return HandType.HighCard;
	}
}

enum HandType{
	FourOfAKind, FullHouse, Flush, ThreeOfAKind, TwoPair,
	Pair, HighCard;
}
