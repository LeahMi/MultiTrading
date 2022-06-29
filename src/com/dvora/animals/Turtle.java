//Dvora Mizrachi Id: 207919341 
//Shilat Hakimi Id: 324026277
package animals;

import java.util.Observable;

import diet.Herbivore;
import food.EFoodType;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;
/**
 *A Turtle class that inherits from a animal class builds a bear object for me
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see   Lion 
 */
public class Turtle extends Animal{
	
	static final int min=0;
	static final double max=500;
	private int Age=1;
	 /**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param name 
	    *        the name string to name of animal-Turtle
	    *    
	    * @return The return value returned to me is a named Turtle object
	    *    
	    */
	public Turtle(String name) {
		super(name,new Point(80,0));
		MessageUtility.logConstractor("Turtle", name);
		setWeight(1);
		setDiet(new Herbivore());
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
    public Turtle ( String name,int size,String col,double weight, ZooPanel pan , Point location,String nm,int horSpeed,int verSpeed) {///////////////constractor for animal "addanimaldialog"
	    	
			super(name,size,col,weight,pan,location,nm, horSpeed,verSpeed); 
			setDiet(new Herbivore());
	    }
    /**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    *
	    * @param name: the name string to name of animal
	    * @param location : the location Point to location of animal-Turtle 
	    *    
	    * @return The return value returned to me is a named and location Turtle object
	    *    
	    */
	public Turtle(String name,Point location) {
		super(name,location);
		MessageUtility.logConstractor("Turtle", name);
		setWeight(1);
		setDiet(new Herbivore());
	}
	/**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    *
	    * @param name: the name string to name of animal
	    * @param  Age : the Age int  to Age of animal-Turtle 
	    *    
	    * @return The return value returned to me is a named and Age Turtle object
	    *    
	    */
	public Turtle(String name,int Age) {
		super(name,new Point(80,0));
		MessageUtility.logConstractor("Turtle", name);
		setWeight(1);
		setAge(Age);
		setDiet(new Herbivore());
	}
	/**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    *
	    * @param name: the name string to name of animal
	    *        location : the location Point to location of animal-Turtle 
	    *        Age : the Age int  to Age of animal-Turtle
	    *        weight: the weight is double to weight of animal
	    * @return The return value returned to me is a named and location  and age and weight Turtle object
	    *    
	    */
	public Turtle(String name,int Age, Point location, double weight) {
		super(name,location);
		MessageUtility.logConstractor("Turtle", name);
		setWeight(weight);
		setAge(Age);
		setDiet(new Herbivore());
	}
//	public boolean setWeight(double weight) {
//		if(weight>1) {
//			super.setWeight(weight);
//			return true;
//		}
//		else {
//			super.setWeight(1);
//			return false;
//		}
//	}
	/**
	    * A Boolean method of the class performs a placement
	    *  for the weight of a turtle and returns true or false whether successful or not
	    * @param  Age-
	    *        the Age int to  Age of animal-turtle
	    *    
	    * @return The return value returned to me  true/ False  was successful
	    *    
	    */
	public boolean setAge(int Age) {
		if(Age<min || Age>max) {
			MessageUtility.logSetter(getName(), "setAge", Age, false);
			return false;
		}
		else {
			this.Age=Age;
			MessageUtility.logSetter(getName(), "setAge", Age, true);
			return true;
		}
	}
	/**
	    * A class method that gives me Age of the turtle 
	    * 
	    * @param object of the department
	    *    
	    * @return returns the Age of the turtle 
	    *    
	    */
	public int getAge() {
		MessageUtility.logGetter(getName(), "setAge", Age);
		return Age;
	}
	/**
	    * A method of interface that returns the type of food the animal eats
	    * 
	    * @param object of the department
	    *    
	    * @return returns the type of food the animal eats
	    *    
	    */
	@Override
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(getName(), "getFoodtype", EFoodType.MEAT);
		return EFoodType.MEAT;
	}
	/** A method of the class which states 
	    * that the Elephant chews and its roar prints me an appropriate message
	    * 
	    * @param object of the department-turtle 
	    *    
	    * @return Returns to me the bear chew and an appropriate message to that effect
	    *    
	    */

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	

}
