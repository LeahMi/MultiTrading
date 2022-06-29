//Dvora Mizrachi Id: 207919341
// Shilat Hakini Id:324026277
package mobility;

/**
 * An abstract class that defines motion in space and implements the interface of location
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see     Point 
 */
public class Point {
	static final int max_x=800;
	static final int max_y=600;
	private int x;
	private int y;
	 /**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	   * @param x- location of the animal On the X-axis
	    * @param  y- location of the animal On the Y-axis 
	    *    
	    * @return contractor who builds the object of the department
	    *    
	    */
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	/**
	    * A Boolean method of the class performs a placement
	    *  for the Point of a animal and returns true or false whether successful or not
	    * @param x- location of the animal On the X-axis
	    * @return returns true or false whether successful or not
	    */
	public boolean setx(int x) {
		if(check_x(x)) {
			this.x=x;
			return true;
		}
		return false;
	}
	/**
	    * A Boolean method of the class performs a placement
	    *  for the Point of a animal and returns true or false whether successful or not
	    * @param  y- location of the animal On the Y-axis 
	    * @return returns true or false whether successful or not
	    */
	public boolean sety(int y) {
		if(check_y(y)) {
			this.y=y;
			return true;
		}
		return false;
	}
	/**
	    * A class method that gives X location of the animal On the X-axis 
	    * 
	    * @param object of the department
	    *    
	    * @return returns the Y of the animal
	    *    
	    */
	public int getx() {
		return x;
	}
	/**
	    * A class method that gives Y location of the animal On the Y-axis 
	    * 
	    * @param object of the department
	    *    
	    * @return returns the Y of the animal
	    *    
	    */
	public int gety() {
		return y;
	}
	/**
	    * A method of the department that receives a point and checks me
	    *  if the point is indeed in the right ranges and returns me a true Boolean value.
	    * @param pointToCheck- location of the animal 
	    * @return returns true or false if location is true /false 
	    */
	public static boolean cheackBounderies(Point pointToCheck) {
		if(!check_x(pointToCheck.getx()) )
			return false;
		else {
			if(!check_y(pointToCheck.gety()) )
				return false;
			else
				return true;
		}
	}
	/**
	    * A method of the department that receives a point and checks me
	    *  if the point is indeed in the right ranges and returns me a true Boolean value.
	    * @param x- location of the animal On the X-axis
	    *  @return returns true or false if location is true /false 
	    */
	public static boolean check_x(int x) {
		if(x<0 || x>max_x )
			return false;
		else
			return true;
	}
	/**
	    * A method of the department that receives a point and checks me
	    *  if the point is indeed in the right ranges and returns me a true Boolean value.
	    * @param y- location of the animal On the Y-axis
	    *  @return returns true or false if location is true /false 
	    */
	public static boolean check_y(int y) {
		if(y<0 || y>max_y )
			return false;
		else
			return true;
	}
}
