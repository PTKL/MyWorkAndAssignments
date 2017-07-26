import java.util.Random;

public class Deck{
	Card[] deck;
	
	public Deck(){
		deck = new Card[52];
		int r = 0, n = 0;
		
		for (int i = 0; i < 52; i++){
			if (n == 13) { r++; n = 0; }
			deck[i] = new Card(Rank.values()[n], Suit.values()[r]);
			n++;
		}		
	}
	
	public String toString(){
		String s = "";
		for (int i = 0; i < 52; i++){
			s += deck[i] + "\n";
		}
		return s;
	}
	
	public void swap(int i, int j){
		try {
			Card temp = deck[i];
			deck[i] = deck[j];
			deck[j] = temp;
		}catch (ArrayIndexOutOfBoundsException e){}
	}
	
	public void shuffle(){
		Random r = new Random();
		for (int i = 0; i < 60; i++){
			swap(r.nextInt(52), r.nextInt(52));
		}
	}
	
	public void sort(){
		boolean swapped;
		do {
			swapped = false;
			for (int i = 1; i < deck.length; i++){
				if (deck[i-1].isBiggerThan(deck[i])){
					swap(i-1, i);
					swapped = true;
				}
			}
		} while (swapped);
	}
	
}
