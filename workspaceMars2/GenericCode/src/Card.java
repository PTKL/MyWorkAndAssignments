public class Card{
	Rank rank;
	Suit suit;
	
	public Card(Rank r, Suit s){
		rank = r;
		suit = s;
	}
	
	public Rank getRank(){ return rank; }
	public Suit getSuit(){ return suit; }
	public int getNumber(){ return rank.number; }
	public int getPosition(){ return rank.number + (suit.number*13); }
	
	public String toString(){
		return rank + suit.symbol;
	}
	
	public boolean isBiggerThan(Card c){
		return getPosition() > c.getPosition();
	}
}

enum Rank{
	Ace(1,11), Two(2,0), Three(3,0), Four(4,0), Five(5,0), Six(6,0), Seven(7,0), Eight(8,0),
	Nine(9,0), Ten(10,10), Jack(11,2), Queen(12,3), King(13,4);
	
	int number, points;
	
	Rank(int n, int p){
		number = n;
		points = p;
	}
}

enum Suit{
	Hearts("♡", 0), Diamonds("♢", 1), Clubs("♣", 2), Spades("♠", 3);
	
	String symbol;
	int number;
	
	Suit(String s, int n){
		symbol = s;
		number = n;
	}
}
