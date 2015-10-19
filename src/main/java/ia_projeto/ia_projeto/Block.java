package ia_projeto.ia_projeto;

/**
 * Block class 
 * @author Andre
 * @author Daniel
 * @author Paulo
 */
public class Block {

	char id;	//ID for a block
	String on;	//String of who is under it (e.g: On(A,B)
	int pos;	//Its position on table
	
	/**
	 * Constructor for a block
	 * @param id Its ID
	 * @param on String of On action
	 */
	Block(char id, String on) {
		this.id = id;
		this.on = on;
	}

	/**
	 * Get ID
	 * @return Blocks' ID 
	 */
	public char getId() {
		return id;
	}

	/**
	 * Get on
	 * @return On action's string
	 */
	public String getOn() {
		return on;
	}
	
	/**
	 * Set on
	 * @param on String of On action
	 */
	public void setOn(String on) {
		this.on = on;
	}

	/**
	 * Get position
	 * @return Its position
	 */
	public int getPos() {
		return pos;
	}
	
	
	
}
