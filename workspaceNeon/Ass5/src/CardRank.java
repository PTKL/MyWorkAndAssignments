public enum CardRank {
	UNIQUE, RARE, UNCOMMON, COMMON;

	public static CardRank parseEnumRank(String value) { // used to assign the rank to the cards
		if (value.equals(UNIQUE)) {
			return CardRank.UNIQUE;
		}

		if (value.equals(RARE)) {
			return CardRank.RARE;
		}

		if (value.equals(UNCOMMON)) {
			return CardRank.UNCOMMON;
		}

		if (value.equals(COMMON)) {
			return CardRank.COMMON;
		}

		return null;
	}
}
