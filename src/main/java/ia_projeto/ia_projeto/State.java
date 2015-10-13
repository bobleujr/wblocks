package ia_projeto.ia_projeto;

import java.util.ArrayList;

/**
 * State class to be extended for Current state and Goal state
 * @author Andre
 * @author Daniel
 * @author Paulo
 */
public class State {

	protected World state;					//A world state
	protected ArrayList<String> function;	//A list of functions that describe the world
	
	/**
	 * Constructor for class state
	 * @param world Matrix of chars to show how the world is
	 * @param numberBlocks Store number of blocks in the world
	 * @param sizeTable Store size of table in number of positions
	 */
	State(char[][] world, int numberBlocks, int sizeTable, ArrayList<String> function) {
		this.state = new World(world, numberBlocks, sizeTable);
		this.function = function;
	} 	
    
	/**
	 * Get state
	 * @return state
	 */
	protected World state() {
		return this.state;
	}
	
	/**
	 * Get function
	 * @return ArrayList of functions 
	 */
	protected ArrayList<String> function() {
		return this.function;
	}

	
}
