package graphics;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.swing.*;

import animals.Animal;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;
//import diet.ActionEvent;
//import diet.ActionListener;
//import diet.DefaultComboBoxModel;
import diet.SampleAbstractFactory;
import mobility.Point;
/**
 * An AddAnimalDialog  class that builds the panel about the Move animal and 
 * fields that each class inherits from JFrame
 *
 * @version 3.5  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see    FoodDialoge
*/
public class AddAnimalDialog extends JDialog implements ActionListener  {
 
	private JPanel pan=new JPanel();
	private JLabel lb0=new JLabel("Please tap the kind:");/////4
	private JLabel lb1=new JLabel("Please tap the animal you want:");
	private JLabel lb3=new JLabel("Please tap the animal size you want [50-300 pixels]:");
	private JLabel lb2=new JLabel("Please tap the color of the animal as you wish:");
	private JLabel lb4=new JLabel("Enter Horizontal Speed [0-10]");
	private JLabel lb5=new JLabel("Insert Vertical Speed [0-10]");
	private Scanner sc=new Scanner(System.in);
	private JTextField txt1=new JTextField();
	private JTextField txt2=new JTextField();
	private JTextField txt3=new JTextField();
	private JTextField txt4=new JTextField();
	private JTextField txt5=new JTextField();
	private JButton submit=new JButton("Add Animal");
	String sizeText;
	String colorText;
	int co=1;
	/////4
	 private String [] kindAnimal = {"Carnivore"," Herbivore","Omnivore"}; 
	private JComboBox  kindA=new JComboBox(kindAnimal); 
	public    String [] type_herbivore = {"Giraffe","Elephant","Turtle"}; 
	public String [] type_carnivor= {"Lion"}; 
	public  String [] type_omnivore= {"Bear"}; 
	private	JComboBox typeA=new JComboBox(type_carnivor);////type of animal 
	///4
	
	
	
	
	
	private  String [] colors = {"Red","Blue","Netural"};
    private JComboBox cb2=new JComboBox(colors);//colors Box
    private Animal animal;
	private Point location;
	private ZooFrame frame;	
	private static int counter=0;
	private JLabel message;
	
	public final static int Thread_count=10; 
	 public  static Executor poolExecutor =Executors.newFixedThreadPool(Thread_count); 
	 private SampleAbstractFactory sample; 
	 public static String str ;
	 //AnimalFactory animalFactor; 

	
	/**
	 * @param pen 
	 * 
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	 /**
	    * This method is a constructor which 
	    * describes the parameters of the object 
	    * @param frame is the type frame 
	    * @return An object that contains an animal move.
	    *    
	    */
	public AddAnimalDialog(ZooFrame frame)
	{
		super(frame, true);
		this.frame=frame;
		this.setPreferredSize(new Dimension(550,300));
		lb3.setFont(new Font(Font.SANS_SERIF,Font.BOLD,12));
		lb3.setForeground(Color.red);
//		this. str=JOptionPane.showInputDialog(this, "Please choose type of Animal: Omnivor,erbivore ,carnvore", " Massage",JOptionPane.PLAIN_MESSAGE);
//		System.out.print("hhhhhhhhhhhh"+str);
		//JComboBox typeA=new JComboBox();////type of animal
//		     if (str== "Carnivore") { 
//		    	    typeA = new JComboBox(type_carnivor); 
// 		     } 
// 		     else if (str == " Omnivore") { 
// 		    	 typeA = new JComboBox (type_omnivore); 
// 		     } 
// 		     else { 
// 		    	 typeA = new JComboBox (type_herbivore); 
// 		      } 
		this.setBounds(50, 300,10 ,10);
		this.setLayout(new GridLayout(7,2));
		lb1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,12));
		lb1.setForeground(Color.orange);
		this .add(lb0);//4
		this.add(kindA );
    	this .add(lb1);
		this.add(typeA );
		lb2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,12));
		lb2.setForeground(Color.pink);
    	this .add(lb2);
		this.add(cb2);
        this .add(lb3);
        txt1.setPreferredSize(new Dimension(200,40));
        this.add(txt1);
    //    kindA .addActionListener(this);
        kindA.addActionListener(this); 
        	//private JComboBox typeA;

//			public void actionPerformed(ActionEvent e)
        	{
//        	    if (e.getSource()== kindA) { 
//				        		     typeA = new JComboBox(type_carnivor); 
//				        		     } 
//				        		     else if (e.getSource() == " Omnivore") { 
//				        		     typeA = new JComboBox (type_omnivore); 
//				        		     } 
//				        		     else { 
//				        		    typeA = new JComboBox (type_herbivore); 
//				        		      } 
//        			 
//        			 
//    			
//    		}
//        });/////////4
                   
//        
//        comboBox_2.addActionListener(new ActionListener() {
//    		public void actionPerformed(ActionEvent e) {
//    			factorAnimal=attributeFactory.createFactory(comboBox_2.getSelectedItem().toString());
//    			comboBox.setModel(new DefaultComboBoxModel(factorAnimal.arrAnimal()));	
//    		}
//    	});
//    	
        
        
        
        
        submit.addActionListener(this);
        txt2.setPreferredSize(new Dimension(200,40));
        txt3.setPreferredSize(new Dimension(200,40));
        this .add(lb4);
        this.add(txt2);
        this .add(lb5);
        this .add(txt3);
        this.add(submit);
        message = new JLabel("the jjjjjjj");
        message.setForeground(Color.RED);
      	message.setVisible(false);
      	this.add(message);
	    this.pack();
	    this.setVisible(true);
        	}
		   
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
		  
		 String type;
		 String color;
		 String kind;
		 kind = (String)kindA.getSelectedItem();
		 type = (String)typeA.getSelectedItem();////typeAnimal 
		 color = (String)cb2.getSelectedItem();
		 
		 
		 //System.out.print("gggggggggggggggggggggggggggggggggggggggggggggggggg"); 
