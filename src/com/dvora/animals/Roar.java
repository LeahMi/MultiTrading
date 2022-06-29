//Dvora Mizrachi Id: 207919341 
//Shilat Hakimi Id: 324026277
package animals;


import graphics.ZooPanel;
import mobility.Point;
/**
 *An abstract class that inherits from an animal class and implements a roaring phenomenon
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see   Lion 
 */
public abstract class Roar extends Animal{
	public abstract void roar();
	public Roar(){}
	public Roar(String name,Point l) {
		super(name,l);
	}
	/**
	    *A method of the class which operates the method that
	    * specifies the sound of the animal after eating    
	    * @return the sound of the animal after eating
	    *    
	    */
	public void makeSound() {
		//Roar  לבדוק אם הוא מכיר את של של אריה
		roar();
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
	public Roar( String name,int size,String col,double weight, ZooPanel pan , Point location,String nm,int horSpeed,int verSpeed) {///////////////constractor for animal "addanimaldialog"
    	
		super(name,size,col,weight,pan,location,nm,horSpeed, verSpeed); 
    }
}
