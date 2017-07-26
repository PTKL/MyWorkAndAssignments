import java.util.Scanner;

class Hanoi { 
    public static void main(String [] args) {
	int playDisks = 0;
	Scanner fromInput = new Scanner(System.in);
	System.out.println("Please, specify the number of disks?");
	playDisks = fromInput.nextInt();

	if(playDisks < 1) { 
	    System.out.println("You can't have 0 disks!");
	    playDisks = fromInput.nextInt();
	}
	moveDisks(playDisks, 1, 3);
    }

    public static void moveDisks(int disksMoving, int from, int to) {
	if(disksMoving == 1) {
	    System.out.println("Moving disks from " + from + " to " + to);
	}
	else {
	    int others = (6 - (from + to));
	    moveDisks(disksMoving - 1, from, others);
	    moveDisks(1, from, to);
	    moveDisks(disksMoving - 1, others, to);
	}
    }
}
