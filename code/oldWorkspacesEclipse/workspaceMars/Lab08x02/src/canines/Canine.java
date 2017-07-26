package canines;
public abstract class Canine extends Animal {

	protected static int packSize;

	public Canine(int packSize) {
		 this.packSize = packSize;
		
	}

	public int getPackSize() {
		return packSize;
	}

}
