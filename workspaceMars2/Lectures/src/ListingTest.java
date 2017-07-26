import java.util.*;

public class ListingTest {
	public static void main(String[] args) {
		List<Listing> listings = new ArrayList<Listing>();
		listings.add(new Listing(Listing.Type.HOUSE, "TW20 0EX", 300, 1));
		listings.add(new Listing(Listing.Type.HOUSE, "TW20 0EX", 250, 2));
		listings.add(new Listing(Listing.Type.HOUSE, "TW20 0EX", 200, 2));
		listings.add(new Listing(Listing.Type.FLAT, "RG42 4EX", 300, 3));
		listings.add(new Listing(Listing.Type.FLAT, "SW3 1QP", 750, 4));
		listings.add(new Listing(Listing.Type.FLAT, "SW3 1QP", 750, 4));

		System.out.println("All listings:");
		System.out.println(listings);

		// Add all listings to a HashSet
		HashSet<Listing> hashSet = new HashSet<Listing>();
		hashSet.addAll(listings);
		System.out.println("In HashSet:");
		System.out.println(hashSet);

		// Add all listings to a TreeSet
		TreeSet<Listing> treeSet = new TreeSet<Listing>();
		treeSet.addAll(listings);
		System.out.println("In TreeSet:");
		System.out.println(treeSet);

		// Create a HashMap from serial numbers to listings
		HashMap<Integer, Listing> priceMap = new HashMap<Integer, Listing>();
		for (Listing l : listings) {
			priceMap.put(l.getSerial(), l);
		}
		System.out.println("Listing with ID 3: " + priceMap.get(3));

	}
}

class Listing implements Comparable<Listing> {
	public enum Type {
		HOUSE, FLAT, FLATSHARE
	};

	private Type type;
	private int price;
	private String postCode;
	private int serial;

	public Listing(Type type, String postCode, int price, int serial) {
		this.type = type;
		this.postCode = postCode;
		this.price = price;
		this.serial = serial;
	}

	public int getPrice() {
		return price;
	}

	public String getPostCode() {
		return postCode;
	}

	public Type getType() {
		return type;
	}

	public int getSerial() {
		return serial;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Listing)) {
			return false;
		}
		Listing other = (Listing) obj;
		// Allow listings to be seen as equal even when the price differs
		return this.serial == other.serial
				&& this.postCode.equals(other.postCode)
				&& this.type.equals(other.type);
	}

	@Override
	public int hashCode() {
		int hash = serial; // Use int directly as basis for hashCode
		hash = 31 * hash + postCode.hashCode(); // add string hashCode
		hash = 31 * hash + type.hashCode(); // add enum hashCode
		return hash;
	}

	@Override
	public int compareTo(Listing other) {
		// Sort by postcode first, then by serial
		int pcComp = postCode.compareTo(other.postCode);
		if (pcComp == 0) {
			return this.serial - other.serial;
		} else {
			return pcComp;
		}
	}

	public String toString() {
		return postCode + ": " + type + " @ " + price + " [" + serial + "]";
	}
}