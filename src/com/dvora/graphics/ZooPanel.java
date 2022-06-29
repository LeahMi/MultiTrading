package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import animals.Animal;
import animals.Bear;
import diet.Herbivore;
import food.EFoodType;
import graphics.ShowTable.Zoo;
import mobility.Point;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;
/**
 * An zoopanel class that builds the template and 
 * fields that each class inherits from JPanel
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see     FoodDialog 
*/
public class ZooPanel extends JPanel implements ActionListener,Runnable{

	private static CopyOnWriteArrayList<Animal> animals=new CopyOnWriteArrayList();
	private ZooFrame zoo;

	private JPanel panelButtons;
	private BufferedImage img;
	private JButton btnAdd = new JButton("Add Animal");
	//private	JButton btnMove = new JButton("Move Animal");
	private	JButton btnChange = new JButton("color change");
	private	JButton btnSave = new JButton("Save status");
	private	JButton btnRecovery = new JButton("Status recovery");
	private	JButton btnClear = new JButton("Clear");
	private JButton btnFood = new JButton("Food");
	private	JButton btnInfo = new JButton("Info");
	private	JButton btnExit = new JButton("Exit");
	private	JButton btnSleep = new JButton("Sleep");
	private	JButton btnWake = new JButton("Wake up");
	/////////
	private JButton carnivo = new JButton("Carnivor");
	private JButton herbivo = new JButton("Herbivor");
	private JButton omnivor= new JButton("Omnivore");
	private JButton add= new JButton("add");
	//////////
	private  boolean isclear = false;
	private FoodDialog food;
	private Cabbage cabbage = null;
	private Lettuce lettuce = null;
	private Meat meat = null;
	private Thread controller;
	private final static String PICTURE_PATH = "images\\imgs\\";
	private  boolean Suspended = false; 
	private Plant plant=null;
	private int  hspeed;
	private int vspeed;
	public static  String type;//
	public final static int Thread_count=10;
	public  static Executor poolExecutor =Executors.newFixedThreadPool(Thread_count);
	private static ZooPanel instance=null;
	
	public static synchronized ZooPanel getInstance() {
		System.out.println("Getting the Singelton");
		if (instance == null) {
			instance = new ZooPanel();}
		return instance;
	}
	 
