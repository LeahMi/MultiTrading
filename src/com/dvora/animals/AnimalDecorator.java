package animals;

public abstract class AnimalDecorator implements ColorAnimal {
	
    protected ColorAnimal coloranimal;
	public AnimalDecorator(ColorAnimal coloranimal) {
		this.coloranimal=coloranimal;
	}
	
	public void ChangColore(String col ) {
		coloranimal.ChangColore( col);
	}
}
