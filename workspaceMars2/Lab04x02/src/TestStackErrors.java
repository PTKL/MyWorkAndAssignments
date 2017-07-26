public class TestStackErrors {

	public static void main(String[] args) throws Overflow, Underflow {
		StringStackArray s = new StringStackArray();
//		 if (s.size() < 0) {
//		 s.pop();
//		
//		 }

		while (true) {

			s.push("ouch");
			throw new Overflow(null);

		}

	}

}
