package graphics;

import diet.Omnivore;

/**
 * An interface that responsible for drawing objects
 *
 * @version 2.5  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see    Omnivore 
 */
public interface IAnimalBehavior {
	 /**
	    *  
	    *  the method is returns the name of animal 
	    * @return returns the name of animal.
	    *    
	    */
	public String getAnimalName();
	/**
	    *  
	    *  the method is returns the size of animal 
	    * @return returns the size of animal.
	    *    
	    */
	public int getSize();
	/**
	    *  
	    *  the method is counter eat the food's animal. 
	    * @return eat the food's animal.
	    *    
	    */
	public void eatInc();
	/**
	    *  
	    *  the method  return is counter eat the food's animal. 
	    * @return  return eat the food's animal.
	    *    
	    */
	public int getEatCount();
	/**
	    *  
	    *  the method  return value boolean if the animal make change. 
	    * @return   value boolean if the animal make change.
	    *    
	    */
	public boolean getChanges ();
	/**
	    *  
	    *  the method  make set value  if the animal make change. 
	    * @return  set the animal make change.
	    *    
	    */
	public void setChanges (boolean state);
	public void setSuspended();
	public void setResumed ();
	
}
