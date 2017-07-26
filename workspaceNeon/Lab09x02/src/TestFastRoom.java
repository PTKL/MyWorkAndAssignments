public class TestFastRoom {
	public static void main(String[] args) {
		for (int i = 0; i <= 100; ++i) {
			FastRoom room = new FastRoom(i);

			System.out.println("Number of pepole in room " + i
					+ " and are there some with the same birday "
					+ room.sameBirthday());
		}
	}
}
