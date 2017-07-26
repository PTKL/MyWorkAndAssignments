import java.util.*;

public class Permute {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out
					.println("Please provide a word as a command line argument.");
			return;
		}

		HashSet<String> perms = permute(args[0]);
		System.out.println("\nThe set of permutations of " + args[0]
				+ " contains:");
		for (String str : perms) {
			System.out.println(str);
		}

	}

	private static HashSet<String> permute(String s) {
		System.out.println("Calling permute(" + s + ")");
		HashSet<String> results = new HashSet<String>();

		if (s.length() <= 1) {
			results.add(s);
		} else {
			for (int i = 0; i < s.length(); i++) {
				char ithChar = s.charAt(i);
				String sWithoutIthChar = s.substring(0, i) + s.substring(i + 1);
				HashSet<String> perm = permute(sWithoutIthChar);
				System.out.println("Back in permute(" + s + ")");
				for (String p : perm) {
					results.add(ithChar + p);
				}
			}
		}
		System.out.println("Returning from permute(" + s + ") with result "
				+ results);
		return results;
	}

}