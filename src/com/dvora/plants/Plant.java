package plants;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import food.*;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.ILocatable;
import mobility.Point;
import utilities.MessageUtility;

/**
 *An the class that inherits from an animal class and implements a ILocatable and ILocatable and IDrawable
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see   Luttuce 
 */
public abstract class Plant implements IEdible, ILocatable , IDrawable{
	/**
	 * 
	 */
	private double height;
	private double width;
	private BufferedImage  img;

	private ZooPanel pan;
	private String name;////
	private Point location;
	
	/**
	  * 
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param nm 
	    *        the name string to loud imgs of animal
	    * @param pan ths panel type ZooPanel
	    * @return The return value returned to me is a named bear object
	    *    
	    */
	public Plant(String name,ZooPanel pan) {
		
		Random rand = new Random();
		int x = rand.nextInt(30);
		int y = rand.nextInt(12);
		this.location = new Point(pan.getWidth()/2,pan.getHeight()/2);
		this.height = rand.nextInt(30);
		this.width = rand.nextInt(12);
		this.pan = pan;
		this.name = name;
		loadImages( this.name);
		MessageUtility.logConstractor("Plant", "Plant");
	}
	/**
	  * 
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param nm 
	    *        the name string to loud imgs of animal
	
	    * @return The return value returned to me is a named bear object
	    *    
	    */
	
    public Plant( String name) {
		
		this.name=name;
		loadImages( this.name);
		
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
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGETABLE);
		return EFoodType.VEGETABLE;
	}

	  /**
	    * A method of the department that returns the Height of the food 
	    * 
	    
	    *    
	    * @return returns the Height of the img
	    *    
	    */
	public int getHeight() {
		return  (int) (height);
	}
	  /**
	    * A method of the department that returns the Width of the food 
	    *
	    * @return returns the Width of the img
	    *    
	    */
	public int getWidth() {
		return  (int) (width);
	}

	 /**
	    * A method of the department that returns the Location of the food
	    * 
	    
	    *    
	    * @return returns the Location of the food 
	    *    
	    */
	@Override
	public Point getLocation() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation", this.location);
		return this.location;
	}
	public ZooPanel getPan() {/////
		return pan;
	}
	 /**
	    * A method that loads the image into the system
	    * 
	    * @param String nm ,Type String ,this is for loudImage.
	    * @returnThe method returns the uploaded image
	    *    
	    */
	public void loadImages(String nm) {	
		
			try {img = ImageIO.read(new File(PICTURE_PATH+nm+".png"));
			System.out.println(nm+"planttttthhhhhh");
			setImg(img);}
			catch (IOException e) { System.out.println("Cannot load image"); }
		 }
		 
	 /**
	    * A method that loads the image into the system
	    * 
	    * @param String nm ,Type String ,this is for loudImage.
	    * @returnThe method returns the uploaded image
	    *    
	    */
	public void drawObject(Graphics g){
	     // Animal goes to the right side
			g.drawImage(img, getLocation().getx(), getLocation().gety(),getWidth()+18 ,getHeight()+20, pan);
	}		 

	/**
	    *  
	    *  the method  make set about image type BufferdImage . 
	    * @return  set the  image.
	    *    
	    */
	public void setImg (BufferedImage img) {
		this.img = img;
	}
	

	   /**
     * A function that receives the
     *  Location of the animal and performs placement
     * 
     * @param Location 
     *        The weight of the animal we want to indicate
     *    
     * @return the input value as a Location of the animal  
     *    
     */
	@Override
	public boolean setLocation(Point newLocation) {
		boolean isSuccess = Point.cheackBounderies(newLocation);
		if (isSuccess) {
			this.location = newLocation;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
		return isSuccess;
	}


	 /**
	    * A method of the class which prints to me the
	    *  object (animal) and its details
	    * @param object (animal)
	    * @return prints to me the
	    *  object (animal) and its details
	    *    
	    */
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] ";
	}

}
