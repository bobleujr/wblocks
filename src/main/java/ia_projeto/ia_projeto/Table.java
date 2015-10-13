package ia_projeto.ia_projeto;

import java.awt.geom.Line2D;

/**
 * Table class stores creates a line in space
 * @author Andre
 * @author Daniel
 * @author Paulo
 */
public class Table extends Item{

	Line2D.Double line; //A 2D Line
	
	/** 
	 * Constructor for table
	 * @param x1 Its beginning X-position in space
	 * @param y1 Its beginning Y-position in space
	 * @param x2 Its ending X-position in space
	 * @param y2 Its ending Y-position in space
	 * @param under Who is under it (null)
	 */
	Table(double x1, double y1, double x2, double y2, Item under) {
		super(null, under, null,-1);
		this.line = new Line2D.Double(x1, y1, x2, y2);
		super.shape(this.line);
	}
}
