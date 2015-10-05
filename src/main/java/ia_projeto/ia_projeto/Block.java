package ia_projeto.ia_projeto;

public class Block {
	private char id;
	private Block on;
	private boolean clear;
	
	public Block(char id, Block on) {
		super();
		this.id = id;
		this.on = on;
	}
	
	public char getId() {
		return id;
	}
	public void setId(char id) {
		this.id = id;
	}
	public Block getOn() {
		return on;
	}
	public void setOn(Block on) {
		this.on = on;
	}

	public boolean isClear() {
		return clear;
	}

	public void setClear(boolean clear) {
		this.clear = clear;
	}
	
}
