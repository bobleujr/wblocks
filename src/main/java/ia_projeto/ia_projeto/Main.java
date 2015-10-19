package ia_projeto.ia_projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.Problem;
import aima.core.search.framework.ResultFunction;
import aima.core.search.uninformed.DepthLimitedSearch;

public class Main {
	
	static State initial;
	static BlocksGoalTest goal;
	static ActionsFunction action;
	static ResultFunction result;
	static ArrayList<Action> plan;
	static boolean first, found;
	static int depth; 				
	static int limit = 4;				//Max depth to be looked
	
	/**
	 * Recursion function to create a graph and search best route
	 * @param state Current state in search
	 */
	public static void recursion(State state) {
		//If state is equal to initial and it is not the first run, 
		//return and remove last plan added into the plan's list
		if(state.isState(initial) && !first) {
			if(plan.size() > 0) plan.remove(plan.size() - 1);
			return;
		}
		//If state is equal to goal, return and set found
		//variable true
		else if(goal.isGoalState(state)) {
			found = true;
			return; 
		}
		//If first is true, set is false
		if(first) first = !first;
		//Get possible actions for current state
		Set<Action> actions = action.actions(state);
		//Increment depth
		depth++;
		//If depth is equal limit, return, remove last plan
		//added into plan's list and decrement depth
		if(depth == limit) {
			if(plan.size() > 0) plan.remove(plan.size() - 1);
			depth--;
			return;
		}
		//For each action in action's list, generate a new state,
		//added the action taken to plan's list, and send
		//new state to function
		for(Action act : actions) {
			if(found) return;
			State newState = (State) result.result(state, (Action) act);
			plan.add(act);
			recursion(newState);
		}
		//If it is end of siblings, remove last plan added into plan's list
		//decrement depth, and return to parent node
		if(plan.size() > 0) plan.remove(plan.size() - 1);
		depth--;
	}
	
	/**
	 * Main function (the running starts here)
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		
		//List of functions of initial state
		ArrayList<String> stateFunctions = new ArrayList<String>();
		stateFunctions.add("On(A,0)");
		stateFunctions.add("On(B,1)");
		stateFunctions.add("On(C,D)");
		stateFunctions.add("On(D,3)");
		stateFunctions.add("Clear(A)");
		stateFunctions.add("Clear(B)");
		stateFunctions.add("Clear(C)");
		stateFunctions.add("Clear(2)");
		
		//Create initial state
		initial = new State(stateFunctions);
		
		//List of functions of goal state
		ArrayList<String> goalFunctions = new ArrayList<String>();
		goalFunctions.add("On(A,2)");
		goalFunctions.add("On(D,3)");
		goalFunctions.add("On(C,1)");
		goalFunctions.add("On(B,0)");
		goalFunctions.add("Clear(A)");
		goalFunctions.add("Clear(B)");
		goalFunctions.add("Clear(C)");
		goalFunctions.add("Clear(D)");
		
		//Cretate goal state
		goal = new BlocksGoalTest(goalFunctions); 
		
		action = FunctionFactory.getActionsFunction();
		result = FunctionFactory.getResultFunction();
		//Create plan list
		plan = new ArrayList<Action>();
		first = true;	//Control variable for first run
		found = false;	//Set true when a plan has been found
		depth = 0;		//Initial graph's depth variable
		
		//Call recursion to find plan
		recursion(initial);
		
		//Print initial state
		initial.print();
		System.out.println();
		
		//Print actions taken 
		for(Action act : plan) {
			initial = (State) result.result(initial, (Action) act);
			System.out.println(act.toString());
		}
		
		//Print final state
		System.out.println();
		initial.print();	
	}
}