	/**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    * 
	    *    
	    * @return The return value returned to me is a ZooPanel object
	    *    
	    */
	private  ZooPanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		this.setSize(800,600);
		this.setBackground(Color.white);
		this.controller = new Thread(this);
		controller.start();
		
		
		panelButtons = new JPanel();
		panelButtons.setBackground(Color.blue);
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.LINE_AXIS));
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 500;      //make this component tall
		c.weightx = 1.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;

		
		panelButtons.add(btnAdd);
		panelButtons.add(Box.createHorizontalGlue());
		panelButtons.add(btnChange);
		panelButtons.add(Box.createHorizontalGlue());
		panelButtons.add(btnSave);
		panelButtons.add(Box.createHorizontalGlue());
		panelButtons.add(btnRecovery);
		panelButtons.add(Box.createHorizontalGlue());
		panelButtons.add(btnSleep);
		panelButtons.add(Box.createHorizontalGlue());
		panelButtons.add(btnWake);
		panelButtons.add(Box.createHorizontalGlue());
		panelButtons.add(btnClear);
		panelButtons.add(Box.createHorizontalGlue());
		panelButtons.add(btnFood);
		panelButtons.add(Box.createHorizontalGlue());
		panelButtons.add(btnInfo);
		panelButtons.add(Box.createHorizontalGlue());
		panelButtons.add(btnExit);
		
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.weightx = 1.0;
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.insets = new Insets(10,0,0,0);  
		c.gridx = 1;       //aligned with button 2
		c.gridwidth = 2;   //2 columns wide
		c.gridy = 2;       //third row
		btnAdd .addActionListener(this);
		btnClear.addActionListener(this);
		btnChange.addActionListener(this);
		btnSave.addActionListener(this);
		btnRecovery.addActionListener(this);
		btnSleep.addActionListener(this);
		btnWake.addActionListener(this);
		btnFood.addActionListener(this);
		btnInfo.addActionListener(this);
		btnExit.addActionListener(this);
		
		
		add(panelButtons, c);
		

	}
	 /**
	    * Auxiliary function that 
	    * returns the arryAnimal of the animal.  
	    * @return returns the arryAnimal of the animal.
	    *    
	    */
	public static CopyOnWriteArrayList<Animal> getarryAnimal() {
		if(animals == null) {
			animals = new CopyOnWriteArrayList<Animal>();
			
		}
		return animals;
	}
	 /**
	    *A void function
	    * that checks my animal's food type
	    * 
	    * @param color 
	    *        the color of animal
	    *    
	    * @return return the  set color

	    *    
	    */
	public void setColorPanel(Color color) {
		img = null;
		this.setBackground(color);
		isclear = false;
		repaint();
	}
	
	 /**
	    * A method that loads the image into the system
	    * 
	    * @param String nm ,Type String ,this is for loudImage.
	    * @returnThe method returns the uploaded image
	    *    
	    */
	public void loadImage(String str) {
        
		try {img = ImageIO.read(ZooPanel.class.getResource(str));}
		catch (IOException e) { System.out.println("Cannot load image"); }
	}
	 /**
	    * A method that show the buttons on the panel 
	  
	    * @returnThe method returns the show
	    *    
	    */
	public void showButtons() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.weightx = 1.0;
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.insets = new Insets(10,0,0,0);  
		c.gridx = 1;       //aligned with button 2
		c.gridwidth = 2;   //2 columns wide
		c.gridy = 2;
		add(panelButtons, c);
	}
	 /**
	    *A  void function
	    * that checks my animal's food type
	    * 
	    * @param clear 
	    *        the clear is param boolean the give me massge 
	    *    
	    * @return return the color

	    *    
	    */
	public  void setIsclear( boolean clear) {
		this.isclear= clear;
	}
	 /**
	    A method that is responsible for drawing
	     me with the screen in accordance with the demanding requirements by operating it
	    *    
	    * @return return the drawing on the window

	    *    
	    */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gr = (Graphics2D) g;
	//	boolean chang;
		
		if (isclear == true) { 
			getpan().removeAll();
			showButtons();
		    }
		else {
		   if(img!=null) {
			 gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			 gr.drawImage(img,0,0,getWidth(),getHeight(),this);
		   }
		   if(animals!= null) {
			   for(Animal animal : animals) {
				   if (animal != null) {
			    	animal.drawObject(g);
				   }
			   }
		   }
		   if(plant != null){
			   plant.drawObject(g);
		   }

		   if(meat != null) {
			   meat.drawObject(g);
		   }
		  
		}
		
		
	}
	 /**
	    * the method return the panel 
	    * returns the panel on the frame .  
	    * @return panel.
	    *    
	    */
	public ZooPanel getpan() {
		return this;
	}
	 /**
	    *	This method is responsible for checking if the value is true 
	    *then it will draw the change on the screen
 
	    * @return repaint() is  call the paintComponent .
	    *    
	    */
	public  void manageZoo(){		

	        for (Animal animal : animals) { // going through the entire array
	        	
	        	 
	        	 
	
	            if (plant!=null && animal.getDiet().canEat(plant.getFoodtype()))
	            {
	                if(animal.getLocation().getx()>plant.getLocation().getx())
	                    animal.setx_dir(-1);
	                else
	                	animal.setx_dir(1);
	
	                if(animal.getLocation().gety()>plant.getLocation().gety())
	                	animal.sety_dir(-1);
	                else
	                	animal.sety_dir(1);
	
	                if(Math.abs(animal.getLocation().getx()-plant.getLocation().getx())<=animal.getHorSpeed() && animal.getHorSpeed()!=0)
	                {
	                    animal.setLocation(new Point(plant.getLocation().getx(),animal.getLocation().gety()));
	                    hspeed=animal.getHorSpeed();
	                    animal.setHorSpeed(0);
	                    
	                }
	
	                if(Math.abs(animal.getLocation().gety()-plant.getLocation().gety())<=animal.getVerSpeed()&&animal.getVerSpeed()!=0)
	                {
	                    animal.setLocation(new Point(animal.getLocation().getx(),plant.getLocation().gety()));
	                    vspeed=animal.getVerSpeed();
	                    animal.setVerSpeed(0);
	                }
	
	            }
	
	            if (meat!=null && animal.getDiet().canEat(meat.getFoodtype()))
	            {
	                if(animal.getLocation().getx()>meat.getLocation().getx())
	                    animal.setx_dir(-1);
	                else
	                    animal.setx_dir(1);
	
	                if(animal.getLocation().gety()>meat.getLocation().gety())
	                    animal.sety_dir(-1);
	                else
	                    animal.sety_dir(1);
	
	                if(Math.abs(animal.getLocation().getx()-meat.getLocation().getx())<=animal.getHorSpeed() && animal.getHorSpeed()!=0)
	                {
	                    animal.setLocation(new Point(meat.getLocation().getx(),animal.getLocation().gety()));
	
	                    hspeed=animal.getHorSpeed();
	
	                    animal.setHorSpeed(0);
	
	                }
	
	                if(Math.abs(animal.getLocation().gety()-meat.getLocation().gety())<=animal.getVerSpeed()&&animal.getVerSpeed()!=0)
	                {
	                    animal.setLocation(new Point(animal.getLocation().getx(),meat.getLocation().gety()));
	
	                    vspeed=animal.getVerSpeed();
	
	                    animal.setVerSpeed(0);
	                }
	
	            }
	            if(animal.getHorSpeed()==0 && plant==null && meat==null)
	                animal.setHorSpeed(hspeed);
	
	             if(animal.getVerSpeed()==0&&plant==null&&meat==null)
	                animal.setVerSpeed( vspeed); 
	        }
	        isChange();
	        repaint() ;
	       
	        
	   
	}
	 /**
	    *A method that is responsible for the link between the user and the system's 
	    *operations in that the system connects the operations 
	    *and runs the request accordingly 
	    * @param e from the system . 
	    * @return repaint() is  call the paintComponent .
	    *    
	    */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd) {
            JButton [] typeC= {carnivo,omnivor,herbivo};
			this.carnivo .addActionListener(this);
			this.omnivor.addActionListener(this);
			this.herbivo.addActionListener(this);
			if(animals == null)
				animals = new CopyOnWriteArrayList<Animal>();
			if (animals.size()<10) {
				AddAnimalDialog d = new AddAnimalDialog(zoo);
				isclear = false;
				repaint();
				if(animals!= null)
					manageZoo();
			}
			else {
				JOptionPane.showMessageDialog(null,"you cannot add more that 10 animal "," Massage",JOptionPane.PLAIN_MESSAGE);
			}
		}			 	
		if(e.getSource() == btnChange) {
			new ChangAnimalDialog();
			
			manageZoo();
			//repaint();
			
		}
		
		
		if(e.getSource() == btnSleep) {
			for(Animal animal:animals) {
				animal.setSuspended();
			}
			this.Suspended=true;
		}
		if(e.getSource() == btnWake) {
			for(Animal animal:animals) {
				animal.setResumed();/////
			}
		   this.Suspended=false;
		   for (Animal animal:animals ) {
			   if(this.Suspended==false) {
				   synchronized(animal) {
					   if(this.Suspended==false) {
						   animal.notify();
					   }
				   }
			   }
		   }
		}

		if(e.getSource() == btnClear) {
			 isclear = true;
			 plant = null;
//			 lettuce = null;
			 meat = null;
			 img = null;
			 for(Animal animal:animals) {
					//animal.getThread().stop();
				 // כאן נבצע מחיקה מהתור של הטרדים 
				}
			 animals = null;
			 repaint();
			 
			
		}
		if(e.getSource() == btnFood) {
			food= new FoodDialog(zoo);
			if (food.getPlantCabb()!=null) {
				this.isclear = false;
				plant = food.getPlantCabb();
//				lettuce = null;
				meat = null;
				repaint();
				manageZoo();
				
			}
		    if (food.getPlantLett()!=null) {
		    	this.isclear = false;
		    	plant = food.getPlantLett();
		    //	cabbage = null;
		    	meat = null;
				repaint();
				manageZoo();
			}
		    if(food.gatMeat() == true) {
		    	this.isclear = false;
		    	plant = null;
		    	meat =meat.getInstance("meat",this.getpan());
				repaint();
				manageZoo();
			}
		    
		}
		if(e.getSource() == btnInfo) {
			if(animals!= null) {
				Animal[] animalsArr = new Animal[animals.size()];
				int i=0;
				for(Animal animal:animals) {
					animalsArr[i] = animal;
					i++;
				}
				ShowTable window = new ShowTable(zoo,new Zoo(animalsArr));
			}else {
				JOptionPane.showMessageDialog(null,"No animals to show"," Massage",JOptionPane.PLAIN_MESSAGE);
			}
	    }
		if(e.getSource() == btnExit) {
			System.exit(0);
		}
	}
		
	

	 /**
	    *the method is set frame
	    * 
	    * @param zoo 
	    *        the zoo  us frame of ZOOFRAME 
	    *    
	    * @return return the  set color

	    *    
	    */
	public void setFrame(ZooFrame zoo) {
		this.zoo = zoo;
	}
	 /**
	    *This method checks me if there are any changes including whether an animal can 
	    *eat another must in order to know what to
	    * draw on the screen and what to do when changing
	    * 
	    * @return return param boolean 

	    *    
	    */  
	public boolean isChange() {
		
		if(animals != null) {
			   for(Animal animal : animals) {
				   ////
				   for(Animal animal2 : animals) {
					   
					   if( (animal!=animal2) && (animal.getDiet().canEat(animal2.getFoodtype()))) {
					    	if(animal.getWeight() >= (animal2.getWeight()*4)) {
					    		if (animal.calcDistance(animal2.getLocation())<animal2.getSize()) {
					    			System.out.printf("ggggggggg");
					    			animal.eat(animal2);
					    			animal.eatInc();
					    			animal.totalEatInc();
					    			animals.remove(animals.indexOf(animal2));
					    			JOptionPane.showMessageDialog(null,animal.getName() +" ate " + animal2.getName()," Massage",JOptionPane.PLAIN_MESSAGE);
					    			return true;
					    		}
					    	}
				      }
				   }
				   
				   if (plant!=null && (animal.calcDistance(plant.getLocation())<10)&& animal.getDiet().canEat(EFoodType.VEGETABLE )) {
					   animal.eat(plant);
					   animal.eatInc();
					   animal.totalEatInc();
					   plant=null;
					   return true;
				   }

				  if (meat != null && (animal.calcDistance(meat.getLocation())<10) && animal.getDiet().canEat(EFoodType.MEAT)) {
					  animal.eat(meat);
					  animal.eatInc();
					  animal.totalEatInc();
					  meat = null;
					  return true;
				  }
			   }
			}
			return false;
		
	}
	/**
	    *   
	    *  the method handles in the threads of animals, call to manageZoo() 
	    */
	@Override
	public void run() {
		
		while(animals!=null) {
			manageZoo();
			repaint();
			}
		
	}
	
}

