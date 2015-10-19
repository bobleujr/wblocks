package ia_projeto.ia_projeto;

import java.util.ArrayList;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

/**
 * State class that has possible actions
 * @author Andre
 * @author Daniel
 * @author Paulo
 */
public class State {

	ArrayList<String> functions; //List of functions that describe this state
	ArrayList<Block> blocks;	 //List of blocks 
	ArrayList<Integer> freePos;	 //List of free positions
	
	//All positions actions to be take
	public Action MOVEA0 = new DynamicAction("MOVEA0");
	public Action MOVEA1 = new DynamicAction("MOVEA1");
	public Action MOVEA2 = new DynamicAction("MOVEA2");
	public Action MOVEA3 = new DynamicAction("MOVEA3");
	public Action MOVEB0 = new DynamicAction("MOVEB0");
	public Action MOVEB1 = new DynamicAction("MOVEB1");
	public Action MOVEB2 = new DynamicAction("MOVEB2");
	public Action MOVEB3 = new DynamicAction("MOVEB3");
	public Action MOVEC0 = new DynamicAction("MOVEA0");
	public Action MOVEC1 = new DynamicAction("MOVEC1");
	public Action MOVEC2 = new DynamicAction("MOVEC2");
	public Action MOVEC3 = new DynamicAction("MOVEC3");
	public Action MOVED0 = new DynamicAction("MOVED0");
	public Action MOVED1 = new DynamicAction("MOVED1");
	public Action MOVED2 = new DynamicAction("MOVED2");
	public Action MOVED3 = new DynamicAction("MOVED3");
	public Action MOVEAB = new DynamicAction("MOVEAB");
	public Action MOVEAC = new DynamicAction("MOVEAC");
	public Action MOVEAD = new DynamicAction("MOVEAD");
	public Action MOVEBA = new DynamicAction("MOVEBA");
	public Action MOVEBC = new DynamicAction("MOVEBC");
	public Action MOVEBD = new DynamicAction("MOVEBD");
	public Action MOVECA = new DynamicAction("MOVECA");
	public Action MOVECB = new DynamicAction("MOVECB");
	public Action MOVECD = new DynamicAction("MOVECD");
	public Action MOVEDA = new DynamicAction("MOVEDA");
	public Action MOVEDB = new DynamicAction("MOVEDB");
	public Action MOVEDC = new DynamicAction("MOVEDC");

	/**
	 * Constructor for a state
	 * @param functions List of functions that describe this state
	 */
	State(ArrayList<String> functions) {
		blocks = new ArrayList<Block>();
		freePos = new ArrayList<Integer>();
		this.functions = functions;
		for(String str : functions) {
			char[] array = str.toCharArray();
			//If function starts with 'O' (On(A,B), create a new block
			//and send this function as parameter for on
			if(array[0] == 'O') {
				char[] values = str.toCharArray();
				Block block = new Block(values[3], str);
				blocks.add(block);
			}
			//Otherwise set a new free position
			else {
				char[] values = str.toCharArray();
				freePos.add((int) values[6]);
			}
		}
	}
	
	/**
	 * Get functions
	 * @return List of functions
	 */
	public ArrayList<String> functions() {
		return this.functions;
	}
	
	/**
	 * Remove a functions from list
	 * @param function Function to be removed
	 */
	public void remove(String function) {
		int i;
		for(i = 0; i < this.functions.size(); i++) {
			if(this.functions.get(i).equals(function)) {
				break;
			}
		}
		this.functions.remove(i);
	}
	
	/**
	 * Add function to list
	 * @param function Function to be added
	 */
	public void add(String function) {
		this.functions.add(function);
	}
	
	/**
	 * Return true if a state is equal to this state
	 * @param state a state
	 * @return true of false
	 */
	public boolean isState(Object state) {
		State currentState = (State) state;
		for(String s : currentState.functions()) {
			if(!functions.contains(s)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Get block by id
	 * @param id block's id
	 * @return block
	 */
	public Block getBlock(char id) {
		for(Block b : blocks) {
			if(b.getId() == id) {
				return b;
			}
		}
		return null;
	}
	
	/**
	 * Print how is the state by its functions
	 */
	public void print() {
		for(String s : functions) {
			System.out.println(s);
		}
	}
	
}
