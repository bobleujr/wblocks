package ia_projeto.ia_projeto;

import java.awt.geom.Rectangle2D;
import java.awt.Color;

/**
 * Block class stores its ID and creates a rectangle in space
 * @author Andre
 * @author Daniel
 * @author Paulo
 */
public class Block extends Item{
	
	private Rectangle2D.Double rect; //A 2D rectangle
	private char id;				 //ID for a block
	
	/**
	 * Constructor for a block
	 * @param color Its Color
	 * @param x Its X-position in space
	 * @param y Its Y-position in space
	 * @param width Its width
	 * @param height Its height
	 * @param under	Who is under it (block or table)
	 * @param id Its ID
	 * @param position Its position in table (-1 if it's the table)
	 */
	Block(Color color, double x, double y, int width, int height, Item under, char id, int position) {
		super(null, under, color, position);
		this.rect = new Rectangle2D.Double(x, y, width, height);
		this.id = id;
		super.shape(rect);
	}

	/**
	 * Get ID
	 * @return Blocks' ID 
	 */
	public char id() {
		return this.id;
	}	
}
