package ia_projeto.ia_projeto;

import java.awt.Color;
import java.awt.Shape;

/**
 * Item class to be implemented by block and table
 * @author Andre
 * @author Daniel
 * @author Paulo
 */
public class Item {
	
	Shape shape;
	Color color;
	Item on;
	int position;  			 //Block's position on table
	
	/**
	 * Constructor for item
	 * @param shape Shape of item (Rectangle or Line)
	 * @param under	Who is under the item (Block or Table)
	 * @param color Its color
	 * @param position Its position in table (-1 if it's the table)
	 */
	Item(Shape shape, Item under, Color color, int position) {
		this.shape = shape;
		this.on = under;
		this.color = color;
		this.position = position;
	}
	
	/**
	 * Get Shape
	 * @return Item's shape
	 */
	public Shape shape() {
		return this.shape;
	}
	
	/**
	 * Set Shape
	 * @param shape Shape of item (Rectangle or Line)
	 */
	public void shape(Shape shape) {
		this.shape = shape;  
	}
	
	/**
	 * Get who is under this item
	 * @return Item that is under
	 */
	public Item on() {
		return this.on;
	}
	
	/**
	 * Set who is under this item
	 * @param on Item that is under this item
	 */
	public void on(Item on) {
		this.on = on;
	}

	/**
	 * Get Item's color
	 * @return Color of this item (Block) 
	 */
	public Color color() {
		return this.color;
	}

	/**
	 * Get position
	 * @return position
	 */
	public int position() {
		return this.position;
	}
	
	/**
	 * Set new position
	 * @param position position in table
	 */
	public void position(int position) {
		this.position = position;
	}
}
