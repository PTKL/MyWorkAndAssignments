class Card {

    private final Rank rank;
    private final Suit suit;
    private final int points;
    
    public Card (Rank r, Suit s) {
    
      rank = r;
      suit = s;
      points = rank.getPoints();
    
    }
    
	public Rank getRank(){
    
      return this.rank;
    
    }
    
    public Suit getSuit() {
    
      return this.suit;
    
    }
    
    public int getPoints() {
    
      return this.points;
    
    }
    
    public boolean equals(Card other) {
    
    
      if (this.suit == other.suit && this.points == other.points) {
      
	return true;
      
      }
      
      return false;
      //return (this.suit == other.suit && this.points == other.points);
    
    }
    
    public String toString() {
    
        return this.rank.name() + " of " + this.suit;
    }

}