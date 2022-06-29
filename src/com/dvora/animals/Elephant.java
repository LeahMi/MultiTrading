//Dvora Mizrachi Id: 207919341 
//Shilat Hakimi Id: 324026277
package animals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;

import diet.Herbivore;
import food.EFoodType;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;
/**
 *A Elephant class that inherits from a animal class builds a bear object for me
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see     Giraffe
 */
public class Elephant extends Animal{
	
	static final double min=0.5;
	static final double max=3;
	private double trunkLength=1;
	
	 /**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param name 
	    *        the name string to name of animal
	    *    
	    * @return The return value returned to me is a named Elephant object
	    *    
	    */
	public Elephant(String name) {
		super(name,new Point(50,90));
		MessageUtility.logConstractor("Elephant", name);
		setDiet(new Herbivore());
		setWeight(500);
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
    public Elephant ( String name,int size,String col,double weight, ZooPanel pan , Point location,String nm,int horSpeed,int verSpeed) {///////////////constractor for animal "addanimaldialog"
    	
		super(name,size,col,weight,pan,location,nm, horSpeed, verSpeed); 
		setDiet(new Herbivore());
    }
    /**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    *
	    * @param name: the name string to name of animal
	    * @param location : the location Point to location of animal 
	    *    
	    * @return The return value returned to me is a named and location Elephant object
	    *    
	    */
	public Elephant(String name,Point location) {
		super(name,location);
		MessageUtility.logConstractor("Elephant", name);
		setDiet(new Herbivore());
		setWeight(500);
	}
	/**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param name: the name string to name of animal 
	    * @param trunkLength: the trunkLength is double to trunkLength of animal 
	    * @return The return value returned to me is a named and trunkLength Elephant object
	    *    
	    */
	public Elephant(String name,double trunkLength) {
		super(name,new Point(50,90));
		MessageUtility.logConstractor("Elephant", name);
		setWeight(500);
		settrunkLength(trunkLength);
		setDiet(new Herbivore());
	}
	/**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param name: the name string to name of animal 
	    * @param   trunkLength: the trunkLength is double to trunkLength of animal 
	    * @param  location : the location Point to location of animal 
	    * @param  weight: the weight is double to weight of animal
	    * @return The return value returned to me is a named and trunkLength and location and weight Elephant object
	    *    
	    */
	public Elephant(String name,double trunkLength,Point location,double weight) {
		super(name,location);
		MessageUtility.logConstractor("Elephant", name);
		setWeight(weight);
		settrunkLength(trunkLength);
		setDiet(new Herbivore());
	}
	 /**
	    * A method that performs placement along the 
	    * elephant's trunk and returns me a true/ False 
	    * @param   weight
	    *        the  trunkLength double to  trunkLength of animal
	    *    
	    * @return The return value returned to me  true/ False  was successful
	    *    
	    */
//	public boolean setWeight(double weight) {
//		if(weight>500) {
//			super.setWeight(weight);
//			return true;
//		}
//		else {
//			super.setWeight(500);
//			return false;
//		}
//	}
	 /**
	    * A method that performs placement along the 
	    * elephant's trunk and returns me a true/ False 
	    * @param  trunkLength
	    *        the  trunkLength double to  trunkLength of animal
	    *    
	    * @return The return value returned to me  true/ False  was successful
	    *    
	    */
	public boolean settrunkLength(double trunkLength) {
		if(trunkLength<min || trunkLength>max) {
			MessageUtility.logSetter(getName(), "settrunkLength", trunkLength, false);
			return false;
		}
		else {
			this.trunkLength=trunkLength;
			MessageUtility.logSetter(getName(), "settrunkLength", trunkLength, true);
			return true;
		}
	}
	 /**
	    * A method that performs placement along the 
	    * elephant's trunk and returns me a true/ False 
	    * @param  trunkLength
	    *        the  trunkLength double to  trunkLength of animal
	    *    
	    * @return The return value returned to me the   trunkLength of animal
	    *    
	    */
	public double gettrunkLength() {
		MessageUtility.logGetter(getName(), "gettrunkLength", trunkLength);
		return trunkLength;
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
	    * @param object of the department-Elephant
	    *    
	    * @return Returns to me the bear chew and an appropriate message to that effect
	    *    
	    */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	



}
