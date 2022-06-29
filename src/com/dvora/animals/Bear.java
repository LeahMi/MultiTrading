//Dvora Mizrachi Id: 207919341 
//Shilat Hakimi Id: 324026277
package animals;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import diet.Omnivore;
import food.EFoodType;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

enum Color{BLACK, WHITE, GRAY}
/**
 *A bear class that inherits from a animal class builds a bear object for me
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see     Elephant
 */
public class Bear extends Animal{
	
	private String furColor =Color.GRAY.name();
	  /**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param name 
	    *        the name string to name of animal
	    *    
	    * @return The return value returned to me is a named bear object
	    *    
	    */
	public Bear(String name) {
		super(name,new Point(100,5));
		MessageUtility.logConstractor("Bear", name);
		setWeight(308.2);
		setFurColor(Color.GRAY.name());
		setDiet(new Omnivore());
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
    public Bear ( String name,int size,String col,double weight, ZooPanel pan , Point location,String nm,int horSpeed,int verSpeed) {///////////////constractor for animal "addanimaldialog"
    	
		super(name,size,col,weight,pan,location,nm, horSpeed, verSpeed);
		
		setDiet(new Omnivore());
    }
    /**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param name: the name string to name of animal
	    * @param color : the color string to color of animal 
	    *    
	    * @return The return value returned to me is a named and color bear object
	    *    
	    */

	public Bear(String name,String color) {
		super(name,new Point(100,5));
		MessageUtility.logConstractor("Bear", name);
		setWeight(308.2);
		setFurColor(color);
		setDiet(new Omnivore());
	}
	/**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param name: the name string to name of animal
	    * @param color : the color string to color of animal 
	    * @param  weight: the weight is double to weight of animal 
	    * @return The return value returned to me is a named and color bear object
	    *    
	    */
	public Bear(String name,String color,Point location,double weight) {
		super(name,location);
		MessageUtility.logConstractor("Bear", name);
		setWeight(weight);
		setFurColor(color);
		setDiet(new Omnivore());
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
//		if(weight>308.2) {
//			super.setWeight(weight);
//			return true;
//		}
//		else {
//			super.setWeight(308.2);
//			return false;
//		}
//	}
	  /**
	    * A method of the department that returns the color of the bear to me
	    * 
	    * @param object of the department
	    *    
	    * @return returns the color of the bear to me
	    *    
	    */
	public boolean setFurColor(String color) {
		if(color.equalsIgnoreCase(Color.BLACK.name()) || color.equalsIgnoreCase(Color.WHITE.name()) || color.equalsIgnoreCase(Color.GRAY.name()) ) {
			this.furColor = color.toUpperCase();
			MessageUtility.logSetter(getName(), "setFurColor", color, true);
			return true;
		}
		else {
			MessageUtility.logSetter(getName(), "setFurColor", color, false);
			return false;
		}
	}
	 /**
	    * A method of the department that returns the color of the bear to me
	    * 
	    * @param object of the department
	    *    
	    * @return returns the color of the bear to me
	    *    
	    */
	public String getFurColor() {
		MessageUtility.logGetter(getName(), "getFurColor", furColor);
		return furColor;
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
	 /**
	    * A method of the class which states 
	    * that the bear roars and its roar prints me an appropriate message
	    * 
	    * @param object of the department
	    *    
	    * @return Returns to me the bear roar and an appropriate message to that effect
	    *    
	    */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void roar() {
//		MessageUtility.logSound(this.getName(),"Stands on its hind legs, roars and scratches its belly");
//		
//	}



}
