package diet;

import animals.Animal;
import food.*;
/**
 * An interface that describes the functionality of eating
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see    Omnivore 
 */
public interface IDiet {
	/**
	 * the function checks if the given food is allowed to the animal and if does it returns true
	 * else false.
	 * 
	 * @param food the food is from type EFoodType
	 * @return
	 */
	public boolean canEat(EFoodType food);
	/**
	 * A method of the interface that accepts the 
	 * animal and the food and checks whether the animal can eat the food
	 * 
	 * @param food the food is from type EFoodType and animal
	 * @return If the animal eats the food then the function will return the weight it gained
	 */
	public double eat(Animal animal, IEdible food);
}
