package ia_projeto.ia_projeto;

import java.util.ArrayList;

import aima.core.search.framework.GoalTest;

/**
 * Class has goal world state
 * @author Andre
 * @author Daniel
 * @author Paulo
 */
public class BlocksGoalTest extends State implements GoalTest{
	 

	/**
	 * Constructor for class GoalTest
	 * @param world Matrix of chars to show how the world is
	 * @param numberBlocks Store number of blocks in the world
	 * @param sizeTable Store size of table in number of positions
	 */
	BlocksGoalTest(char[][] world, int numberBlocks, int sizeTable, ArrayList<String> function) {
		super(world, numberBlocks, sizeTable, function); 
	} 

	/**
	 * Return true if the current world is equal to goal world
	 */
	public boolean isGoalState(Object currentState) {
		if(state().equals((World) currentState)) {
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * Prints the world
	 */
    protected void printState() {
    	for(int i = state.world().length - 1; i >= 0; i--) {
    		for(int j = 0; j < state.world()[i].length; j++) {
    			System.out.print(state.world()[i][j]);
    		}
    		System.out.println();
    	}
    	for(int i = 0; i < state.world()[0].length; i++) {
    		System.out.print('=');
    	}
    	System.out.println();
    	
    	for (String s : function) {
    		System.out.println(s);
    	}
    }


	

}
