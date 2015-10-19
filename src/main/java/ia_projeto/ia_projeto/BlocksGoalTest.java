package ia_projeto.ia_projeto;

import java.util.ArrayList;
import java.util.Hashtable;

import aima.core.search.framework.GoalTest;

/**
 * Class has goal world state
 * @author Andre
 * @author Daniel
 * @author Paulo
 */
public class BlocksGoalTest implements GoalTest{

	ArrayList<String> functions;
	
	/**
	 * Constructor for class GoalTest
	 * @param functions List of Actions that describes the world (e.g: On(A,table), Clear(B))
	 */
	public BlocksGoalTest(ArrayList<String> functions) {
		this.functions = functions;
	}
	
	/**
	 * Return true if the current world is equal to goal world
	 */
	public boolean isGoalState(Object state) {
		State currentState = (State) state;
		for(String s : currentState.functions()) {
			if(!functions.contains(s)) {
				return false;
			}
		}
		return true;
	}

}
