package diet;

import animals.Animal;
import animals.Lion;
import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;
/**
 * An animal class that builds the template and 
 * fields that each class inherits from that class is abstract
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see     Carnivore
 */

public class Omnivore implements IDiet,AnimalFactory{
	private Animal animal;
	public Animal CreatAnimalFactory (String factor,int size,String col,double weight, ZooPanel pan , Point location,String nm,int horSpeed,int verSpeed) {
		if (factor== "Lion" ) 
	   		animal=new Lion(factor,size,col,size*0.8,pan ,location ,nm , horSpeed, verSpeed);
		return animal;
	}
		
	/**
	 * the function checks if the given food is allowed to the animal and if does it returns true
	 * else false.
	 * 
	 * @param food the food is from type EFoodType
	 * @return
	 */
	public boolean canEat(EFoodType food) {
		 synchronized(this) {
		if(food == EFoodType.NOTFOOD)
			return false;
		else 
			return true;
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
		if(this.canEat(food.getFoodtype())) {
			IDiet diet =null;
			if(food.getFoodtype()== EFoodType.MEAT)
				diet=new Carnivore();
			if(food.getFoodtype()== EFoodType.VEGETABLE)	
				diet=new Herbivore();
			return diet.eat(animal, food);
		}
		else
			return 0;
		 }
	}
	

}
