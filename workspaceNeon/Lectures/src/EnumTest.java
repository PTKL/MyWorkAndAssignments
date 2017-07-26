public class EnumTest {
	public enum Day {
		MON, TUE, WED, THU, FRI, SAT, SUN;
	}

	public enum Direction {
		NORTH, SOUTH, EAST, WEST;

		public String toString() {
			return "Direction: " + name();
		}

		public boolean isCold() {
			return this == NORTH;
		}
	}

	public static void feeling(Day day) {
		switch (day) {
		case MON:
			System.out.println("I hate Mondays.");
			break;
		case FRI:
			System.out.println("Fridays are better.");
			break;
		case SAT:
		case SUN:
			System.out.println("Weekends are best.");
			break;
		default:
			System.out.println("Midweek days are so-so.");
			break;
		}
	}

	public static void main(String[] args) {
		feeling(Day.WED);
	}
}