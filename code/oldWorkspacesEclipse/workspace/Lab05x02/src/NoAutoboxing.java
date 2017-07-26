class NoAutoboxing {

	public static void main(String args[]) {
		// From the primitive to the object
		Integer intObject = Integer.valueOf(42);
		System.out.println(intObject);
		// From the object to the primitive
		int intPrimitive = intObject.intValue();
		System.out.println(intPrimitive);
	}
}
