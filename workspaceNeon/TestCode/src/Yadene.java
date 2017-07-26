import java.util.*;

public class Yadene {

	static Scanner input = new Scanner(System.in);

	static String state = "yes";

	public static void dish() {

		System.out.println(Yastie.getRandomYastie());

	}

	public static void main(String[] args) {
		while (true) {
			if (state.isEmpty()) {
				break;
			}
			dish();
			state = input.nextLine();
		}
	}

	public enum Yastie {
		Kartofi_s_luk_i_meso, Musaka, Supa_topcheta, Tarator;

		public static Yastie getRandomYastie() {
			Random random = new Random();
			return values()[random.nextInt(values().length)];
		}
	}
}