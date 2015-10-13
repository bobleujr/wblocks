package ia_projeto.ia_projeto;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * World Class describes how the world is in that moment 
 * @author Andre
 * @author Daniel
 * @author Paulo
 */
public class World {
	
	private char[][] world; //Matrix with a visual of how the blocks are organized
	private Table table;	//The table where the blocks will be put on
	private Block[] blocks; //Array of blocks
	private Item[] top;		//Array of top items on table
	private Random random;	//Random variable
	
	/**
	 * Constructor for class world
	 * @param world Matrix of chars to show how the world is
	 * @param numberBlocks Store number of blocks in the world
	 * @param sizeTable Store size of table in number of positions
	 */
	World(char[][] world, int numberBlocks, int sizeTable) {
		this.random = new Random();
		this.world = world;
		this.top = new Item[sizeTable];
		this.blocks = new Block[numberBlocks];
		table = new Table(50, (sizeTable*100) - 50, (100*sizeTable) - 50, (sizeTable*100) - 50, null);
		createBlocks(sizeTable);
	}
	
	/**
	 * Get table
	 * @return table variale
	 */
	public Table table() {
		return this.table;
	}
	
	/**
	 * Get blocks array
	 * @return Array of blocks
	 */
	public Block[] blocks() {
		return this.blocks;
	}
	
	/**
	 * Get a block by its ID
	 * @param ID Block's ID
	 * @return Block or null
	 */
	public Block blocks(char ID) {
		for(Block b : blocks) {
			if(b.id() == ID) {
				return b;
			}
		}
		return null;
	}
	
	/**
	 * Get top items array
	 * @return Array of top items on table
	 */
	public Item[] top() {
		return this.top;
	}
	
	/**
	 * Based on world matrix, set position for each block in the table
	 * @param sizeTable Store size of table in number of positions
	 */
	private void createBlocks(int sizeTable) {
		int index = 0;
		for(int i = 0; i < this.world.length; i++) {
			for(int j = 0; j < this.world[i].length; j++) {
				if(i == 0) { 
					if(this.world[i][j] != ' ') {
						this.blocks[index] = new Block(getNewColor(), 100 + j*50, (100*sizeTable) - 100, 50, 50, this.table, this.world[i][j], j);
						this.top[j] = this.blocks[index];
						index++;
					}
					else {
						this.top[j] = this.table;
					}
				}
				else {
					if(this.world[i][j] != ' ') {
						Block under = null;
						for(int k = 0; k < index; k++) {
							if(this.blocks[k].id() == this.world[i-1][j]) {
								under = this.blocks[k];
								break;
							};
						}
						this.blocks[index] = new Block(getNewColor(), 100 + j*50, (100*sizeTable) - (100 + 50*i), 50, 50, under, this.world[i][j], j);
						this.top[j] = this.blocks[index];
						index++;
					}
					else {
						//DO NOTHING
					}
				}
			}
		}
	}
	
	/**
	 * Get a new color
	 * @return A new and unique random color
	 */
	private Color getNewColor() {
		ArrayList<Color> usedColors = new ArrayList<Color>();
		Color color;
		int multiplier, value;
		int[] rgb = new int[3];
		
		do {
			for(int i = 0; i < 3; i++) {
				multiplier = random.nextInt(5);
				value = random.nextInt(50);
				rgb[i] = value * multiplier;
			}	
			color = new Color(rgb[0],rgb[1],rgb[2]);
		}while(usedColors.contains(color));
		usedColors.add(color);
		return color;
	}
	
	/**
	 * Move a block 'b' from position 'x', to position 'y' in table
	 * @param b Block 
	 * @param x	index of position in table
	 * @param y index of position in table
	 */
	public void move(Block b, int x, int y) {
		if(clear(b) && clear(this.top[y])) {
			this.top[x] = b.on();
			b.on(this.top[y]);
			this.top[y] = b;
			b.position(y);
		}
	}
	
	/**
	 * Returns true or false if Item 'b' is on Item 'x'
	 * @param b Item (block) 
	 * @param x Item (block or table)
	 * @return true or false
	 */
	public boolean on(Item b, Item x) {
		if(b.on() == x) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true of false if Item 'b' has nothing on it
	 * @param b item (block or table)
	 * @return true or false
	 */
	private boolean clear(Item b) {
		if(b == this.table) {
			return true;
		}
		if(this.top[b.position] == b) {
			if(b.on() == this.table) {
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	/**
	 * Get world matrix
	 * @return matrix of char that describes the world
	 */
	public char[][] world() {
		return this.world;
	}
}
