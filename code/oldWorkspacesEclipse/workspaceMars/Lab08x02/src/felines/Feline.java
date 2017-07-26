package felines;

public abstract class Feline extends Animal {
	
	
	protected static int lives;
	
	public Feline(int lives) {
		this.lives = lives;
		
	}

	public int getLives(){
		return lives;
	}
}
