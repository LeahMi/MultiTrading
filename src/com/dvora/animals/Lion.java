//Dvora Mizrachi Id: 207919341 
//Shilat Hakimi Id: 324026277
package animals;

import java.util.Observable;
import java.util.Random;

import diet.Carnivore;
import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;
/**
 *A Lion class that inherits from a animal class builds a bear object for me
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see   Turtle
 */
public class Lion extends Animal{

	private int scarCount = 0;
	
	 /**
	    * This method is a constructor which 
	    * describes the parameters of the object
	    * @param name string  name to of  animal 
	    * @return An object that contains an animal and its name and location   
	    */
	public Lion(String name) {
		super(name,new Point(20,0));
		MessageUtility.logConstractor("Lion", name);
		setWeight(408.2);
		setDiet(new Carnivore());
	}
	
	 /**
	    * This method is a constructor which 
	    * describes the parameters of the object
	    * 
	    * @param name string  name to of  animal 
	    * @param location Point it is the location of the animal 
	    * @return An object that contains an animal and its name and location
	    */
	public Lion(String name,Point location) {
		super(name,location);
		MessageUtility.logConstractor("Lion", name);
		setWeight(408.2);
		setDiet(new Carnivore());
	}
	 /**
	    * This method is a constructor which 
	    * describes the parameters of the object
	    * 
	    * @param name string  name to of  animal 
	    * @param location Point it is the location of the animal 
	    * @param size ,the size of animal (pixel)
	    * @param col , the color for animal.
	    * @param weight ,the weight of animal .
	    * @param  pan type ZooPanel ,the panel that the animal will be painted on
	    * @param nm Type String ,this is for loudImage.
	    * @return An object that contains an animal and its name and location
	    *    
	    */
	public Lion( String name,int size,String col,double weight, ZooPanel pan , Point location,String nm,int horSpeed,int verSpeed) {///////////////constractor for animal "addanimaldialog"
    	
		super(name,size,col,weight,pan,location,nm, horSpeed, verSpeed); 
		setDiet(new Carnivore());
		
    }
	 /**
	    * This method is a constructor which 
	    * describes the parameters of the object
	    * 
	    * @param name string  name to of  animal 
	    * @param location Point it is the location of the animal 
	    * @param weight ,the weight of animal .
	    * @return An object that contains an animal and its name and location
	    *    
	    */
	public Lion(String name,Point location,double weight) {
		super(name,location);
		MessageUtility.logConstractor("Lion", name);
		setWeight(weight);
		setDiet(new Carnivore());
	}
//	public boolean setWeight(double weight) {
//		if(weight>408.2) {
//			super.setWeight(weight);
//			return true;
//		}
//		else {
//			super.setWeight(408.2);
//			return false;
//		}
//	}
	public int getscarCount() {
		MessageUtility.logGetter(getName(), "getscarCount", scarCount);
		return scarCount;
	}
	public boolean setscarCount(int scarCount) {
		if(scarCount>=0) {
			this.scarCount+=scarCount;
			MessageUtility.logSetter(getName(), "setScars", scarCount,true);
			return true;
		}else{
			MessageUtility.logSetter(getName(), "setScars", scarCount,false);
			return false;
		}
		
	}
	/**
	    * A method of interface that returns the type of food the animal eats
	    * 
	    * @param object of the department
	    *    
	    * @return returns the type of food the animal eats
	    *    
	    */
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(getName(), "getFoodtype", EFoodType.NOTFOOD);
		return EFoodType.NOTFOOD;
	}
	 /**
	    * A method of the class which states 
	    * that the bear roars and its roar prints me an appropriate message
	    * 
	    * @param object of the department
	    *    
	    * @return Returns to me the bear roar and an appropriate message to that effect
	    *    
	    */
//	public void roar() {
//		MessageUtility.logSound(this.getName(),"Roars, then stretches and shakes its mane");
//	}
	/**
	    * A method of the department that receives
	    *  food and checks whether the animal can eat the food and returns true or false
	    * 
	    * @param food-type food IEdible
	    *    
	    * @return Returns to me if can eat the food and returns true or false
	    *    
	    */
	@Override
	public boolean eat(IEdible food) {
		
		if(getDiet().canEat(food.getFoodtype())) {
			super.eat(food);
			Random rand =new Random();
			setscarCount(rand.nextInt(2));
			return true;
		}
		return false;
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}