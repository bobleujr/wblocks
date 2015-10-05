package ia_projeto.ia_projeto;

public class BlocksState {
	private Block a, b, c;
	
	
	public Block aOn(){
		return a.getOn();
	}
	
	public Block bOn(){
		return b.getOn();
	}

	public Block cOn(){
		return c.getOn();
	}
	
	public void showBlocks(){
		System.out.println("[A] is on ["+a.getOn().getId()+"]");
		System.out.println("[B] is on ["+b.getOn().getId()+"]");
		System.out.println("[C] is on ["+c.getOn().getId()+"]");
	}
	
}



