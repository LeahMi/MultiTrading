package graphics;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * An zooFrame class that builds the template and 
 * fields that each class inherits from JFrame
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see     FoodDialog 
*/
public class ZooFrame extends JFrame implements ActionListener {

	private static ZooPanel zooPanel;
	private JPanel panel1;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu backgroundMenu;
	private JMenu helpMenu;
	private JMenuItem helpItem;
	private JMenuItem imageItem;
	private JMenuItem greenItem;
	private JMenuItem noneItem;
	private JMenuItem exitItem;
	
	 /**
	    *A contractor who builds the object of the 
	    *department and performs data placement
	    *    
	    * @return The return value returned to me is a ZooPanel object
	    *    
	    */
	public ZooFrame(ZooPanel pan ) {
			super("zoo");
	        menuBar = new JMenuBar();
	        this.setJMenuBar(menuBar);
	        fileMenu = new JMenu("File");
	        backgroundMenu = new JMenu("Background");
	        helpMenu = new JMenu("Help");
	        
	        helpItem = new JMenuItem("Help");
	        imageItem = new JMenuItem("Image");
	        exitItem = new JMenuItem("Exit");
	        greenItem = new JMenuItem("Green");
	        noneItem = new JMenuItem("None");
	        
	        helpItem.addActionListener(this);
	        imageItem.addActionListener(this);
	        exitItem.addActionListener(this);
	        greenItem.addActionListener(this);
	        noneItem.addActionListener(this);
	        
	        
	        fileMenu.add(helpItem);
	        fileMenu.add(exitItem);
	        
	        backgroundMenu.add(imageItem);
	        backgroundMenu.add(greenItem);
	        backgroundMenu.add(noneItem);
	        
	        helpMenu.add(helpItem);
	        
	        menuBar.add(fileMenu);
	        menuBar.add(backgroundMenu);
	        menuBar.add(helpMenu);
	        
	        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
	        this.getContentPane().setBackground(Color.white);
	        zooPanel =zooPanel.getInstance() ;
	        zooPanel.setFrame(this);
			this.add(zooPanel);       
	    	this.pack();
	    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	this.setSize(800,600);
	    	this.setVisible(true);
	    }
	 /**
	    *The method is running the
	    * program and calling the function responsible for drawing and testing
	    * 
	    * @return The return value drawing and testing
	    *    
	    */
	public static void main(String[] args) {
		ZooFrame zoo = new ZooFrame(zooPanel.getInstance());
		zoo.getZooPanel().manageZoo();
		BufferedImage imglion;
	  
		
	}
	 /**
	    * the method return the frame 
	    *  
	    * @return frame.
	    *    
	    */
	public ZooPanel getZooPanel() {
		return zooPanel.getInstance();
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
		if(e.getSource() == helpItem)
	        JOptionPane.showMessageDialog(null,"Home Work 2 Gui "," Massage",JOptionPane.PLAIN_MESSAGE);
		    //JOptionPane.showMessageDialog(null,"you cannot add more that 10 animal "," Massage",JOptionPane.PLAIN_MESSAGE);
		   // JOptionPane.showMessageDialog(null,"you cannot add more that 10 animal "," Massage",JOptionPane.);

    	if(e.getSource() == imageItem) { 
    		zooPanel.loadImage("savanna.jpg");
    		zooPanel.setIsclear(false);
    		zooPanel.repaint();
    	}
    	if(e.getSource() == exitItem)
    		System.exit(0);
    	if(e.getSource() == greenItem) 
    		zooPanel.setColorPanel(Color.green);
    	if(e.getSource() == noneItem)
    		zooPanel.setColorPanel(Color.white);
	}

}