//	     if ( e.getSource()==kindA) { 
//	    	if (kind) 
//	      typeA = new JComboBox(type_carnivor); 
//	     } 
//	     else if (e.getSource()== kindA) { 
//	     typeA= new JComboBox (type_omnivore); 
//	     } 
//	     else { 
//	     typeA = new JComboBox (type_herbivore); 
//	      } 
		 
		 
		 
	
		 int size2=0;
		 if (e.getSource()==submit) {
		     try {
		         size2 = Integer.parseInt(txt1.getText()) ;
		         int hor=Integer.parseInt(txt2.getText()) ;
		         int ver=Integer.parseInt(txt3.getText()) ;
		            if((hor>=1 && hor<=10)&&(ver>=1 && ver<=10)&& (size2>=50 && size2<=300)) {
		 		    	switch(type) {
		 		    	 case "Lion":{ 
		 	                 System.out.print("case Lion"); 
		 	                 animal= sample.creatFactor(kind). CreatAnimalFactory(type, size2, color,size2, frame.getZooPanel(),new Point(50,90),"lio" ,hor,ver); 
		 	 
		 	                    poolExecutor.execute(animal); 
		 	                   frame.getZooPanel().getarryAnimal().add(animal); 
		 	                  Controller controller= new Controller();
		 	                  animal.addObserver(controller);
		 	                   
		 	                     break; 
		 	                 } 
		 	                  case "Bear":{ 
		 	                 System.out.print("case Beer"); 
		 	                 animal= sample.creatFactor(kind). CreatAnimalFactory(type, size2, color,size2, frame.getZooPanel(),new Point(50,90),"bea" ,hor,ver); 
		 	 
		 	                    poolExecutor.execute(animal); 
		 	                   frame.getZooPanel().getarryAnimal().add(animal);
		 	                  Controller controller= new Controller();
		 	                  animal.addObserver(controller);
		 	                     break; 
		 	                } 
		 	                 case "Giraffe":{ 
		 	                 System.out.print("case Giraffe"); 
		 	                 animal= sample.creatFactor(str). CreatAnimalFactory(type, size2, color,size2, frame.getZooPanel(),new Point(50,90),"grf" ,hor,ver); 
		 	 
		 	                    poolExecutor.execute(animal); 
		 	                   frame.getZooPanel().getarryAnimal().add(animal); 
		 	                  Controller controller= new Controller();
		 	                  animal.addObserver(controller);
		 	                     break; 
		 	                } 
		 	                case "Elephant":{ 
		 	                 System.out.print("case Elephant"); 
		 	                 animal= sample.creatFactor(kind). CreatAnimalFactory(type, size2, color,size2, frame.getZooPanel(),new Point(50,90),"elf" ,hor,ver); 
		 	 
		 	                    poolExecutor.execute(animal); 
		 	                   frame.getZooPanel().getarryAnimal().add(animal); 
		 	                  Controller controller= new Controller();
		 	                  animal.addObserver(controller);
		 	                     break; 
		 	                } 
		 	                case "Turtle":{ 
		 	                 System.out.print("case Turtle"); 
		 	                 animal= sample.creatFactor(kind). CreatAnimalFactory(type, size2, color,size2, frame.getZooPanel(),new Point(50,90),"trt" ,hor,ver); 
		 	 
		 	                    poolExecutor.execute(animal); 
		 	                   frame.getZooPanel().getarryAnimal().add(animal); 
		 	                  Controller controller= new Controller();
		 	                  animal.addObserver(controller);
		 	                   frame.getZooPanel().getarryAnimal().add(animal); 
		 	                     break; 
		 	                } 
		 		    	}
		         	}
		            else {
				         if(hor<1 || hor>10) {
//		        	 message.setVisible(true);
		        	 type=null;
			 		 JOptionPane.showMessageDialog(null,"Input is invalid Please type again "," Massage",JOptionPane.PLAIN_MESSAGE);
			 		 }
		                  if(ver<1 || ver>10) {
		             	 type=null;
//		        	 message.setVisible(true);
			 		      JOptionPane.showMessageDialog(null,"Input is invalid Please type again "," Massage",JOptionPane.PLAIN_MESSAGE);

			 		 }
		         
		             if (size2<50 || size2>300) {
		 		    JOptionPane.showMessageDialog(null,"Input is invalid Please type again "," Massage",JOptionPane.PLAIN_MESSAGE);
		 		      }
		            }
		            
		    
		      } catch (NumberFormatException e1) {   JOptionPane.showMessageDialog(null,"Please enter a valid size for the animal "," Massage",JOptionPane.PLAIN_MESSAGE);}
		     	this.setVisible(false);
		}

	 }
		//public String JBotton5ActionPerFormed(java.awt.event.ActionEvent evt) {
			//String str= JOptionPane.showMessageDialog(this, " jjjjj",JOp);
		//}
	  /**
	    * Auxiliary function that 
	    * returns the Animal of the animal.  
	    * @return returns the Animal type Animal.
	    *    
	    */
	  public Animal getAnimal() {
		  return animal;
	  }
	  
}