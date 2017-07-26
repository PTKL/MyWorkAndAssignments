import java.util.HashMap;

/* Control unit of Turing machine.
 * 
 */

public class Control {
	private HashMap<String, State> states; // list of states
	private HashMap<String, Transition> transitions; // list of transitions
	private State state; // current state

	public Control() {
		states = new HashMap<String, State>();
		transitions = new HashMap<String, Transition>();
	}

	// get and set the current state
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	// add a state to the control unit
	public void addState(String name, String type) {
		State s = new State(name, type);
		states.put(name, s);
		if (state == null)
			state = s; // start state
	}

	// find and return state with given name
	private State findState(String name) {
		return states.get(name);
	}

	// add a transition
	public void addTransition(String f, String t, String read, String write) {
		State from = findState(f);
		State to = findState(t);
		Transition transition = new Transition(from, to, read, write);
		if (transitions.get(f + Transition.DELIMITER + read) != null)
			throw new RuntimeException("Nondeterministic Turing machine");
		transitions.put(f + Transition.DELIMITER + read, transition);
	}

	// Return appropriate transition, null if no matching transition
	public Transition getTransition(String read) {
		Transition t = transitions.get(state.getName() + Transition.DELIMITER
				+ read);
		return t;
	}

}
