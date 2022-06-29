 package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;
import mobility.Point;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;

/**
 * An MoveAnimalDialog  class that builds the panel about the Move animal and 
 * fields that each class inherits from JFrame
 *
 * @version 3.5  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see    AddAnimalDialoge
*/

public class FoodDialog extends JDialog implements ActionListener {

	
	
	private JButton lettuce =new JButton("Lettuce");
	private JButton cabbage=new JButton("Cabbage");
	private JButton meat=new JButton("Meat");
	private JPanel pan=new JPanel();
	private JLabel lbl=new JLabel("Please choose food:");
	private ZooFrame frame;
	private Cabbage cab=null;
	private Lettuce lett=null;
	private final static String PICTURE_PATH = "images\\imgs\\";
	private  boolean isMeat=false;
	 /**
	    * This method is a constructor which 
	    * describes the parameters of the object
	    * 
	    * @param animals is the Array animals 
	    * @param owner is the type frame 
	    * @return An object that contains an animal move.
	    *    
	    */
	public FoodDialog(ZooFrame frame)
	{
		super(frame, true);
		pan.setLayout(null);
		this.setPreferredSize(new Dimension(300,200));
		this.setBounds(500, 500, 500, 500);
		this.setLayout(new FlowLayout());
		lbl.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
		lbl.setForeground(Color.orange);
		this.add(lbl);
		this.add(lettuce);
		this.add(cabbage);
		this.add(meat);
		this.cabbage.addActionListener(this );
		this.lettuce.addActionListener(this );
		this.meat.addActionListener(this );
		this.frame=frame;
		this.pack();
		this.setVisible(true);
		
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
		
			    if (e.getSource()==cabbage) {
			    	
			    	cab= cab. getInstance("cabbage",frame.getZooPanel());
			   
			    }
			    else if(e.getSource()==lettuce) {
			    	lett = lett.getInstance("lettuc", frame.getZooPanel());
			    }
			    else if(e.getSource()== meat) {
			    	isMeat = true;
			    }
			    
			  this.setVisible(false);  
			   
		 }
	   
	   
	   private Cabbage getInstance(String string, ZooPanel zooPanel) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	    * Auxiliary function that 
	    * returns the Meat.
	    * @return returns the Meat.
	    *    
	    */
	    public  boolean  gatMeat() {
			
		   return isMeat;
		
    	}
	    /**
		    * Auxiliary function that 
		    * returns the Cabbage.
		    * @return returns the Cabbage.
		    *    
		    */
    	public Cabbage getPlantCabb() {
		   return cab;
	    }
    	/**
		    * Auxiliary function that 
		    * returns the Lettuce.
		    * @return returns the Lettuce.
		    *    
		    */
	   public Lettuce getPlantLett() {
		   return lett;
	    }
	   
	   
	  
}