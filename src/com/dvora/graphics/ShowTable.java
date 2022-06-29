package graphics;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

import animals.Animal;
/**
 * An zooFrame class that builds the template and 
 * fields that each class inherits from JFrame
 *
 * @version 3.4  April 2022
 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
 * @see     FoodDialog 
*/

public class ShowTable extends JDialog{
	/**
	 * An internal class
	 *  which contains within it the contents of the table is in fact an array of animals
	 *
	 * @version 3.5  April 2022
	 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
	 * @see     FoodDialog 
	*/
	public static class Zoo {
        private Animal[] animals;
        /**
  	    *A contractor who builds the object of the 
  	    *department and performs data placement
  	    * @param animals the array animals type Zoo
  	    * @return The return value returned to me is a named bear object
  	    *    
  	    */
        public Zoo(Animal[] animals) {
            this.animals = animals;
        }

        /**
		    * Auxiliary function that returns size of array animals  
		    * @return returns size of array animals .
		    *    
		    */
        public int size() {
            return animals.length;
        }
        /**
		    * Auxiliary function that returns index in array animals  
		    * @return returns size of array animals .
		    *    
		    */
        public Animal at(int index) {
            return animals[index];
        }
    }
	/**
	 * At class responsible for the structure of the table
	 *
	 * @version 3.5  April 2022
	 * @author Dvora Mizrachi Id: 207919341 and Shilat Hakimi  Id: 324026277 Ashdod Campus
	 * @see     FoodDialog 
	*/
	private static class ZooModel extends AbstractTableModel {
        private Zoo data;
        private final String[] columnNames = {"Animal", "Color", "Weight","HorSpeed","VerSpeed", "Eat Counter"};
        /**
 	    *A contractor who builds the object of the 
 	    *department and performs data placement
 	    * @param data the type Zoo
 	    * @return The return value returned to me is a named bear object
 	    *    
 	    */
        public ZooModel(Zoo data) {
            this.data = data;
        }
        /**
		    * Auxiliary function that 
		    * returns Column Count of the table.  
		    * @return returns Column Count of the table.
		    *    
		    */
		@Override
		public int getColumnCount() {
			return 6;
		}
		@Override
		 /**
		    * Auxiliary function that 
		    * returns Row Count of the table.  
		    * @return returns Row Count of the table.
		    *    
		    */
		public int getRowCount() {
			return data.size()+1;
		}
		 /**
		    * Auxiliary function that 
		    * returns Value At table.  
		    * @param rowIndex is the index row
		    * @param columnIndex  index column
		    * @return returns Value At table. 
		    *    
		    */
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			if( rowIndex == data.size()) {
				switch (columnIndex) {
	                case 0: return "Total";
	                case 1: return null;
	                case 2: return null;
	                case 3: return null;
	                case 4: return null;
	                case 5: return Animal.getTotal();
	                
				}
				 return null;
            }
			else {
			 Animal animal = data.at(rowIndex);
	            switch (columnIndex) {
	                case 0: return animal.getName();
	                case 1: return animal.getColor();
	                case 2: return animal.getWeight();
	                case 3: return animal.getHorSpeed();
	                case 4: return animal.getVerSpeed();
	                case 5: return animal.getEatCount();
	            }
	            return null;
			}

		}
		  /**
		    * Auxiliary function that 
		    * returns Column Name of the table.
		    * @param  column
		    * @return returns Column Name of the table.
		    *    
		    */
		@Override
	    public String getColumnName(int column) {
			return columnNames[column];
	     }

	}
	
	 /**
	    * Auxiliary function that 
	    * returns Column Name of the table.  
	    * @param owner is frame the table is show.
	    * @param zoo the information the show in the table .
	    * @return returns the table.
	    *    
	    */
	public ShowTable(ZooFrame owner,Zoo zoo) {
	        //super("Table MVC Example");
			super(owner, true);
	        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

	        ZooModel model = new ZooModel(zoo);
	        JTable table = new JTable(model);
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
	        table.setFillsViewportHeight(true);
	        this.add(new JScrollPane(table));
	        this.pack();
	        this.setVisible(true);
	 }
}
