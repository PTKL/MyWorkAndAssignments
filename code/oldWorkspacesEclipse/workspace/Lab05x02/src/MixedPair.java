
public class MixedPair<U, V> {
	private U first;
	private V second;

	public MixedPair(U first, V second) {
		this.first = first;
		this.second = second;
	}

	public U getFirst() {
		return first;
	}

	public V getSecond() {
		return second;
	}

	public void setFirst(U first) {
		this.first = first;
	}

	public void setSecond(V second) {
		this.second = second;
	}
	
	public String toString() {
		return "The First is: " + getFirst() + " The Second is: " + getSecond();
		
	}
}
