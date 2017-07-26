class ReverseString {

	public static String revRec(String str) {
		if ((null == str) || (str.length() <= 1)) {
			return str;
		}
		return revRec(str.substring(1)) + str.charAt(0);
	}

	public static String rev(String str) {

		for (int i = 1; i <= str.length(); i++) {
			System.out.print(str.charAt(str.length() - i));
		}
		return "";
	}

	public static void main(String[] args) {
		System.out.println("Enter string: ");
		
		String t = String.valueOf(args[0]);

		System.out.println(revRec(t));
	}
}
