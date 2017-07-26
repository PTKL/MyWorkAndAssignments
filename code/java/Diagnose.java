
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Diagnose extends Applet {

	public void init() {
		int rows = 20;
		int cols = 20;
		int n = rows * cols;
		int pos = (38*n)/100;  //38% of tests are positive
		int neg = n - pos;
		setLayout(new GridLayout(rows,cols,5,5));
		
		int cpos = (80*pos)/100;  //80% of positives are true positives
		int cneg = pos - cpos;
		for(int i=1; i<=pos; i++) {
			if(Math.random() < (double)cpos/(double)(cpos+cneg)) {
				add(new Card("M+",Color.yellow,"C+",Color.red,12));
				cpos = cpos - 1;
			}
			else {
				add(new Card("M+",Color.yellow,"C-",Color.green,12));
				cneg = cneg - 1;
			}
		}
			
		cpos = (20*pos)/100;  //20% of negatives are false positives
		cneg = neg - cpos;		
			
		for(int i=pos+1; i<=n; i++) {
			if(Math.random() < (double)cpos/(double)(cpos+cneg)) {
				add(new Card("M-",Color.white,"C+",Color.red,12));
				cpos = cpos - 1;
			}
			else {
				add(new Card("M-",Color.white,"C-",Color.green,12));
				cneg = cneg - 1;
			}
		}
		repaint();
	
	}
	
}
