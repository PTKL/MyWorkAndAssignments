class InstanceScope {
	public String x; // scope of x starts at line 2 ends at line 16
	private int v; // scope of v starts at line 3 ends at line 16

	public InstanceScope(String x) { 
		this.x = x;
		v = 0;
	}

	private void doSomething(float f) {
		float z = f; // scope of z starts at line 11 ends at line 14
		for (int x = 1; x < 3; x++) { // scope of x starts at line 12 ends at line 14
			int a = x;  // scope of a starts at line 13 ends at line 14
		}
		int w = 4; // scope of starts at line 15 ends at line 16
	}
}
