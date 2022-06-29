//Dvora Mizrachi Id: 207919341
// Shilat Hakimi Id : 324026277

package mobility;

import java.util.Observable;

/**
 * An abstract class that defines motion in space and implements the interface of location
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see     Point 
 */


public abstract class Mobile  extends Observable  implements ILocatable  {
	private Point location;
	private double totalDistance;
	public Mobile() {}
	 /**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param location 
	    *        the location Point to location of animal
	    *    
	    * @return The method returns to me the contractor that contains the location of the animal
	    *    
	    */
	public Mobile(Point location) {
		this.location=location;
		this.totalDistance=0;
	}
	 /**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param x- location of the animal On the X-axis
	    * @param  y- location of the animal On the Y-axis     
	    *    
	    * @return The method returns to me the contractor that contains the location of the animal
	    *    
	    */
	public Mobile(int x,int y) {
		this.location= new Point(x,y);
		this.totalDistance=0;
	}
	/**
	    * A class method that gives me Location of the animal
	    * 
	    * @param object of the department
	    *    
	    * @return returns the Location of the animal
	    *    
	    */
	public Point getLocation() {
		return location;
	}
	/**
	    * A class method that gives metotalDistance of the animal
	    * 
	    * @param object of the department
	    *    
	    * @return returns the totalDistance of the animal
	    *    
	    */
	public double getTotalDistance() {
		return totalDistance;
	}
	/**
	    * A Boolean method of the class performs a placement
	    *  for the Point of a animal and returns true or false whether successful or not
	    * @param  l-
	    *        the l Point to  location of animal
	    *    
	    * @return The return value returned to me  true/ False  was successful
	    *    
	    */
	public boolean setLocation(Point l){
		//if(l.getx()<0||l.gety()<0||l.getx()>800||l.gety()>600)
		if(!Point.cheackBounderies(l))
			return false;
		location=l;
		return true;
	}
	/**
	    * A method of class which gets the extra distance the
	    *  animal has to go and prints the new distance
	    * 
	    * @param d type of double and prints the new distance
	    *    
	    * @return returns the totalDistance prints the new distance
	    *    
	    */
	public void	addTotalDistance(double d) {
		totalDistance = totalDistance+d;
	}
	/**
	    * A method of the class that receives a point and calculates the distance of the 
	    * animal from its position to the point it received and returns the calculation
	    * 
	    * @param l -point the location type of Point .
	    *    
	    * @return returns the calculates the distance of the 
	    * animal from its position to the point it received and returns the calculation.
	    *    
	    */
	public double calcDistance(Point l){
		return Math.sqrt((location.getx()-l.getx())*(location.getx()-l.getx())+(location.gety()-l.gety())*(location.gety()-l.gety()));
	}
	/**
	    * A method of the class which gets the point and moves my animal to that point
	    * 
	    * @param l -point the location type of Point 
	    *    
	    * @return returns the totalDistance (double) prints the new distance
	    *    
	    */
	
	public double move(Point l){
		synchronized(this) {
		if (location.equals(l)==true || !Point.cheackBounderies(l) ) {
			return 0;
		}
		double d=this.calcDistance(l);
		addTotalDistance(d);
		setLocation(l);
		return d;
	} 
	
	}
}
