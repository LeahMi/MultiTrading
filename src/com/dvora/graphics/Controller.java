package graphics;

import java.awt.Panel;
import java.util.Observable;
import java.util.Observer;

import food.IEdible;

public class Controller implements Runnable , Observer {

	
	ZooPanel panel= ZooPanel.getInstance();
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		panel.manageZoo();
		// TODO Auto-generated method stub
		
	}
	

}
