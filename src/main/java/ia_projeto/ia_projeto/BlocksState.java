package ia_projeto.ia_projeto;

import java.util.ArrayList;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

/**
 * Class has current world state and list of actions that can be done
 * @author Andre
 * @author Daniel
 * @author Paulo
 */
public class BlocksState extends State{
	
	public Action MOVEA0 = new DynamicAction("MOVEA0");
	public Action MOVEA1 = new DynamicAction("MOVEA1");
	public Action MOVEA2 = new DynamicAction("MOVEA2");
	public Action MOVEA3 = new DynamicAction("MOVEA3");
	public Action MOVEB0 = new DynamicAction("MOVEB0");
	public Action MOVEB1 = new DynamicAction("MOVEB1");
	public Action MOVEB2 = new DynamicAction("MOVEB2");
	public Action MOVEB3 = new DynamicAction("MOVEB3");
	public Action MOVEC0 = new DynamicAction("MOVEC0");
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
	 * Constructor for class BlockState
	 * @param world Matrix of chars to show how the world is
	 * @param numberBlocks Store number of blocks in the world
	 * @param sizeTable Store size of table in number of positions
	 */
    BlocksState(char[][] world, int numberBlocks, int sizeTable, ArrayList<String> function) {
		super(world, numberBlocks, sizeTable, function);
	} 	   

    /**
     * Print the world
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



