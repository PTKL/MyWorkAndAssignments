public class Card implements Comparable<Card> {
	private long id; 
	private String name; 
	private CardRank rank; 
	private long price; 

	public Card(long id, String name, CardRank rank, long price) {
		this.id = id;
		this.name = name;
		this.rank = rank;
		this.price = 0;
	}

	public long getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public CardRank getRank() {
		return rank;
	}

	public long getPrice() {
		return price;
	}

	public String toString() {
		return "ID: " + id + "\n" + "Name: " + name + "\n" + "Rank: " + rank
				+ "\n" + "Price: " + price;
	}

	@Override
	public int hashCode() { // used Source -> Generate hasCode() and equals() from Eclipse
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (price ^ (price >>> 32));
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) { // used Source -> Generate hasCode() and equals() from Eclipse
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Card other = (Card) obj;
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (price != other.price) {
			return false;
		}
		if (rank != other.rank) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Card o) {
		String thisCard = rank + " " + name;
		String thatCard = o.getRank() + " " + o.getName();

		return thatCard.compareTo(thisCard);
	}
}
