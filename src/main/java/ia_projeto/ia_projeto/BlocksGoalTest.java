package ia_projeto.ia_projeto;

import java.util.ArrayList;
import java.util.Hashtable;

import aima.core.search.framework.GoalTest;

public class BlocksGoalTest implements GoalTest{

	ArrayList<String> functions;
	
	public BlocksGoalTest(ArrayList<String> functions) {
		this.functions = functions;
	}
	
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
