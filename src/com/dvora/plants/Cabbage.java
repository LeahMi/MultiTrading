package plants;

import java.io.IOException;

import javax.imageio.ImageIO;

import animals.Lion;
import graphics.ZooPanel;
import utilities.MessageUtility;

/**
 *An the class that inherits from an Plant class  and is  extends Plant
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see   Luttuce 
 */
public class Cabbage extends Plant {
   private static final String String = null;
	// private	Plant panel;
	private static Cabbage instance=null;
	
	public static synchronized Cabbage getInstance(String nm,ZooPanel pan) {
		System.out.println("Getting the Singelton");
		if (instance == null) {
			instance = new Cabbage( nm, pan);}
		return instance;
	}
	  /**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param nm 
	    *        the name string to loud imgs of animal
	    * @param pan ths panel type ZooPanel
	    * @return The return value returned to me is a named bear object
	    *    
	    */

	private Cabbage(String nm,ZooPanel pan) {
		//MessageUtility.logConstractor("Cabbage", "Cabbage");
		super(nm,pan);
		//panel.loadImages(nm);
		
	}
	 /**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    * @param nm 
	    *        the name string to loud imgs of animal
	    * @return The return value returned to me is a named bear object
	    *    
	    */
//	public Cabbage(String nm) {
//		//MessageUtility.logConstractor("Cabbage", "Cabbage");
//		super(nm);
//		//panel.loadImages(nm);
//		
//	}
	 /**
	    * the method return the color of cabbage 
	    * 
	    * @return The return value  color of cabbage 
	    *    
	    */
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
