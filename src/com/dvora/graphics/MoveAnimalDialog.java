package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import animals.Animal;
import mobility.Point;
/**
 * An MoveAnimalDialog  class that builds the panel about the Move animal and 
 * fields that each class inherits from JFrame
 *
 * @version 3.5  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see     FoodDialog 
*/

public class MoveAnimalDialog extends JDialog implements ActionListener{
	
	private JButton submit;
	private JTextField Fieldx, Fieldy;
	private String x, y, s;
	private static String[] names = null;
	private JRadioButton radio;
	private final ButtonGroup radios = new ButtonGroup();
	private JLabel message;
	private JLabel text;
	private JLabel textx;
	private JLabel texty;
	private ArrayList<Animal> animals;
	 /**
	    * This method is a constructor which 
	    * describes the parameters of the object
	    * 
	    * @param animals is the Array animals 
	    * @param owner is the type frame 
	    * @return An object that contains an animal move.
	    *    
	    */
	public MoveAnimalDialog(JFrame owner,ArrayList<Animal> animals){
		super(owner, true);
		this.setBounds(50, 300,400 ,300);
		textx = new JLabel("enter x:");
		this.add(textx);
		Fieldx = new JTextField();
		this.add(Fieldx);
		texty = new JLabel("enter y:");
		this.add(texty);
		Fieldy = new JTextField();
		this.add(Fieldy);
		text = new JLabel("Select the animal you want to move");
		this.add(text);
		names = new String[animals.size()];
		int i=0;
		for (Animal animal : animals) {
			names[i] = animal.getName();
			i++;
		}
		for (i = 0; i < names.length; i++) {
			radio = new JRadioButton(names[i]);
			radio.setActionCommand(String.valueOf(i));
			radio.setSelected(i==0);
			radio.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					s = arg0.getActionCommand();
					
				}	
			});
			this.add(radio);
			radios.add(radio);
		}
		this.animals = animals;
		message = new JLabel("the coordinates are out of range");
		message.setForeground(Color.RED);
		message.setVisible(false);
		this.add(message);
		submit = new JButton("submit");
		submit.addActionListener(this);
		this.add(submit);
		this.setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));
		this.setVisible(true);
	}
	
	 /**
	    * Auxiliary function that 
	    * returns the location about point x.
	    * @return returns the location about point x
	    *    
	    */
	public String getx() {
		return x;
	}
	 /**
	    * Auxiliary function that 
	    * returns the location about point y.
	    * @return returns the location about point y.
	    *    
	    */
	public String gety() {
		return y;
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
		if(e.getSource() == submit) {
			int index =Integer.parseInt(s);
			//System.out.println("index==  "+ index);
			
			x = Fieldx.getText().trim().toString();
			y = Fieldy.getText().trim().toString();
			try{
				int intx = Integer.parseInt(x);
				int inty = Integer.parseInt(y);
				if( intx >= 0 && intx <= 800 && inty >= 0 && inty <= 600 ) {
					animals.get(index).setChanges(true);
					animals.get(index).setLocation(new Point(intx,inty));
					setVisible(false);
				}else {
					message.setVisible(true);
				}
	        }
	        catch (NumberFormatException ex){
	        	message.setText("Invalid values");
	        	message.setVisible(true);
	        }
			
		}
	}
}
