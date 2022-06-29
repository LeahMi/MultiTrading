//Dvora Mizrachi Id: 207919341 
//Shilat Hakimi Id: 324026277
package animals;

import java.awt.Graphics;
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
 *A Giraffe class that inherits from a animal class builds a bear object for me
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see     Lion
 */
public class Giraffe extends Animal{

	static final int min=1;
	static final double max=2.5;
	private double neckLength=1.5;
	 /**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param name 
	    *        the name string to name of animal-Giraffe
	    *    
	    * @return The return value returned to me is a named Giraffe object
	    *    
	    */
	public Giraffe(String name) {
		super(name,new Point(50,0));
		MessageUtility.logConstractor("Giraffe", name);
		setWeight(450);
		setDiet(new Herbivore());
	}
	
//	public Giraffe(int size,String col) {///////////////constractor for animal "addanimaldialog"
//    	
//		  this.setSize(size);
//		  this.setCol(col);
//		  setWeight(408.2);
//		 
//	    }
	/**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    *
	    * @param name: the name string to name of animal
	    * @param location : the location Point to location of animal-Giraffe 
	    *    
	    * @return The return value returned to me is a named and location Giraffe object
	    *    
	    */
	public Giraffe(String name,Point location) {
		super(name,location);
		MessageUtility.logConstractor("Giraffe", name);
		setWeight(450);
		setDiet(new Herbivore());
	}
	/**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param name: the name string to name of animal 
	    * @param neckLength: the neckLength is double to neckLength of animal 
	    * @return The return value returned to me is a named and neckLength Giraffe object
	    *    
	    */
	public Giraffe(String name,double neckLength) {
		super(name,new Point(50,0));
		MessageUtility.logConstractor("Giraffe", name);
		setWeight(450);
		setNeckLength(neckLength);
		setDiet(new Herbivore());
	}
	/**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param name: the name string to name of animal 
	    * @param   neckLength: the neckLength is double to neckLength of animal 
	    * @param  location : the location Point to location of animal 
	    * @param   weight: the weight is double to weight of animal
	    * @return The return value returned to me is a named and trunkLength and location and weight Giraffe object
	    *    
	    */
	public Giraffe(String name,double neckLength,Point location,double weight) {
		super(name,location);
		MessageUtility.logConstractor("Giraffe", name);
		setWeight(weight);
		setNeckLength(neckLength);
		setDiet(new Herbivore());
	}
	 /**
	    * A function that receives the
	    *  weight of the animal and performs placement
	    * 
	    * @param weight 
	    *        The weight of the animal we want to indicate
	    *    
	    * @return the input value as a weight of the animal  double
	    *    
	    */
//	public boolean setWeight(double weight) {
//		if(weight>450) {
//			super.setWeight(weight);
//			return true;
//		}
//		else {
//			super.setWeight(450);
//			return false;
//		}
//	}
	 /**
	    * A method of the department that returns the neckLength of the Giraffe to me
	    * 
	    * @param object of the department
	    *    
	    * @return returns the neckLengthof the Giraffe to me
	    *    
	    */
	public boolean setNeckLength(double neckLength) {
		if(neckLength<min || neckLength>max) { 
			MessageUtility.logSetter(getName(), "setNeckLength", neckLength, false);
			return false;
		}
		else {
			this.neckLength=neckLength;
			MessageUtility.logSetter(getName(), "setNeckLength", neckLength, true);
			return true;
		}
	}
    public Giraffe ( String name,int size,String col,double weight, ZooPanel pan , Point location,String nm,int horSpeed,int verSpeed) {///////////////constractor for animal "addanimaldialog"
    	
		super(name,size,col,weight,pan,location,nm, horSpeed, verSpeed); 
		setDiet(new Herbivore());
    }
    /**
	    * A method of the department that returns the neckLength of the Giraffe to me
	    * 
	    * @param object of the department
	    *    
	    * @return returns the neckLengthof the Giraffe to me
	    *    
	    */
	public double getNeckLength() {
		MessageUtility.logGetter(getName(), "getNeckLength", neckLength);
		return neckLength;
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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	
}
