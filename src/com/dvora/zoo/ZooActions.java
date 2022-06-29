//Dvora Mizrachi Id: 207919341 
//Shilat Hakimi Id: 324026277
package zoo;


import java.util.Random;
import java.util.Scanner;

import animals.Animal;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;
/**
* A first class that contains the static methods
*
* @version 3.4  April 2022
* @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
* @see     Point 
*/
public class ZooActions {
	
	private static Animal[] animals;
	private static Scanner input;
	 /**
 *A main method that contains all the auxiliary methods that perform the main process for me
 * 
 * @param args 
 *        the argument string of  the animal
 *    
 * @return The return value the main process for me
 *    
 */
	public static void main(String[] args) {
		input = new Scanner(System.in);
		init();
		moveAll();
		printAll();
		feed();
		printAll();
		input.close();
	}
	/**
	  * A method of the department that receives an animal 
	  * and checks what kind of animal it is and returns its type   
	  * @param animal
	  * @return returns it type of animal 
	  *    
	  */
	public static Animal getType(Object animal) {
		
		if(animal instanceof Lion) 
			return (Lion)animal;
		
		if(animal instanceof Bear)
			return (Bear)animal;
			
		if(animal instanceof Elephant) 
			return (Elephant)animal;
				
		if(animal instanceof Turtle) 
			return (Turtle)animal;
				
		if(animal instanceof Giraffe) 
			return (Giraffe)animal;
		
		return null;	
	}
	/**
	 * A method of the interface that accepts the 
	 * animal and the food and checks whether the animal can eat the food
	 * 
	 * @param animal the food is from type EFoodType and animal
	 * @param  food  is from type EFoodType and animal
	 * @return If the animal eats the food then the function will return the weight it gained
	 */
	public static boolean eat(Object animal, IEdible food) {
		
		if(getType(animal)!=null) {
			if(animal == food) {
				MessageUtility.logBooleanFunction(((Animal) animal).getName(), "eat","["+food.getClass().getSimpleName()+"]"+((Animal)food).getName(), false);
				return false;
			}
			boolean isEaten =((Animal) animal).eat(food);
			if(isEaten) {
				MessageUtility.logBooleanFunction(((Animal) animal).getName(), "eat","["+food.getClass().getSimpleName()+"]"+((Animal)food).getName(), true);
				return true;
			}
		}	
		MessageUtility.logBooleanFunction(((Animal) animal).getName(), "eat","["+food.getClass().getSimpleName()+"]"+((Animal)food).getName(), false);
		return false;
	}
	/**
  * A method of the class which gets the point and  animal and moves my animal to that point
  * 
  * @param point-point the location type of Point 
  *  @param animal-animal  type of Object   
  * @return returns the totalDistance (double) prints the new distance
  *    
  */
	public static boolean move(Object animal, Point point) {
		if(animal instanceof Animal) {
			if(Point.cheackBounderies(point)) {
				((Animal) animal).move(point);
				MessageUtility.logBooleanFunction(((Animal)animal).getName(), "move", point.getx()+","+point.gety(), true);
				return true;
			}else
			MessageUtility.logBooleanFunction(((Animal)animal).getName(), "move", point.getx()+","+point.gety(), false);
		}
		MessageUtility.logBooleanFunction(((Animal)animal).getName(), "move",  point.getx()+","+point.gety(), false);
		return false;
	}
	
	/**
  * A method of the department that builds the array 
  * of animals and prints the details of the array   
  * @return returns the prints me the array of animals with their details
  *    
  */
	private static void init() {
		System.out.println("********************************************");
		System.out.println("\t\tInitilize");
		System.out.println("********************************************");

		//Scanner input;
		int size;
		System.out.print("Please enter number of animals: ");
		//input = new Scanner(System.in);
		do {
			size=input.nextInt();
		}while(size<3);
		animals = new Animal[size];
		int type;
		String name, color;
		
		
		double weight, length;
		int x, y, age;
		Point location;
		for(int i=0; i<size; ++i ) {
			System.out.println("What kind of animal are you interested in?");
			System.out.println("Choose an animal:\n"
					+ "1) Lion\n"
					+ "2) Bear\n"
					+ "3) Elephant\n"
					+ "4) Giraffe\n"
					+ "5) Turtle\n");
			do {
				type = input.nextInt();
			}while(type<1 || type>5);
			System.out.println("Enter the animal details:");
			System.out.print("Name: ");
			input.nextLine();
			name = input.nextLine();
			System.out.print("Weight : ");
			do {
				weight = input.nextDouble();
			}while(weight <=0);
			System.out.print("Enter a location: ");
			do {
				System.out.print("x: ");
				x = input.nextInt();
				System.out.print("y: ");
				y = input.nextInt();
			}while(!(Point.check_x(x)) || !(Point.check_y(y)));
			location = new Point(x,y);
			switch(type) {
				case 1:
					animals[i] = new Lion(name,location,weight);
					break;
				case 2:
					System.out.print("Enter furColor: ");
					input.nextLine();
					color = input.nextLine();
					animals[i] = new Bear(name,color,location,weight); 
					break;
				case 3:
					System.out.print("Enter trunkLength: ");
					do {
						length = input.nextDouble();
					}while(length<=0);
					animals[i] = new Elephant(name,length,location,weight);
					break;
				case 4:
					System.out.print("Enter trunkLength: ");
					do {
						length = input.nextDouble();
					}while(length<=0);
					animals[i] = new Giraffe(name,length,location,weight);
					break;
				case 5:
					System.out.print("Enter age: ");
					do {
						age = input.nextInt();
					}while(age<0);
					animals[i] = new Turtle(name,age,location,weight);
					break;
				}
		}
		//input.close();
	}
	/**
	  * A method of the class which moves all the animals in an array and prints   
	  * @param input 
	  * @return returns the animals in an array and prints
	  *    
	  */
	public static void moveAll() {
		System.out.println("********************************************");
		System.out.println("\t\tMove");
		System.out.println("********************************************");

		int x,y;
		Point location;
		
		
		for (Animal animal : animals) {
			System.out.println("Enter a point for move");
			System.out.println("x: ");
			x = input.nextInt();
			System.out.print("y: ");
			y = input.nextInt();
			location = new Point(x,y);
			move(animal,location);
		}

	}
	/**
  * An auxiliary method we added to see that it prints 
  * us all the parameters of the array of our animals   
  * @return returns the animals in an array and prints
  *    
  */
	public static void printAll() {
		System.out.println("********************************************");
		System.out.println("\t\tPrint");
		System.out.println("********************************************");
		
		for(int i=0; i<(animals.length) ;++i) {
			if(animals[i]!=null)
				System.out.println(animals[i].toString());
			else
				System.out.println("null");
		}
	}
	
	/**
	    * A method of the department that raffles a food animal and checks whether the animal
	    *  can eat the food that has been drawn if it is an animal from the array.
	    * @return returns the  back the prints of eating for the array of animals there are
	    *    
	    */
	public static void feed() {
		System.out.println("********************************************");
		System.out.println("\t\tFeed");
		System.out.println("********************************************");
	
		int rnd1,rnd2;
		int size=(animals.length)/2;
		boolean isEaten;
		for(int i=0; i<size ;++i) {
			do {
				rnd1 = new Random().nextInt(animals.length);
				rnd2 = new Random().nextInt(animals.length);
			}while(animals[rnd1]==null || animals[rnd2]==null);
			
			isEaten = eat(animals[rnd1],animals[rnd2]);
			if(isEaten == true)
				animals[rnd2] = null;		
		}
	}


}
