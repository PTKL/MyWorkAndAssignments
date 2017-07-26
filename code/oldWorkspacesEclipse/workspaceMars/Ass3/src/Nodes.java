public class Nodes {

	int key;
	String name;

	Nodes leftChild;
	Nodes rightChild;

	public Nodes(int key, String name) {

		this.key = key;
		this.name = name;

	}

	public String toString() {

		//return name + " has the key " + key;

		
		  return name + " has the key " + key + "\nLeft Child: " + leftChild +
		  "\nRight Child: " + rightChild + "\n";
		 

	}

}