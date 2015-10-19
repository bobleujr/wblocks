package ia_projeto.ia_projeto;

public class Block {

	char id;
	String on;
	int pos;
	
	Block(char id, String on) {
		this.id = id;
		this.on = on;
	}

	public char getId() {
		return id;
	}

	public String getOn() {
		return on;
	}
	
	public void setOn(String on) {
		this.on = on;
	}

	public int getPos() {
		return pos;
	}
	
	
	
}
