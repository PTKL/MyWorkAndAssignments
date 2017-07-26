/******************************************************************************
 * Compilation: javac TuringMachine.java Execution: java TuringMachine
 * Dependencies: Stack.java Control.java Tape.java Transition.java
 * 
 * % java TuringMachine comparator.tur "1101<1110"
 *
 * Reads in a .tur file describing a Turing machine, and simulates the input on
 * the machine.
 *
 ******************************************************************************/

public class TuringMachine {
	private Control control; // control unit
	private Tape tape; // ticker tape

	// input file
	public TuringMachine(In in) {
		control = new Control();
		String s = "";

		// the vertices / states
		while (!s.equalsIgnoreCase("vertices")) {
			s = in.readLine().trim();
		}
		while (!s.equalsIgnoreCase("edges")) {
			s = in.readLine().trim();
			if (s.equals(""))
				continue;
			if (s.startsWith("//"))
				continue;
			if (s.equalsIgnoreCase("edges"))
				continue;
			String[] fields = s.split("\\s");
			control.addState(fields[0], fields[1]);
		}

		// the edges / transitions
		while (!s.equalsIgnoreCase("tapes")) {
			s = in.readLine().trim();
			if (s.equals(""))
				continue;
			if (s.startsWith("//"))
				continue;
			if (s.equalsIgnoreCase("tapes"))
				continue;
			String[] fields = s.split("\\s");
			control.addTransition(fields[0], fields[1], fields[2], fields[3]);
		}
	}

	// simulate the Turing machine
	public void simulate(String input) {
		tape = new Tape(input); // starting tape
		State state = control.getState(); // starting state

		// do fetch, decode, execute cycle
		while (!state.isHalt() && !state.isYes() && !state.isNo()) {
			// // System.out.println(state);
			String read = tape.read(); // current character
			Transition transition = control.getTransition(read); // transition
																	// to follow
			if (transition != null) { // state in same state if no transition
				state = transition.getNextState(); // next state
				control.setState(state); // update the state
				tape.write(transition.getWrite()); // write the symbol
			}
			if (state.isLeft())
				tape.left(); // move tape left
			else if (state.isRight())
				tape.right(); // or move tape right
		}

		if (state.isYes())
			System.out.println("Accepted");
		else if (state.isNo())
			System.out.println("Rejected");
		else if (state.isHalt())
			System.out.println("Halted");
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		TuringMachine tm = new TuringMachine(in);
		tm.simulate(args[1]);
	}

}
