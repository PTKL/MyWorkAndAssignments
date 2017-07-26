class Record {

	private static int totalNumber; // Class variable
	public String name;

	// Instance variable
	public Record(String s) {
		name = s;
		totalNumber++;
	}

}
