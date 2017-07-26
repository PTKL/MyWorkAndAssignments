class Pattern {
	private String pattern = "";

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String s) {
		pattern = s;
	}

	public Pattern(int n) {
		for (int i = 0; i < n; i++) {
			double temp = Math.random();
			if (temp > 0.5)
				pattern += "1";

			else
				pattern += "0";
		}
	}

	public Pattern(String s) {
		String checked = "";

		while (s.length() > 0) {
			if (s.charAt(0) == '1' || s.charAt(0) == '0') {
				checked += s.charAt(0);
				s = s.substring(1);
			} else {
				System.out.println("INPUT INVALID");
				break;
			}
		}
		pattern = checked;
	}

	public static boolean duplicates(Pattern p) {
		System.out.println(p.getPattern());
		if (p.getPattern().length() > 1) {
			if (p.getPattern().charAt(0) == p.getPattern().charAt(1)) {
				return true;
			}

			Pattern temp = new Pattern(p.getPattern().substring(1));
			return duplicates(temp);
		}
		return false;
	}

	public static boolean palindrome(Pattern p) {
		if (p.getPattern().length() <= 1)
			return true;
		if (p.getPattern().charAt(0) == p.getPattern().charAt(
				p.getPattern().length() - 1)) {
			Pattern temp = new Pattern(p.getPattern().substring(1,
					p.getPattern().length() - 1));
			return palindrome(temp);
		}
		return false;
	}

	public String removeDuplicates() {
		String checked = "";
		String hold = getPattern();

		while (getPattern().length() > 1) {
			if (getPattern().charAt(0) != getPattern().charAt(1))
				checked += getPattern().charAt(0);
			setPattern(getPattern().substring(1));
		}
		checked += getPattern().charAt(0);
		setPattern(hold);
		return checked;
	}
}