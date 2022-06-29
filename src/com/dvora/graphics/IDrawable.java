package graphics;

import java.awt.Graphics;

import diet.Omnivore;
/**
 * An interface that responsible for drawing objects
 *
 * @version 2.5  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see    Omnivore 
 */
public interface IDrawable {
	
	public final static String PICTURE_PATH = "images\\imgs\\";
	 /**
	    * A method that loads the image into the system
	    * 
	    * @param String nm ,Type String ,this is for loudImage.
	    * @returnThe method returns the uploaded image
	    *    
	    */
	public void loadImages(String nm);
	 /**
	    * The method paints the image uploaded to the system
	    * 
	    * @param String nm ,Type String ,this is for loudImage.
	    * @returnThe method returns the uploaded image
	    *    
	    */
	public void drawObject (Graphics g);

	 /**
	    *  
	    * the method is return color of the animal 
	    * @return the String color about animal.
	    *    
	    */
	public String getColor();
}
