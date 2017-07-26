public class TestMixedPair {

	public static void main(String[] args) {
		MixedPair<Integer, Boolean> pIB = new MixedPair<Integer, Boolean>(1,
				false);
		MixedPair<Character, Double> pCD = new MixedPair<Character, Double>(
				'a', 2.78);
		System.out.println(pIB);
		System.out.println(pCD);

	}

}
