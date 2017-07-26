
public class Card {
	private long id;
	private String name;
	private long price;
	private final Rank rank;
	
	//Getters
	public long getID() {
		return id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public long getPrice() {
		return price;
	}
	
	public Rank getRank(){
		return this.rank;
	}

	//Setters
	public void setID(long di) {
		this.id = di;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	//Constructor
	public Card(String name, long id, Rank Rank){
		this.name = name;
		this.id = id;
		this.rank = Rank;
		this.price = 0;
	}
	
	//hashCode
	@Override
	public int hashCode(){
		return 0;
	}
	
	//to string method
	public String toString(){
		return "CARD"+"\n"+name + "\n" + id + "\n" + rank + "\n" + price;
	}
}
