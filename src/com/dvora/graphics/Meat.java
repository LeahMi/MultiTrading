package graphics;

 import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import food.EFoodType;
import food.IEdible;
import mobility.ILocatable;
import mobility.Point;
import plants.Lettuce;

/**
 *A meat class  that will show me the meat on the system
 *
 * @version 2.5  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see   Luttuce 
 */
public class Meat implements IEdible, ILocatable , IDrawable{
	private BufferedImage  img;
	private Point location;
	private ZooPanel pan;
	private String name;
   private static Meat instance=null;
	
	public static synchronized Meat getInstance(String nm,ZooPanel pan) {
		System.out.println("Getting the Singelton");
		if (instance == null) {
			instance = new Meat( nm, pan);}
		return instance;
	}
	/**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param name 
	    *        the name string to loud imgs of animal
	    * @param pan ths panel type ZooPanel
	    * @return The return value returned to me is a named bear object
	    *    
	    */
	private Meat(String name,ZooPanel pan) {

		//this.location = new Point((pan.getWidth()/2)-30,(pan.getHeight()/2)-30);
		this.location = new Point(pan.getWidth()/2,pan.getHeight()/2);
		this.pan=pan;
		this.name=name;
		loadImages(this.name);
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
	    * A method that loads the image into the system
	    * 
	    * @param String nm ,Type String ,this is for loudImage.
	    * @returnThe method returns the uploaded image
	    *    
	    */
	@Override
	public void loadImages(String nm) {
		try {
			img = ImageIO.read(new File(PICTURE_PATH+nm+".gif"));
			System.out.println(nm+" planttttthhhhhh");
			setImg(img);
		}
		catch (IOException e) { System.out.println("Cannot load image"); }
		
	}
	/**
	    * The method paints the image uploaded to the system
	    * 
	    * @param String nm ,Type String ,this is for loudImage.
	    * @returnThe method returns the uploaded image
	    *    
	    */
	@Override
	public void drawObject(Graphics g) {
		g.drawImage(img, getLocation().getx(), getLocation().gety(),30,30, pan);
		
	}
	 /**
	    *  
	    * the method is return color of the  meat
	    * @return the String color about meat.
	    *    
	    */
	
	@Override
	public String getColor() {
		return null;
	}
	 /**
	    *  
	    * the method is return Location of the meat
	    * @return the String location of the meat.
	    *    
	    */
	@Override
	public Point getLocation() {
		return this.location;
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
	public boolean setLocation(Point l) {
		boolean isSuccess = Point.cheackBounderies(l);
		if (isSuccess) {
			this.location = l;
		}
		return isSuccess;
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
		return EFoodType.MEAT;
	}
}