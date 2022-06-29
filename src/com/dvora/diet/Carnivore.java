package diet;

import animals.Animal;
import animals.Bear;
import animals.Lion;
import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;

/**
 * A department that describes carnivores and implements the interface
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see     Omnivore 
 */

public class Carnivore implements IDiet,AnimalFactory {
	private Animal animal;
	public Animal CreatAnimalFactory (String factor,int size,String col,double weight, ZooPanel pan , Point location,String nm,int horSpeed,int verSpeed) {
		if (factor== "Lion" ) {
	   		animal=new Lion(factor,size,col,size*0.8,pan ,location ,nm , horSpeed, verSpeed);
		}
		else if(factor == "Bear") {
	   		animal=new Bear(factor,size,col,size*1.5,pan ,location ,nm , horSpeed, verSpeed);
		}
	 return animal;
	}
	public Carnivore() {}
	 /**
	    * A method of the class which states 
	    * that the bear roars and its roar prints me an appropriate message
	    * 
	    * @param object of the department
	    *    
	    * @return Returns to me the bear roar and an appropriate message to that effect
	    *    
	    */
	public void roar() {}
	/**
	 * the function checks if the given food is allowed to the animal and if does it returns true
	 * else false.
	 * 
	 * @param food the food is from type EFoodType
	 * @return
	 */
	public boolean canEat(EFoodType food) {
		 synchronized(this) {
		if(food==EFoodType.MEAT)
			return true;
		else 
			return false;
		 }
	}
	/**
	 * A method of the interface that accepts the 
	 * animal and the food and checks whether the animal can eat the food
	 * 
	 * @param food the food is from type EFoodType and animal
	 * @return If the animal eats the food then the function will return the weight it gained
	 */
	public double eat(Animal animal, IEdible food) {
		 synchronized(this) {
		if(canEat(food.getFoodtype())) {
			return animal.getWeight()*0.1;
		}
		else 
			return 0;
		 }
	}
}
