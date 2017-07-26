import java.awt.*; 
import java.awt.event.*; 
import java.applet.Applet; 
public class Wason extends Applet { 
	public void init() { 
		setLayout(new GridLayout(1,4,20,0)); 
		add(new Card("E", Color.white,"E", Color.yellow, 24)); 
		add(new Card("K", Color.white,"K", Color.yellow, 24)); 
		add(new Card("4", Color.white,"4", Color.yellow, 24)); 
		add(new Card("5", Color.white,"5", Color.yellow, 24)); 
		repaint(); 
		} 
}
