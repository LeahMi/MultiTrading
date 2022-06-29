//Dvora Mizrachi Id: 207919341

package mobility;
/**
 * Interface that describes the functionality of a location
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see     Mobility
 */
public interface ILocatable {

	/**
	 * A function of the interface that returns the point that marks the position of the animal
	 * @return returns the point that marks the Location of the animal
	 */
	public Point getLocation();
	/**
	 *A function of the interface which performs placement to the location of 
	 *the animal and returns true Boolean value. Lie if the placement was successful
	 * @param l-  the Location of the animal from type Point
	 * @return returns true Boolean value. Lie if the placement was successful
	 */
	public boolean setLocation(Point l);
}
