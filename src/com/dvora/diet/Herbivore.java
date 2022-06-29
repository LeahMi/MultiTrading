package diet;

import animals.Animal;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;
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
 * @see     Omnivore 
 */
public class Herbivore implements IDiet,AnimalFactory {
	private Animal animal;
	public Animal CreatAnimalFactory (String factor,int size,String col,double weight, ZooPanel pan , Point location,String nm,int horSpeed,int verSpeed) {
	    	switch(factor) {
      
   	  case "Bear":{
   		System.out.print("case Beer");
   		animal=new Bear(factor,size,col,size*1.5,pan ,location ,nm , horSpeed, verSpeed);
   		
   	    break;
   	}
   	 case "Giraffe":{
   		System.out.print("case Giraffe");
   		animal=new Giraffe(factor,size,col,size*2.2,pan,location,nm,horSpeed, verSpeed);
   	     
   	     break;
   	}
   	case "Elephant":{
   		System.out.print("case Elephant");
   		animal=new Elephant(factor,size,col,size*10,pan,location,nm,horSpeed, verSpeed);
   	     
   	     break;
   	}
   	case "Turtle":{
   		System.out.print("case Turtle");
   		animal=new Turtle(factor,size,col,size*0.5,pan,location,nm,horSpeed, verSpeed);
   	     
   	     break;
     	}
 	}
	   	return animal ;
}
	/**
	 * the function checks if the given food is allowed to the animal and if does it returns true
	 * else false.
	 * 
	 * @param food the food is from type EFoodType
	 * @return
	 */
	public Herbivore() {}
	public boolean canEat(EFoodType food) {
		 synchronized(this) {
		if(food==EFoodType.VEGETABLE)
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
		if(this.canEat(food.getFoodtype())) {
			return animal.getWeight()*0.07;
		}
		else
			return 0;
	}
	}
	
}