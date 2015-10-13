package ia_projeto.ia_projeto;

import java.util.ArrayList;
/**
 * Main Class that will start execution
 * @author Andre
 * @author Daniel
 * @author Paulo
 */
public class App {
	
	/**
	 * This class will create initial and goals char matrices
	 * as well as lists of functions that describes the states.
	 * With these informations, the class will create the initial
	 * and goal states.
	 */
    public static void main(String[] args)    {
    	char[][] mapState = {{' ','A',' ','B'},
							 {' ','C',' ','D'}};

    	char[][] mapGoal = {{' ','A',' ','B'},
    					 	{' ','D',' ','C'}};
    	
    	ArrayList<String> stateFunction, goalFunction;
    	stateFunction = new ArrayList<String>();
    	goalFunction = new ArrayList<String>();
    	
    	stateFunction.add("clear(0)");
    	stateFunction.add("on(A,table)");
    	stateFunction.add("on(C,A)");
    	stateFunction.add("clear(C)");
    	stateFunction.add("clear(2)");
    	stateFunction.add("on(B,table)");
    	stateFunction.add("on(D,B)");
    	stateFunction.add("clear(D)");
    	
    	goalFunction.add("clear(0)");
    	goalFunction.add("on(A,table)");
    	goalFunction.add("on(D,A)");
    	stateFunction.add("clear(D)");
    	goalFunction.add("clear(2)");
    	goalFunction.add("on(B,table)");
    	goalFunction.add("on(C,B)");
    	stateFunction.add("clear(C)");
    	
    	BlocksState state = new BlocksState(mapState, 4, 4, stateFunction);
        BlocksGoalTest goal = new BlocksGoalTest(mapGoal, 4, 4, goalFunction);
        
        state.printState();
        goal.printState();
        
    }
}
