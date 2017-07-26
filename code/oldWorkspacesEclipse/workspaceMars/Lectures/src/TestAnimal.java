public enum TestAnimal { // definition
	Dog("Woof"), Cat("Meow"); // calling constructor
	// fields and constructors of enum are private
	private String sound;

	private TestAnimal(String s) {
		sound = s;
	}

	public String toString() {
		return sound;
	}

	public static class Test {
		public static void main(String[] args) {
			TestAnimal a = TestAnimal.Dog; // enum element
			System.out.println(a);
		}
	}
}