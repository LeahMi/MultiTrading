package animals;

public class AnimalDeco extends AnimalDecorator {
	
	public AnimalDeco(ColorAnimal coloranimal) {
		super(coloranimal);
	}
	
	public void ChangColore(String col ) {
		super.ChangColore(col);
	}
	public void setColor(String col) {
		this.ChangColore(col);
	}
	
}
