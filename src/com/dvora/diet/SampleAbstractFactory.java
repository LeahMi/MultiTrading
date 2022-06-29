package diet;

public class SampleAbstractFactory {  
	public static AnimalFactory creatFactor(String coice) {
		if (coice == "Carnivor")
			return new Carnivore();
		else if (coice == "Herbivore")
			return new Herbivore();
		else
			return new Omnivore();
		
	}
}
